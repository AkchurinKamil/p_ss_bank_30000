package com.bank.history.service;

import com.bank.history.entity.History;
import com.bank.history.repository.HistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * History service using repositories methods implementation
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    @Transactional
    @Override
    public History createHistoryAccount(History history) {
        return historyRepository.save(history);
    }

    @Transactional
    @Override
    public void deleteHistory(Long id){
        historyRepository.deleteById(id);
    }
    @Transactional
    @Override
    public void updateHistory(History history) {
        historyRepository.save(history);

    }

    @Override
    public Optional<History> findHistoryById(Long id) {
        return historyRepository.findById(id);
    }
}
