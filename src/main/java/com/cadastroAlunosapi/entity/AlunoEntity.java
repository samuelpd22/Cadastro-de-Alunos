package com.cadastroAlunosapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "alunosregistr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoEntity {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    private String primeiroName;

    private String segundoName;

    private String classe;


}
