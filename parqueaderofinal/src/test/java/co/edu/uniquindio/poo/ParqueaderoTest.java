package co.edu.uniquindio.poo;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void testCalcularTarifaCarro() {
        LocalDateTime horaEntrada = LocalDateTime.of(2024, 5, 1, 10, 0);
        LocalDateTime horaSalida = LocalDateTime.of(2024, 5, 1, 12, 30);
        Registro registro = new Registro(horaEntrada, horaSalida);

        Parqueadero parqueadero = new Parqueadero();
        double tarifaCalculada = parqueadero.calcularTarifa(registro, TipoVehiculo.CARRO);

        assertEquals(7500, tarifaCalculada, 0);
    }
}
