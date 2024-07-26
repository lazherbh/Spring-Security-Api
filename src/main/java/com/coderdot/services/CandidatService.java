package com.coderdot.services;

import com.coderdot.entities.Candidature;
import com.coderdot.entities.Offre;
import com.coderdot.entities.Utilisateur;
import com.coderdot.repository.CandidatRepository;
import com.coderdot.repository.CandidatureRepository;
import com.coderdot.repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private CandidatureRepository candidatureRepository;

    // Méthode postuler
    public void postuler(Long candidatId, Long offreId) {
        Utilisateur candidat = candidatRepository.findById(candidatId).orElseThrow();
        Offre offre = offreRepository.findById(offreId).orElseThrow();

        // Vérifier l'éligibilité du candidat et l'existence d'une candidature existante

        Candidature candidature = new Candidature();
        candidature.setCandidat(candidat);
        candidature.setOffre(offre);
        candidature.setStatut("En cours");
        candidature.setDatePostulation(LocalDate.now());

        // Calculer le pourcentage d'adéquation du candidat

        candidatureRepository.save(candidature);
    }

    // Méthode consulterHistoriqueCandidature
    public List<Candidature> consulterHistoriqueCandidature(Long candidatId) {
        Utilisateur candidat = candidatRepository.findById(candidatId).orElseThrow();
        List<Candidature> candidatures = candidatureRepository.findByCandidat(candidat);

        // Enrichir les candidatures avec des informations détaillées

        return candidatures;
    }


}

