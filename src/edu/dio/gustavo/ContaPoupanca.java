package edu.dio.gustavo;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Agencia agencia, Cliente cliente) {
		super(agencia, cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupan�a ===");
		super.imprimirInfosComuns();
		System.out.println();
	}
}
