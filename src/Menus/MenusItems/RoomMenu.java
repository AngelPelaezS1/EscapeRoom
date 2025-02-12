package Menus.MenusItems;

import java.util.Scanner;

import static Controller.RoomController.*;

public class RoomMenu {

    public static void roomStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
            try {
                System.out.println("***Bienvenido al gestor de salas***");
                System.out.println("1.-Crear sala");
                System.out.println("2.-Eliminar sala");
                System.out.println("3.-Mostrar salas");
                System.out.println("4.-Modificar sala");
                System.out.println("5.-Atras");
                System.out.print("Elige una opción: ");

                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1: createRoom();
                        break;
                    case 2: removeRoom();
                        break;
                    case 3: showRooms();
                        break;
                    case 4: modifyRoom();
                        break;
                    case 5:
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

