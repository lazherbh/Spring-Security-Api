package com.coderdot.repository;

import com.coderdot.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdministrateurRepository extends JpaRepository<Utilisateur, Long> {
}
