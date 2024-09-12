package cristianorocchi.u5d8.payloads;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewAutoreDTO(

        @NotEmpty(message = "Il nome dell'autore è obbligatorio")
        @Size(min = 2, max = 40, message = "Il nome dell'autore deve essere compreso tra 2 e 40 caratteri")
        String nome,

        @NotEmpty(message = "Il cognome dell'autore è obbligatorio")
        @Size(min = 2, max = 40, message = "Il cognome dell'autore deve essere compreso tra 2 e 40 caratteri")
        String cognome,

        @NotEmpty(message = "L'email è obbligatoria")
        @Email(message = "L'email inserita non è valida")
        String email,

        @NotEmpty(message = "La data di nascita è obbligatoria")
        String dataDiNascita,

        String avatar

) {}
