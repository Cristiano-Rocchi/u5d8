package cristianorocchi.u5d8.services;




import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import cristianorocchi.u5d8.entities.Autore;
import cristianorocchi.u5d8.exceptions.NotFoundException;
import cristianorocchi.u5d8.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private Cloudinary cloudinaryUploader;

    public List<Autore> trovaTutti() {
        return autoreRepository.findAll();
    }

    public Autore salvaAutore(Autore body) {
        return autoreRepository.save(body);
    }

    public Autore trovaPerId(int autoreId) {
        return autoreRepository.findById(autoreId)
                .orElseThrow(() -> new NotFoundException(autoreId));
    }

    public Autore trovaPerIdEAggiorna(int autoreId, Autore autoreAggiornato) {
        Autore autore = trovaPerId(autoreId);
        autore.setNome(autoreAggiornato.getNome());
        autore.setCognome(autoreAggiornato.getCognome());
        autore.setEmail(autoreAggiornato.getEmail());
        autore.setDataDiNascita(autoreAggiornato.getDataDiNascita());
        autore.setAvatar(autoreAggiornato.getAvatar());
        return autoreRepository.save(autore);
    }

    public void trovaPerIdECancella(int autoreId) {
        Autore autore = trovaPerId(autoreId);
        autoreRepository.delete(autore);
    }

    public void uploadImage(MultipartFile file) throws IOException {
       String url=(String) cloudinaryUploader.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        System.out.println("URL------>" + url);
    }
}

