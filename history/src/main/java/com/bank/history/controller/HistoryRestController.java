package com.bank.history.controller;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.entity.History;
import com.bank.history.mapper.HistoryMapper;
import com.bank.history.service.HistoryService;
import io.micrometer.core.annotation.Timed;
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
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8188")
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
    @Timed("account_history_get_all")
    @GetMapping("/account_history")
    public ResponseEntity<List<HistoryDTO>> getAllHistory() {
        final List<HistoryDTO> historyListDTO =
                historyMapper.historyToDTOList(historyService.getAllHistory());
        return ResponseEntity.ok().body(historyListDTO);
    }
    @Timed("account_history_delete")
    @DeleteMapping("/account_history/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable("id") Long id) {
        historyService.deleteHistory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Timed("account_history_get_by_id")
    @GetMapping("/account_history/{id}")
    public ResponseEntity<HistoryDTO> getHistoryById(@PathVariable("id") Long id) {
        final History history =
                historyService.findHistoryById(id);
        return ResponseEntity.ok().body(historyMapper.historyToDTO(history));
    }
    @Timed("account_history_post")
    @PostMapping("/account_history")
    public ResponseEntity<HistoryDTO> createHistoryAccount(@RequestBody @Valid HistoryDTO historyDTO) {
        historyService.createHistoryAccount(historyMapper.historyToEntity(historyDTO));
        return ResponseEntity.ok().body(historyDTO);
    }
    @Timed("account_history_put")
    @PutMapping("/account_history")
    public ResponseEntity<HistoryDTO> updateHistory(@RequestBody @Valid HistoryDTO historyDTO) {
        historyService.updateHistory(historyMapper.historyToEntity(historyDTO));
        return ResponseEntity.ok(historyDTO);
    }
}










