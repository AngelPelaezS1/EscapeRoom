package Menus.MenusItems;

import Controller.TrackController;

import java.util.Scanner;

public class TrackMenu {

    public void trackStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {

                System.out.println(" ");
                System.out.println("***Bienvenido al gestor de pistas***");
                System.out.println("1.-Crear pista");
                System.out.println("2.-Eliminar pista");
                System.out.println("3.-Mostrar pistas");
                System.out.println("4.-Modificar pista");
                System.out.println("5.-Atras");
                System.out.print("Elige una opción: ");
                TrackController trackController = new TrackController();
                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1:
                            trackController.createTrack();
                        break;
                    case 2:
                            trackController.removeTrack();
                        break;
                    case 3:
                            trackController.showTracks();
                        break;
                    case 4:
                            trackController.modifyTrack();
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

