package Menus.MenusUser;

import Controller.ClientController;

import java.util.Scanner;


public class ClientMenu {

        public void clientStart() {
            Scanner sc = new Scanner(System.in);
            int choose;
            boolean exit = true;
            do {

                    System.out.println(" ");
                    System.out.println("*** Gestor de clientes***");
                    System.out.println("1.-Mostrar clientes ");
                    System.out.println("2.-Eliminar clientes");
                    System.out.println("3.-Modificar clientes");
                    System.out.println("4.-Atras");
                    System.out.print("Elige una opción: ");
                    ClientController clientController = new ClientController();
                    choose = sc.nextInt();
                    sc.nextLine();

                    switch (choose) {
                        case 1:
                                clientController.showClient();
                            break;
                        case 2:
                                clientController.removeClient();
                            break;
                        case 3:
                                clientController.modifyClient();
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

