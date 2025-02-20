package Menus.MenusUser;

import java.util.Scanner;

public class UserMenu {
    public void userStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {

                System.out.println(" ");
                System.out.println("*** Gestor de clientes***");
                System.out.println("1.-Gestor de clientes");
                System.out.println("2.-Gestor de tikets");
                System.out.println("3.-Dar certificados");
                System.out.println("4.-Atras");
                System.out.print("Elige una opción: ");

                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1:ClientMenu clientMenu = new ClientMenu();
                           clientMenu.clientStart();
                        break;
                    case 2:TicketMenu ticketMenu = new TicketMenu();
                           ticketMenu.ticketStart();
                        break;
                    case 3:CertificateMenu certificateMenu = new CertificateMenu();
                           certificateMenu.certificateStart();
                        break;
                    case 4:
                        exit = false;
                        break;
                    default:
                        System.out.println("Valor incorrecto");
                        break;
                }
        } while (exit);
    }
}
