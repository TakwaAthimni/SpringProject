package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entity.Universite;
import tn.esprit.springproject.services.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteController {

    IUniversiteService iUniversiteService;

    @GetMapping("/getAllUniversites")
    public List<Universite> getAllUniversites()
    {return iUniversiteService.getAllUniversites();}

    @PostMapping("/addUniversite")
    @ResponseBody
    public Universite addUniversite(@RequestBody Universite u)
    {return iUniversiteService.addUniversite(u);}

    @PutMapping("/updateUniversite")
    @ResponseBody
    public Universite updateUniversite(@RequestBody Universite u)
    {return iUniversiteService.updateUniversite(u);}

    @DeleteMapping("/removeUniversite/{idUniv}")
    public void removeUniversite(@PathVariable ("idUniv")long idUniv)
    { iUniversiteService.removeUniversite(idUniv);}

    @GetMapping("/retriveUniversite/{idUniv}")
    public Universite retriveUniversite(@PathVariable("idUniv")long idUniv)
    { return iUniversiteService.retrieveUniversite(idUniv);}

    @PutMapping("assignUniversiteToDepartement/{idUniv}/{idDepart}")
    public void  assignUniversiteToDepartement(@PathVariable("idUniv")long idUniv , @PathVariable("idDepart") long idDepart )
    {iUniversiteService.assignUniversiteToDepartement(idUniv,idDepart);}


}
