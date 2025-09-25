/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cultura.cinema.controller;

import br.com.cultura.cinema.model.Analise;
import br.com.cultura.cinema.repository.AnaliseRepository;
import br.com.cultura.cinema.repository.FilmeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author Paulo
 */
@RestController
@RequestMapping("/api/filmes")
public class AnaliseController {

    private final FilmeRepository filmeRepo;
    private final AnaliseRepository analiseRepo;

    public AnaliseController(FilmeRepository filmeRepo, AnaliseRepository analiseRepo) {
        this.filmeRepo = filmeRepo;
        this.analiseRepo = analiseRepo;
    }

    @PostMapping("/{id}/analises")
    public ResponseEntity<Analise> adicionarAnalise(@PathVariable Long id, @RequestBody Analise analise) {
        return filmeRepo.findById(id)
                .map(filme -> {
                    analise.setFilme(filme);
                    Analise salva = analiseRepo.save(analise);
                    return ResponseEntity.ok(salva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/analises")
    public ResponseEntity<List<Analise>> listarAnalises(@PathVariable Long id) {
        return filmeRepo.findById(id)
                .map(filme -> ResponseEntity.ok(filme.getAnalises()))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/analises/{analiseId}")
    public ResponseEntity<Object> deletarAnalise(@PathVariable Long id, @PathVariable Long analiseId) {
        return analiseRepo.findById(analiseId)
                .map(analise -> {
                    analiseRepo.delete(analise);
                    return ResponseEntity.<Void>noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}