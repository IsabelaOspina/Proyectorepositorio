package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = null;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Crear parqueadero");
            System.out.println("2. Registrar entrada de vehículo");
            System.out.println("3. Registrar salida de vehículo");
            System.out.println("4. Generar reporte diario");
            System.out.println("5. Generar reporte mensual");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Crear parqueadero
                    System.out.print("Ingrese el nombre del parqueadero: ");
                    String nombreParqueadero = scanner.nextLine();
                    System.out.print("Ingrese el número de puestos: ");
                    int numeroPuestos = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    parqueadero = new Parqueadero(nombreParqueadero, numeroPuestos);
                    System.out.println("Parqueadero creado exitosamente.");
                    break;
                case 2:
                    // Registrar entrada de vehículo
                    System.out.print("Ingrese la placa del vehículo: ");
                    String placaEntrada = scanner.nextLine();
                    System.out.print("Ingrese el modelo del vehículo: ");
                    String modeloEntrada = scanner.nextLine();
                    System.out.print("Ingrese el ID del propietario: ");
                    String idPropietarioEntrada = scanner.nextLine();
                    System.out.print("Ingrese el nombre del propietario: ");
                    String nombrePropietarioEntrada = scanner.nextLine();
                    System.out.print("Ingrese la fecha de entrada (YYYY-MM-DD-HH:mm): ");
                    DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
                    LocalDateTime horaEntrada = LocalDateTime.parse(scanner.nextLine(), formatterEntrada);
                    ;
                    Propietario propietarioEntrada = new Propietario(idPropietarioEntrada, nombrePropietarioEntrada);
                    System.out.print("Ingrese el tipo de vehículo (CARRO, MOTOCLASICA, MOTOHIBRIDA): ");
                    String tipoVehiculoEntrada = scanner.nextLine().toUpperCase();
                    TipoVehiculo tipoEntrada = TipoVehiculo.valueOf(tipoVehiculoEntrada);

                    Vehiculo vehiculoEntrada;
                    if (tipoEntrada == TipoVehiculo.CARRO) {
                        vehiculoEntrada = new Carro(placaEntrada, modeloEntrada, propietarioEntrada);
                    } else {
                        System.out.print("Ingrese la velocidad máxima de la moto: ");
                        int velocidadMaxima = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        vehiculoEntrada = new Moto(placaEntrada, modeloEntrada, propietarioEntrada, velocidadMaxima,
                                tipoEntrada);
                    }

                    Registro registroEntrada = new Registro(horaEntrada, null, vehiculoEntrada);
                    parqueadero.registrarEntrada(registroEntrada);

                    if (parqueadero.asignarPuesto(vehiculoEntrada)) {
                        System.out.println("Entrada registrada y puesto asignado.");
                    } else {
                        System.out.println("No hay puestos disponibles.");
                    }
                    break;
                case 3:
                    // Registrar salida de vehículo
                    if (parqueadero == null) {
                        System.out.println("No hay parqueadero creado.");
                        break;
                    }
                    System.out.print("Ingrese la placa del vehículo: ");
                    String placaSalida = scanner.nextLine();
                    System.out.print("Ingrese la fecha de salida (YYYY-MM-DD HH:mm:ss): ");
                    DateTimeFormatter formatterSalida = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
                    LocalDateTime horaSalida = LocalDateTime.parse(scanner.nextLine(), formatterSalida);
                    Registro registroSalida = parqueadero.buscarRegistroPorPlaca(placaSalida);

                    if (registroSalida != null) {
                        registroSalida.setHoraSalida(horaSalida);
                        double tarifa = parqueadero.calcularTarifa(registroSalida, registroSalida.getVehiculo());
                        parqueadero.liberarPuesto(registroSalida.getVehiculo());
                        parqueadero.registrarSalida(registroSalida);
                        System.out.println("Salida registrada. Monto a pagar: $" + tarifa);

                    } else {
                        System.out.println("No se encontró un registro de entrada para ese vehículo.");
                    }
                    break;
                case 4:
                    // Generar reporte diario
                    if (parqueadero == null) {
                        System.out.println("No hay parqueadero creado.");
                        break;
                    }
                    System.out.print("Ingrese la fecha del reporte (YYYY-MM-DD): ");
                    LocalDate fecha = LocalDate.parse(scanner.nextLine());
                    double[] reporteDiario = new double[3]; 
                    parqueadero.generarReporteDiario(fecha);
                    
                    System.out.println("Reporte diario:");
                    System.out.println("Total recaudado por carros: $" + reporteDiario[0]);
                    System.out.println("Total recaudado por motos clásicas: $" + reporteDiario[1]);
                    System.out.println("Total recaudado por motos híbridas: $" + reporteDiario[2]);
                    break;
                case 5:
                    // Generar reporte mensual
                    if (parqueadero == null) {
                        System.out.println("No hay parqueadero creado.");
                        break;
                    }
                    System.out.print("Ingrese el mes del reporte (1-12): ");
                    int mes = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    double totalMensual = parqueadero.generarReporteMensual(mes);

                    System.out.println("Reporte mensual:");
                    System.out.println("Total recaudado en el mes: $" + totalMensual);
                    break;
                case 6:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
