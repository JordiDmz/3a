/**
 * Punto de entrada del programa.
 * Sólo delega el trabajo a la clase Logic.
 */
public class App {
    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.logic1a(args);
    }
}
