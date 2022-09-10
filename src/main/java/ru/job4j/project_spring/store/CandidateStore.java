package ru.job4j.project_spring.store;

import org.springframework.stereotype.Repository;
import ru.job4j.project_spring.model.Candidate;

import javax.annotation.concurrent.ThreadSafe;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class CandidateStore {

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

        private final static AtomicInteger CANDIDATE_ID = new AtomicInteger(3);

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Alex", "looking for junior", LocalDate.now(), false, null, null));
        candidates.put(2, new Candidate(2, "Nick", "looking for middle", LocalDate.now(), false, null, null));
        candidates.put(3, new Candidate(3, "Mike", "looking for senior", LocalDate.now(), false, null, null));
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void add(Candidate candidate) {
        candidates.put(candidate.getId(), candidate);
        candidate.setCreated(LocalDate.now());
        candidate.setId(CANDIDATE_ID.incrementAndGet());
    }

    public void update(Candidate candidate) {
         candidates.replace(candidate.getId(), candidate);
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }
}
