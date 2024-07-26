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
public class ResponsableRHService {

    @Autowired
    private  ManagerService managerService;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private CandidatureRepository candidatureRepository;

    // Méthode créerOffre
    public void creerOffre(Offre offre) {
        
        offreRepository.save(offre);
    }

    // Méthode modifierOffre
    public void modifierOffre(Offre offre) {
        
        offreRepository.save(offre);
    }

    // Méthode archiverOffre
    public void archiverOffre(Long offreId) {
        Offre offre = offreRepository.findById(offreId).orElseThrow();
        offre.setArchive(true);
        offreRepository.save(offre);
    }

    // Méthode listerOffres
    public List<Offre> listerOffres() {
        
        return offreRepository.findAll();
    }
    public Offre getOneOffre(Long idOffre) {
        // Implement logic to retrieve the Offre object with the given id
        // For example, using a repository or database access layer
        Offre offre = offreRepository.findById(idOffre).orElseThrow(  );
        return offre;
    }
    /*Méthode publierOffre
    public void publierOffre(long offreId) {
        Offre offre = offreRepository.findById(offreId).orElseThrow();

        if (!offre.isValide()) {
            // Offer not validated, delete it
            offreRepository.delete(offre);
            return;
        }
        offre.setDatePublication(LocalDate.now());
        offreRepository.save(offre);

    }
*/
    // Méthode gérerCandidatures
    public void créerCandidature(Long offreId, Long candidatId) {
        Offre offre = offreRepository.findById(offreId).orElseThrow();
        Utilisateur candidat = candidatRepository.findById(candidatId).orElseThrow();

        // Vérifier si le candidat est éligible pour l'offre
        // ...

        Candidature candidature = new Candidature();
        candidature.setCandidat(candidat);
        candidature.setOffre(offre);
        candidature.setStatut("En cours");
        candidature.setDatePostulation(LocalDate.now());

        // Calculer le pourcentage d'adéquation du candidat
        // ...

        candidatureRepository.save(candidature);
    }

    public void modifierCandidature(Long candidatureId, Candidature candidature) {
        Candidature candidatureExistante = candidatureRepository.findById(candidatureId).orElseThrow();

        // Valider les modifications apportées à la candidature
        // ...

        candidatureExistante.setStatut(candidature.getStatut());
        candidatureExistante.setDateEntretien(candidature.getDateEntretien());
        candidatureExistante.setMotifRefus(candidature.getMotifRefus());
        candidatureExistante.setNiveauxAcquis(candidature.getNiveauxAcquis());
        candidatureExistante.setPourcentageAdequationGlobale(candidature.getPourcentageAdequationGlobale());

        candidatureRepository.save(candidatureExistante);
    }

    public void supprimerCandidature(Long candidatureId) {
        candidatureRepository.deleteById(candidatureId);
    }

    public Candidature consulterCandidatureDetails(Long candidatureId) {
        Candidature candidature = candidatureRepository.findById(candidatureId).orElseThrow();

        // Enrichir la candidature avec des informations supplémentaires (candidat, offre, ...)
        // ...

        return candidature;
    }

    public List<Candidature> consulterCandidaturesParOffre(Long offreId) {
        Offre offre = offreRepository.findById(offreId).orElseThrow();
        List<Candidature> candidatures = candidatureRepository.findByOffre(offre);

        // Enrichir les candidatures avec des informations supplémentaires (candidat, statut, ...)
        for (Candidature candidature : candidatures) {
            Utilisateur candidat = candidatRepository.findById(candidature.getCandidat().getId()).orElseThrow();
            candidature.setCandidat(candidat);

            // Enrichir avec d'autres informations selon vos besoins (statut, date entretien, ...)
        }

        return candidatures;
    }



    // ... autres méthodes du service ResponsableRH ...
}

