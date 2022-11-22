package tn.esprit.springproject.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table  (name ="Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="idEtudiant")
    private Long idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne
    @JsonIgnore
    private Departement departement;
    @OneToMany (mappedBy = "etudiant", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Contrat> Contrats;
    @ManyToMany(mappedBy="etudiants", cascade = CascadeType.PERSIST)
    //@JsonIgnore
    private Set<Equipe> equipes ;
}
