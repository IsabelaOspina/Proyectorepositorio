package co.edu.uniquindio.poo;

public class Propietario {
    private String id;
    private String nombre;

    /**
     * constructor de propietario
     * @param id
     * @param nombre
     */
    public Propietario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * metodo para obtener la identificacion
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * metodo set para la identificacion
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * metodo para obtener el nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo set para el nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
