package Menus;

import java.util.Scanner;

public class EscapeRoomMenu {

    public static void escapeRoomsStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
            try {
                System.out.println("***Bienvenido al gestor del escape room***");
                System.out.println("1.-Gestion de salas");
                System.out.println("2.-Gestion de items");
                System.out.println("-3.Gestion de pistas");
                System.out.println("4.-Salir de la aplicacion");
                System.out.print("Elige una opción: ");

                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1: RoomMenu.roomStart();
                        break;
                    case 2: ItemMenu.itemStart();
                        break;
                    case 3: HintMenu.hintStart();
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

