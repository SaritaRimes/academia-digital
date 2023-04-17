package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm matriculaForm) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(matriculaForm.getAlunoId());

        if (alunoOptional.isPresent()) {
            Matricula matricula = new Matricula(
                    alunoOptional.get(),
                    LocalDateTime.now()
            );

            return matriculaRepository.save(matricula);
        } else
            return null;
    }

    @Override
    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public List<Matricula> getByAluno(Long idAluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(idAluno);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();

            return matriculaRepository.findByAluno(aluno);
        } else
            return List.of();
    }

    @Override
    public List<Matricula> getAllByBairro(String bairro) {
        if (bairro == null || bairro.isEmpty())
            return List.of();
        else
            return matriculaRepository.findByAlunoBairro(bairro);
    }

    @Override
    public void deleteByIdAluno(Long idAluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(idAluno);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();

            List<Matricula> matriculas = matriculaRepository.findByAluno(aluno);

            matriculaRepository.deleteAll(matriculas);
        }
    }
}
