package services;

import interfaces.ReservaServiceInterface;
import models.Hospede;
import models.Quarto;
import models.Reserva;

// 🔹 Implementação da interface para baixo acoplamento
public class ReservaService implements ReservaServiceInterface {

    @Override
    public Reserva criarReserva(Hospede hospede, Quarto quarto) {
        return new Reserva(hospede, quarto);
    }
}
