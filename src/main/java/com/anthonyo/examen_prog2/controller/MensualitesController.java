package com.anthonyo.examen_prog2.controller;

import com.anthonyo.examen_prog2.model.Mensualites;
import com.anthonyo.examen_prog2.service.MensualitesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
public class MensualitesController {
    private MensualitesService mensualitesService;

    @GetMapping("/mensualites")
    public List<Mensualites> getAllmensualites() {
        return this.mensualitesService.getAllmensualites();
    }

    @GetMapping("/mensualites/id/{id_mois}")
    public Mensualites getStudentsByStd(@PathVariable int id_mois) {
        return this.mensualitesService.getMoisById(id_mois);
    }

    @PostMapping("/mensualites/insert")
    public Mensualites createMois(@RequestBody Mensualites mensualites) {
        return mensualitesService.createMois(mensualites);
    }

    @PutMapping("/mensualites/{id_mois}")
    public Mensualites updateMois(@PathVariable int id_mois,@RequestBody Mensualites mensualites) {
        return mensualitesService.updateMois(id_mois,mensualites);
    }

    @DeleteMapping("/mensualites/delete/{id_mois}")
    public String deleteMois(@PathVariable int id_mois){
        return mensualitesService.deleteMois(id_mois);
    }

}
