package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entity.Departement;
import tn.esprit.springproject.entity.Option;
import tn.esprit.springproject.services.IDepartementService;

import java.util.List;

@RestController

@AllArgsConstructor
public class DepartementController {

    IDepartementService iDepartementService;

    @GetMapping ("/getAllDepartements")
    public List<Departement> getAllDepartement()
    {return iDepartementService.getAllDepartement();}

    @PostMapping("/addDepartement")
    @ResponseBody
    public Departement addDepartement( @RequestBody Departement d)
    {return iDepartementService.addDepartement(d);}

    @PutMapping("/updateDepartement")
    @ResponseBody
    public Departement update(@RequestBody Departement d)
    {return iDepartementService.addDepartement(d);}

    @DeleteMapping("/removeDepartement/{idDepart}")
    public void removeDepartement(@PathVariable("idDepart") long idDepart)
    { iDepartementService.removeDepartement(idDepart);}

    @GetMapping("/retriveDepartement/{idDepart}")
    public Departement retriveDepartement(@PathVariable("idDepart")long idDepart)
    {return iDepartementService.retriveDepartement(idDepart);}

    @GetMapping("/retriveDepartementByOptionEtudiants/{option}")
    public List<Departement> retrieveDepartementByOptionEtudiants(@PathVariable("option") Option option)
    {return  iDepartementService.retrieveDepartementByOptionEtudiants(option);}
    @GetMapping("retrieveDepartementsByUniversite/{idUniv}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUniv") long idUniv)
    {return  iDepartementService.retrieveDepartementsByUniversite(idUniv);}

}
