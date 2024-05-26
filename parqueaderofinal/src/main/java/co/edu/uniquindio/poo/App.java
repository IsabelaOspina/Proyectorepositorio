package co.edu.uniquindio.poo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Parqueadero parqueadero = new Parqueadero("Parquedavid", 15);
        for (int i = 0; i < parqueadero.getParqueadero().length; i++) {
            System.out.println((i + 1) + " = " + parqueadero.getParqueadero()[i].isDisponible());
        }

        System.out.println("Hello World!");
    }
}
