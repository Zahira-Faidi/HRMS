package ma.emsi.pfa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private String sexe;
    private int nb_enfant;
    private String type_contat;
    private String adresse;
    private String tel;
    private String email;
    @Temporal(TemporalType.DATE)
    private  Date date_emboche;
    private int nb_jourConge;
    //user
    private String login;
    private String password;
    private String role;

}
