package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private int velocidadMaxima;

    /**
     * constructo de la clase moto
     * 
     * @param placa
     * @param modelo
     * @param propietario
     * @param velocidadMaxima
     * @param tipoVehiculo
     */
    public Moto(String placa, String modelo, Propietario propietario, int velocidadMaxima, TipoVehiculo tipoVehiculo) {
        super(placa, modelo, propietario, tipoVehiculo);
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * metodo para obtener la velocidad maxima
     * 
     * @return
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * metodo para modificar la velocidad maxima
     * 
     * @param velocidadMaxima
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    /**
     * Metodo que permite obtener el modelo de un vehiculo
     * @return
     */
    @Override
    public String getModelo() {
        return super.getModelo();
    }
    /**
     * Metodo que permite obtener la placa de un vehiculo
     * @return
     */

    @Override
    public String getPlaca() {
        return super.getPlaca();
    }
    /**
     * Metodo que permite obtener el propieatario de un vehiculo
     * @return
     */
    @Override
    public Propietario getPropietario() {
        return super.getPropietario();
    }
    /**
     * Metodo que permite obtener el tipo vehiculo
     * @return
     */
    @Override
    public TipoVehiculo getTipoVehiculo() {
        return super.getTipoVehiculo();
    }
    /**
     * Metodo que permite modificar el modelo de un vehiculo
     * @return
     */
    @Override
    public void setModelo(String modelo) {
        super.setModelo(modelo);
    }
    /**
     * Metodo que permite modificar la placa de un vehiculo
     * @return
     */
    @Override
    public void setPlaca(String placa) {
        super.setPlaca(placa);
    }
    /**
     * Metodo que permite modificar el propiatario de un vehiculo
     * @return
     */

    @Override
    public void setPropietario(Propietario propietario) {
        super.setPropietario(propietario);
    }
    /**
     * Metodo que permite modificar el tipo de vehiculo
     * @return
     */
    @Override
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        super.setTipoVehiculo(tipoVehiculo);
    }

}
