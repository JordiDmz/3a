import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Encapsula la lectura de texto desde un archivo.
 * (Ahorita no lo usamos mucho, pero está para seguir el diseño del PSP.)
 */
public class Input {

    private String data;
    private BufferedReader br = null;

    /**
     * Lee todo el contenido de un archivo de texto y lo regresa como String.
     */
    public String readData(String inFile) {
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(inFile));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            data = sb.toString();
        } catch (IOException e) {
            System.err.println("Error al leer archivo de entrada: " + e.getMessage());
            data = "";
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                // nada
            }
        }
        return data;
    }
}
