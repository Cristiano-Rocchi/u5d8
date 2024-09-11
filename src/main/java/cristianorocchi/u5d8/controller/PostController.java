package cristianorocchi.u5d8.controller;


import cristianorocchi.u5d8.entities.Post;
import cristianorocchi.u5d8.payloads.BlogPostPayload;
import cristianorocchi.u5d8.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public Page<Post> getAllPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return postService.trovaTuttiPaginati(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody BlogPostPayload payload) {
        return postService.salvaPost(payload);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable int postId) {
        return postService.trovaPerId(postId);
    }

    @PutMapping("/{postId}")
    public Post updatePostById(@PathVariable int postId, @RequestBody Post body) {
        return postService.trovaPerIdEAggiorna(postId, body);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostById(@PathVariable int postId) {
        postService.trovaPerIdECancella(postId);
    }
}
