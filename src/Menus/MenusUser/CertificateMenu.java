package Menus.MenusUser;

import java.util.Scanner;
import Controller.CertificateController;

public class CertificateMenu {
    public void certificateStart() {
    Scanner sc = new Scanner(System.in);
    int choose;
    boolean exit = true;
    do {
        try {
            System.out.println(" ");
            System.out.println("*** Gestor de certificados***");
            System.out.println("1.-Historico de Certificados");
            System.out.println("2.-Dar Certificado");
            System.out.println("3.-Atras");
            System.out.print("Elige una opción: ");
            CertificateController controller= new CertificateController();
            choose = sc.nextInt();
            sc.nextLine();


            switch (choose) {
                case 1: controller.createCertificate();
                    break;
                case 2: controller.showCertificate();
                    break;
                case 3:
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
