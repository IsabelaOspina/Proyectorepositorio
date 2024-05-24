package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {
    public Carro(String placa, String modelo, Propietario propietario) {
        super(placa, modelo, propietario, TipoVehiculo.CARRO);
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

}
