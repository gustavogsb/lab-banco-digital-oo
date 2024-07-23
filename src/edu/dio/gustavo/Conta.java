package edu.dio.gustavo;

public abstract class Conta implements IConta {
	
	private static int SEQUENCIAL = 1;

	private int numero;
	private double saldo;
	private Agencia agencia;
	private Cliente cliente;

    public Conta(Agencia agencia, Cliente cliente) {
    	this.numero = SEQUENCIAL++;
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = 0.0;
    }
    
	@Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("\nA conta "+ this.numero + " Não tem saldo suficiente para transação(sacar).");
            System.exit(1);
        }
    }	

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
    public void transferir(double valor, IConta contaDestino) {
        if (saldo >= valor) {
        	this.sacar(valor);
        	contaDestino.depositar(valor);
        } else {
            System.out.println("\nA conta "+ this.numero + " Não tem saldo suficiente para transação(transferir).");
            System.exit(1);
        }
    }	

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %s", this.agencia.getCodigo() +" - "+this.agencia.getEndereco() ));
		System.out.println(String.format("Conta: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}




}
