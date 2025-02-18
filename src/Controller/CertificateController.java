package Controller;

import Model.Certificate;
import Model.Client;
import Services.ClientService;

import java.util.Scanner;

import static Controller.ClientController.showClient;
import static Services.ClientService.getClient;

public class CertificateController {
    public void createCertificate(){
        Scanner sc= new Scanner(System.in);
        ClientService service= new ClientService();
        String name="Certificate";
        String achievement="felicidades te has pasado la sala";
        String gift="Enhorabuena, has ganado una taza";
        int clientId=0;
        int choose;
        System.out.println("Selecciona la posicion del usuario al que quieres asignarle un certificado:");
        showClient();
        choose=sc.nextInt();
        sc.nextLine();
        Client client= service.getClient(choose);
        clientId=client.getId();
        Certificate certificate= new Certificate(name,achievement,gift,clientId);
        //addCertificate;
    }
    public void showCertificate(){
        //metodo servicio que devuelve los certificados y el nombre de los clientes;
    }
    public void deleteCertificate(){
        Scanner sc= new Scanner(System.in);
        int choose;
        showCertificate();
        System.out.println("Selecciona la posicion del certificado que quieres eliminar");
        choose=sc.nextInt();
        sc.nextLine();
        //metodo para elminar certificado por posicion;

    }
}
