package com.cra.ebanking.repositories;

import com.cra.ebanking.entites.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<CompteBancaire, String> {
}
