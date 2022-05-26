package com.desafiodiobanco.Classes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banco {
    private String nome;
    private List<Conta> contas;
}
