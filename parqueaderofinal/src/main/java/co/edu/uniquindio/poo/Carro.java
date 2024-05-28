package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {

    /**
     * constructor de la clase carro
     * 
     * @param placa
     * @param modelo
     * @param propietario
     */
    public Carro(String placa, String modelo, Propietario propietario) {
        super(placa, modelo, propietario, TipoVehiculo.CARRO);
    }

    /**
     * Metodo que permite obtener el modelo de un vehiculo
     * 
     * @return
     */
    @Override
    public String getModelo() {
        return super.getModelo();
    }

    /**
     * Metodo que permite obtener la placa de un vehiculo
     * 
     * @return
     */
    @Override
    public String getPlaca() {
        return super.getPlaca();
    }

    /**
     * Metodo que permite obtener el propietario de un vehiculo
     * 
     * @return
     */
    @Override
    public Propietario getPropietario() {
        return super.getPropietario();
    }

    /**
     * Metodo que permite modificar el modelo de un vehiculo
     * 
     * @return
     */
    @Override
    public void setModelo(String modelo) {
        super.setModelo(modelo);
    }

    /**
     * Metodo que permite modificar la placa de un vehiculo
     * 
     * @return
     */
    @Override
    public void setPlaca(String placa) {
        super.setPlaca(placa);
    }

    /**
     * Metodo que permite modificar el propieatario de un vehiculo
     * 
     * @return
     */
    @Override
    public void setPropietario(Propietario propietario) {
        super.setPropietario(propietario);
    }

}
