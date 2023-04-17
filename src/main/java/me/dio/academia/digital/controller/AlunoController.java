package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private IAlunoService alunoService;

    @GetMapping("/{id}")
    public Aluno get(@PathVariable Long id) {
        return alunoService.get(id);
    }

    @GetMapping
    public List<Aluno> getAll() {
        return alunoService.getAll();
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id) {
        return alunoService.getAllAvaliacaoFisicaPorId(id);
    }

    @GetMapping("/dataDeNascimento")
    public List<Aluno> getAllByDataDeNascimento(@RequestParam String dataDeNascimento) {
        return alunoService.getAllByDataDeNascimento(dataDeNascimento);
    }

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm alunoForm) {
        return alunoService.create(alunoForm);
    }

    @PatchMapping("/atualizar/{id}")
    public Aluno update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateForm alunoUpdateForm) {
        return alunoService.updateById(id, alunoUpdateForm);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteById(@PathVariable Long id) {
        alunoService.deleteById(id);
    }
}
