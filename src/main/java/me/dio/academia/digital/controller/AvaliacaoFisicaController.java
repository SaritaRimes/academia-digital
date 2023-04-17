package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
    @Autowired
    private IAvaliacaoFisicaService avaliacaoFisicaService;

    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaService.getAll();
    }

    @GetMapping("/aluno")
    public List<AvaliacaoFisica> getByAluno(@RequestParam Long idAluno) {
        return avaliacaoFisicaService.getByAluno(idAluno);
    }

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm avaliacaoFisicaForm) {
        return avaliacaoFisicaService.create(avaliacaoFisicaForm);
    }

    @PatchMapping("/atualizar/{id}")
    public AvaliacaoFisica update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm avaliacaoFisicaUpdateForm) {
        return avaliacaoFisicaService.update(id, avaliacaoFisicaUpdateForm);
    }
}
