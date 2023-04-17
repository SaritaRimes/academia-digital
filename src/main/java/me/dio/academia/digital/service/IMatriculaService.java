package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;

import java.util.List;

public interface IMatriculaService {
    Matricula create(MatriculaForm form);
    List<Matricula> getByAluno(Long idAluno);
    List<Matricula> getAll();
    List<Matricula> getAllByBairro(String bairro);
    void deleteByIdAluno(Long idAluno);
}
