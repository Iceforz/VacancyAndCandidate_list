package ru.job4j.VacancyAndCandidate_list.service;

import org.springframework.stereotype.Service;

import ru.job4j.VacancyAndCandidate_list.model.Candidate;

import ru.job4j.VacancyAndCandidate_list.store.CandidateDBStore;


import javax.annotation.concurrent.ThreadSafe;
import java.util.Collection;
import java.util.List;

@ThreadSafe
@Service
public class CandidateService {

    private final CandidateDBStore store;

    private final CityService cityService;

    public CandidateService(CandidateDBStore store, CityService cityService) {
        this.store = store;
        this.cityService = cityService;
    }

    public Collection<Candidate> findAll() {
        List<Candidate> candidates = store.findAll();
        candidates.forEach(
                candidate -> candidate.setCity(
                        cityService.findById(candidate.getCity().getId())
                )
        );
        return candidates;
    }

    public void add(Candidate candidate) {
        store.add(candidate);
    }

    public Candidate findById(int id) {
        return store.findById(id);
    }

    public void update(Candidate candidate) {
        store.update(candidate);
    }
}


