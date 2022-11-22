package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import tn.esprit.springproject.entity.Equipe;
import tn.esprit.springproject.entity.Niveau;
import tn.esprit.springproject.services.IEquipeService;


import java.util.List;

@RestController
@AllArgsConstructor
public class EquipeController {

    IEquipeService iEquipeService;

    @GetMapping("/getAllEquipes")
    public List<Equipe> getAllEquipe()
    { return iEquipeService.getAllEquipes();}

    @PostMapping("/addEquipes")
    @ResponseBody
    public Equipe addEquipe(@RequestBody Equipe equipe)
    {return iEquipeService.addEquipe( equipe);}

    @PutMapping("/updateEquipes")
    @ResponseBody
    public Equipe updateEquipe (@RequestBody Equipe equipe)
    {return iEquipeService.updateEquipe(equipe);}

    @DeleteMapping("/removeEquipes/{idEquipe}")
    public void   removeEquipe (@PathVariable("idEquipe") long idEquipe)
    { iEquipeService.removeEquipe(idEquipe);}

    @GetMapping("/retriveEquipe/{idEquipe}")
    public Equipe  retriveEquipe(@PathVariable("idEquipe") long idEquipe)
    {return iEquipeService.retrieveEquipe(idEquipe);}

 @GetMapping("/getEquipeEtudiantIdEtudiant/{idEtudiant}")
public List<Equipe> findEquipeByEtudiantsIdEtudiant (@PathVariable long idEtudiant)
 {
     return  iEquipeService.findEquipeByEtudiantsIdEtudiant(idEtudiant);
 }
    @GetMapping("/getEtudiantIdEtudiantAndDetailEquipeThematiqueNotNul/{idEtudiant}")
    public List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (@PathVariable long idEtudiant)
    {
        return iEquipeService.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @GetMapping("/getEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart/{idEtudiant}/{idDepart}")
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(@PathVariable long idEtudiant , @PathVariable  long idDepart)
    {return iEquipeService.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,idDepart);}

    @GetMapping("/retriveEquipeByNiveauAndThematique/{niveau}/{thematique}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niveau") Niveau niveau, @PathVariable("thematique") String thematique)
    {return iEquipeService.retriveEquipeByNiveauAndThematique(niveau,thematique);}

    @DeleteMapping("/deleteEquipeByNiveau/{niveau}")
    public  void deleteEquipeByNiveau( @PathVariable("niveau") Niveau niveau)
    { iEquipeService.deleteEquipeByNiveau(niveau);}




}
