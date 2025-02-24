package Menus.MenusItems;

import Controller.ItemController;

import java.util.Scanner;


public class ItemMenu {

    public static void itemStart() {
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {

                System.out.println(" ");
                System.out.println("***Bienvenido al gestor de items***");
                System.out.println("1.-Crear item");
                System.out.println("2.-Eliminar item");
                System.out.println("3.-Mostrar items");
                System.out.println("4.-Modificar item");
                System.out.println("5.-Mostrar precio total inventario");
                System.out.println("6.-Atras");
                System.out.print("Elige una opción: ");
                ItemController itemController = new ItemController();
                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1: itemController.createItem();
                        break;
                    case 2: itemController.removeItem();
                        break;
                    case 3: itemController.showItem();
                        break;
                    case 4: itemController.modyfyItem();
                        break;
                    case 5: itemController.totalValue();
                        break;
                    case 6:
                        exit = false;
                        break;
                    default:
                        System.out.println("Valor incorrecto");
                        break;
                }
        } while (exit);
    }
}



