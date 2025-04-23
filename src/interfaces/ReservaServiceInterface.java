package interfaces;
import models.Hospede;
import models.Quarto;
import models.Reserva;
/*
Protected Variations:
Esta interface protege o sistema contra variações na lógica de criação de reservas.
Posso ter várias implementações diferentes sem alterar as classes que a usam.
*
*
* */

public interface ReservaServiceInterface {

    Reserva  criarReserva(Hospede hospede, Quarto quarto);
}
