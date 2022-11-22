package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.*;
import tn.esprit.springproject.repository.ContratRepository;
import tn.esprit.springproject.repository.DepartementRepository;
import tn.esprit.springproject.repository.EquipeRespository;
import tn.esprit.springproject.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class EtudiantServiceImp implements IEtudiantService{


    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    ContratRepository contratRepository;
    EquipeRespository equipeRespository;

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }


    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }

    @Override
    public Etudiant findByPrenomEContains(String prenomE) {
        return etudiantRepository.findByPrenomEContains(prenomE);
    }

    @Override
    public void updateEtudiantByOption(Option option, Long idEtudiant) {
        etudiantRepository.updateEtudiantByOption(option,idEtudiant);
    }

    @Override
    public void assignEtudiantToDepartement(long idEtudiant, long idDepart) {
        Etudiant etudiant=etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement=departementRepository.findById(idDepart).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, long idContrat, long idEquipe) {
        Contrat contrat=contratRepository.findById(idContrat).orElse(null);
        Equipe equipe=equipeRespository.findById(idEquipe).orElse(null);
        contrat.setEtudiant(e);
        contratRepository.save(contrat);
        equipe.getEtudiants().add(e);
     return    etudiantRepository.save(e);

    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Long idDepart) {
        return etudiantRepository.findEtudiantByDepartement(departementRepository.findById(idDepart).orElse(null));

    }


}
