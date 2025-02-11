package Controller;

import Model.Client;

import java.util.Scanner;


public class ClientController {

    public static void createClient() {
        Scanner sc = new Scanner(System.in);
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
        do{
                System.out.println("Quieres recibir notificaciones ? si/no");
                choose = sc.nextLine();
                String lowerCase = choose.toLowerCase();
                char election = lowerCase.charAt(1);
                if(election =='y'){
                    notifications=true;
                    exit=false;
                }else if (election=='n') {
                    notifications=false;
                    exit=false;
                }else{
                    System.out.println("Porfavor escriba si o no:");
                }
        }while(exit);
        Client client =new Client(name,mail,notifications);
        System.out.println("Cliente creado");
    }

    public static void showClient(){
        //metodo  de servicio listar usuarios
    }

    public static void removeClient(){
        Scanner sc= new Scanner(System.in);
        int choose;
        showClient();
        System.out.println("Selecciona la  posición en la que se encuentra el usuario");
        choose=sc.nextInt();
        sc.nextLine();
        //metodo de servicio para eliminar usuario en x posicion
    }
    public static void modifyClient(){
        Scanner sc= new Scanner(System.in);
        int choose;
        String name;
        String mail;
        String option;
        boolean notifications=true;
        boolean exit=true;

        showClient();
        System.out.println("Selecciona la  posición en la que se encuentra el usuario");
        choose=sc.nextInt();
        sc.nextLine();
        // metodo de servicio que devuelve el usuario en x posicion;
        // hacer un cliente con la info
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
                // client.setName(name);
                //metodo servicio update;
                break;
            case 2:
                System.out.println("Porque mail desea sustituirlo:");
                mail=sc.nextLine();
                // client.setMail(mail);
                //metodo servicio updateclient;
                break;
            case 3:
                do{
                System.out.println("Quieres recibir notificaciones ? si/no");
                option = sc.nextLine();
                String lowerCase = option .toLowerCase();
                char election = lowerCase.charAt(1);
                if(election =='y'){
                    notifications=true;
                    exit=false;
                    //client.setNotifications(notifications);
                    //metodo servicio updateclient
                }else if (election=='n') {
                    notifications=false;
                    exit=false;
                    //client.setNotifications(notifications);
                    //metodo servicio updateclient
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
