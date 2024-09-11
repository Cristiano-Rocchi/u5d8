package cristianorocchi.u5d8.exceptions;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorsPayload {
    private String message;
    private String details;
}

