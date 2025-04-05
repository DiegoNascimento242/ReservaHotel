package models;

// 🔹 Herança -> Suite herda de Quarto
public class Suite extends Quarto {
    private boolean cafeDaManha;
    // 🔹 Construtor
    public Suite(int numero, boolean cafeDaManha) {
        super(numero, "Suite");
        this.cafeDaManha = cafeDaManha;
    }
    // 🔹 Sobrescrita (Reescrita)
    @Override
    public double calcularPreco() {
        return cafeDaManha ? 300.0 : 250.0;
    }
    // 🔹 Getters e Setters
    public boolean isCafeDaManha() {
        return cafeDaManha;
    }

    public void setCafeDaManha(boolean cafeDaManha) {
        this.cafeDaManha = cafeDaManha;
    }
}
