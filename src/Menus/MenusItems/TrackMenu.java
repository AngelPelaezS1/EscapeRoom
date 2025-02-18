package Menus.MenusItems;

import Controller.TrackController;

import java.util.Scanner;

public class TrackMenu {

    public void trackStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
            try {
                System.out.println("***Bienvenido al gestor de pistas***");
                System.out.println("1.-Crear pista");
                System.out.println("2.-Eliminar pista");
                System.out.println("3.-Mostrar pistas");
                System.out.println("4.-Modificar pista");
                System.out.println("5.-Atras");
                System.out.print("Elige una opción: ");

                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1: TrackController trackController = new TrackController();
                            trackController.createTrack();
                        break;
                    case 2: TrackController trackController1 = new TrackController();
                            trackController1.removeTrack();
                        break;
                    case 3: TrackController trackController2 = new TrackController();
                            trackController2.showTracks();
                        break;
                    case 4: TrackController trackController3 = new TrackController();
                            trackController3.modifyTrack();
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

