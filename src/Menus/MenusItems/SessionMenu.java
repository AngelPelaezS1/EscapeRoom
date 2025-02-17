package Menus.MenusItems;

import Controller.SessionController;

import java.util.Scanner;

public class SessionMenu {

    public void sessionStart(){
        Scanner sc = new Scanner(System.in);
        int choose;
        boolean exit = true;
        do {
            try {
                System.out.println("***Bienvenido al gestor de sesiones***");
                System.out.println("1.-Crear sesion");
                System.out.println("2.-Eliminar sesion");
                System.out.println("3.-Mostrar sesion");
                System.out.println("4.-Marcar sesion como finalizada");
                System.out.println("5.-Atras");
                System.out.print("Elige una opción: ");

                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1:
                            SessionController sessionController = new SessionController();
                            sessionController.createSesion();
                        break;
                    case 2: SessionController sessionController1 = new SessionController();
                            sessionController1.removeSession();
                        break;
                    case 3: SessionController sessionController2 = new SessionController();
                            sessionController2.showSessions();
                        break;
                    case 4: SessionController sessionController3 = new SessionController();
                            sessionController3.markSessionAsPassed();
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


