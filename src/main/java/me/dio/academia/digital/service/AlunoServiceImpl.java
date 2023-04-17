package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public Aluno create(AlunoForm alunoForm) {
        Aluno aluno = new Aluno(
                alunoForm.getNome(),
                alunoForm.getCpf(),
                alunoForm.getBairro(),
                alunoForm.getDataDeNascimento()
        );

        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        return alunoOptional.orElse(null);
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public List<Aluno> getAllByDataDeNascimento(String dataDeNascimento) {
        if (dataDeNascimento == null || dataDeNascimento.isEmpty())
            return List.of();
        else {
            LocalDate data = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return alunoRepository.findByDataDeNascimento(data);
        }
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaPorId(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        return alunoOptional.map(Aluno::getAvaliacoes).orElse(null);
    }

    @Override
    public Aluno updateById(Long id, AlunoUpdateForm alunoUpdateForm) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();

            if (alunoUpdateForm.getNome() != null && !alunoUpdateForm.getNome().isEmpty())
                aluno.setNome(alunoUpdateForm.getNome());

            if (alunoUpdateForm.getBairro() != null && !alunoUpdateForm.getBairro().isEmpty())
                aluno.setBairro(alunoUpdateForm.getBairro());

            if (alunoUpdateForm.getDataDeNascimento() != null)
                aluno.setDataDeNascimento(alunoUpdateForm.getDataDeNascimento());

            return alunoRepository.save(aluno);
        } else
            return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            List<Matricula> matricula = matriculaRepository.findByAluno(aluno);

            if (matricula != null)
                matriculaRepository.deleteAll(matricula);

            alunoRepository.delete(aluno);
        }
    }
}
