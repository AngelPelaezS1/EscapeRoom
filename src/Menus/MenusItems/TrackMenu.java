package Menus.MenusItems;

import java.util.Scanner;

import static Controller.TrackController.*;

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
                    case 1: createTrack();
                        break;
                    case 2: removeTrack();
                        break;
                    case 3: showTracks();
                        break;
                    case 4: modifyTrack();
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

