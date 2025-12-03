import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Maneja la salida del programa.
 * Escribe el texto en consola y opcionalmente en un archivo.
 */
public class Output {

    /**
     * outText -> contenido a escribir
     * outFile -> nombre del archivo de salida (si viene vacío, solo imprime en consola)
     */
    public void writeData(String outFile, String outText) {
        // Siempre mostramos en consola
        System.out.println(outText);

        // Si no hay archivo indicado, ya terminamos
        if (outFile == null || outFile.isEmpty()) {
            return;
        }

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(outFile));
            pw.print(outText);
        } catch (IOException e) {
            System.err.println("Error al escribir archivo de salida: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }
}
