package Menus.MenusUser;

import Controller.TicketController;

import java.util.Scanner;

public class TicketMenu {
    public void ticketStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
                System.out.println(" ");
                System.out.println("*** Gestor de tickets***");
                System.out.println("1.-Añadir ticket a jugador exisente");
                System.out.println("2.-Mostrar tickets");
                System.out.println("3.-Eliminar tikets");
                System.out.println("4.-Atras");
                System.out.print("Elige una opción: ");
                TicketController ticketController  = new TicketController();
                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1:
                            ticketController.createTicketClient();
                        break;
                    case 2:
                            ticketController.showTicket();
                       break;
                    case 3:
                            ticketController.deleteTicket();
                            break;
                    case 4:
                        exit=false;
                        break;
                    default:
                        System.out.println("Valor incorrecto");
                        break;
                }
        } while (exit);
    }
}
