package me.dio.academia.digital.entity.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MatriculaForm {
    @NotNull(message = "A matricula não pode ser vazia.")
    @Positive(message = "O Id do aluno precisa ser positivo.")
    private Long alunoId;
}
