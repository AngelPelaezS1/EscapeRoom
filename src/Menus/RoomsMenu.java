package Menus;

import java.util.Scanner;

public class RoomsMenu {

    public static void roomsStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
            try {
                System.out.println("***Bienvenido al gestor de salas***");
                System.out.println("1.-Gestion de salas");
                System.out.println("2.-Gestion de items");
                System.out.println("-3.Gestion de pistas");
                System.out.println("4.-Salir de la aplicacion");
                System.out.print("Elige una opción: ");

                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1: // metodo para llamar el menu de salas;
                        break;
                    case 2: // metodo para llamar al menu de items;
                        break;
                    case 3: // metodo para llamar al menu de pistas;
                        break;
                    case 4:
                        System.out.println("Saliendo de la aplicacion...");
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

