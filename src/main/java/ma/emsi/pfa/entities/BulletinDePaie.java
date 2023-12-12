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
public class BulletinDePaie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double salaire_base;
    private Double salaire_brut;
    private Double net_apayer;
    @Temporal(TemporalType.DATE)
    private Date date_entre;
    private String status;
}
