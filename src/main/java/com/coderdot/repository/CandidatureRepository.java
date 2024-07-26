package com.coderdot.repository;

import com.coderdot.entities.Candidature;
import com.coderdot.entities.Offre;
import com.coderdot.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
    List<Candidature> findByCandidat(Utilisateur utilisateur);

    List<Candidature> findByOffre(Offre offre);
}
