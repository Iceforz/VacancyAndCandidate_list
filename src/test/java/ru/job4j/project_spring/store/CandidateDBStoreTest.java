package ru.job4j.project_spring.store;

import org.junit.jupiter.api.Test;
import ru.job4j.project_spring.Main;
import ru.job4j.project_spring.model.Candidate;
import ru.job4j.project_spring.model.City;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CandidateDBStoreTest {

    @Test
    public void whenCreateCandidate() {
        CandidateDBStore store = new CandidateDBStore(new Main().loadPool());
        Candidate candidate = new Candidate(0, "Candidate Name", "Skills", LocalDate.now(), false, new City(1, null), new byte[0]);
        store.add(candidate);
        Candidate candidateInDB = store.findById(candidate.getId());
        assertThat(candidateInDB.getName(), is(candidate.getName()));
    }
}