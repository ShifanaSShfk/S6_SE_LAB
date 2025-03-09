package com.sap.sapm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    
    @Column(name = "category_name", nullable = false)
    private String name;
    
    private String description;
    
    @Column(name = "max_points")
    private Integer maxPoints;
    
    @Column(name = "is_active")
    private Boolean active = true;
}
