package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;

import java.util.List;

public interface IAlunoService {
    Aluno create(AlunoForm form);
    Aluno get(Long id);
    List<Aluno> getAll();
    List<Aluno> getAllByDataDeNascimento(String dataDeNascimento);
    Aluno updateById(Long id, AlunoUpdateForm formUpdate);
    List<AvaliacaoFisica> getAllAvaliacaoFisicaPorId(Long id);
    void deleteById(Long id);
}
