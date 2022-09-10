package ru.job4j.project_spring.store;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import ru.job4j.project_spring.Main;
import ru.job4j.project_spring.model.City;
import ru.job4j.project_spring.model.Post;

import java.time.LocalDate;


class PostDBStoreTest {

    @Test
    public void whenCreatePost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post(0, "Java Job", "specialist", LocalDate.now(), true, new City(1, null));
        store.add(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }
}