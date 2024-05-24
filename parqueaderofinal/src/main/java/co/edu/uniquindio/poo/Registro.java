package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Registro {
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Registro(LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
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

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

}