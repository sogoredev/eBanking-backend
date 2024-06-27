package com.cra.ebanking.entites;

import com.cra.ebanking.enums.OperationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Operations {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOperation;
    private double montant;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    @ManyToOne
    private CompteBancaire compteBancaire;
}
