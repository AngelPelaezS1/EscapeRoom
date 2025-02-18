package Menus.MenusItems;

import Controller.RoomController;

import java.util.Scanner;

public class RoomMenu {

    public void roomStart() {
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
                    case 1: RoomController roomController = new RoomController();
                            roomController.createRoom();
                        break;
                    case 2: RoomController roomController1 = new RoomController();
                            roomController1.removeRoom();
                        break;
                    case 3: RoomController roomController2 = new RoomController();
                            roomController2.showRooms();
                        break;
                    case 4: RoomController roomController3 = new RoomController();
                            roomController3.modifyRoom();
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

