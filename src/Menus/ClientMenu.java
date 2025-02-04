package Menus;

import java.util.Scanner;

public class ClientMenu {
    public static void ClientStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
            try {
                System.out.println("  ");
                System.out.println("*** Gestor de clientes***");
                System.out.println("1.-Jugadores");
                System.out.println("2.-Tikets");
                System.out.println("3.-Certificados");
                System.out.println("4.-Atras");
                System.out.print("Elige una opción: ");

                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1:// metodo para llamar al menu de jugadores;
                        break;
                    case 2:// metodo para llamar al menu de tikets;
                        break;
                    case 3: // metodo para llamar al menu de certificados;
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
