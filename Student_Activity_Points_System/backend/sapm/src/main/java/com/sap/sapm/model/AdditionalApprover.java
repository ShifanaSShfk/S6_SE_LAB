package com.sap.sapm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "additional_approvers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalApprover {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private ActivityRequest request;
    
    @ManyToOne
    @JoinColumn(name = "approver_id", nullable = false)
    private User approver;
    
    @Enumerated(EnumType.STRING)
    private ApprovalStatus status = ApprovalStatus.PENDING;
    
    private String comments;
    
    @Column(name = "is_waived")
    private Boolean waived = false;
    
    @Column(name = "waiver_reason")
    private String waiverReason;
    
    @Column(name = "approval_date")
    private LocalDateTime approvalDate;
    
    public enum ApprovalStatus {
        PENDING, APPROVED, REJECTED
    }
}
