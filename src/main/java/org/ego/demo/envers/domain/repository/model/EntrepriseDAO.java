package org.ego.demo.envers.domain.repository.model;

import org.ego.demo.envers.domain.model.model1.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseDAO extends JpaRepository<Enterprise,Long> {
    Optional<Enterprise> findByName(String name);
}
