import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ej4 {


    public static void main(String[] args) throws IOException {
        ex4("Z:\\ACCESO A DATOS\\no se q hay q hacer\\untitled\\examenes");
    }


    public static void ex4(String ruta) throws IOException {

        String solucion = "TTTFFFTTTFTFTFTFTFTF";


        Path archivo = Paths.get(ruta);

        if (!Files.exists(archivo)) {
            System.out.println("No existe el archivo");
            System.exit(1);
        }

        List<String> lineas = Files.lines(archivo).toList();

        Map<String, String> mapa = new HashMap<>();

        for (String linea : lineas) {
            String clave = linea.split("-")[0];
            String valor = linea.split("-")[1];

            if (valor.length() != solucion.length()) {
                System.out.println("La clave " + clave + " tiene longitud incorrecta");
            } else {
                mapa.put(clave, valor);
            }
        }

        for (Map.Entry<String, String> entry : mapa.entrySet()) {
            String clave = entry.getKey();
            String valor = entry.getValue();

            double nota = corregir(solucion, valor);

            System.out.println(clave + "\t" + valor + "\t" + nota + "\t" +aCalificacion(nota));
        }

    }


    public static double corregir(String solucion, String resultados) {

        double resultado = 0;

        for (int i = 0; i < solucion.length(); i++) {
            if (solucion.charAt(i) == resultados.charAt(i)) {
                resultado += 0.5;
            } else if (resultados.charAt(i) == ' ') {
                resultado += 0;
            } else {
                resultado -= 0.15;
            }
        }

        if (resultado < 0) {
            resultado = 0;
        }
        return resultado;
    }

    public static String aCalificacion(double nota) {
        if (nota >= 0 && nota <= 4.99) {
            return "Suspenso";
        } else if (nota >= 5 && nota <= 5.99) {
            return "Aprobado";
        } else if (nota >= 6 && nota <= 6.99) {
            return "Bien";
        } else if (nota >= 7 && nota <= 8.49) {
            return "Notable";
        } else if (nota >= 8.5 && nota <= 10) {
            return "Sobresaliente";
        } else{
            System.err.println("La nota " + nota + " no esta dentro del rango de clasificacion");
        }
        return "";
    }
}
