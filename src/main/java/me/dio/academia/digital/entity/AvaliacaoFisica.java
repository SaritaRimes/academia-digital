package me.dio.academia.digital.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {
    /* Atributos */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    // cascade: como alteracoes realizadas nas avaliacoes refletirao nos alunos respectivos
    // JoinColumn: a coluna das chaves estrangeiras estara dentro da tabela de avaliacoes

    private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

    @Positive(message = "O peso precisa ser um valor positivo.")
    @Column(name = "peso_atual")
    private double peso;

    @Positive(message = "A altura precisa ser um valor positivo.")
    @Column(name = "altura_atual")
    private double altura;

    /* Construtores */
    public AvaliacaoFisica(Aluno aluno, LocalDateTime dataDaAvaliacao, double peso, double altura) {
        this.aluno = aluno;
        this.dataDaAvaliacao = dataDaAvaliacao;
        this.peso = peso;
        this.altura = altura;
    }
}
