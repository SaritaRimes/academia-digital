package me.dio.academia.digital.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "tb_matriculas")
public class Matricula {
    /* Atributos */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    // cascade: como alteracoes realizadas na matricula refletirao no aluno respectivo
    // JoinColumn: a coluna das chaves estrangeiras estara dentro da tabela de matriculas

    private LocalDateTime dataDaMatricula = LocalDateTime.now();

    /* Construtores */
    public Matricula(Aluno aluno, LocalDateTime dataDaMatricula) {
        this.aluno = aluno;
        this.dataDaMatricula = dataDaMatricula;
    }
}
