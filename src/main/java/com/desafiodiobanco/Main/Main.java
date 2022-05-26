package com.desafiodiobanco.Main;

import com.desafiodiobanco.Classes.Cliente;
import com.desafiodiobanco.Classes.Conta;
import com.desafiodiobanco.Classes.ContaCorrente;
import com.desafiodiobanco.Classes.ContaPoupanca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		Cliente wellington = new Cliente();
        wellington.setNome("Wellington");

        Conta cc = new ContaCorrente(wellington);
        cc.depositar(100);
		
        Conta poupanca = new ContaPoupanca(wellington);
        poupanca.sacar(300);

        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();



		Conta irineu = new ContaCorrente(new Cliente("Irineu"));
		cc.sacar(300);
		cc.depositar(1000);
		cc.transferir(100, irineu);
		cc.transferir(300, poupanca);


		cc.imprimirExtradoDetalhado();
		poupanca.imprimirExtradoDetalhado();

		irineu.imprimirExtradoDetalhado();
		

	}

}
