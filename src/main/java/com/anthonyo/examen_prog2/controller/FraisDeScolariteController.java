package com.anthonyo.examen_prog2.controller;

import com.anthonyo.examen_prog2.model.FraisDeScolarite;
import com.anthonyo.examen_prog2.service.FraisDeScolariteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FraisDeScolariteController {
    private FraisDeScolariteService fraisDeScolariteService;

    @GetMapping("/frais")
    public List<FraisDeScolarite> getAllFrais() {
        return this.fraisDeScolariteService.getAllFrais();
    }

    @GetMapping("/frais/id/{id_FS}")
    public FraisDeScolarite getFraisById(@PathVariable int id_FS) {
        return this.fraisDeScolariteService.getFraisById(id_FS);
    }

    @PostMapping("/frais/insert")
    public FraisDeScolarite createFrais(@RequestBody FraisDeScolarite fraisDeScolarite) {
        return fraisDeScolariteService.createFrais(fraisDeScolarite);
    }

    @PutMapping("/frais/{id_FS}")
    public FraisDeScolarite updateFrais(@PathVariable int id_FS,@RequestBody FraisDeScolarite fraisDeScolarite) {
        return fraisDeScolariteService.updateFrais(id_FS,fraisDeScolarite);
    }

    @DeleteMapping("/frais/delete/{id_FS}")
    public String deleteFrais(@PathVariable int id_FS){
        return fraisDeScolariteService.deleteFrais(id_FS);
    }
}
