package cristianorocchi.u5d8.services;

import cristianorocchi.u5d8.entities.Post;
import cristianorocchi.u5d8.entities.Autore;
import cristianorocchi.u5d8.exceptions.NotFoundException;
import cristianorocchi.u5d8.payloads.BlogPostPayload;
import cristianorocchi.u5d8.repositories.AutoreRepository;
import cristianorocchi.u5d8.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    public List<Post> trovaTutti() {
        return postRepository.findAll();
    }

    public Post salvaPost(BlogPostPayload payload) {
        Autore autore = autoreRepository.findById(payload.getAutoreId())
                .orElseThrow(() -> new NotFoundException(payload.getAutoreId()));

        Post newPost = new Post();
        newPost.setTitolo(payload.getTitolo());
        newPost.setContenuto(payload.getContenuto());
        newPost.setTempoDiLettura(payload.getTempoDiLettura());
        newPost.setCategoria(payload.getCategoria());  
        newPost.setCover(payload.getCover());
        newPost.setAutore(autore);

        return postRepository.save(newPost);
    }


    public Page<Post> trovaTuttiPaginati(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Post trovaPerId(int postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(postId));
    }

    public Post trovaPerIdEAggiorna(int postId, Post postAggiornato) {
        Post post = trovaPerId(postId);
        post.setCategoria(postAggiornato.getCategoria());
        post.setTitolo(postAggiornato.getTitolo());
        post.setCover(postAggiornato.getCover());
        post.setContenuto(postAggiornato.getContenuto());
        post.setTempoDiLettura(postAggiornato.getTempoDiLettura());
        return postRepository.save(post);
    }

    public void trovaPerIdECancella(int postId) {
        Post post = trovaPerId(postId);
        postRepository.delete(post);
    }
}
