package tn.esprit.springproject.services;

import tn.esprit.springproject.entity.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {
    public List<Contrat> getAllContrats();
    public Contrat addContrat(Contrat c);
    public Contrat updateContrat (Contrat c);
    public Contrat retriveContrat(long idContrat);
    public void removeContrat(long idContrat);
    Contrat affectContratToEtudiant (Long idContrat , String nomE,String prenomE);
    public String getChiffreAffaireEntreDeuxDate(Date dateDebutContrat, Date dateFinContrat);



}
