package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class RegistroTest {

    @Test
    /**
     * prueba para verificar el tiempo de un vehiculo en un parqueadero
     */
    public void pruebaCalcularHoraTOtal(){
        LocalDateTime horaEntrada=LocalDateTime.of(2024,5,25,11,30);
        LocalDateTime horaSalida=LocalDateTime.of(2024,5,25,12,45);
        Propietario propietario=new Propietario("12345", "David");
        Vehiculo vehiculo=new Vehiculo("BBB-000","2025",propietario,TipoVehiculo.CARRO);
        Registro registro = new Registro(horaEntrada, horaSalida,vehiculo);
        long resultado = registro.CalcularHoraTotal(horaEntrada, horaSalida);
        assertEquals(1, resultado);



    }

    
}
