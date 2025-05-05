package models;
// Protected Variations:
// Classe abstrata com método abstrato, permitindo que subclasses variem o comportamento de "calcularPreco()"
// sem afetar o restante do sistema.

    public class Quarto {
    protected int numero; // Encapsulamento: atributo protegido
    protected String tipo;
    protected boolean ocupado;
    // 🔹 Construtor
    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.ocupado = false;
    }

    public double calcularPreco(){

        return 200.0;
    };

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
