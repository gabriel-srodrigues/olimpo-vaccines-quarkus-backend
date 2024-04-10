package br.com.bonnasys.domain.repository;

import br.com.bonnasys.domain.model.Vaccine;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VaccineRepository implements PanacheRepositoryBase<Vaccine, String> {
}
