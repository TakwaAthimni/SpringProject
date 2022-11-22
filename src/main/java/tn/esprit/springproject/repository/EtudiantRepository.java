package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entity.Departement;
import tn.esprit.springproject.entity.Etudiant;
import tn.esprit.springproject.entity.Option;

import javax.transaction.Transactional;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByPrenomEContains(String prenomE);
@Transactional
    @Modifying
    @Query("update Etudiant etudiant  set etudiant.option=:option " +
            "where etudiant.idEtudiant=:idEtudiant ")
    void updateEtudiantByOption(@Param("option") Option option , @Param ("idEtudiant")Long idEtudiant);

     Etudiant  findEtudiantByNomEAndPrenomE(String nomE , String prenomE);
     List<Etudiant> findEtudiantByDepartement(Departement departement);


}
