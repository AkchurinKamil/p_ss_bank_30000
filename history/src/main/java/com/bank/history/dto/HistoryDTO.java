package com.bank.history.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * Data transfer object for History
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDTO {

    private Long id;

    @Nullable
    private Long transferAuditId;

    @Nullable
    private Long profileAuditId;

    @Nullable
    private Long accountAuditId;

    @Nullable
    private Long antiFraudAuditId;

    @Nullable
    private Long publicBankInfoAuditId;

    @Nullable
    private Long authorizationAuditId;

}
