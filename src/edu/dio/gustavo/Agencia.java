package edu.dio.gustavo;

import java.util.List;

public class Agencia {
    private int codigo;
    private String endereco;
    private List<Conta> listaDeContas;
    private static int SEQUENCIAL = 1;
    
    public Agencia(String endereco) {
		this.codigo = SEQUENCIAL++;
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Conta> getListaDeContas() {
		return listaDeContas;
	}
	
	public void setListaDeContas(List<Conta> listaDeContas) {
		this.listaDeContas = listaDeContas;
	}

	public void adicionarConta(Conta conta) {
        listaDeContas.add(conta);
    }

    public void removerConta(Conta conta) {
        listaDeContas.remove(conta);
    }

    public void listarContas() {
    	listaDeContas.stream()
        .forEach(conta -> System.out.println("Conta: " + conta.getNumero() + ", Cliente: " + conta.getCliente().getNome()));
    }

}

