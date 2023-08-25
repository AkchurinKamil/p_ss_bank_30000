package com.bank.history.mapper;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.entity.History;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * History Entity/DTO mapper
 */

@Mapper(componentModel = "spring")
public interface HistoryMapper {

    HistoryDTO historyToDTO(History history);

    History historyToEntity(HistoryDTO historyDTO);

    List<HistoryDTO> historyToDTOList(List<History> list);
}
