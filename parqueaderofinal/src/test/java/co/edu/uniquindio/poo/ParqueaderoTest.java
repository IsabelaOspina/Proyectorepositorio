package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParqueaderoTest {
        /*
         * metodo que permite verificar
         */
        @Test
        public void testCalcularTarifaCarro() {
                LocalDateTime horaEntrada = LocalDateTime.of(2024, 5, 1, 10, 0);
                LocalDateTime horaSalida = LocalDateTime.of(2024, 5, 1, 12, 20);
                Propietario propietario = new Propietario("12345", "David");
                Vehiculo vehiculo = new Vehiculo("BBB-000", "2025", propietario, TipoVehiculo.CARRO);
                Registro registro = new Registro(horaEntrada, horaSalida, vehiculo);
                Parqueadero parqueadero = new Parqueadero("parking", 100);
                double tarifaCalculada = parqueadero.calcularTarifa(registro, vehiculo);

                assertEquals(5000, tarifaCalculada, 0);
        }

        /*
         * metodo que permite verificar el recaudo total diario en un parqueadero
         */
        @Test
        public void testGenerarReporteDiario() {
                Propietario propietario = new Propietario("12345", "David");
                Vehiculo vehiculo1 = new Vehiculo("BBB-000", "2025", propietario, TipoVehiculo.CARRO);
                Vehiculo vehiculo2 = new Vehiculo("BBB-002", "2025", propietario, TipoVehiculo.MOTOCLASICA);
                Vehiculo vehiculo3 = new Vehiculo("BBB-090", "2015", propietario, TipoVehiculo.MOTOHIBRIDA);
                Vehiculo vehiculo4 = new Vehiculo("IOB-090", "202P0", propietario, TipoVehiculo.CARRO);
                // Crear registros para la prueba
                Registro registro1 = new Registro(
                                LocalDateTime.of(2024, 5, 1, 10, 0),
                                LocalDateTime.of(2024, 5, 1, 12, 30),
                                vehiculo1);
                Registro registro2 = new Registro(
                                LocalDateTime.of(2024, 5, 1, 11, 0),
                                LocalDateTime.of(2024, 5, 1, 13, 15),
                                vehiculo2);
                Registro registro3 = new Registro(
                                LocalDateTime.of(2024, 5, 1, 12, 0),
                                LocalDateTime.of(2024, 5, 1, 14, 45),
                                vehiculo3);
                Registro registro4 = new Registro(
                                LocalDateTime.of(2024, 5, 2, 10, 0),
                                LocalDateTime.of(2024, 5, 2, 12, 0),
                                vehiculo4);

                // Agregar registros a una lista
                List<Registro> registros = new ArrayList<>();
                registros.add(registro1);
                registros.add(registro2);
                registros.add(registro3);
                registros.add(registro4);

                // Crear el objeto Parqueadero y asignar la lista de registros
                Parqueadero parqueadero = new Parqueadero("parking", 100);
                parqueadero.setRegistros(registros);

                // Calcular el total recaudado para el 1 de mayo de 2024
                double[] totalRecaudado = parqueadero.generarReporteDiario(LocalDate.of(2024, 5, 1));

                // Verificar que el total recaudado sea el esperado
                double[] expected = { 7500, 3000, 3600 }; // total para carro, moto clásica, moto híbrida
                                                          // respectivamente
                assertArrayEquals(expected, totalRecaudado);

        }

        /*
         * metodo que permite verificar el recaudo total mensual en un parqueadero
         */
        @Test
        public void testGenerarReporteMensual() {
                Propietario propietario = new Propietario("12345", "David");
                Vehiculo vehiculo1 = new Vehiculo("BBB-000", "2025", propietario, TipoVehiculo.CARRO);
                Vehiculo vehiculo2 = new Vehiculo("BBB-002", "2025", propietario, TipoVehiculo.MOTOCLASICA);
                Vehiculo vehiculo3 = new Vehiculo("BBB-090", "2015", propietario, TipoVehiculo.MOTOHIBRIDA);
                Vehiculo vehiculo4 = new Vehiculo("IOB-090", "202P0", propietario, TipoVehiculo.CARRO);
                List<Registro> registros = new ArrayList<>();
                registros.add(new Registro(LocalDateTime.of(2024, 5, 1, 10, 0), LocalDateTime.of(2024, 5, 1, 12, 30),
                                vehiculo1));
                registros.add(new Registro(LocalDateTime.of(2024, 5, 2, 11, 0), LocalDateTime.of(2024, 5, 2, 13, 15),
                                vehiculo2));
                registros.add(new Registro(LocalDateTime.of(2024, 5, 3, 12, 0), LocalDateTime.of(2024, 5, 3, 14, 45),
                                vehiculo3));
                registros.add(new Registro(LocalDateTime.of(2024, 6, 1, 10, 0), LocalDateTime.of(2024, 6, 1, 12, 0),
                                vehiculo4));

                Parqueadero parqueadero = new Parqueadero("parking", 100);
                parqueadero.setRegistros(registros);

                double totalRecaudado = parqueadero.generarReporteMensual(5);

                assertEquals(14100, totalRecaudado, 0);
        }

        /*
         * metodo que permite verificar que un puesto este disponible para ser asignado
         */
        @Test
        public void testAsignarPuestoDisponible() {
                Parqueadero parqueadero = new Parqueadero("Mi Parqueadero", 3); // Crear un parqueadero con 3 puestos
                Propietario propietario = new Propietario("Juan", "12345"); // Crear un propietario
                Vehiculo vehiculo = new Vehiculo("ABC123", "ModeloX", propietario, TipoVehiculo.CARRO);

                // Verificar que se pueda asignar un puesto cuando hay puestos disponibles
                assertTrue(parqueadero.asignarPuesto(vehiculo));
        }

        /*
         * metodo que permite verificar que no se pueda asignar un puesrto cuando no
         * hayan disponibles
         */
        @Test
        public void testAsignarPuestoNoDisponible() {
                Parqueadero parqueadero = new Parqueadero("Mi Parqueadero", 3); // Crear un parqueadero con 3 puestos

                // Llenar todos los puestos
                parqueadero.asignarPuesto(new Vehiculo("ABC123", "ModeloX", new Propietario("Juan", "12345"),
                                TipoVehiculo.CARRO));
                parqueadero.asignarPuesto(new Vehiculo("DEF456", "ModeloY", new Propietario("Ana", "67890"),
                                TipoVehiculo.MOTOCLASICA));
                parqueadero.asignarPuesto(new Vehiculo("GHI789", "ModeloZ", new Propietario("Luis", "11223"),
                                TipoVehiculo.MOTOHIBRIDA));

                Vehiculo vehiculo = new Vehiculo("JKL012", "ModeloW", new Propietario("Carlos", "44556"),
                                TipoVehiculo.CARRO);

                // Verificar que no se pueda asignar un puesto cuando no hay puestos disponibles
                assertFalse(parqueadero.asignarPuesto(vehiculo));
        }

        /*
         * Metodo para buscar la placa de un vehiculo de forma correcta
         */
        @Test
        public void testBuscarRegistroPorPlaca() {
                Parqueadero parqueadero = new Parqueadero("Parqueadero Central", 10);
                Propietario propietario1 = new Propietario("Juan", "12345");
                Propietario propietario2 = new Propietario("Maria", "87654");
                Vehiculo vehiculo1 = new Vehiculo("ABC123", "ModeloX", propietario1, TipoVehiculo.CARRO);
                Vehiculo vehiculo2 = new Vehiculo("XYZ789", "ModeloY", propietario2, TipoVehiculo.MOTOCLASICA);

                // Establecer fechas y horas específicas
                LocalDateTime horaEntrada1 = LocalDateTime.of(2024, 5, 25, 10, 0);
                LocalDateTime horaSalida1 = LocalDateTime.of(2024, 5, 25, 12, 0);
                LocalDateTime horaEntrada2 = LocalDateTime.of(2024, 5, 25, 11, 0);
                LocalDateTime horaSalida2 = LocalDateTime.of(2024, 5, 25, 12, 0);

                Registro registro1 = new Registro(horaEntrada1, horaSalida1, vehiculo1);
                Registro registro2 = new Registro(horaEntrada2, horaSalida2, vehiculo2);

                parqueadero.registrarEntrada(registro1);
                parqueadero.registrarEntrada(registro2);

                Registro registroEncontrado = parqueadero.buscarRegistroPorPlaca("ABC123");
                assertEquals(registro1, registroEncontrado,
                                "El registro encontrado debería coincidir con el registro1.");

                Registro registroEncontrado2 = parqueadero.buscarRegistroPorPlaca("XYZ789");
                assertEquals(registro2, registroEncontrado2,
                                "El registro encontrado debería coincidir con el registro2.");
        }

        /*
         * prueba que asignar a un vehiculo un puesto no disponible en el parqueadero
         */
        @Test
        public void testLiberarPuesto() {
                // Configuración inicial
                Parqueadero parqueadero = new Parqueadero("Central Parking", 1);
                Propietario propietario = new Propietario("John Doe", "123456");
                Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota", propietario, TipoVehiculo.CARRO);

                // Asignar un puesto al vehículo
                parqueadero.asignarPuesto(vehiculo);

                // Liberar el puesto
                parqueadero.liberarPuesto(vehiculo);

                // Verificar que el puesto esté disponible
                assertTrue(parqueadero.getPuestos()[0].isDisponible());
        }
}
