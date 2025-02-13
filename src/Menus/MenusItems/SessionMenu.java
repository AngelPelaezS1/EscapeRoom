package Menus.MenusItems;

import java.util.Scanner;

import static Controller.SessionController.*;

public class SessionMenu {

    public static void sessionStart(){
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
            try {
                System.out.println("***Bienvenido al gestor de sesiones***");
                System.out.println("1.-Crear sesion");
                System.out.println("2.-Eliminar sesion");
                System.out.println("3.-Mostrar sesion");
                System.out.println("4.-Modificar sesion");
                System.out.println("5.-Atras");
                System.out.print("Elige una opción: ");

                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1: createSesion();
                        break;
                    case 2: removeSession();
                        break;
                    case 3: showSessions();
                        break;
                    case 4: //metodo para modificar las sesiones
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


