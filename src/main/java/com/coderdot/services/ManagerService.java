package com.coderdot.services;


import com.coderdot.entities.Candidature;
import com.coderdot.entities.CompetenceOffre;
import com.coderdot.entities.Domaine;
import com.coderdot.entities.Offre;
import com.coderdot.repository.CompetenceRepository;
import com.coderdot.repository.DomaineRepository;
import com.coderdot.repository.OffreRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ManagerService {


    private final OffreRepository offreRepository;
    private final DomaineRepository domaineRepository;
    private final CompetenceRepository competenceRepository;

    public ManagerService(OffreRepository offreRepository, DomaineRepository domaineRepository, CompetenceRepository competenceRepository) {
        this.offreRepository = offreRepository;
        this.domaineRepository = domaineRepository;
        this.competenceRepository = competenceRepository;
    }

    // Valider Offre
    public void validerOffre(Offre offre) {
        // Implement validation logic here (e.g., check required fields, data integrity)
        // ...

        // If validation passes, set offre.setValide(true) and save it
        //offre.setValide(true);
        offreRepository.save(offre);
    }

    // CRUD Domaines
    public void creerDomaine(Domaine domaine) {
        domaineRepository.save(domaine);
    }

    public void modifierDomaine(Domaine domaine) {
        domaineRepository.save(domaine);
    }

    public void supprimerDomaine(Long domaineId) {
        domaineRepository.deleteById(domaineId);
    }

    public List<Domaine> listerDomaines() {
        return domaineRepository.findAll();
    }

    // CRUD Competences
    public void creerCompetence(CompetenceOffre competence) {
        competenceRepository.save(competence);
    }

    public void modifierCompetence(CompetenceOffre competence) {
        competenceRepository.save(competence);
    }

    public void supprimerCompetence(Long competenceId) {
        competenceRepository.deleteById(competenceId);
    }

    public List<CompetenceOffre> listerCompetences() {
        return competenceRepository.findAll();
    }

    // Consulter Historique Offres
    public List<Offre> consulterHistoriqueOffres() {
        // Implement logic to retrieve historical offers (e.g., archived or expired offers)
        // ...

        return offreRepository.findAll(); // Replace this with your implementation
    }

    // Consulter Historique Candidatures par Offre
    public List<Candidature> consulterHistoriqueCandidatures(Long offreId) {
        // Implement logic to retrieve historical applications for a specific offer
        // ...

        return null; // Replace this with your implementation
    }
}

