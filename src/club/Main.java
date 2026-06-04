package club;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        while (true) {
            menu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    ArrayList<Jugador> jugadores = new ArrayList<>();

                    jugadores.add(new Jugador("Yeremay",2000,Posicion.DELANTERO));
                    break;

                case 2:




            }
        }




    }
    public static void menu(){
        System.out.println("1. Contratar Jugador");
        System.out.println("2. Contratar cuerpor tecnico");
        System.out.println("3. Despedir profesional");
        System.out.println("4. Ver nominas totales");
        System.out.println("5. Salir");
    }



}
