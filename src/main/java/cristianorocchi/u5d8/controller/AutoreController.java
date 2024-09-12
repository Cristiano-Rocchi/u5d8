package cristianorocchi.u5d8.controller;

import cristianorocchi.u5d8.entities.Autore;
import cristianorocchi.u5d8.payloads.NewAutoreDTO;
import cristianorocchi.u5d8.services.AutoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;



import cristianorocchi.u5d8.entities.Autore;
import cristianorocchi.u5d8.payloads.NewAutoreDTO;
import cristianorocchi.u5d8.services.AutoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @GetMapping
    public List<Autore> getAllAutori() {
        return autoreService.trovaTutti();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@Valid @RequestBody NewAutoreDTO newAutoreDTO) {
        Autore autore = new Autore();
        autore.setNome(newAutoreDTO.nome());
        autore.setCognome(newAutoreDTO.cognome());
        autore.setEmail(newAutoreDTO.email());
        autore.setDataDiNascita(newAutoreDTO.dataDiNascita());
        autore.setAvatar(newAutoreDTO.avatar());

        return autoreService.salvaAutore(autore);
    }

    @GetMapping("/{autoreId}")
    public Autore getAutoreById(@PathVariable int autoreId) {
        return autoreService.trovaPerId(autoreId);
    }

    @PutMapping("/{autoreId}")
    public Autore updateAutoreById(@PathVariable int autoreId, @RequestBody Autore body) {
        return autoreService.trovaPerIdEAggiorna(autoreId, body);
    }

    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutoreById(@PathVariable int autoreId) {
        autoreService.trovaPerIdECancella(autoreId);
    }
}
