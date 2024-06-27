package com.cra.ebanking.repositories;

import com.cra.ebanking.entites.Operations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operations, Long> {
}
