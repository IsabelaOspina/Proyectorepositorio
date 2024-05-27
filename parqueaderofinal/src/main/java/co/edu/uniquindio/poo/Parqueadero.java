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

    /**
     * metodo para generar el reporte diario de dinero recogido por dia segun el
     * tipo de vehículo
     * 
     * @param fecha
     * @return
     */
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

    /*
     * Método para generar el reporte mensual del dinero recaudado
     */
    public double generarReporteMensual(int mes) {
        double totalRecaudado = 0;
        for (Registro registro : registros) {
            if (registro.getHoraEntrada().getMonthValue() == mes) {
                totalRecaudado += calcularTarifa(registro, registro.getVehiculo());
            }
        }
        return totalRecaudado;
    }

    /*
     * Metodo para calcular la tarfifa de un vehiculo basado en el registro y el tipo de vehiculo
     */
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
    /*
     * Metdo que permite asignar puesto a un vehiculo
     */
    public boolean asignarPuesto(Vehiculo vehiculo) {
        for (Puesto puesto : this.puestos) {
            if (puesto.isDisponible()) {
                puesto.setDisponible(false);
                puesto.identificarPropietario(vehiculo); // Método para identificar al propietario del vehículo
                return true; // Puesto asignado correctamente
            }
        }
        return false; // No hay puestos disponibles
    }

    /*
     * metodo para liberar un puesto de un parqueadero haciendo que este disponible nuevamente
     */
    public void liberarPuesto(Vehiculo vehiculo) {
        for (Puesto puesto : this.puestos) {
            if (!puesto.isDisponible()) { //comprueba si el puesto no esta disponible
                puesto.setDisponible(true); // Marcar el puesto como disponible
                return; // Salir del método una vez que el puesto se ha liberado
            }
        }
        // Si el vehículo no se encuentra en el parqueadero
        throw new IllegalArgumentException("El vehículo no está en el parqueadero.");
    }

    /*
     * Metodo que busca un registro específico en una colección de registros, basándose en la placa del vehículo
     */
    public Registro buscarRegistroPorPlaca(String placa) {
        for (Registro registro : registros) {
            if (registro.getVehiculo().getPlaca().equals(placa)) {
                return registro; // Devuelve el registro si se encuentra la placa buscada
            }
        }
        // Si no se encuentra ningún registro con la placa buscada, lanzamos una excepción
        throw new IllegalArgumentException("No se encontró ningún registro con la placa: " + placa);
    }

    /*
     * metodo que permite modificar la lista de registros
     */
    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
    /*
     * Metodo qu epermite obtener el nombre del parqueadero
     */
    public String getNombre() {
        return nombre;
    }
    /*
     * metodo que permite modificar el nomnbre del parqueadero
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /*
     * metodo que permite obtener el numero de puestos de un parqueadero
     */
    public int getNumeroPuestos() {
        return numeroPuestos;
    }
    /*
     * metodo qu epermite modificar el numero de puestos de un parqueadero
     */
    public void setNumeroPuestos(int numeroPuestos) {
        this.numeroPuestos = numeroPuestos;
    }
    /*
     * metodo que permite obtener la lista de registros
     */
    public List<Registro> getRegistros() {
        return registros;
    }
    /*
     * metodo para obtener el vectro de puestos
     */
    public Puesto[] getPuestos() {
        return puestos;
    }
}