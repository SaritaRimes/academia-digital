package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaServiceImpl matriculaService;

    @GetMapping
    public List<Matricula> getAll() {
        return matriculaService.getAll();
    }

    @GetMapping("/aluno")
    public List<Matricula> getByAluno(@RequestParam Long idAluno) {
        return matriculaService.getByAluno(idAluno);
    }

    @GetMapping("/bairro")
    public List<Matricula> getAllPorBairro(@RequestParam String bairro) {
        return matriculaService.getAllByBairro(bairro);
    }

    @PostMapping
    public Matricula create(@RequestBody MatriculaForm matriculaForm) {
        return matriculaService.create(matriculaForm);
    }

    @DeleteMapping("/deletar")
    public void deleteByIdAluno(@RequestParam Long idAluno) {
        matriculaService.deleteByIdAluno(idAluno);
    }
}
