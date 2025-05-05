package models;

public class QuartoEconomico extends Quarto {

    public QuartoEconomico(int numero) {
        super(numero, "Econômico");
    }

    @Override
    public double calcularPreco() {
        return 150.0;
    }
}
