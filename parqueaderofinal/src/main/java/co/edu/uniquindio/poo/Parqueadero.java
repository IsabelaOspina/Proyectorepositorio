package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private List<Registro> registros;

    /**
     * metodo para calcular la tarifa de los vehiculos
     * @param registro
     * @param tipoVehiculo
     * @return
     */
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
}
