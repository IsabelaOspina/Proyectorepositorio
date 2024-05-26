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
        crearPuestos(numeroPuestos); // La lista de puestos se crea inmediatamente se instancia un Parqueadero y se
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
    public double[] generarReporteDiario(LocalDate fecha) {
        double totalCarro = 0;
        double totalMotoClasica = 0;
        double totalMotoHibrida = 0;

        for (Registro registro : registros) {
            if (registro.getHoraEntrada().toLocalDate().equals(fecha)) {
                Vehiculo vehiculo = registro.getVehiculo(); // Obtenemos el vehículo del registro
                double tarifa = calcularTarifa(registro, vehiculo); // Calculamos la tarifa según el tipo de vehículo
                                                                    // del registro

                // Actualizar el total recaudado según el tipo de vehículo del registro
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
     * método que permite la creación de puestos en el parqueadero
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

    public void liberarPuesto(Vehiculo vehiculo) {
        for (Puesto puesto : puestos) {
            if (!puesto.isDisponible()) {
                puesto.setDisponible(true); // Marcar el puesto como disponible
                return; // Salir del método una vez que el puesto se ha liberado
            }
        }
        // Si el vehículo no se encuentra en el parqueadero, lanzar una excepción
        throw new IllegalArgumentException("El vehículo no está en el parqueadero.");
    }

    public Registro buscarRegistroPorPlaca(String placa) {
        for (Registro registro : registros) {
            if (registro.getVehiculo().getPlaca().equals(placa)) {
                return registro; // Devuelve el registro si se encuentra la placa buscada
            }
        }
        // Si no se encuentra ningún registro con la placa buscada, lanzamos una
        // excepción
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