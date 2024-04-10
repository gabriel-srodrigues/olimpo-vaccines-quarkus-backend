package br.com.bonnasys.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "vaccines")
public class Vaccine {
    @Id
    @Column(length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String producer;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public static Vaccine newVaccine(String name, String producer) {
        Vaccine vaccine = new Vaccine();
        vaccine.name = Objects.requireNonNull(name, "'name' should not be null");
        vaccine.producer = Objects.requireNonNull(producer, "'producer' should not be null");
        OffsetDateTime now = OffsetDateTime.now();
        vaccine.createdAt = now;
        vaccine.updatedAt = now;
        return vaccine;
    }
}
