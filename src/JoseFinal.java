import java.io.*;
import java.util.*;
//JOSE MANUEL MEJIA CORREDOR
public class JoseFinal {
    public static void main(String[] args) throws IOException {

        String[] dias = { "lunes.txt", "martes.txt", "miercoles.txt", "jueves.txt", "viernes.txt" };
        HashMap<String, ArrayList<String[]>> datosSemana = new HashMap<>();

        for (String dia : dias) {
            BufferedReader reader = new BufferedReader(new FileReader(dia));
            ArrayList<String[]> datosDia = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                datosDia.add(line.split(";"));
            }
            datosSemana.put(dia, datosDia);
            reader.close();
        }

        Scanner leer = new Scanner(System.in);
        while (true) {
            System.out.println("1. Día de la semana cuando mayor cantidad de dinero se movió");
            System.out.println("2. Hora del día en que más cantidad de dinero se mueve en promedio");
            System.out.println("3. Transacción a través ID");
            System.out.println("4. Los datos n de X día");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int option = leer.nextInt();

            if (option == 5) {
                break;
            }

            switch (option) {
                case 1:
                    String maximoDia = "";
                    int monto = 0;
                    for (String dia : datosSemana.keySet()) {
                        int totalmonto = 0;
                        for (String[] transaccion : datosSemana.get(dia)) {
                            totalmonto += Integer.parseInt(transaccion[1]);
                        }
                        if (totalmonto > monto) {
                            monto = totalmonto;
                            maximoDia = dia;
                        }
                    }

                    System.out.println("día de la semana en que mayor cantidad de dinero se manejo: " + maximoDia);
                    break;
                case 2:
                    int[] horas = new int[24];
                    for (String dia : datosSemana.keySet()) {
                        for (String[] transaccion : datosSemana.get(dia)) {
                            horas[Integer.parseInt(transaccion[4])] += Integer.parseInt(transaccion[1]);
                        }
                    }
                    int maxHora = 0;
                    for (int i = 0; i < 24; i++) {
                        if (horas[i] > horas[maxHora]) {
                            maxHora = i;
                        }
                    }
                    System.out.println(
                            "hora del día en que más cantidad de dinero se mueve en promedio de los siete días: "
                                    + maxHora);
                    break;
                case 3:
                    System.out.print("id de la transacción: ");
                    String id = leer.next();
                    for (String dia : datosSemana.keySet()) {
                        for (String[] transaccion : datosSemana.get(dia)) {
                            if (transaccion[0].equals(id)) {
                                System.out.println("id transacción: " + transaccion[0]);
                                System.out.println("cantidad de dinero enviado: " + transaccion[1]);
                                System.out.println("tipo emisor: " + transaccion[2]);
                                System.out.println("tipo receptor: " + transaccion[3]);
                                System.out.println("hora de la transacción: " + transaccion[4]);
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.print("ingresa el día: ");
                    String dia = leer.next();
                    System.out.print("Ingrese el número de transacciones a visualizar: ");
                    int n = leer.nextInt();
                    for (int i = 0; i < n; i++) {
                        String[] transaccion = datosSemana.get(dia).get(i);
                        System.out.println("id transacción: " + transaccion[0]);
                        System.out.println("cantidad de dinero enviado: " + transaccion[1]);
                        System.out.println("tipo de emisor: " + transaccion[2]);
                        System.out.println("tipo de receptor: " + transaccion[3]);
                        System.out.println("hora de la transacción: " + transaccion[4]);
                    }
                    break;
                default:
                    System.out.println("no es válida.");
            }
        }
        leer.close();
    }
}
