package com.misaeborges.deliveryapi.domain.services;

import com.misaeborges.deliveryapi.domain.exception.BusinessException;
import com.misaeborges.deliveryapi.domain.exception.EntityInUseException;
import com.misaeborges.deliveryapi.domain.exception.UserNotFoundException;
import com.misaeborges.deliveryapi.domain.models.Group;
import com.misaeborges.deliveryapi.domain.models.User;
import com.misaeborges.deliveryapi.domain.repositories.IUserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private GroupService groupService;

    @Transactional
    public User save(User user) {
        entityManager.detach(user);

        Optional<User> userExist = userRepository.findByEmail(user.getEmail());

        if (userExist.isPresent() && !userExist.get().equals(user)) {
            throw new BusinessException(String.format("There is already a registered user with the email %s", user.getEmail()));

        }

        return userRepository.save(user);
    }

    @Transactional
    public void changePassword(Long id, String currentPassword, String newPassword) {
        User user = searchEngine(id);

        if (!currentPassword.equals(user.getPassword())) {
            throw new BusinessException("The current password entered does not match the registered password");
        }
        user.setPassword(newPassword);
    }

    @Transactional
    public void addGroup(Long userId, Long groupId) {
        User user = searchEngine(userId);
        Group group = groupService.searchEngine(groupId);
        user.assignToGroup(group);
    }

    @Transactional
    public void removeGroup(Long userId, Long groupId) {
        User user = searchEngine(userId);
        Group group = groupService.searchEngine(groupId);
        user.unassignFromGroup(group);
    }

    @Transactional
    public void delete(Long id) {
        User user = searchEngine(id);
        try {
            userRepository.deleteById(user.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(id);
        }
    }

    public User searchEngine(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
