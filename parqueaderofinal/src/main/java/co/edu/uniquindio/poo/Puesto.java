package co.edu.uniquindio.poo;

public class Puesto {
    private boolean disponible;
    private Vehiculo vehiculo;

    /**
     * constructo clase puesto
     * 
     * @param disponible
     */
    public Puesto(boolean disponible) {
        this.disponible = true;
    }

    /**
     * metodo para cambiar el puesto de estado
     */
    public void cambiarEstado() {
        if (this.disponible) {
            this.disponible = false;

        } else {
            this.disponible = true;
        }

    }

    public void identificarPropietario(Vehiculo vehiculo) {
        vehiculo.getPropietario();

    }

    /**
     * metodo get
     * 
     * @return
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * metodo sed
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
