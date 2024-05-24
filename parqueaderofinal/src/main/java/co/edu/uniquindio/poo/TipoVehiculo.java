package co.edu.uniquindio.poo;

public enum TipoVehiculo {
    CARRO(2500),
    MOTOCLASICA(1500),
    MOTOHIBRIDA(1200);

    private final double tarifaHora;

    TipoVehiculo(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }
}
