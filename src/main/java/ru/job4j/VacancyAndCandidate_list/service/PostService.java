package ru.job4j.VacancyAndCandidate_list.service;

import org.springframework.stereotype.Service;
import ru.job4j.VacancyAndCandidate_list.model.Post;
import ru.job4j.VacancyAndCandidate_list.store.PostDBStore;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Collection;
import java.util.List;

@ThreadSafe
@Service
public class PostService {
    private final PostDBStore store;
    private final CityService cityService;

    public PostService(PostDBStore store, CityService cityService) {
        this.store = store;
        this.cityService = cityService;
    }

        public void add(Post post) {
            store.add(post);
        }

        public Post findById(int id) {
            return store.findById(id);
        }

        public void update(Post post) {
            store.update(post);
        }

    public Collection<Post> findAll() {
        List<Post> posts = store.findAll();
        posts.forEach(
                post -> post.setCity(
                        cityService.findById(post.getCity().getId())
                )
        );
        return posts;
    }
}
