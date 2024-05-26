package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private String nombre;
    private int numeroPuestos;
    private List<Registro> registros;
    private Puesto puestos[];

    public Parqueadero(String nombre, int numeroPuestos) {
        this.registros = new ArrayList<>();
        this.numeroPuestos = numeroPuestos;
        this.nombre = nombre;
        crearPuestos(numeroPuestos);// La lista de puestos se crea inmediatamente se instancia un Parqueadero y se
                                    // asigna al atributo puestos (atributo de la clase)
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
    public double[] generarReporteDiario(LocalDate fecha,Vehiculo vehiculo) {
        double totalCarro = 0;
        double totalMotoClasica = 0;
        double totalMotoHibrida = 0;

        for (Registro registro : registros) {
            if (registro.getHoraEntrada().toLocalDate().equals(fecha)) {
                TipoVehiculo tipoVehiculo = registro.getVehiculo();
                double tarifa = calcularTarifa(registro, tipoVehiculo);

                // Actualizar el total recaudado según el tipo de vehículo
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

        // Devolver un array con los totales recaudados para cada tipo de vehículo
        return new double[] { totalCarro, totalMotoClasica, totalMotoHibrida };
    }

    // Método para generar el reporte mensual del dinero recaudado
    public double generarReporteMensual(int mes) {
        double totalRecaudado = 0;
        for (Registro registro : registros) {
            if (registro.getHoraEntrada().getMonthValue() == mes) {
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
    /*
     * metodo que permite la creacion de puestos en el parqueadero
     */

    public void crearPuestos(int cantidadPuestos) {
        Puesto[] puestos = new Puesto[cantidadPuestos];
        for (int i = 0; i < cantidadPuestos; i++) {
            puestos[i] = new Puesto(true);
        }
        this.puestos = puestos;

    }

    public boolean asignarPuesto(Vehiculo vehiculo) {
        for (Puesto puesto : puestos) {
            if (puesto.isDisponible()) {
                puesto.setDisponible(false);
                puesto.identificarPropietario(vehiculo); // Método para identificar al propietario del vehículo
                return true; // Puesto asignado correctamente
            }
        }
        return false; // No hay puestos disponibles
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
        return numeroPuestos;
    }

    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuestos = numeroPuesto;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public Puesto[] getPuestos() {
        return puestos;
    }

    public void setPuestos(Puesto[] puestos) {
        this.puestos = puestos;
    }

}