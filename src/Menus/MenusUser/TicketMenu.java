package Menus.MenusUser;

import Controller.TicketController;

import java.util.Scanner;

public class TicketMenu {
    public void ticketStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
            try {
                System.out.println(" ");
                System.out.println("*** Gestor de tickets***");
                System.out.println("1.-Jugadores exisente");
                System.out.println("2.-Nuevo jugador");
                System.out.println("3.-Mostrar tickets");
                System.out.println("4.-Eliminar tikets");
                System.out.println("5.-Atras");
                System.out.print("Elige una opción: ");
                TicketController ticketController  = new TicketController();
                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1:
                            ticketController.createTicketClient();
                        break;
                    case 2:
                            ticketController.createTicket();
                        break;
                    case 3:
                            ticketController.showTicket();
                       break;
                    case 4:
                            ticketController.deleteTicket();
                    case 5:
                        exit=false;
                    default:
                        System.out.println("Valor incorrecto");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: Debes ingresar un número entero.");
                sc.nextLine();
            }
        } while (exit);
    }
}
