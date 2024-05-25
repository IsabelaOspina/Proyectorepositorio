package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Registro {
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    /**
     * Constructo de la clase registro
     * @param horaEntrada
     * @param horaSalida
     */
    public Registro(LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    /**
     * metodo para calcular la cantidad de horas que duro el vehiculo en el parqueadero
     * @param horaEntrada
     * @param horaSalida
     * @return
     */
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
     * metodo get para hora entrada
     * @return
     */
    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }
    /**
     * metodo set para hora entrada
     * @param horaEntrada
     */
    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * metodo get para hora de salida
     * @return
     */
    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    /**
     * metodo set para hora de salida
     * @param horaSalida
     */
    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

}