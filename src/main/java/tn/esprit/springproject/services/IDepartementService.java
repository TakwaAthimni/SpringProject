package tn.esprit.springproject.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entity.Departement;
import tn.esprit.springproject.entity.Option;

import java.util.List;

public interface IDepartementService {
    public List<Departement> getAllDepartement();
    public Departement addDepartement(Departement d);
    public Departement updateDepartement(Departement d);
    public Departement retriveDepartement (long idDepart);
    public void removeDepartement (long idDepart);
    List<Departement> retrieveDepartementByOptionEtudiants(Option option);
    public List<Departement> retrieveDepartementsByUniversite(long idUniv);



}
