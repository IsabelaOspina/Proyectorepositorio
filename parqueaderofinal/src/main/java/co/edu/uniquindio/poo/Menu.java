package co.edu.uniquindio.poo;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion=0;
        while (opcion!=5) {
            System.out.println("1.crear parqueadero");
            opcion= scanner.nextInt();

        

            switch (opcion) {
                case 1:
                scanner.nextLine();
                System.out.println("ingrese el nombre del parqueadero");
                String nombre=scanner.nextLine();
                System.out.println("ingrese la cantidad de puestos para el parqueadero");
                scanner.nextInt();
                int cantidadPuestos=scanner.nextInt();
                Parqueadero parqueadero= new Parqueadero(nombre, cantidadPuestos);
                parqueadero.crearPuestos(cantidadPuestos);
                    break;
            
                default:
                    break;
            }
        }
    }
}