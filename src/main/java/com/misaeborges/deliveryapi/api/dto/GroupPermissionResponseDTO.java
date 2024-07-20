package com.misaeborges.deliveryapi.api.dto;

import com.misaeborges.deliveryapi.domain.models.Permission;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GroupPermissionResponseDTO {

    private Long id;
    private String name;
    private List<Permission> permissions = new ArrayList<>();
}
