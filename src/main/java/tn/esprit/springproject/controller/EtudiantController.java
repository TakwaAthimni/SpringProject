package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entity.Etudiant;
import tn.esprit.springproject.entity.Option;
import tn.esprit.springproject.services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController {
    IEtudiantService iEtudiantService;
    @GetMapping
    public String Say_hello(){
        return "Hello";}
    @GetMapping ("/getAllEtudiants")
    public List<Etudiant> getAllEtudiant()
    {return iEtudiantService.getAllEtudiants();}

    @PostMapping("/addEtudiant")
    @ResponseBody
    public Etudiant addEtudiant (@RequestBody Etudiant e){
        return iEtudiantService.addEtudiant(e);
    }

    @PutMapping("/updateEtudiant")
    @ResponseBody
    public Etudiant updateEtudiant (@RequestBody Etudiant e){
        return iEtudiantService.updateEtudiant(e);
    }

    @DeleteMapping ("/removeEtudiant/{idEtudiant}")
    public void removeEtudiant (@PathVariable("idEtudiant") long idEtudiant){
        iEtudiantService.removeEtudiant(idEtudiant);
    }

    @GetMapping("/retrieveEtudiant/{idEtudiant}")
    public Etudiant retrieveEtudiant (@PathVariable("idEtudiant") long idEtudiant){
        return iEtudiantService.retrieveEtudiant(idEtudiant);
    }
    @GetMapping("/getEtudiantByPrenomE/{prenomE}")
    public Etudiant findByPrenomEContains(@PathVariable String prenomE)
    { return iEtudiantService.findByPrenomEContains(prenomE);
    }
    @PutMapping("/updateEtudiantByOption/{option}/{idEtudiant}")
    public void updateEtudiantByOption(@PathVariable("option") Option option , @PathVariable ("idEtudiant")Long idEtudiant)
    {iEtudiantService.updateEtudiantByOption(option , idEtudiant); }

    @PutMapping("/assignEtudiantToDepartement/{idEtudiant}/{idDepart}")
    public void assignEtudiantToDepartement(@PathVariable("idEtudiant") long idEtudiant, @PathVariable("idDepart") long idDepart) {
        iEtudiantService.assignEtudiantToDepartement(idEtudiant, idDepart);
    }
    @PostMapping("/addAndAssignEtudiantToEquipeAndContract/{idEquipe}/{idContrat}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") long idContrat,@PathVariable("idEquipe") long idEquipe)
    { return iEtudiantService.addAndAssignEtudiantToEquipeAndContract(e, idContrat , idEquipe) ;}

    @GetMapping("/getEtudiantsByDepartement/{idDepart}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepart") Long idDepart)
    {return iEtudiantService.getEtudiantsByDepartement(idDepart);}

}


