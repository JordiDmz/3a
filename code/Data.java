/**
 * Se encarga de transformar una cadena con números
 * en un arreglo de Strings, para después convertirlos a double.
 */
public class Data {

    /**
     * Recibe una cadena con números separados por espacios, comas, saltos de línea, etc.
     * y regresa un arreglo de Strings con cada número.
     */
    public String[] saveData(String data) {
        if (data == null || data.trim().isEmpty()) {
            return new String[0];
        }
        // Normalizamos separadores para que todo sean espacios simples
        String cleaned = data.replace("\n", " ")
                             .replace("\r", " ")
                             .replace(";", " ")
                             .replace(",", " ");
        cleaned = cleaned.trim().replaceAll("\\s+", " ");
        return cleaned.split(" ");
    }
}
