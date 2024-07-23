package edu.dio.gustavo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Cliente cli1 = new Cliente();
		cli1.setNome("Gustavo");
		
		Cliente cli2 = new Cliente();
		cli2.setNome("Carlos");
		
		Cliente cli3 = new Cliente();
		cli3.setNome("Marta");
		
		Agencia agencia = new Agencia("Rua Principal, 123");
		Agencia filial = new Agencia("Outra Rua, 456");
		
		List<Conta> contas = new ArrayList<>();
		ContaCorrente cc1 = new ContaCorrente(agencia, cli1);
		ContaCorrente cc2 = new ContaCorrente(filial, cli2);
		ContaCorrente cc3 = new ContaCorrente(agencia, cli3);
		
		agencia.setListaDeContas(List.of(cc1, cc3));
		filial.setListaDeContas(List.of(cc2));
				
		cc1.depositar(150);
		cc1.transferir(100, cc2);
		cc1.imprimirExtrato();
		
		cc2.depositar(30);
		//cc2.transferir(1000, cc3);
		cc2.transferir(45, cc3);
		cc2.imprimirExtrato();
				
		cc3.imprimirExtrato();
		
        contas.add(cc1);
        contas.add(cc2);
        contas.add(cc3);
        
        System.out.println("------------------Lista de Contas da Agencia------------------------");
        agencia.listarContas();
        
        System.out.println();
        
        System.out.println("------------------Lista de Contas da Filial-------------------------");
        filial.listarContas();
        
        System.out.println();
                
        System.out.println("------------------Lista das Agências, seus clientes e contas-------------------------");
        contas.forEach(conta -> System.out.println("\n Agência "+ conta.getAgencia().getEndereco() + " - Conta: " + conta.getNumero() + ", Cliente: " + conta.getCliente().getNome()));
        
	}

}
