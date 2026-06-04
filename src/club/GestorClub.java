package club;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorClub {
    private final double PRESUPUESTO_MAXIMO = 10000.0;

    ArrayList<Profesional> trabajadores = new ArrayList<>();

    public void controlFlujo() throws PresupuestoExcedidoException {
        Scanner sc = new Scanner(System.in);
        int opcion;
        double salarioTotal = 0;
        while (true) {
            boolean salida=true;
            menu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    do {

                        System.out.println("Di Nombre Jugador");
                        String nombre = sc.next();
                        System.out.println("Di Salario Jugador");
                        double salario = sc.nextDouble();
                        System.out.println("Di Posicion Jugador (PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO)");
                        String posicion = sc.next();
                        trabajadores.add(new Jugador(nombre,salario,Posicion.valueOf(posicion.toUpperCase())));
                        salarioTotal+=salario;
                        if(salarioTotal>PRESUPUESTO_MAXIMO) {
                            throw new PresupuestoExcedidoException("presupuesto Excedido");
                        }

                            System.out.println("Quieres crear otro jugador? S/N");
                            String salir = sc.next();
                            if (salir.equals("N") || salir.equals("n")) {
                                salida = false;
                            }


                        }while(salida);
                    break;
                case 2:
                    do {


                        System.out.println("Di Nombrer tecnico");
                        String nombre = sc.next();
                        System.out.println("Di Salario  tecnico");
                        double salario = sc.nextDouble();
                        System.out.println("Di Posicion  tecnico (Ej: Entrenador, Fisioterapeuta,Médico, Analista etc)");
                        String puesto = sc.next();
                        trabajadores.add(new Tecnico(nombre, salario, puesto.toUpperCase()));
                        salarioTotal += salario;
                        if (salarioTotal > PRESUPUESTO_MAXIMO) {
                            throw new PresupuestoExcedidoException("presupuesto Excedido");
                        }
                        System.out.println("Quieres crear otro tecnico? S/N");
                        String salir = sc.next();
                        if (salir.equals("N") || salir.equals("n")) {
                            salida = false;
                        }

                    }while (salida);
                    break;
                case  3:
                    do {
                        System.out.println("A quien quieres despedir");
                        String nombre = sc.next();
                        for (Profesional p:trabajadores){

                        if (!p.getNombre().equals(nombre)) {
                            throw new ProfesionalNoEncontradoException("Profesional no encontrado");
                        }else {
                            trabajadores.remove(p);
                            salarioTotal -= p.getSalarioBase();
                        }
                        }

                        System.out.println("Quieres despedir otro? S/N");
                        String salir = sc.next();
                        if (salir.equals("N") || salir.equals("n")) {
                            salida = false;
                        }

                    }while (salida);
                    break;
                case 4:
                    double salarioBonus=0;
                    for (Profesional p:trabajadores){
                        System.out.println(p.getNombre());
                        System.out.println(p.getSalarioBase());
                        salarioBonus=p.getSalarioBase();
                        if (p.getClass()== Jugador.class){

                            System.out.println(((Jugador) p).getPosicion());
                            salarioBonus=salarioBonus*0.10;
                            System.out.println("Salario con plus "+p.plusSalarial(p.getSalarioBase(),salarioBonus));
                            salarioBonus=0;
                        }else {
                            salarioBonus=0;
                            System.out.println(((Tecnico) p).getPuesto());
                            salarioBonus=salarioBonus+200;
                            System.out.println("Salario con plus "+p.plusSalarial(p.getSalarioBase(),salarioBonus));
                            salarioBonus=0;

                        }
                    }

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

