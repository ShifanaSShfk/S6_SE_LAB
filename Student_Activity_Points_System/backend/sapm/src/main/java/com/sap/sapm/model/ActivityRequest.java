package com.sap.sapm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "activity_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ActivityCategory category;
    
    @Column(name = "activity_description", nullable = false)
    private String description;
    
    @Column(name = "requested_points", nullable = false)
    private Integer requestedPoints;
    
    @Column(name = "proof_document")
    private String proofDocument;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status = RequestStatus.PENDING;
    
    @ManyToOne
    @JoinColumn(name = "faculty_advisor_id")
    private User facultyAdvisor;
    
    @CreationTimestamp
    @Column(name = "requested_at", updatable = false)
    private LocalDateTime requestedAt;
    
    @UpdateTimestamp
    @Column(name = "last_updated_at")
    private LocalDateTime lastUpdatedAt;
    
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Prevents infinite recursion during serialization
    private List<AdditionalApprover> additionalApprovers;
    
    public enum RequestStatus {
        PENDING, APPROVED, REJECTED
    }
}
