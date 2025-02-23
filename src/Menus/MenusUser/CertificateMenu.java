package Menus.MenusUser;

import Controller.CertificateController;

import java.util.Scanner;

public class CertificateMenu {
    public void certificateStart() {
    Scanner sc = new Scanner(System.in);
    int choose;
    boolean exit = true;
    do {

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
                case 1: controller.showCertificate();
                    break;
                case 2: controller.createCertificate();
                    break;
                case 3:
                    exit = false;
                    break;
                default:
                    System.out.println("Valor incorrecto");
                    break;
            }

    } while (exit);
  }
}
