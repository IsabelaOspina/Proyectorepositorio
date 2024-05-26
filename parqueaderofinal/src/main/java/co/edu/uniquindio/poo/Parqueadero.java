package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private String nombre;
    private int numeroPuestos;
    private List<Registro> registros;
    private Puesto[] puestos;

    public Parqueadero(String nombre, int numeroPuestos) {
        this.registros = new ArrayList<>();
        this.numeroPuestos = numeroPuestos;
        this.nombre = nombre;

        crearPuestos(numeroPuestos);
    }

    public void registrarEntrada(Registro registro) {
        registros.add(registro);
    }

    /*
     * public void registrarSalida(LocalDateTime horaEntrada, LocalDateTime
     * horaSalida) {
     * horaSalida.setHoraSalida(horaSalida);
     * }
     */

    public double[] generarReporteDiario(LocalDate fecha) {
        double totalCarro = 0;
        double totalMotoClasica = 0;
        double totalMotoHibrida = 0;

        for (Registro registro : registros) {
            if (registro.getHoraSalida() != null && registro.getHoraEntrada().toLocalDate().equals(fecha)) {
                Vehiculo vehiculo = registro.getVehiculo();
                double tarifa = calcularTarifa(registro, vehiculo);

                switch (vehiculo.getTipoVehiculo()) {
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

        return new double[] { totalCarro, totalMotoClasica, totalMotoHibrida };
    }

    public double generarReporteMensual(int mes) {
        double totalRecaudado = 0;
        for (Registro registro : registros) {
            if (registro.getHoraSalida() != null && registro.getHoraEntrada().getMonthValue() == mes) {
                totalRecaudado += calcularTarifa(registro, registro.getVehiculo());
            }
        }
        return totalRecaudado;
    }

    public double calcularTarifa(Registro registro, Vehiculo vehiculo) {
        long horas = registro.CalcularHoraTotal(registro.getHoraEntrada(), registro.getHoraSalida());
        double tarifa;

        switch (vehiculo.getTipoVehiculo()) {
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
                throw new IllegalArgumentException("Tipo de vehículo no válido ");
        }

        return horas * tarifa;
    }

    public void crearPuestos(int cantidadPuestos) {
        Puesto[] puestos = new Puesto[cantidadPuestos];
        for (int i = 0; i < cantidadPuestos; i++) {
            puestos[i] = new Puesto(true);
        }
        this.puestos = puestos;
    }

    public boolean asignarPuesto(Vehiculo vehiculo) {
        for (Puesto puesto : this.puestos) {
            if (puesto.isDisponible()) {
                puesto.setDisponible(false);
                puesto.identificarPropietario(vehiculo);
                return true;
            }
        }
        return false;
    }

    public void liberarPuesto(Vehiculo vehiculo) {
        for (Puesto puesto : puestos) {
            if (!puesto.isDisponible() && puesto.getVehiculo().equals(vehiculo)) {
                puesto.setDisponible(true);
                return;
            }
        }
        throw new IllegalArgumentException("El vehículo no está en el parqueadero.");
    }

    public Registro buscarRegistroPorPlaca(String placa) {
        for (Registro registro : registros) {
            if (registro.getVehiculo().getPlaca().equals(placa)) {
                return registro;
            }
        }
        throw new IllegalArgumentException("No se encontró ningún registro con la placa: " + placa);
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

    public int getNumeroPuestos() {
        return numeroPuestos;
    }

    public void setNumeroPuestos(int numeroPuestos) {
        this.numeroPuestos = numeroPuestos;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public Puesto[] getPuestos() {
        return puestos;
    }
}
