package cristianorocchi.u5d8.payloads;





import lombok.Data;

@Data
public class BlogPostPayload {
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;
    private String categoria;
    private String cover;
}

