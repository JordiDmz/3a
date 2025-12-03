/**
 * Encapsula todos los cálculos de regresión lineal y correlación.
 * Aquí se hacen las sumas, betas, r, r^2 y la predicción yk.
 */
public class EstimacionCorLineal {

    // Sumas y promedios calculados a partir de los datos
    private double dblSumX;
    private double dblSumY;
    private double dblSumXY;
    private double dblSumXX;
    private double dblSumYY;
    private double dblAvgX;
    private double dblAvgY;

    // Tamaño de la muestra y resultados de regresión/correlación
    private int    intN;
    private double dblB1;
    private double dblRXY;
    private double dblB0;
    private double dblR;
    private double dblXk;
    private double dblYk;

    /**
     * Recibe el valor de Xk para el que queremos predecir Yk.
     */
    public EstimacionCorLineal(double xk) {
        this.dblXk = xk;
    }

    /**
     * Calcula la suma de X y el promedio de X.
     */
    public double sumX(String[] datalist) {
        dblSumX = 0.0;
        intN = datalist.length;
        for (String s : datalist) {
            dblSumX += Double.parseDouble(s);
        }
        dblAvgX = dblSumX / intN;
        return dblSumX;
    }

    /**
     * Calcula la suma de Y y el promedio de Y.
     * (intN se asume del mismo tamaño que X).
     */
    public double sumY(String[] datalist) {
        dblSumY = 0.0;
        for (String s : datalist) {
            dblSumY += Double.parseDouble(s);
        }
        dblAvgY = dblSumY / intN;
        return dblSumY;
    }

    /**
     * Calcula la suma de X*Y.
     */
    public double sumXY(String[] datalistX, String[] datalistY) {
        dblSumXY = 0.0;
        for (int i = 0; i < datalistX.length; i++) {
            double x = Double.parseDouble(datalistX[i]);
            double y = Double.parseDouble(datalistY[i]);
            dblSumXY += x * y;
        }
        return dblSumXY;
    }

    /**
     * Calcula la suma de X^2.
     */
    public double sumXX(String[] datalist) {
        dblSumXX = 0.0;
        for (String s : datalist) {
            double x = Double.parseDouble(s);
            dblSumXX += x * x;
        }
        return dblSumXX;
    }

    /**
     * Calcula la suma de Y^2.
     */
    public double sumYY(String[] datalist) {
        dblSumYY = 0.0;
        for (String s : datalist) {
            double y = Double.parseDouble(s);
            dblSumYY += y * y;
        }
        return dblSumYY;
    }

    /**
     * Regresa B1 usando las fórmulas de regresión.
     * (reutiliza las sumas ya calculadas).
     */
    public double getB1() {
        double numerator = intN * dblSumXY - dblSumX * dblSumY;
        double denominator = intN * dblSumXX - dblSumX * dblSumX;
        dblB1 = numerator / denominator;
        return dblB1;
    }

    /**
     * Regresa r_xy (correlación lineal).
     */
    public double getRXY() {
        double numerator = intN * dblSumXY - dblSumX * dblSumY;
        double denominator = Math.sqrt(
                (intN * dblSumXX - dblSumX * dblSumX) *
                (intN * dblSumYY - dblSumY * dblSumY)
        );
        dblRXY = numerator / denominator;
        return dblRXY;
    }

    /**
     * Calcula B0 usando B1 y los promedios de X y Y.
     */
    public double getB0() {
        dblB0 = dblAvgY - dblB1 * dblAvgX;
        return dblB0;
    }

    /**
     * Calcula la predicción Yk para el Xk configurado en el constructor.
     */
    public double getYk() {
        dblYk = dblB0 + dblB1 * dblXk;
        return dblYk;
    }

    /**
     * Regresa r^2 (fuerza de la relación).
     */
    public double getR() {
        dblR = dblRXY * dblRXY;
        return dblR;
    }
}
