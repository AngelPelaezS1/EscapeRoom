package Controller;

import Model.Certificate;
import Model.Client;
import Services.CertificatesService;
import Services.ClientService;

import java.util.Scanner;

import static Controller.ClientController.showClient;


public class CertificateController {
    public void createCertificate(){
        Scanner sc= new Scanner(System.in);
        CertificatesService certificatesService=new CertificatesService();
        ClientService service= new ClientService();
        String name="Certificate";
        String achievement="felicidades te has pasado la sala";
        String gift="Enhorabuena, has ganado una taza";
        int clientId=0;
        int choose;
        System.out.println("Lista de salas:");
        showClient();
        System.out.println("Selecciona la posicion del usuario al que quieres asignarle un certificado:");
        choose=sc.nextInt();
        sc.nextLine();
        Client client= service.getClient(choose);
        clientId=client.getId();

        Certificate certificate= new Certificate(name,achievement,gift,clientId);
        certificatesService.addCertificate(certificate);
        System.out.println("Ceritificado creadocon exito.");
    }
    public void showCertificate(){
        System.out.println("Lista de certificados:");
        CertificatesService service= new CertificatesService();
        service.seeCertificates();
    }
    public void deleteCertificate(){
        Scanner sc= new Scanner(System.in);
        CertificatesService service = new CertificatesService();
        int choose;
        System.out.println("Lista de certificados:");
        showCertificate();
        System.out.println("Selecciona la posicion del certificado que quieres eliminar");
        choose=sc.nextInt();
        sc.nextLine();
        service.deleteCertificate(choose);
        System.out.println("Certificado eliminado con exito.");
    }
}
