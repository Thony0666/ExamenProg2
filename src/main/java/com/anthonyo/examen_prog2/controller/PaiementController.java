package com.anthonyo.examen_prog2.controller;

import com.anthonyo.examen_prog2.model.Etudiant;
import com.anthonyo.examen_prog2.model.Mensualites;
import com.anthonyo.examen_prog2.model.Paiements;
import com.anthonyo.examen_prog2.service.EtudiantService;
import com.anthonyo.examen_prog2.service.PaiementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PaiementController {
    private PaiementService paiementService;

    @GetMapping("/paiements")
    public List<Paiements> getAllPaiements() {
        return this.paiementService.getAllPaiements();
    }

    @GetMapping("/paiements/id/{id_paiements}")
    public Paiements getStudentsByStd(@PathVariable int id_paiements) {
        return this.paiementService.getPaiementsById(id_paiements);
    }

    @PostMapping("/paiements/insert")
    public Paiements createMois(@RequestBody Paiements paiements) {
        return paiementService.createPaiements(paiements);
    }

    @PutMapping("/paiements/{id_paiements}")
    public Paiements updateMois(@PathVariable int id_paiements,@RequestBody Paiements paiements) {
        return paiementService.updatePaiements(id_paiements,paiements);
    }

    @DeleteMapping("/paiements/delete/{id_paiements}")
    public String deletePaiements(@PathVariable int id_paiements){
        return paiementService.deletePaiements(id_paiements);
    }

}
