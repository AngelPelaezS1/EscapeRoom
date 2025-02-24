package Menus.MenusItems;

import Controller.RoomController;

import java.util.Scanner;

public class RoomMenu {

    public void roomStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {

                System.out.println(" ");
                System.out.println("***Bienvenido al gestor de salas***");
                System.out.println("1.-Crear sala");
                System.out.println("2.-Eliminar sala");
                System.out.println("3.-Mostrar salas");
                System.out.println("4.-Modificar sala");
                System.out.println("5.-Atras");
                System.out.print("Elige una opción: ");
                RoomController roomController = new RoomController();
                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1:
                            roomController.createRoom();
                        break;
                    case 2:
                            roomController.removeRoom();
                        break;
                    case 3:
                            roomController.showRooms();
                        break;
                    case 4:
                            roomController.modifyRoom();
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

