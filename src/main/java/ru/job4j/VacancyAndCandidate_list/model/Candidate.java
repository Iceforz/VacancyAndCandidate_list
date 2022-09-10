package ru.job4j.VacancyAndCandidate_list.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Candidate implements Serializable {

    private int id;

    private String name;

    private String description;

    private LocalDate created;

    private boolean visible;

    private City city;

    private byte[] photo;

    public Candidate() {}

    public Candidate(int id, String name, String description, LocalDate created, boolean visible, City city, byte[] photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.visible = visible;
        this.city = city;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Candidate candidate = (Candidate) o;
            return id == candidate.id
                    &&
                    Objects.equals(name, candidate.name)
                    &&
                    Objects.equals(description, candidate.description)
                    &&
                    Objects.equals(created, candidate.created)
                    &&
                    Objects.equals(visible, candidate.visible)
                    &&
                    Objects.equals(city, candidate.city)
                    &&
                    Arrays.equals(photo, candidate.photo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, description, created, visible, city, Arrays.hashCode(photo));
        }
}
