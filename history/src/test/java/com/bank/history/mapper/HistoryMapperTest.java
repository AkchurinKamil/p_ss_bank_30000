package com.bank.history.mapper;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.entity.History;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class HistoryMapperTest {
    @Spy
    private final HistoryMapper historyMapper = Mappers.getMapper(HistoryMapper.class);

    @Test
    void historyToDTO() {
        final History history = new History(1L,
                2L,2L,null,
                2L,2L,2L);
        final HistoryDTO historyDTO = new HistoryDTO(1L,
                2L,2L,null,
                2L,2L,2L);
        final HistoryDTO actualHistoryDTO = historyMapper.historyToDTO(history);
        assertEquals(historyDTO, actualHistoryDTO);
    }

    @Test
    void historyToEntity() {
        final History history = new History(1L,
                2L,2L,null,
                2L,2L,2L);
        final HistoryDTO historyDTO = new HistoryDTO(1L,
                2L,2L,null,
                2L,2L,2L);
        final History actualHistory = historyMapper.historyToEntity(historyDTO);
        assertEquals(history,actualHistory);
    }

    @Test
    void historyToDTOList() {
        final History history = new History(1L,
                2L,2L,null,
                2L,2L,2L);
        final HistoryDTO historyDTO = new HistoryDTO(1L,
                2L,2L,null,
                2L,2L,2L);
        final List<HistoryDTO> actualHistoryDTOList = historyMapper.historyToDTOList(List.of(history));
        assertEquals(List.of(historyDTO),actualHistoryDTOList);
    }
}