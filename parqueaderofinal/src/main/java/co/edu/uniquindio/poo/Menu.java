package co.edu.uniquindio.poo;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion=0;
        while (opcion!=5) {
            System.out.println("Bienvenido a al menu del parqueadero");
            System.out.println("Elija una opcion:");
            System.out.println("1.Crear parqueadero");
            System.out.println("2. Registrar entrada de un vehiculo");

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
                
                case 2:
                System.out.println("ingrese el propietario:");
                System.out.println("ingrese el nombre del propietario:");
                String nombrePropietario=scanner.nextLine();
                System.out.println("intrese la identificacion del propietario:");
                String id=scanner.nextLine();
                Propietario propietario=new Propietario(id, nombrePropietario);
                System.out.println("ingrese el vehiculo:");
                System.out.println("ingrese la placa del vehiculo:");
                String placa=scanner.nextLine();
                System.out.println("ingrese el modelo:");
                String modelo=scanner.nextLine();
                System.out.println(" ingrese el tipo de vehiculo: (CARRO, MOTOHIBRIDA, MOTOCLASICA)");
                String input=scanner.nextLine();
                try{
                    TipoVehiculo tipoVehiculo=TipoVehiculo.fromString(input);
                    Vehiculo vehiculo=new Vehiculo(placa, modelo, propietario,tipoVehiculo);

                }catch (IllegalArgumentException e) {
                    System.out.println("Tipo de vehículo inválido");

                }
                P
                break;
            }
        }
    }
}