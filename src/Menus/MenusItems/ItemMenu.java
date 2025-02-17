package Menus.MenusItems;

import java.util.Scanner;

import static Controller.ObjectController.*;

public class ItemMenu {

    public static void itemStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
            try {
                System.out.println("***Bienvenido al gestor de items***");
                System.out.println("1.-Crear item");
                System.out.println("2.-Eliminar item");
                System.out.println("3.-Mostrar items");
                System.out.println("4.-Modificar item");
                System.out.println("5.-Atras");
                System.out.print("Elige una opción: ");

                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1: createObject();
                        break;
                    case 2: removeObject();
                        break;
                    case 3: showObject();
                        break;
                    case 4: modyfyObject();
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



