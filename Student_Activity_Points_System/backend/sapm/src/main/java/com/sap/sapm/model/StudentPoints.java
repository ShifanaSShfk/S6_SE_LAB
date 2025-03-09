package com.sap.sapm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "student_points")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPoints {
    
    @Id
    @OneToOne
    @JoinColumn(name = "student_id")
    private User student;
    
    @Column(name = "total_points")
    private Integer totalPoints = 0;
    
    @Column(name = "last_updated_at")
    private LocalDateTime lastUpdatedAt;
    
    @OneToMany(mappedBy = "id.student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StudentCategoryPoints> categoryPoints;
    
    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        this.lastUpdatedAt = LocalDateTime.now();
    }
}
