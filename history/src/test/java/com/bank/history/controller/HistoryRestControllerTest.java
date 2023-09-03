package com.bank.history.controller;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.entity.History;
import com.bank.history.mapper.HistoryMapper;
import com.bank.history.service.HistoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class HistoryRestControllerTest {
    @InjectMocks
    private HistoryRestController historyRestController;
    @Mock
    private HistoryService historyService;

    @Spy
    private final HistoryMapper historyMapper = Mappers.getMapper(HistoryMapper.class);


    @Test
    void getAllHistory_ReturnedAllHistory() {
        final History history = new History(1L,
                2L,2L,null,
                2L,2L,2L);
        final HistoryDTO historyDTO = new HistoryDTO(1L,
                2L,2L,null,
                2L,2L,2L);
        when(historyService.getAllHistory()).thenReturn(List.of(history));
        ResponseEntity<List<HistoryDTO>> response = ResponseEntity.ok(List.of(historyDTO));
        assertEquals(response,historyRestController.getAllHistory());
        verify(historyService, times(1)).getAllHistory();
    }

    @Test
    void deleteHistoryById_1_DeletedHistoryById_1() {
        historyRestController.deleteHistory(1L);
        verify(historyService, times(1)).deleteHistory(1L);

    }

    @Test
    void getHistoryById_returnHistoryById() {
        final History history = new History(1L,
                2L,2L,null,
                2L,2L,2L);
        final HistoryDTO historyDTO = new HistoryDTO(1L,
                2L,2L,null,
                2L,2L,2L);
        final ResponseEntity<HistoryDTO> responseEntity = ResponseEntity.ok().body(historyDTO);
        when(historyService.findHistoryById(1L)).thenReturn(history);
        final  ResponseEntity<HistoryDTO> actualResponseEntity = historyRestController.getHistoryById(1L);
        assertEquals(responseEntity,actualResponseEntity);
        verify(historyService, times(1)).findHistoryById(1L);

    }

    @Test
    void createHistoryAccount_CreatedHistoryAccount() {
        final History history = new History(1L,
                2L,2L,null,
                2L,2L,2L);
        final HistoryDTO historyDTO = new HistoryDTO(1L,
                2L,2L,null,
                2L,2L,2L);
        final ResponseEntity<HistoryDTO> responseEntity = ResponseEntity.ok().body(historyDTO);
        final  ResponseEntity<HistoryDTO> actualResponseEntity = historyRestController.createHistoryAccount(historyDTO);
        assertEquals(responseEntity, actualResponseEntity);
        verify(historyService, times(1)).createHistoryAccount(history);


    }

    @Test
    void updateHistory_UpdatedHistory() {
        final History history = new History(1L,
                2L,2L,null,
                2L,2L,2L);
        final HistoryDTO historyDTO = new HistoryDTO(1L,
                2L,2L,null,
                2L,2L,2L);
       final ResponseEntity<HistoryDTO> responseEntity = ResponseEntity.ok().body(historyDTO);
       final ResponseEntity<HistoryDTO> actualResponseEntity = historyRestController.updateHistory(historyDTO);
       assertEquals(responseEntity, actualResponseEntity);
       verify(historyService, times(1)).updateHistory(history);
    }
}