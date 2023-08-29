package com.bank.history.service;

import com.bank.history.entity.History;

import java.util.List;

/**
 * History service using repositories methods
 */

public interface HistoryService {

    List<History> getAllHistory();

    History createHistoryAccount(History history);

    void deleteHistory(Long id);

    void updateHistory(History history);

    History findHistoryById(Long id);


}
