import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ex5 {
    public static void main(String[] args) throws IOException {

        ex5("res/coches.txt");;


    }

    public static void ex5(String ruta) throws IOException {
        Map<String,String> coches = new HashMap<>();

        Path path = Paths.get(ruta);

        if (!Files.exists(path)) {
            System.out.println("No existe el archivo");
            System.exit(1);
        }

        // leemos archivo x lineas
        List<String> lines = Files.lines(path).toList();

        // recorremos la lista
        for (String line : lines) {
            // hacemos esto para que no haya espacios en blanco
            if (!line.isEmpty()) {

                String marca = line.split(" ")[0];
                String modelo =  line.substring(line.indexOf(" ")+1);
                // System.out.println(modelo);

                // si la marca NO esta registrada en el mapa de coches, la registramos con su modelo
                if (!coches.containsKey(marca)) {
                    coches.put(marca, modelo);
                } else {
                    // si está registrada, añadimos el modelo a la lista que es un string

                    coches.put(marca,coches.get(marca) + ", " + modelo);
                }
            }
        }

        // logica para escribir el fichero

        //inizializar string donde se recogen los datos del mapa
        String datosFinal = "";

        // recorremos el mapa añadiendo los datos al string
        for (Map.Entry<String, String> entry : coches.entrySet()) {
            String marca = entry.getKey();
            String modelos = entry.getValue();

            // x cada entrada del mapa escribimos los valores en datosFinal con saltos de linea
            datosFinal = datosFinal.concat(marca + ": " + modelos +"\n");
        }
        // finalmente escribimos el string a marcas.txt
        Files.writeString(Paths.get("res/marcas.txt"), datosFinal);

        // System.out.println(datosFinal);
    }
}
