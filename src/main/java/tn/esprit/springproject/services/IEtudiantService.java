package tn.esprit.springproject.services;

import tn.esprit.springproject.entity.Etudiant;
import tn.esprit.springproject.entity.Option;

import java.util.List;

public interface IEtudiantService {

    public List<Etudiant> getAllEtudiants();
    public Etudiant addEtudiant (Etudiant e);

    public Etudiant updateEtudiant (Etudiant e);

    public Etudiant retrieveEtudiant(long idEtudiant);

    public void removeEtudiant(long idEtudiant);

    public   Etudiant findByPrenomEContains(String prenomE);

   public  void updateEtudiantByOption(Option option , Long idEtudiant);

    public  void assignEtudiantToDepartement(long idEtudiant, long idDepart);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, long  idContrat, long idEquipe);
    List<Etudiant> getEtudiantsByDepartement (Long idDepartement);

}
