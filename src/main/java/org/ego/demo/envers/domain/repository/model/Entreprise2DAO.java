package org.ego.demo.envers.domain.repository.model;

import org.ego.demo.envers.domain.model.model2.Enterprise2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Entreprise2DAO extends JpaRepository<Enterprise2,Long> {
    Optional<Enterprise2> findByName(String name);
}
