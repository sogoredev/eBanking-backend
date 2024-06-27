package com.cra.ebanking.entites;

import com.cra.ebanking.enums.CompteStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 10)
public class CompteBancaire {

    @Id
    private String id;
    private double solde;
    private LocalDate dateCreatrion;
    @Enumerated(EnumType.STRING)
    private CompteStatus status;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "compteBancaire")
    private List<Operations> compteList;

}
