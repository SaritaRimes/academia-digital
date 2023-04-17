package me.dio.academia.digital.entity.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AlunoForm {
    @NotEmpty(message = "O campo nome não pode ser vazio.")
    @Size(min = 3, max = 50, message = "o nome precisa ter entre {min} e {max} caracteres.")
    private String nome;

    @NotEmpty(message = "O campo CPF não pode ser vazio.")
//    @CPF(message = "Digite um CPF válido.")
    private String cpf;

    @NotEmpty(message = "O campo bairro não pode ser vazio.")
    @Size(min = 3, max = 50, message = "O bairro precisa ter entre {min} e {max} caracteres.")
    private String bairro;

    @NotNull(message = "O campo data de nascimento não pode ser vazio.")
    @Past(message = "Digite uma data de nascimento válida.")
    private LocalDate dataDeNascimento;
}
