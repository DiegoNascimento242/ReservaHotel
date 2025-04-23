package models;
// Protected Variations:
// Classe abstrata com método abstrato, permitindo que subclasses variem o comportamento de "calcularPreco()"
// sem afetar o restante do sistema.


// 🔹 Classe Abstrata (não pode ser instanciada diretamente)

//   PV Classe abstrato Quarto
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

    // PV aplicado: este método será implementado por cada tipo de Quarto (ex: Suite), permitindo flexibilidade.
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
