package services;

import models.Quarto;
import models.Reserva;
import models.Hospede;
import java.util.ArrayList;
import java.util.List;

// 🔹 Classe responsável pela gestão do hotel
public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void fazerReserva(Hospede hospede, Quarto quarto) {
        if (!quarto.isOcupado()) {
            Reserva reserva = new Reserva(hospede, quarto);
            reservas.add(reserva);
            reserva.reservar();
        } else {
            System.out.println("❌ Quarto já está ocupado! Escolha outro.");
        }
    }

    public void cancelarReserva(int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == idReserva) {
                reserva.cancelar();
                reservas.remove(reserva);
                System.out.println("✅ Reserva ID " + idReserva + " cancelada com sucesso!");
                return;
            }
        }
        System.out.println("❌ Reserva não encontrada.");
    }

    public List<Quarto> getQuartosDisponiveis() {
        List<Quarto> disponiveis = new ArrayList<>();
        for (Quarto q : quartos) {
            if (!q.isOcupado()) {
                disponiveis.add(q);
            }
        }
        return disponiveis;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}
