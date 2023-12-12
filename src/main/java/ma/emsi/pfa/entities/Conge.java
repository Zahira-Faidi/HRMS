package ma.emsi.pfa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date_envoi;
    private int periode;
    @Temporal(TemporalType.DATE)
    private Date date_debut;
    private String fichier_just;
    private String avis;
    private String rais_avis;
    private Date date_avis;
}
