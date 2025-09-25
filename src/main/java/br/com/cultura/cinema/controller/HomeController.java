package br.com.cultura.cinema.controller;

import br.com.cultura.cinema.model.Analise;
import br.com.cultura.cinema.model.Filme;
import br.com.cultura.cinema.repository.AnaliseRepository;
import br.com.cultura.cinema.repository.FilmeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final FilmeRepository filmeRepo;
    private final AnaliseRepository analiseRepo;

    public HomeController(FilmeRepository filmeRepo, AnaliseRepository analiseRepo) {
        this.filmeRepo = filmeRepo;
        this.analiseRepo = analiseRepo;
    }

    @GetMapping("/filmes")
    public String listarFilmes(Model model) {
        model.addAttribute("filmes", filmeRepo.findAll());
        return "listar-filmes"; // templates/listar-filmes.html
    }

    @GetMapping("/filmes/novo")
    public String novoFilme(Model model) {
        model.addAttribute("filme", new Filme());
        return "cadastro-filme"; // templates/cadastro-filme.html
    }

    @PostMapping("/filmes")
    public String salvarFilme(@ModelAttribute Filme filme) {
        filmeRepo.save(filme);
        return "redirect:/filmes";
    }

    @GetMapping("/filmes/{id}")
    public String detalhesFilme(@PathVariable Long id, Model model) {
        filmeRepo.findById(id).ifPresent(filme -> {
            model.addAttribute("filme", filme);
            model.addAttribute("analise", new Analise());
        });
        return "detalhes-filme"; // templates/detalhes-filme.html
    }
    
    @PostMapping("/filmes/{id}/analises")
    public String adicionarAnalise(@PathVariable Long id, @ModelAttribute Analise analise) {
        filmeRepo.findById(id).ifPresent(filme -> {
            analise.setFilme(filme);
            analiseRepo.save(analise);
        });
        return "redirect:/filmes/" + id;
    }
}