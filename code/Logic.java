/**
 * Coordina el flujo del programa:
 * - Define los datos de la tabla 1
 * - Llama a EstimacionCorLineal para cada uno de los 4 tests
 * - Forma el texto de salida y se lo pasa a Output
 */
public class Logic {

    // Estos campos están en el diagrama, pero en este ejemplo casi no se usan.
    private String dataX;
    private String dataY;
    private String dataXk;
    private String arrDataX;
    private String arrDataXk;
    private double thisXk = 386.0;   // Xk para el programa 11

    /**
     * Método principal de lógica (nombre tomado del diagrama).
     * args[0] se usa como nombre de archivo de salida (opcional).
     */
    public void logic1a(String[] args) {

        Output output = new Output();
        Data data = new Data();

        String outFile = (args != null && args.length > 0) ? args[0] : "salida.txt";

        // ================== DATOS TABLA 1 ==================
        // Se dejan como String para que Data los convierta a arreglos.

        // Estimated Proxy Size
        String strEstimatedProxy = "130 650 99 150 128 302 95 945 368 961";

        // Plan Added & Modified Size
        String strPlanAddedMod = "163 765 141 166 137 355 136 1206 433 1130";

        // Actual Added & Modified Size
        String strActualAddedMod = "186 699 132 272 291 331 199 1890 788 1601";

        // Actual Development Hours
        String strActualDevTime = "15.0 69.9 6.5 22.4 28.4 65.9 19.4 198.7 38.8 138.2";

        // Convertimos cada lista de texto a arreglos de String
        String[] estimatedProxy = data.saveData(strEstimatedProxy);
        String[] planAddedMod   = data.saveData(strPlanAddedMod);
        String[] actualAddedMod = data.saveData(strActualAddedMod);
        String[] actualDevTime  = data.saveData(strActualDevTime);

        // ================== TEST 1 ==================
        // x = Estimated Proxy Size
        // y = Actual Added & Modified Size
        EstimacionCorLineal est1 = new EstimacionCorLineal(thisXk);
        est1.sumX(estimatedProxy);
        est1.sumY(actualAddedMod);
        est1.sumXY(estimatedProxy, actualAddedMod);
        est1.sumXX(estimatedProxy);
        est1.sumYY(actualAddedMod);
        double b1_1  = est1.getB1();
        double rxy_1 = est1.getRXY();
        double b0_1  = est1.getB0();
        double yk_1  = est1.getYk();
        double r2_1  = est1.getR();

        // ================== TEST 2 ==================
        // x = Estimated Proxy Size
        // y = Actual Development Time
        EstimacionCorLineal est2 = new EstimacionCorLineal(thisXk);
        est2.sumX(estimatedProxy);
        est2.sumY(actualDevTime);
        est2.sumXY(estimatedProxy, actualDevTime);
        est2.sumXX(estimatedProxy);
        est2.sumYY(actualDevTime);
        double b1_2  = est2.getB1();
        double rxy_2 = est2.getRXY();
        double b0_2  = est2.getB0();
        double yk_2  = est2.getYk();
        double r2_2  = est2.getR();

        // ================== TEST 3 ==================
        // x = Plan Added & Modified Size
        // y = Actual Added & Modified Size
        EstimacionCorLineal est3 = new EstimacionCorLineal(thisXk);
        est3.sumX(planAddedMod);
        est3.sumY(actualAddedMod);
        est3.sumXY(planAddedMod, actualAddedMod);
        est3.sumXX(planAddedMod);
        est3.sumYY(actualAddedMod);
        double b1_3  = est3.getB1();
        double rxy_3 = est3.getRXY();
        double b0_3  = est3.getB0();
        double yk_3  = est3.getYk();
        double r2_3  = est3.getR();

        // ================== TEST 4 ==================
        // x = Plan Added & Modified Size
        // y = Actual Development Time
        EstimacionCorLineal est4 = new EstimacionCorLineal(thisXk);
        est4.sumX(planAddedMod);
        est4.sumY(actualDevTime);
        est4.sumXY(planAddedMod, actualDevTime);
        est4.sumXX(planAddedMod);
        est4.sumYY(actualDevTime);
        double b1_4  = est4.getB1();
        double rxy_4 = est4.getRXY();
        double b0_4  = est4.getB0();
        double yk_4  = est4.getYk();
        double r2_4  = est4.getR();

        // ================== ARMAR SALIDA ==================
        StringBuilder sb = new StringBuilder();
        sb.append("===== PROGRAM 3 - RESULTADOS =====\n");

        sb.append("\nTest 1: Estimated Proxy Size vs Actual Added & Modified Size\n");
        sb.append(String.format("B0   = %.4f\n", b0_1));
        sb.append(String.format("B1   = %.4f\n", b1_1));
        sb.append(String.format("rxy  = %.4f\n", rxy_1));
        sb.append(String.format("r^2  = %.4f\n", r2_1));
        sb.append(String.format("yk   = %.4f\n", yk_1));

        sb.append("\nTest 2: Estimated Proxy Size vs Actual Development Time\n");
        sb.append(String.format("B0   = %.4f\n", b0_2));
        sb.append(String.format("B1   = %.4f\n", b1_2));
        sb.append(String.format("rxy  = %.4f\n", rxy_2));
        sb.append(String.format("r^2  = %.4f\n", r2_2));
        sb.append(String.format("yk   = %.4f\n", yk_2));

        sb.append("\nTest 3: Plan Added & Modified vs Actual Added & Modified Size\n");
        sb.append(String.format("B0   = %.4f\n", b0_3));
        sb.append(String.format("B1   = %.4f\n", b1_3));
        sb.append(String.format("rxy  = %.4f\n", rxy_3));
        sb.append(String.format("r^2  = %.4f\n", r2_3));
        sb.append(String.format("yk   = %.4f\n", yk_3));

        sb.append("\nTest 4: Plan Added & Modified vs Actual Development Time\n");
        sb.append(String.format("B0   = %.4f\n", b0_4));
        sb.append(String.format("B1   = %.4f\n", b1_4));
        sb.append(String.format("rxy  = %.4f\n", rxy_4));
        sb.append(String.format("r^2  = %.4f\n", r2_4));
        sb.append(String.format("yk   = %.4f\n", yk_4));

        // Enviar salida a consola y/o archivo
        output.writeData(outFile, sb.toString());
    }
}
