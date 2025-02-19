package Menus.MenusItems;

import Controller.SessionController;

import java.util.Scanner;

public class SessionMenu {

    public void sessionStart(){
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {

                System.out.println(" ");
                System.out.println("***Bienvenido al gestor de sesiones***");
                System.out.println("1.-Crear sesion");
                System.out.println("2.-Eliminar sesion");
                System.out.println("3.-Mostrar sesion");
                System.out.println("4.-Marcar sesion como finalizada");
                System.out.println("5.-Atras");
                System.out.print("Elige una opción: ");
                SessionController sessionController = new SessionController();
                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1:
                            sessionController.createSesion();
                        break;
                    case 2:
                            sessionController.removeSession();
                        break;
                    case 3:
                            sessionController.showSessions();
                        break;
                    case 4:
                            sessionController.markSessionAsPassed();
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


