package interfaces;
import models.Hospede;
import models.Quarto;
import models.Reserva;

public interface ReservaServiceInterface {

    Reserva  criarReserva(Hospede hospede, Quarto quarto);
}
