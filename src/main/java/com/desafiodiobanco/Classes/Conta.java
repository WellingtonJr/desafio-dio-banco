package com.desafiodiobanco.Classes;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> transacoes;


    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.transacoes= new ArrayList<>();
    }
  
    @Override
    public void sacar(double valor) {
        transacoes.add(new Transacao("Saque", valor, this));
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        transacoes.add(new Transacao("Depósito", valor, this));
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        transacoes.add(new Transacao("Transferência", valor, this, contaDestino));
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }


    public void imprimirExtradoDetalhado(){
        System.out.println("=== Extrato Detalhado ===");
		System.out.println("Cliente: " + this.getCliente().getNome());
		System.out.println("Agencia: " + this.getAgencia());
		System.out.println("Numero: " + this.getNumero());
		for (Transacao t : this.getTransacoes()) {
			if(t.getContaFavorecida() != null){
				System.out.println(String.format("Transação: %s || Valor: %.2f || Cliente Favorecido: %s", 
												t.getTipo(),t.getValor(),t.getContaFavorecida().getCliente().getNome() ));
			}
			else{
				System.out.println(String.format("Transação: %s || Valor: %.2f", t.getTipo(),t.getValor() ));
			}
		}
		
    }

}
