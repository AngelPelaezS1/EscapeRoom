package Menus;

import java.util.Scanner;

public class RoomsMenu {

    public static void roomsStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
            try {
                System.out.println("  ");
                System.out.println("***Bienvenido al gestor de salas***");
                System.out.println("1.-Gestión de salas");
                System.out.println("2.-Gestión de ítems");
                System.out.println("-3.Gestión de pistas");
                System.out.println("4.-Salir de la aplicación");
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

