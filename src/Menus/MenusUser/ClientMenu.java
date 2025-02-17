package Menus.MenusUser;

import java.util.Scanner;

import static Controller.ClientController.*;


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
                        case 1:showClient();
                            break;
                        case 2:
                            break;
                        case 3:modifyClient();
                            break;
                        case 4: removeClient();
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

