package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entity.Departement;
import tn.esprit.springproject.entity.Option;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

@Query("SELECT departement from Departement departement , Etudiant etudiant" +
        " where departement.idDepart = etudiant.departement.idDepart " +
        "and etudiant.option=:option")
List<Departement> retrieveDepartementByOptionEtudiants(@Param("option")Option option);



}
