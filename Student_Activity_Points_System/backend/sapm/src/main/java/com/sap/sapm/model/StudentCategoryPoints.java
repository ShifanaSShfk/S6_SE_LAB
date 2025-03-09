package com.sap.sapm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_category_points")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCategoryPoints {
    
    @EmbeddedId
    private StudentCategoryPointsId id;
    
    private Integer points = 0;
    
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StudentCategoryPointsId implements java.io.Serializable {
        
        @ManyToOne
        @JoinColumn(name = "student_id")
        private User student;
        
        @ManyToOne
        @JoinColumn(name = "category_id")
        private ActivityCategory category;
    }
}
