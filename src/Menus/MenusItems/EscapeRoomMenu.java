package Menus.MenusItems;

import java.util.Scanner;
public class EscapeRoomMenu {

    public void escapeRoomStart() {

        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {

                System.out.println(" ");
                System.out.println("***Bienvenido al gestor de salas***");
                System.out.println("1.-Gestión de salas");
                System.out.println("2.-Gestión de sesiones");
                System.out.println("3.-Gestión de items");
                System.out.println("4.-Gestión de pistas");
                System.out.println("5.-Atras");

                System.out.print("Elige una opción: ");

                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {

                    case 1: RoomMenu roomMenu = new RoomMenu();
                            roomMenu.roomStart();
                    break;
                    case 2: SessionMenu sessionMenu = new SessionMenu();
                            sessionMenu.sessionStart();
                    break;
                    case 3: ItemMenu itemMenu = new ItemMenu();
                            itemMenu.itemStart();
                    break;
                    case 4: TrackMenu trackMenu = new TrackMenu();
                            trackMenu.trackStart();
                    break;
                    case 5: exit = false;
                    break;
                    default:System.out.println("Valor incorrecto");
                    break;
                }
        } while (exit);
    }
}

