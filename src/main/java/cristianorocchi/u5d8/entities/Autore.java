package cristianorocchi.u5d8.entities;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Autori")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String dataDiNascita;
    private String avatar;
}
