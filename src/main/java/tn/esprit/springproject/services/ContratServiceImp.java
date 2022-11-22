package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Contrat;
import tn.esprit.springproject.entity.Etudiant;
import tn.esprit.springproject.repository.ContratRepository;
import tn.esprit.springproject.repository.EtudiantRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ContratServiceImp implements IContratService{

    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;


    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll() ;
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat retriveContrat(long idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(long idContrat) {
        contratRepository.deleteById(idContrat);

    }

    @Override
    public  Contrat affectContratToEtudiant(Long idContrat, String nomE, String prenomE) {
       Etudiant etudiant=etudiantRepository.findEtudiantByNomEAndPrenomE( nomE , prenomE);
       Contrat ce =contratRepository.findById(idContrat).orElse(null);
       Set<Contrat> contrats=etudiant.getContrats();
       Integer nbContratActifs=0;
       if (contrats.size()!=0){
           for(Contrat contrat: contrats){
               if (((contrat.getArchive())!=null)&&((contrat.getArchive())!=false))
               {nbContratActifs++;}
           }
       }
            if (nbContratActifs<=4){
                ce.setEtudiant(etudiant);
                contratRepository.save(ce);
            }

        return ce;
    }

    @Override
    public String getChiffreAffaireEntreDeuxDate(Date dateDebutContrat, Date dateFinContrat) {
        float chiffre=0;
        float chiffreIA=0;
        float chiffreRESAUX=0;
        float chiffreCLOUD=0;
        float chiffreSECURITE=0;
        List<Contrat> lc = contratRepository.ListContratBetweenToDate(dateDebutContrat,dateFinContrat);
        for(Contrat c : lc){

            if(c.getSpecialite().toString().equals("IA")){
                chiffreIA = chiffreIA + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("CLOUD")){
                chiffreCLOUD = chiffreCLOUD + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("SECURITE")){
                chiffreCLOUD = chiffreCLOUD + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("RESEAUX")){
                chiffreRESAUX = chiffreRESAUX + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            chiffre = chiffre + c.getMontantContrat();

        }
        String ch ="Pour un contrat dont la spécialité est IA: "+chiffreIA+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est RESEAUX: "+chiffreRESAUX+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est CLOUD: "+chiffreCLOUD+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est SECURITE: "+chiffreSECURITE+"Dt/mois\n";
        return ch;
    }
  }

