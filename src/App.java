import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class App {


    public class transacciones{


        int id ;
        int monto ;
        int tipoE ;
        int tipoR ;
        int hora ;
        String ciudad;


    }
    public static void main(String[] args) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        String path = getPath();

        try {
        
            archivo = new File ("lunes.txt" , "martes.txt", "miercoles.txt" , "jueves.txt" , "viernes.txt" , "sabado.txt" , "domingo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null){
                System.out.println(linea);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al leer el archivo");
        } finally{
            try {
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        String[] tipoE = {"natural" , "juridica" , "ONG"};

        String[] tipoR = {"natural" , "juridica" , "ONG"};


        HashMap<String, String> billetera = new HashMap<String, String>();

        billetera.put("");
        
        

        billetera.put("");
        System.out.println(billetera);
    }
    private static String getPath() {
        return null;
    }
}
