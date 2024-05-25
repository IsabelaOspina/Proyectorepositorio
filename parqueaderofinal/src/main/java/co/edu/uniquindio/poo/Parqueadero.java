package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private String nombre;
    private int numeroPuesto;
    private List<Registro> registros;

    public Parqueadero(String nombre, int numeroPuesto) {
        this.nombre = nombre;
        this.numeroPuesto = numeroPuesto;
        this.registros = new ArrayList<>();
    }


    // Método para registrar la entrada de un vehículo
    public void registrarEntrada(Registro registro) {
        registros.add(registro);
    }

    // Método para registrar la salida de un vehículo
    public void registrarSalida(Registro registro) {
        registros.remove(registro);
    }

    // Método para generar el reporte diario del dinero recaudado
    public double[] generarReporteDiario(LocalDate fecha) {
        double totalCarro = 0;
        double totalMotoClasica = 0;
        double totalMotoHibrida = 0;

        for (Registro registro : registros) {
            if (registro.getHoraEntrada().toLocalDate().equals(fecha)) {
                TipoVehiculo tipoVehiculo = registro.getTipoVehiculo();
                double tarifa = calcularTarifa(registro, tipoVehiculo);

                // Actualizar el total recaudado según el tipo de vehículo
                switch (tipoVehiculo) {
                    case CARRO:
                        totalCarro += tarifa;
                        break;
                    case MOTOCLASICA:
                        totalMotoClasica += tarifa;
                        break;
                    case MOTOHIBRIDA:
                        totalMotoHibrida += tarifa;
                        break;
                    default:
                        break;
                }
            }
        }

        // Devolver un array con los totales recaudados para cada tipo de vehículo
        return new double[] { totalCarro, totalMotoClasica, totalMotoHibrida };
    }

    // Método para generar el reporte mensual del dinero recaudado
    public double generarReporteMensual(int mes) {
        double totalRecaudado = 0;
        for (Registro registro : registros) {
            if (registro.getHoraEntrada().getMonthValue() == mes) {
                totalRecaudado += calcularTarifa(registro, registro.getTipoVehiculo());
            }
        }
        return totalRecaudado;
    }

    public double calcularTarifa(Registro registro, TipoVehiculo tipoVehiculo) {
        long horas = registro.CalcularHoraTotal(registro.getHoraEntrada(), registro.getHoraSalida());
        double tarifa;

        switch (tipoVehiculo) {
            case CARRO:
                tarifa = TipoVehiculo.CARRO.getTarifaHora();
                break;
            case MOTOCLASICA:
                tarifa = TipoVehiculo.MOTOCLASICA.getTarifaHora();
                break;
            case MOTOHIBRIDA:
                tarifa = TipoVehiculo.MOTOHIBRIDA.getTarifaHora();
                break;
            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido: " + tipoVehiculo);
        }

        return horas * tarifa;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }
}
