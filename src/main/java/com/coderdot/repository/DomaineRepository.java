package com.coderdot.repository;

import com.coderdot.entities.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Long> {
}
