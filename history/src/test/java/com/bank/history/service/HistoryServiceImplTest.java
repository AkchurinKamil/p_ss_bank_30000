package com.bank.history.service;

import com.bank.history.entity.History;
import com.bank.history.repository.HistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HistoryServiceImplTest {
    @InjectMocks
    HistoryServiceImpl historyServiceimpl;
    @Mock
    HistoryRepository historyRepository;

    @Test
    void getAllHistory_ReturnedAllHistory() {
        final History history = new History(1L,
                2L, 2L, null,
                2L, 2L, 2L);
        when(historyRepository.findAll()).thenReturn(List.of(history));
        final List<History> actualHistory = historyServiceimpl.getAllHistory();
        assertEquals(List.of(history), actualHistory);
        verify(this.historyRepository).findAll();
    }

    @Test
    void createHistoryAccount_ReturnedNewHistoryAccount() {
        final History history = new History(1L,
                2L, 2L, null,
                2L, 2L, 2L);
        when(historyRepository.save(history)).thenReturn(history);
        final History actualHistory = historyServiceimpl.createHistoryAccount(history);
        assertEquals(history, actualHistory);
        verify(this.historyRepository).save(history);
    }

    @Test
    void deleteHistoryByID_1_DeletedHistoryById_1() {
        final History history = new History(1L,
                2L, 2L, null,
                2L, 2L, 2L);
        historyRepository.deleteById(history.getId());
        verify(this.historyRepository).deleteById(history.getId());
    }

    @Test
    void updateHistory_ReturnedUpdatedHistory() {
        History updatedHistory = new History(1L,
                2L, 2L, 3L,
                2L, 2L, 2L);
        when(historyRepository.findById(updatedHistory.getId())).thenReturn(Optional.of(updatedHistory));
        when(historyRepository.save(updatedHistory)).thenReturn(updatedHistory);
        historyServiceimpl.updateHistory(updatedHistory);
        final History actualAuditAfterUpdate = historyServiceimpl.findHistoryById(1L);
        assertEquals(actualAuditAfterUpdate, updatedHistory);
        verify(this.historyRepository, times(1)).save(updatedHistory);
    }

    @Test
    void findHistoryById_1_ReturnedHistoryBiId_1() {
        final History history = new History(1L,
                2L, 2L, null,
                2L, 2L, 2L);
        when(historyRepository.findById(history.getId())).thenReturn(Optional.of(history));
        assertEquals(history, historyServiceimpl.findHistoryById(history.getId()));
        verify(this.historyRepository).findById(history.getId());
    }
}