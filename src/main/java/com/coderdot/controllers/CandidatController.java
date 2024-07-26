package com.coderdot.controllers;

import com.coderdot.entities.Candidature;
import com.coderdot.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/candidats")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @PostMapping("/{candidatId}/postuler/{offreId}")
    public ResponseEntity postuler(@PathVariable Long candidatId, @PathVariable Long offreId) {
        candidatService.postuler(candidatId, offreId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{candidatId}/historique-candidatures")
    public ResponseEntity<List<Candidature>> consulterHistoriqueCandidature(@PathVariable Long candidatId) {
        List<Candidature> candidatures = candidatService.consulterHistoriqueCandidature(candidatId);
        return ResponseEntity.ok(candidatures);
    }


}

