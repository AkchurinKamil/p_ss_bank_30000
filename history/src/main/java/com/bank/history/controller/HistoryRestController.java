package com.bank.history.controller;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.entity.History;
import com.bank.history.mapper.HistoryMapper;
import com.bank.history.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * HistoryRestController for CRUD operation
 */

@RestController
@RequestMapping("/history")
public class HistoryRestController {

    private HistoryService historyService;

    private HistoryMapper historyMapper;

    public HistoryRestController() {

    }
    @Autowired
    public HistoryRestController(HistoryService historyService, HistoryMapper historyMapper) {
        this.historyService = historyService;
        this.historyMapper = historyMapper;
    }

    @GetMapping
    public ResponseEntity<List<HistoryDTO>> getAllHistory() {
        final List<HistoryDTO> historyListDTO =
                historyMapper.historyToDTOList(historyService.getAllHistory());
        return ResponseEntity.ok().body(historyListDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable("id") Long id) {


        historyService.deleteHistory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryDTO> getHistoryById(@PathVariable("id") Long id) {
        final History history =
                historyService.findHistoryById(id);
        return ResponseEntity.ok().body(historyMapper.historyToDTO(history));
    }

    @PostMapping
    public ResponseEntity<HistoryDTO> createHistoryAccount(@RequestBody @Valid HistoryDTO historyDTO) {
        historyService.createHistoryAccount(historyMapper.historyToEntity(historyDTO));
        return ResponseEntity.ok().body(historyDTO);
    }

    @PutMapping
    public ResponseEntity<HistoryDTO> updateHistory(@RequestBody @Valid HistoryDTO historyDTO) {
        historyService.updateHistory(historyMapper.historyToEntity(historyDTO));
        return ResponseEntity.ok(historyDTO);
    }
}










