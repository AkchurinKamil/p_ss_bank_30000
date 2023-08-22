package com.bank.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.bank.history.entity.History;

@Repository
public interface HistoryRepository extends JpaRepository<History,Long> {
}
