package com.bank.history.controller;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.entity.History;
import com.bank.history.exception.DTOValidationException;
import com.bank.history.exception.EntityNotFoundByIdException;
import com.bank.history.mapper.HistoryMapper;
import com.bank.history.service.HistoryService;

import com.bank.history.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
                historyService.getAllHistory()
                        .stream()
                        .map(a -> historyMapper.historyToDTO(a))
                        .toList();
        return ResponseEntity.ok().body(historyListDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable("id") Long id) {
        final Optional<History> optionalHistory =
                historyService.findHistoryById(id);
        if (optionalHistory.isEmpty()) {
            throw new EntityNotFoundByIdException(id);
        }
        historyService.deleteHistory(optionalHistory.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryDTO> getHistoryById(@PathVariable("id") Long id) {
        final Optional<History> optionalHistory =
                historyService.findHistoryById(id);
        if (optionalHistory.isEmpty()) {
            throw new EntityNotFoundByIdException(id);
        }
        return ResponseEntity.ok().body(historyMapper.historyToDTO(optionalHistory.get()));
    }

    @PostMapping
    public ResponseEntity<HistoryDTO> createHistoryAccount(@RequestBody @Valid HistoryDTO historyDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final ValidationResult validationResultHandler = new ValidationResult();
            throw new DTOValidationException(validationResultHandler.handleBindingResult(bindingResult));
        }
        historyService.createHistoryAccount(historyMapper.historyToEntity(historyDTO));
        return ResponseEntity.ok().body(historyDTO);
    }

    @PutMapping
    public ResponseEntity<HistoryDTO> updateHistory(@RequestBody @Valid HistoryDTO historyDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final ValidationResult validationResultHandler = new ValidationResult();
            throw new DTOValidationException(validationResultHandler.handleBindingResult(bindingResult));
        }
        historyService.updateHistory(historyMapper.historyToEntity(historyDTO));
        return ResponseEntity.ok(historyDTO);
    }
}










