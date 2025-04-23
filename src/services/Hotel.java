package services;

import models.Quarto;
import models.Reserva;
import models.Hospede;
import interfaces.ReservaServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

 /*=================================================================================================================*/
    /* Protected Variations:
     A classe Hotel depende da abstração (interface ReservaServiceInterface),
    e não de uma implementação específica (ReservaService), protegendo o sistema contra variações futuras.*/

    private ReservaServiceInterface reservaService; // <- usa a interface, não a classe concreta
    public Hotel(ReservaServiceInterface reservaService) {
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.reservaService = reservaService;
    }

    public void adicionarQuarto(Quarto quarto) {
        this.quartos.add(quarto);
    }

    public void fazerReserva(Hospede hospede, Quarto quarto) {
        if (!quarto.isOcupado()) {
            // PV aplicado: criei a reserva através da interface, não diretamente com "new"
            Reserva reserva = reservaService.criarReserva(hospede, quarto); // baixo acoplamento
            reservas.add(reserva);
            reserva.reservar();
        } else {
            System.out.println("Quarto já está ocupado!");
        }
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public List<Reserva> getReservas() {
        return reservas;
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
    public void cancelarReserva(int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == idReserva) {
                reserva.cancelar();
                reservas.remove(reserva);
                System.out.println("✅ Reserva cancelada com sucesso!");
                return;
            }
        }
        System.out.println("❌ Reserva não encontrada.");
    }
}
