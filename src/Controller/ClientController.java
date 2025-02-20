package Controller;
import Model.Client;
import Services.ClientService;

import java.util.Scanner;


public class ClientController {

    public static Client createClient(int sesionID) {
        Scanner sc = new Scanner(System.in);
        ClientService service= new ClientService();
        String name;
        String mail;
        String choose;
        boolean notifications=true;
        boolean exit=true;

        System.out.println("***Creacion de clientes***");
        System.out.println("Introduce un nombre:");
        name = sc.nextLine();
        System.out.println("Introduce un email: ");
        mail = sc.nextLine();
        do {
            System.out.println("¿Quieres recibir notificaciones? (si/no)");
            choose = sc.nextLine().trim().toLowerCase();

            if (choose.equals("si")) {
                notifications = true;
                exit = false;
            } else if (choose.equals("no")) {
                notifications = false;
                exit = false;
            } else {
                System.out.println("Por favor, escribe 'si' o 'no':");
            }
        } while (exit);


        Client client =new Client(name,mail,notifications,sesionID);
        service.addClient(client);

        System.out.println("Cliente creado con exito.");
        return client;
    }


    public static void showClient(){
        System.out.println("Lista de clientes:");
        ClientService service=new ClientService();
        service.seeClients();

    }

    public void removeClient(){
        Scanner sc= new Scanner(System.in);
        ClientService service=new ClientService();
        int choose;
        System.out.println("Lista de clientes:");
        showClient();
        System.out.println("Selecciona la posición en la que se encuentra el usuario");
        choose=sc.nextInt();
        sc.nextLine();
        service.deleteClient(choose);
        System.out.println("Cliente eliminado con exito.");
    }
    public void modifyClient(){
        Scanner sc= new Scanner(System.in);
        ClientService service =new ClientService();
        int choose;
        String name;
        String mail;
        String option;
        boolean notifications=true;
        boolean exit=true;
        System.out.println("Lista de clientes:");
        showClient();
        System.out.println("Selecciona la  posición en la que se encuentra el usuario");
        choose=sc.nextInt();
        sc.nextLine();
        Client client=service.getClient(choose);

        System.out.println("*** Que deseas modificar?***");
        System.out.println("1.-Nombre");
        System.out.println("2.-Mail");
        System.out.println("3.-Notificaciones");
        choose=sc.nextInt();
        sc.nextLine();
        switch (choose){
            case 1:
                System.out.println("Porque nombre desea sustituirlo:");
                name=sc.nextLine();
                client.setName(name);
                service.updateClient(client);
                System.out.println("Nombre actualizado.");
                break;
            case 2:
                System.out.println("Porque mail desea sustituirlo:");
                mail=sc.nextLine();
                client.setMail(mail);
                service.updateClient(client);
                System.out.println("Mail actualizado.");
                break;
            case 3:
                do{
                System.out.println("Quieres recibir notificaciones ? si/no");
                option = sc.nextLine();
                String lowerCase = option .toLowerCase();
                char election = lowerCase.charAt(1);
                if(election =='s'){
                    notifications=true;
                    exit=false;
                    client.setNotifications(notifications);
                    service.updateClient(client);
                    System.out.println("Notificaciones activadas.");
                }else if (election=='n') {
                    notifications=false;
                    exit=false;
                    client.setNotifications(notifications);
                    service.updateClient(client);
                    System.out.println("Notificaciones desactivadas.");
                }else{
                    System.out.println("Porfavor escriba si o no:");
                }
            }while(exit);
            break;
            default:
                System.out.println("introduce un numero entre 1 y 3");
        }
    }
}
