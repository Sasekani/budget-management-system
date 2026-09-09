package com.sasekani.budget_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="income")
@Data
public class Income {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @Column(nullable=false, precision = 12, scale=2)
    private BigDecimal amount;

    private String description;

    @Column(nullable=false)
    private LocalDate incomeDate;

    @Column(nullable = false)
    private LocalDateTime createdAt;


}
