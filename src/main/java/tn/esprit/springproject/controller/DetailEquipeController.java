package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entity.DetailEquipe;
import tn.esprit.springproject.services.IDetailEquipeService;

import java.util.List;

@AllArgsConstructor
@RestController
public class DetailEquipeController {
    IDetailEquipeService iDetailEquipeService;

    @GetMapping("/getAllDetailEquipes")
    public List<DetailEquipe> getAllDetailEquipes()
    {return iDetailEquipeService.getAllDetailEquipes(); }

    @PostMapping("/addDetailEquipe")
    @ResponseBody
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe detailEquipe)
    {return iDetailEquipeService.addDetailEquipe(detailEquipe);}

    @PutMapping("/updateDetailEquipe")
    @ResponseBody
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe detailEquipe)
    {return iDetailEquipeService.updateDetailEquipe(detailEquipe);}

    @DeleteMapping("/removeDetailEquipe/{idDetailEquipe}")
    public void removeDetailEquipe(@PathVariable("idDetailEquipe") long idDetailEquipe)
    { iDetailEquipeService.removeDetailEquipe(idDetailEquipe);}

    @GetMapping("/retriveDetailEquipe/{idDetailEquipe}")
    public DetailEquipe retriveDetailEquipe(@PathVariable("idDetailEquipe") long idDetailEquipe)
    { return iDetailEquipeService.retriveDetailEquipe(idDetailEquipe);}

    @GetMapping("/getAllDetailEquipe/Thematique/{thematique}")
    public List<DetailEquipe> getDetailEquipeByThematique(@PathVariable ("thematique") String thematique )
            {
        return iDetailEquipeService.findByThematiqueLike(thematique);
}

}
