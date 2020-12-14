package org.ego.demo.envers.domain.repository.model;

import org.ego.demo.envers.domain.model3.model2.Department3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Department3DAO extends JpaRepository<Department3,Long> {
    Optional<Department3> findByName(String name);
}
