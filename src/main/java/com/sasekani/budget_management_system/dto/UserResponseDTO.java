package com.sasekani.budget_management_system.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

}
