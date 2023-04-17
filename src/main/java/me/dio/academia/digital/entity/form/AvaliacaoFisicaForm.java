package me.dio.academia.digital.entity.form;

import lombok.*;
import me.dio.academia.digital.entity.Aluno;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

    private Long alunoId;

    private double peso;

    private double altura;
}
