package co.edu.uniquindio.poo;

public class Vehiculo {
    private String placa;
    private String modelo;
    private Propietario propietario;
    private TipoVehiculo tipoVehiculo;

    /**
     * constructor de vehiculo
     * 
     * @param placa
     * @param modelo
     * @param propietario
     * @param tipoVehiculo
     */
    public Vehiculo(String placa, String modelo, Propietario propietario, TipoVehiculo tipoVehiculo) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * metodo para obtener la placa
     * 
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * metodo para set para placa
     * 
     * @param placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * metodo para obtener el modelo
     * 
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * metodo set para modelo
     * 
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * metodo para obtener al propietario
     * 
     * @param nombrePropietarioEntrada
     * @param idPropietarioEntrada
     * 
     * @return
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * metodo set propietario
     * 
     * @param propietario
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /**
     * metodo para obtener el tipo de vehiculo
     * 
     * @return
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * metodo set para tipo de vehiculo
     * 
     * @param tipoVehiculo
     */
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
}
