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
     * metodo set para la velocidad maxima
     * 
     * @param velocidadMaxima
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    @Override
    public String getModelo() {
        return super.getModelo();
    }

    @Override
    public String getPlaca() {
        return super.getPlaca();
    }

    @Override
    public Propietario getPropietario() {
        return super.getPropietario();
    }

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return super.getTipoVehiculo();
    }

    @Override
    public void setModelo(String modelo) {
        super.setModelo(modelo);
    }

    @Override
    public void setPlaca(String placa) {
        super.setPlaca(placa);
    }

    @Override
    public void setPropietario(Propietario propietario) {
        super.setPropietario(propietario);
    }

    @Override
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        super.setTipoVehiculo(tipoVehiculo);
    }

}
