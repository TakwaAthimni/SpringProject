package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.springproject.entity.Contrat;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
    @Query("SELECT  c FROM Contrat c where  c.dateDebutContrat >=? 1 and c.dateFinContrat <=? 2 ")
    List<Contrat> ListContratBetweenToDate(@PathVariable("dateDebutContrat") Date dateDebutContrat , @PathVariable("dateFinContrat")Date dateFinContrat);

}
