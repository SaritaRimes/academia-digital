package me.dio.academia.digital.entity.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AlunoUpdateForm {
    @Size(min = 3, max = 50, message = "o nome precisa ter entre {min} e {max} caracteres.")
    private String nome;

    @Size(min = 3, max = 50, message = "O bairro precisa ter entre {min} e {max} caracteres.")
    private String bairro;

    @Past(message = "Digite uma data de nascimento válida.")
    private LocalDate dataDeNascimento;
}
