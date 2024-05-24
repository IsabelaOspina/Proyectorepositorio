package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private int velocidadMaxima;

    public Moto(String placa, String modelo, Propietario propietario, int velocidadMaxima, TipoVehiculo tipoVehiculo) {
        super(placa, modelo, propietario, tipoVehiculo);
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
}
