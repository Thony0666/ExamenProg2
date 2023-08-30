package com.anthonyo.examen_prog2.controller;

import com.anthonyo.examen_prog2.model.Etudiant;
import com.anthonyo.examen_prog2.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController {
    private EtudiantService etudiantService;

    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants() {
        return this.etudiantService.getAllEtudiants();
    }



    @GetMapping("/etudiants/std/{std}")
    public Etudiant getStudentsByStd(@PathVariable String std) {
        return this.etudiantService.getStudiantById(std);
    }

    @PostMapping("/etudiants/insert")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.createEtudiant(etudiant);
    }

    @PutMapping("/etudiants/{std}")
    public Etudiant updateEtudiant(@PathVariable String std,@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(std,etudiant);
    }

    @DeleteMapping("/etudiants/delete/{std}")
    public String deleteEtudiant(@PathVariable String std){
        return etudiantService.deleteEtudiant(std);
    }
}
