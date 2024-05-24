package co.edu.uniquindio.poo;

public class Vehiculo {
    private String placa;
    private String modelo;
    private Propietario propietario;
    private TipoVehiculo tipoVehiculo;

    public Vehiculo(String placa, String modelo, Propietario propietario, TipoVehiculo tipoVehiculo) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
}
