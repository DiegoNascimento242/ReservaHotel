package models;

import interfaces.Reservavel;
import java.time.LocalDate;

public class Reserva implements Reservavel {
    //atributo estátco
    private static int contadorReservas = 0;
    private int id;
    // 🔹 Associação: Reserva contém um Hospede e um Quarto
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate dataReserva;

    // Construtor padrão
    public Reserva(Hospede hospede, Quarto quarto) {
        this(hospede, quarto, LocalDate.now()); // Chamada para o outro construtor (sobrecarga)
    }
    //polimorfismo
    // Sobrecarga do construtor com data personalizada
    public Reserva(Hospede hospede, Quarto quarto, LocalDate dataReserva) {
        this.id = ++contadorReservas;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataReserva = dataReserva;
        quarto.ocupar();
    }
    // 🔹 Sobrescrita dos métodos da Interface
    @Override
    public void reservar() {
        System.out.println("Reserva realizada para " + hospede.getNome() + " no quarto " + quarto.getNumero() + " na data " + dataReserva);
    }

    @Override
    public void cancelar() {
        quarto.liberar();
        System.out.println("Reserva cancelada.");
    }
    // 🔹 Getters
    public int getId() {
        return id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }
    //polimorfismo
}
