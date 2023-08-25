package com.bank.history.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

/**
 *  History class representing database entity
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Nullable
    @Column(name = "transfer_audit_id")
    private Long transferAuditId;

    @Nullable
    @Column(name = "profile_audit_id")
    private Long profileAuditId;

    @Nullable
    @Column(name = "account_audit_id")
    private Long accountAuditId;

    @Nullable
    @Column(name = "anti_fraud_audit_id")
    private Long antiFraudAuditId;

    @Nullable
    @Column(name = "public_bank_info_audit_id")
    private Long publicBankInfoAuditId;

    @Nullable
    @Column(name = "authorization_audit_id")
    private Long authorizationAuditId;

}



