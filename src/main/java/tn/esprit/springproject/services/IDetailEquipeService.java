package tn.esprit.springproject.services;

import tn.esprit.springproject.entity.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {
    public List<DetailEquipe> getAllDetailEquipes();
    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe);
    public DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe);
    public DetailEquipe retriveDetailEquipe (long idDetailEquipe);
    public void removeDetailEquipe (long idDetailEquipe);
    public List<DetailEquipe> findByThematiqueLike(String thematique);
}
