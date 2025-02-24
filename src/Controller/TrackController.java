package Controller;

import Model.Room;
import Model.Track;
import Services.RoomService;
import Services.TrackService;

import java.util.Scanner;

public class TrackController {
    static Scanner sc = new Scanner(System.in);

    public void createTrack(){
        int idRooms = 0;
        RoomService roomService= new RoomService();
        TrackService service=new TrackService();

        System.out.println(" ");
        System.out.println("Lista de salas:");
        roomService.seeRooms();
        System.out.println(" ");
        System.out.println("Introduce la posicion de la room a la quieres añadir la pista.");
        int choose = sc.nextInt();
        sc.nextLine();
        Room room= roomService.getRoom(choose);
        idRooms = room.getId();

        System.out.println("Introduce el nombre de la pista.");
        String name = sc.nextLine();
        System.out.println("Introduce el tema de la pista.");
        String topics = sc.nextLine();
        System.out.println("Haz una breve descripcion.");
        String details = sc.nextLine();
        Track track = new Track(name, topics, details, idRooms);

        System.out.println("Pista añadida con exito.");
    }

    public void showTracks(){
        TrackService service = new TrackService();
        RoomService roomService = new RoomService();
        System.out.println(" ");
        System.out.println("Lista de salas:");
        roomService.seeRooms();
        System.out.println(" ");
        System.out.println("Introduce la posicion de la room que quieras ver las pistas.");
        int choose = sc.nextInt();
        sc.nextLine();
        roomService.getRoom(choose);
        System.out.println("Lista de pistas:");
        service.seeTrack();
    }

    public void removeTrack(){
        TrackService service = new TrackService();
        System.out.println(" ");
        System.out.println("Lista de pistas:");
        service.seeTrack();
        System.out.println(" ");
        System.out.println("Introduce la posicion de la pista a eliminar.");
        int index = sc.nextInt();
        sc.nextLine();

        while(index < 0){
            System.out.println("Error, introduce un numero valido.");
            index = sc.nextInt();
            sc.nextLine();
        }
        service.deleteTrack(index);
        System.out.println("Pista eliminada con exito.");
    }


    public void modifyTrack(){
        TrackService service = new TrackService();
        System.out.println(" ");
        System.out.println("Lista de pistas:");
        service.seeTrack();
        System.out.println(" ");
        System.out.println("Introduce la posicion de la pista a modificar.");
        int index = sc.nextInt();
        sc.nextLine();
        
        while(index < 0){
            System.out.println("Error, introduce un numero correcto.");
            index = sc.nextInt();
            sc.nextLine();
        }
        Track track= service.getTrack(index);
        System.out.println(" ");
        System.out.println("Elige una opción:");
        System.out.println("1.Nombre.");
        System.out.println("2.Tema.");
        System.out.println("3.Descripcion");
        int choose = sc.nextInt();
        sc.nextLine();

        switch(choose){
            case 1:
                System.out.println("Introduce el nuevo nombre.");
                String newName = sc.nextLine();
                track.setName(newName);
                service.updateTrack(track);
                System.out.println("Nombre actualizado.");
                break;
            case 2:
                System.out.println("Introduce el nuevo tema.");
                String newTopic = sc.nextLine();
                track.setTopics(newTopic);
                service.updateTrack(track);
                System.out.println("Tema actualizado.");
                break;
            case 3:
                System.out.println("Introduce la nueva descripcion.");
                String newDetails = sc.nextLine();
                track.setDetails(newDetails);
                service.updateTrack(track);
                System.out.println("Descripcion actualizada.");
                break;
            default:
                System.out.println("Introduce un numero del 1 al 3.");
        }
    }
}
