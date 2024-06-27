package com.cra.ebanking;

import com.cra.ebanking.entites.*;
import com.cra.ebanking.enums.CompteStatus;
import com.cra.ebanking.enums.OperationType;
import com.cra.ebanking.repositories.ClientRepository;
import com.cra.ebanking.repositories.CompteRepository;
import com.cra.ebanking.repositories.OperationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EBankingApplication {

    public static void main(String[] args) {

        SpringApplication.run(EBankingApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository,
                            CompteRepository compteRepository,
                            OperationRepository operationRepository) {
        return args -> {
            CompteBancaire compteBancaire = compteRepository.findById("06256ba4-cf9c-4b09-b3bc-e922c559bc5d").orElse(null);
            if (compteBancaire != null) {
                System.out.println("======================================");
                System.out.println(compteBancaire.getId()+"id----------");
                System.out.println(compteBancaire.getSolde());
                System.out.println(compteBancaire.getClient().getNom());
                System.out.println(compteBancaire.getDateCreatrion());
                System.out.println(compteBancaire.getClass().getSimpleName());
                if (compteBancaire instanceof CompteCourant) {
                    System.out.println("Decouvert  "+((CompteCourant)compteBancaire).getDecouvert());
                } else if (compteBancaire instanceof CompteEpargne) {
                    System.out.println("Taux "+((CompteEpargne)compteBancaire).getTauxInteret());
                }

                compteBancaire.getCompteList().forEach(operations -> {
                    System.out.println("========================");
                    System.out.println(operations.getType());
                    System.out.println(operations.getMontant());
                    System.out.println(operations.getDateOperation());
                });
            }
        };
    };
//    @Bean
    CommandLineRunner start(ClientRepository clientRepository,
                            CompteRepository compteRepository,
                            OperationRepository operationRepository) {
        return args -> {
            Stream.of("Ibrahim", "Amadou", "Aboubacar").forEach(name->{
                Client client = new Client();
                client.setNom(name);
                client.setTelephone(78920989);
                client.setPrenom(name+"Ly");
                client.setEmail(name+"@gmail.com");
                clientRepository.save(client);
            });
            clientRepository.findAll().forEach(clt -> {
                CompteCourant compteCourant =new CompteCourant();
                compteCourant.setId(UUID.randomUUID().toString());
                compteCourant.setSolde(Math.random()*9700);
                compteCourant.setDateCreatrion(LocalDate.now());
                compteCourant.setStatus(CompteStatus.ACTIVER);
                compteCourant.setClient(clt);
                compteCourant.setDecouvert(230000);
                compteRepository.save(compteCourant);

                CompteEpargne compteEpargne =new CompteEpargne();
                compteEpargne.setId(UUID.randomUUID().toString());
                compteEpargne.setSolde(Math.random()*3200);
                compteEpargne.setDateCreatrion(LocalDate.now());
                compteEpargne.setStatus(CompteStatus.CREER);
                compteEpargne.setClient(clt);
                compteEpargne.setTauxInteret(2.3);
                compteRepository.save(compteEpargne);
            });

            compteRepository.findAll().forEach(cpt-> {
                for (int i = 0; i < 10; i++) {
                    Operations operations = new Operations();
                    operations.setDateOperation(LocalDate.now());
                    operations.setCompteBancaire(cpt);
                    operations.setType(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT);
                    operations.setMontant(Math.random()*45300);
                    operationRepository.save(operations);
                }
            });
        };
    }

}
