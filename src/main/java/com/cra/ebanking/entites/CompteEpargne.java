package com.cra.ebanking.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CURRENT")
@Data @NoArgsConstructor @AllArgsConstructor
public class CompteEpargne extends CompteBancaire{

    private double tauxInteret;
}
