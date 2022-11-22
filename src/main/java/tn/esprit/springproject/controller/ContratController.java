package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entity.Contrat;
import tn.esprit.springproject.services.IContratService;

import java.util.Date;
import java.util.List;

@RestController

@AllArgsConstructor
public class ContratController {

 IContratService iContratService;

    @GetMapping("/getAllContrats")
    public List<Contrat> getAllContrat()
    {return iContratService.getAllContrats();}

    @PostMapping("/addContrat")
    @ResponseBody
    public Contrat addContrat (@RequestBody Contrat c )
    { return iContratService.addContrat(c);}

    @PutMapping ("/updateContrat")
    @ResponseBody
    public Contrat updateContrat (@RequestBody Contrat c)
    {return iContratService.updateContrat(c);}

    @DeleteMapping("/removeContrat/{idContrat}")
    public void removeContart (@PathVariable ("idContrat") long idContrat)
    {iContratService.removeContrat(idContrat);}

    @GetMapping("/retriveContrat/{idContrat}")
    public Contrat retriveContrat (@PathVariable("idContrat") long idContrat)
    { return iContratService.retriveContrat(idContrat);}

    @PostMapping("affectContratToEtudiant/{idContrat}/{nomE}/{prenomE}")
   public Contrat affectContratToEtudiant(@PathVariable ("idContrat") long idContrat ,
                                          @PathVariable("nomE")String nomE,
                                          @PathVariable("prenomE")String prenomE)
   {return iContratService.affectContratToEtudiant( idContrat,  nomE,  prenomE);}

   @GetMapping("/getChiffreAffaireEntreDeuxDate")
   public String getChiffreAffaireEntreDeuxDate(@RequestParam("dateDebutContrat")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateDebutContrat,
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("dateFinContrat") Date dateFinContrat){
      return  iContratService.getChiffreAffaireEntreDeuxDate(dateDebutContrat,dateFinContrat);
   }

}
