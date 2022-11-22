package tn.esprit.springproject.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entity.Equipe;
import tn.esprit.springproject.entity.Niveau;


import java.util.List;

public interface IEquipeService {

    public List<Equipe> getAllEquipes();
    public Equipe addEquipe (Equipe equipe);
    public Equipe updateEquipe (Equipe equipe);
    public Equipe retrieveEquipe(long idEquipe);
    public void removeEquipe(long idEquipe);
    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant);

    List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (Long idEtudiant);

    List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart (Long idEtudiant, Long idDepart);
    List<Equipe> retriveEquipeByNiveauAndThematique( Niveau niveau,  String thematique);
    public void deleteEquipeByNiveau( Niveau niveau);




}
