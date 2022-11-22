package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Equipe;
import tn.esprit.springproject.entity.Niveau;
import tn.esprit.springproject.repository.EquipeRespository;

import java.util.List;

@AllArgsConstructor
@Service
public class EquipeServiceImp implements IEquipeService {

    EquipeRespository equipeRespository;
    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRespository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {
        return equipeRespository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Equipe equipe) {
        return equipeRespository.save(equipe);
    }

    @Override
    public Equipe retrieveEquipe(long idEquipe) {
        return equipeRespository.findById(idEquipe).orElse(null);
    }

    @Override
    public void removeEquipe(long idEquipe) {
        equipeRespository.deleteById(idEquipe);

    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant) {
        return equipeRespository.findEquipeByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant) {
        return equipeRespository.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant );
    }

    @Override
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idEtudiant, Long idDepart) {
        return equipeRespository.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant, idDepart);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRespository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @Override
    public void deleteEquipeByNiveau(Niveau niveau) {
        equipeRespository.deleteEquipeByNiveau(niveau);
    }


}
