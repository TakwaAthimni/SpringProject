package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entity.Equipe;
import tn.esprit.springproject.entity.Niveau;

import javax.transaction.Transactional;
import java.util.List;


public interface EquipeRespository extends JpaRepository<Equipe, Long> {

    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant);

    List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (Long idEtudiant);
    List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart (Long idEtudiant, Long idDepart);

    @Query("select equipe from Equipe equipe,  DetailEquipe detailEquipe  " +
            " where  equipe.idEquipe = detailEquipe.equipe.idEquipe " +
            "and  equipe.niveau =:niveau and detailEquipe.thematique=:thematique  ")

    List<Equipe> retriveEquipeByNiveauAndThematique(@Param("niveau") Niveau niveau,@Param("thematique") String thematique);
@Transactional
    @Modifying
    @Query("delete from Equipe equipe where equipe.niveau =? 1")

    void deleteEquipeByNiveau( Niveau niveau);







}
