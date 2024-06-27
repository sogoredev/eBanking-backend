package com.cra.ebanking.repositories;

import com.cra.ebanking.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
