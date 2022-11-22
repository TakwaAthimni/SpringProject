package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Departement;
import tn.esprit.springproject.entity.Option;
import tn.esprit.springproject.entity.Universite;
import tn.esprit.springproject.repository.DepartementRepository;
import tn.esprit.springproject.repository.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class DepartementServiceImp implements IDepartementService{

    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retriveDepartement(long idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public void removeDepartement(long idDepart) {
        departementRepository.deleteById(idDepart);

    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiants(Option option) {
       return departementRepository.retrieveDepartementByOptionEtudiants(option);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(long idUniv) {
        Universite u =universiteRepository.findById(idUniv).orElse(null);
        List<Departement> ListDep = new ArrayList<>(u.getDepartement());
        return ListDep;

    }


}
