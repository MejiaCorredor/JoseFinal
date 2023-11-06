import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
//import java.util.Scanner

public class JoseFinal {

    public class transacciones {

        int id;
        int monto;
        int tipoE;
        int tipoR;
        int hora;

    }

    public static String[][] Dias(String fileN) {

        String[][] resultados = new String[100][5];

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File("jueves.txt", "domingo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                for (int j = 0; j < 100; j++) {
                    String[] split = linea.split(";");
                    resultados[j] = split;
                    linea = br.readLine();
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al leer el archivo");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return resultados;

    }

    public static void main(String[] args) {

        HashMap<String, List<String>> mapa = new HashMap<>();

        List<String> size = new ArrayList<>();
        size.add("id");
        size.add("monto");
        size.add("tipoE");
        size.add("tipoR");
        size.add("hora");


        mapa.size(); // Tamaño del mapa

        for (String element : mapa.keySet()) {

            System.out.println(element + " sacó " + mapa.get(element));
        }
    }
}
