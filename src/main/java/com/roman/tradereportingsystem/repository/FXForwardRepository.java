package com.roman.tradereportingsystem.repository;

import com.roman.tradereportingsystem.model.trade.FXForward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FXForwardRepository extends JpaRepository<FXForward, Long> {
}