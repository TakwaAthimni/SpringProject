package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Departement;
import tn.esprit.springproject.entity.Universite;
import tn.esprit.springproject.repository.DepartementRepository;
import tn.esprit.springproject.repository.UniversiteRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class UniversiteServiceImp implements IUniversiteService{

    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;


    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniv) {
        return universiteRepository.findById(idUniv).orElse(null);
    }

    @Override
    public void removeUniversite(long idUniv) {
        universiteRepository.deleteById(idUniv);

    }

    @Override
    public void assignUniversiteToDepartement(long idUniv, long idDepart) {
        Universite universite=universiteRepository.findById(idUniv).orElse(null);
        Departement departement=departementRepository.findById(idDepart).orElse(null);
        universite.getDepartement().add(departement);
        universiteRepository.save(universite);

    }
}
