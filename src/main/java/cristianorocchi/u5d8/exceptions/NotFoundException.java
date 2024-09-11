package cristianorocchi.u5d8.exceptions;



public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Elemento con ID " + id + " non trovato");
    }
}
