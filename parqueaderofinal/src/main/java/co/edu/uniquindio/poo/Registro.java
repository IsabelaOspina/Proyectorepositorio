package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Registro {
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private Vehiculo vehiculo;

    public Registro(LocalDateTime horaEntrada, LocalDateTime horaSalida, Vehiculo vehiculo) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.vehiculo = vehiculo;
    }

    public long CalcularHoraTotal(LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        Duration duracion = Duration.between(horaEntrada, horaSalida);
        long horas = duracion.toHours(); // Obtener las horas completas
        long minutosRestantes = duracion.toMinutes() % 60; // Obtener los minutos adicionales

        // Si hay minutos adicionales, y son más de 30 minutos, incrementar las horas
        if (minutosRestantes > 0 && minutosRestantes >= 30) {
            horas++;
        }

        return horas;
    }

    /**
     * Metodo que permite obtener la hora de entrada de un vehiculo
     * 
     * @return
     */
    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Metodo que permite modificar la hora de entrada de un vehiculo
     * 
     * @return
     */
    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Metodo que permite obtener la hora de salida de un vehiculo
     * 
     * @return
     */
    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    /**
     * Metodo que permite modificar la hora de salida de un vehiculo
     * 
     * @return
     */
    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    /*
     * metodo que permite obtener un vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /*
     * metodo que permite modificar un vehiculo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}