package org.ego.demo.envers.domain.repository.model;

import org.ego.demo.envers.domain.model3.model2.Enterprise3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Entreprise3DAO extends JpaRepository<Enterprise3,Long> {
    Optional<Enterprise3> findByName(String name);
}
