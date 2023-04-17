package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
public class AvaliacaoFisicaUpdateForm {
    @NotNull
    @Positive(message = "O peso precisa ser um valor positivo.")
    private double peso;

    @NotNull
    @Positive(message = "A altura precisa ser um valor positivo.")
    private double altura;
}
