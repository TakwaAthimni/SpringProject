package tn.esprit.springproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entity.Universite;

public interface UniversiteRepository extends JpaRepository <Universite, Long> {
}
