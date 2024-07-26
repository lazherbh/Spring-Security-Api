package com.coderdot.repository;

import com.coderdot.entities.CompetenceOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompetenceRepository extends JpaRepository<CompetenceOffre, Long> {
}
