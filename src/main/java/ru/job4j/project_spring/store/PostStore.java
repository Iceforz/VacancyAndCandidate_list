package ru.job4j.project_spring.store;

import org.springframework.stereotype.Repository;
import ru.job4j.project_spring.model.Post;


import javax.annotation.concurrent.ThreadSafe;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class PostStore {
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private static final AtomicInteger POST_ID = new AtomicInteger(3);

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Junior", LocalDate.now(), false, null));
        posts.put(2, new Post(2, "Middle Java Job", "Middle", LocalDate.now(), false, null));
        posts.put(3, new Post(3, "Senior Java Job", "Senior", LocalDate.now(), false, null));
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        post.setId(POST_ID.incrementAndGet());
        post.setCreated(LocalDate.now());
        posts.put(post.getId(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void update(Post post) {
        posts.replace(post.getId(), post);
    }
}