package Menus.MenusUser;

import Controller.ClientController;

import java.util.Scanner;


public class ClientMenu {

        public void clientStart() {
            Scanner sc = new Scanner(System.in);
            int choose;
            boolean exit = true;
            int sessionID = 0;
            do {

                    System.out.println(" ");
                    System.out.println("*** Gestor de clientes***");
                    System.out.println("1.-Crear cliente");
                    System.out.println("2.-Eliminar cliente");
                    System.out.println("3.-Mostrar clientes");
                    System.out.println("4.-Modificar clientes");
                    System.out.println("5.-Atras");
                    System.out.print("Elige una opción: ");
                    ClientController clientController = new ClientController();
                    choose = sc.nextInt();
                    sc.nextLine();

                    switch (choose) {
                        case 1:
                                clientController.createClient(sessionID);
                            break;
                        case 2:
                                clientController.removeClient();
                            break;
                        case 3:
                                clientController.showClient();
                            break;
                        case 4:
                                clientController.modifyClient();
                            break;
                        case 5:
                            exit = false;
                            break;
                        default:
                            System.out.println("Valor incorrecto");
                            break;
                    }
            } while (exit);
        }
    }

