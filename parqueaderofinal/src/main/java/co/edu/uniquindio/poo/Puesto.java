package co.edu.uniquindio.poo;

public class Puesto {
    private boolean disponible;
    private Vehiculo vehiculo;

    /**
     * constructo de la clase puesto
     * 
     * @param disponible
     */
    public Puesto(boolean disponible) {
        this.disponible = true;
    }

    /**
     * metodo que permitre cambiar el estado de un puesto
     */
    public void cambiarEstado() {
        if (this.disponible) {
            this.disponible = false;

        } else {
            this.disponible = true;
        }

    }
    /*
     * metodo que permite identificar el propieteario de un vehiculo
     */
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
     * metodo set 
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    /*
     * metodo para obtener el vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
