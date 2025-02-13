package Controller;

import Model.Certificate;

import java.util.Scanner;

import static Controller.ClientController.showClient;

public class CertificateController {
    public static void createCertificate(){
        String name="Certificate";
        String achievement="felicidades te has pasado la sala";
        String gift="Enhorabuena, has ganado una taza";
        int clientId=0;
        showClient();
        // metodo que debuelve el cliente por posicion;
        //clientID=client.getID();
        Certificate certificate= new Certificate(name,achievement,gift,clientId);
    }
    public static void  showCertificate(){
        //metodo servicio que devuelve los certificados y el nombre de los clientes;
    }
    public static void deleteCertificate(){
        Scanner sc= new Scanner(System.in);
        int choose;
        showCertificate();
        System.out.println("Selecciona la posicion del certificado que quieres eliminar");
        choose=sc.nextInt();
        sc.nextLine();
        //metodo para elminar certificado por posicion;

    }
}
