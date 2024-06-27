package com.cra.ebanking.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@DiscriminatorValue("EPARGNE")
@Data @NoArgsConstructor @AllArgsConstructor
public class CompteCourant extends CompteBancaire{
    private double decouvert;
}
