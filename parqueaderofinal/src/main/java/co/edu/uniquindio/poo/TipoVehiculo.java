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
     * metodo para convertir las opciones del enum en texto
     * @param text
     * @return
     */
    public static TipoVehiculo fromString(String texto) {
        for (TipoVehiculo tipo : TipoVehiculo.values()) {
            if (tipo.name().equalsIgnoreCase(texto)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de vehículo no válido: " + texto);
    }

    /**
     * metodo get para tarifa por hora
     * @return
     */
    public double getTarifaHora() {
        return tarifaHora;
    }
}
