import java.util.Scanner;

public class Menu {

  public static void Start(){
      Scanner sc =new Scanner(System.in);
      int choose;
      boolean exit= true;
    do {
        System.out.println("***Bienvenido al gestor de scape room***");
        System.out.println("1.-Gestion de Escaperoom");
        System.out.println("2.-Gestion de jugadores");
        System.out.println("3.-Salir de la applicacion");
        choose = sc.nextInt();
        sc.nextLine();
        switch (choose) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                System.out.println("Saliendo de la applicacion...");
                exit=false;
                break;
            default:
                System.out.println("Valor incorrecto");
                break;
        }
    }while(exit);

  }
}