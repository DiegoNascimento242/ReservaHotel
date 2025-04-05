package models;

// 🔹 Classe Abstrata (não pode ser instanciada diretamente)
public abstract class Quarto {
    protected int numero; // Encapsulamento: atributo protegido
    protected String tipo;
    protected boolean ocupado;
    // 🔹 Construtor
    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.ocupado = false;
    }
    // 🔹 Método Abstrato
    public abstract double calcularPreco();

    public void ocupar() {
        this.ocupado = true;
    }

    public void liberar() {
        this.ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }
    // 🔹 Getters e Setters
    public int getNumero() { // Encapsulamento
        return numero;
    }
    // Encapsulamento
    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
