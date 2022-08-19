package model;

public class contaBancaria {
    protected String nomeTitular;
    protected String cpf;
    protected String numero;
    protected double saldo;

    public contaBancaria(String nomeTitular, String cpf, String numero, double saldo) {
        super();
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return numero+" - " + nomeTitular + " ("+cpf+") " + saldo;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }

    public boolean debitar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
            return true;
        }
            System.out.println("Você não tem saldo suficiente para realizar essa transação.");
            return false;
    }

}
