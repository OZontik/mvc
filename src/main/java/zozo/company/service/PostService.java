package zozo.company.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import zozo.company.exception.NotFoundException;
import zozo.company.model.Post;
import zozo.company.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    // сервис завязан на интерфейс, а не на конкретную реализацию
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}