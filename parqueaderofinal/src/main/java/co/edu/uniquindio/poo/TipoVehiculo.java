package co.edu.uniquindio.poo;

public enum TipoVehiculo {
    CARRO(2500),
    MOTOCLASICA(1500),
    MOTOHIBRIDA(1200);

    private final double tarifaHora;

    /**
     * constructor tipo de vehiculo
     * @param tarifaHora
     */
    TipoVehiculo(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    /**
     * metodo get para tarifa por hora
     * @return
     */
    public double getTarifaHora() {
        return tarifaHora;
    }
}
