package co.edu.uniquindio.poo;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParqueaderoTest {
        @Test
        public void testCalcularTarifaCarro() {
                LocalDateTime horaEntrada = LocalDateTime.of(2024, 5, 1, 10, 0);
                LocalDateTime horaSalida = LocalDateTime.of(2024, 5, 1, 12, 20);
                Registro registro = new Registro(horaEntrada, horaSalida, TipoVehiculo.CARRO);

                Parqueadero parqueadero = new Parqueadero();
                double tarifaCalculada = parqueadero.calcularTarifa(registro, TipoVehiculo.CARRO);

                assertEquals(5000, tarifaCalculada, 0);
        }

        @Test
        public void testGenerarReporteDiario() {
                // Crear registros para la prueba
                Registro registro1 = new Registro(
                                LocalDateTime.of(2024, 5, 1, 10, 0),
                                LocalDateTime.of(2024, 5, 1, 12, 30),
                                TipoVehiculo.CARRO);
                Registro registro2 = new Registro(
                                LocalDateTime.of(2024, 5, 1, 11, 0),
                                LocalDateTime.of(2024, 5, 1, 13, 15),
                                TipoVehiculo.MOTOCLASICA);
                Registro registro3 = new Registro(
                                LocalDateTime.of(2024, 5, 1, 12, 0),
                                LocalDateTime.of(2024, 5, 1, 14, 45),
                                TipoVehiculo.MOTOHIBRIDA);
                Registro registro4 = new Registro(
                                LocalDateTime.of(2024, 5, 2, 10, 0),
                                LocalDateTime.of(2024, 5, 2, 12, 0),
                                TipoVehiculo.CARRO);

                // Agregar registros a una lista
                List<Registro> registros = new ArrayList<>();
                registros.add(registro1);
                registros.add(registro2);
                registros.add(registro3);
                registros.add(registro4);

                // Crear el objeto Parqueadero y asignar la lista de registros
                Parqueadero parqueadero = new Parqueadero();
                parqueadero.setRegistros(registros);

                // Calcular el total recaudado para el 1 de mayo de 2024
                double[] totalRecaudado = parqueadero.generarReporteDiario(LocalDate.of(2024, 5, 1));

                // Verificar que el total recaudado sea el esperado
                double[] expected = { 7500, 3000, 3600 }; // total para carro, moto clásica, moto híbrida
                                                          // respectivamente
                assertArrayEquals(expected, totalRecaudado);
        }

        @Test
        public void testGenerarReporteMensual() {

                List<Registro> registros = new ArrayList<>();
                registros.add(new Registro(LocalDateTime.of(2024, 5, 1, 10, 0), LocalDateTime.of(2024, 5, 1, 12, 30),
                                TipoVehiculo.CARRO));
                registros.add(new Registro(LocalDateTime.of(2024, 5, 2, 11, 0), LocalDateTime.of(2024, 5, 2, 13, 15),
                                TipoVehiculo.MOTOCLASICA));
                registros.add(new Registro(LocalDateTime.of(2024, 5, 3, 12, 0), LocalDateTime.of(2024, 5, 3, 14, 45),
                                TipoVehiculo.MOTOHIBRIDA));
                registros.add(new Registro(LocalDateTime.of(2024, 6, 1, 10, 0), LocalDateTime.of(2024, 6, 1, 12, 0),
                                TipoVehiculo.CARRO));

                Parqueadero parqueadero = new Parqueadero();
                parqueadero.setRegistros(registros);

                double totalRecaudado = parqueadero.generarReporteMensual(5);

                assertEquals(14100, totalRecaudado, 0);
        }
}
