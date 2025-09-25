/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cultura.cinema.controller;

import br.com.cultura.cinema.model.Filme;
import br.com.cultura.cinema.repository.AnaliseRepository;
import br.com.cultura.cinema.repository.FilmeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    private final FilmeRepository filmeRepo;
    private final AnaliseRepository analiseRepo;

    // Construtor para injeção de dependência
    public FilmeController(FilmeRepository filmeRepo, AnaliseRepository analiseRepo) {
        this.filmeRepo = filmeRepo;
        this.analiseRepo = analiseRepo;
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarFilme(@PathVariable Long id) {
        return filmeRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme) {
        return filmeRepo.save(filme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@PathVariable Long id, @RequestBody Filme filmeAtualizado) {
        return filmeRepo.findById(id).map(filme -> {
            filme.setTitulo(filmeAtualizado.getTitulo());
            filme.setSinopse(filmeAtualizado.getSinopse());
            filme.setGenero(filmeAtualizado.getGenero());
            filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());
            return ResponseEntity.ok(filmeRepo.save(filme));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (filmeRepo.existsById(id)) {
            filmeRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}