package com.roman.tradereportingsystem.repository;

import com.roman.tradereportingsystem.model.ExternalBroker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerRepository extends JpaRepository<ExternalBroker, Long> {
}
