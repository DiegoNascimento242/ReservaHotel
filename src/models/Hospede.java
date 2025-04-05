package models;
//🔹 Classe comum com Encapsulamento
public class Hospede {
    private String nome;
    private String cpf;
    // 🔹 Construtor
    public Hospede(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    // 🔹 Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}