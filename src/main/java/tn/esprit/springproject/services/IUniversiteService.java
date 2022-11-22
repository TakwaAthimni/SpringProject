package tn.esprit.springproject.services;

import tn.esprit.springproject.entity.Etudiant;
import tn.esprit.springproject.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> getAllUniversites();
    public Universite addUniversite (Universite u);

    public Universite updateUniversite (Universite u);

    public Universite retrieveUniversite(long idUniv);

    public void removeUniversite(long idUniv);
    public void assignUniversiteToDepartement(long idUniv, long idDepart);
}
