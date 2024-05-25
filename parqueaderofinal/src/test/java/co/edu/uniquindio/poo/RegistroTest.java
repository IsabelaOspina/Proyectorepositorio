package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class RegistroTest {

    @Test
    /**
     * prueba del metodo  calcular tarifa
     */
    public void pruebaCalcularHoraTOtal(){
        LocalDateTime horaEntrada=LocalDateTime.of(2024,5,25,11,30);
        LocalDateTime horaSalida=LocalDateTime.of(2024,5,25,12,45);
        Registro registro = new Registro(horaEntrada, horaSalida,TipoVehiculo.CARRO);
        long resultado = registro.CalcularHoraTotal(horaEntrada, horaSalida);
        assertEquals(1, resultado);



    }

    
}
