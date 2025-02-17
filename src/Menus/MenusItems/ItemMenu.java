package Menus.MenusItems;

import Controller.ObjectController;

import java.util.Scanner;

public class ItemMenu {

    public void itemStart() {
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
                    case 1: ObjectController objectController = new ObjectController();
                            objectController.createObject();
                        break;
                    case 2: ObjectController objectController1 = new ObjectController();
                            objectController1.removeObject();
                        break;
                    case 3: ObjectController objectController2 = new ObjectController();
                            objectController2.showObject();
                        break;
                    case 4: ObjectController objectController3 = new ObjectController();
                            objectController3.modyfyObject();
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



