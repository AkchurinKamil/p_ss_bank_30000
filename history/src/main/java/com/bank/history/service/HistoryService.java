package com.bank.history.service;

import com.bank.history.entity.History;

import java.util.List;
import java.util.Optional;

public interface HistoryService {

    List<History> getAllHistory();

    History createHistoryAccount(History history);

    void deleteHistory(History history);

    void updateHistory(History history);

    Optional<History> findHistoryById(Long id);


}
