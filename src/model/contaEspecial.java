package model;

public class contaEspecial extends contaBancaria {
    private double limite;

    public contaEspecial(String nomeTitular, String cpf, String numero, double saldo, double limite) {
        super(nomeTitular, cpf, numero, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return super.toString() + " Limite R$" + this.limite;
    }

    @Override
    public boolean debitar(double valor) {
        if (super.saldo + this.limite >= valor) {
            super.saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
            return true;
        }
        System.out.println("Você não tem saldo suficiente para realizar essa transação.");
        return false;
    }
}
