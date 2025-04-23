import models.*;
import services.Hotel;
import services.ReservaService;
import interfaces.ReservaServiceInterface;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Hotel hotel = new Hotel();

        ReservaServiceInterface reservaService = new ReservaService();
        Hotel hotel = new Hotel(reservaService);

        // Adicionando quartos ao hotel
        hotel.adicionarQuarto(new Suite(101, true));
        hotel.adicionarQuarto(new Suite(102, false));
        hotel.adicionarQuarto(new Suite(103, true));

        while (true) {
            System.out.println("\n🏨 MENU:");
            System.out.println("1️⃣ Fazer reserva");
            System.out.println("2️⃣ Cancelar reserva");
            System.out.println("3️⃣ Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (opcao == 1) {
                // Fazer reserva
                System.out.print("\nDigite seu nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite seu CPF: ");
                String cpf = scanner.nextLine();
                Hospede hospede = new Hospede(nome, cpf);

                // Escolhendo um quarto disponível
                Quarto quartoEscolhido = null;
                while (quartoEscolhido == null) {
                    System.out.println("\n🏨 Quartos disponíveis:");
                    List<Quarto> disponiveis = hotel.getQuartosDisponiveis();
                    for (Quarto q : disponiveis) {
                        System.out.println("Número: " + q.getNumero() + " | Tipo: " + q.getTipo() + " | Preço: R$" + q.calcularPreco());
                    }

                    System.out.print("\nDigite o número do quarto desejado: ");
                    int numeroQuarto = scanner.nextInt();

                    for (Quarto q : disponiveis) {
                        if (q.getNumero() == numeroQuarto) {
                            quartoEscolhido = q;
                            break;
                        }
                    }

                    if (quartoEscolhido == null) {
                        System.out.println("❌ Quarto inválido! Escolha um número da lista.");
                    }
                }

                // Criar a reserva
                hotel.fazerReserva(hospede, quartoEscolhido);
            } else if (opcao == 2) {
                // Cancelar reserva
                System.out.println("\n📋 Reservas ativas:");
                List<Reserva> reservas = hotel.getReservas();
                if (reservas.isEmpty()) {
                    System.out.println("⚠ Nenhuma reserva encontrada.");
                    continue;
                }

                for (Reserva r : reservas) {
                    System.out.println("ID: " + r.getId() + " | Hóspede: " + r.getHospede().getNome() + " | Quarto: " + r.getQuarto().getNumero());
                }

                System.out.print("\nDigite o ID da reserva que deseja cancelar: ");
                int idReserva = scanner.nextInt();
                hotel.cancelarReserva(idReserva);
            } else if (opcao == 3) {
                // Sair
                System.out.println("🏨 Obrigado por usar o sistema de reservas!");
                break;
            } else {
                System.out.println("❌ Opção inválida!");
            }
        }
        scanner.close();
    }
}