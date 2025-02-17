package Menus.MenusUser;

import Controller.ClientController;

import java.util.Scanner;


public class ClientMenu {

        public void clientStart() {
            Scanner sc = new Scanner(System.in);
            int choose;
            boolean exit = true;
            do {

                try {
                    System.out.println(" ");
                    System.out.println("*** Gestor de clientes***");
                    System.out.println("1.-Mostrar clientes ");
                    System.out.println("2.-Eliminar clientes");
                    System.out.println("3.-Modificar clientes");
                    System.out.println("4.-Atras");
                    System.out.print("Elige una opción: ");

                    choose = sc.nextInt();
                    sc.nextLine();

                    switch (choose) {
                        case 1: ClientController clientController = new ClientController();
                                clientController.showClient();
                            break;
                        case 2: ClientController clientController2 = new ClientController();
                                clientController2.modifyClient();
                            break;
                        case 3: ClientController clientController3 = new ClientController();
                                clientController3.removeClient();
                            break;
                        case 4:
                            exit = false;
                            break;
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

