package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaService implements IAvaliacaoFisicaService {
    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm avaliacaoFisicaForm) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(avaliacaoFisicaForm.getAlunoId());

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();

            AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica(
                    aluno,
                    LocalDateTime.now(),
                    avaliacaoFisicaForm.getPeso(),
                    avaliacaoFisicaForm.getAltura()
            );

            return avaliacaoFisicaRepository.save(avaliacaoFisica);
        } else
            return null;
    }

    @Override
    public List<AvaliacaoFisica> getByAluno(Long idAluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(idAluno);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();

            return avaliacaoFisicaRepository.findByAluno(aluno);
        } else
            return List.of();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm avaliacaoFisicaUpdateForm) {
        Optional<AvaliacaoFisica> avaliacaoFisicaOptional = avaliacaoFisicaRepository.findById(id);

        if (avaliacaoFisicaOptional.isPresent()) {
            AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaOptional.get();

            if (avaliacaoFisicaUpdateForm.getPeso() != 0d)
                avaliacaoFisica.setPeso(avaliacaoFisicaUpdateForm.getPeso());

            if (avaliacaoFisicaUpdateForm.getAltura() != 0d)
                avaliacaoFisica.setAltura(avaliacaoFisicaUpdateForm.getAltura());

            return avaliacaoFisicaRepository.save(avaliacaoFisica);
        } else
            return null;
    }
}
