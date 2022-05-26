package com.desafiodiobanco.Classes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transacao {
    private String tipo;
    private double valor;
    private Conta conta;
    private Conta contaFavorecida;

    public Transacao(String tipo, double valor, Conta conta) {
        this.tipo = tipo;
        this.valor = valor;
        this.conta = conta;
    }

    public Transacao(String tipo, double valor, Conta conta, Conta contaFavorecida) {
        this.tipo = tipo;
        this.valor = valor;
        this.conta = conta;
        this.contaFavorecida = contaFavorecida;
    }
    
    
}
