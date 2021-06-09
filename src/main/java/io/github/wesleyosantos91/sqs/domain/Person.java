package io.github.wesleyosantos91.sqs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private LocalDate dateOfBirth;
    private String cpf;
    private String email;
}
