package tienda;

import java.time.LocalDate;
import java.time.Period;

/**
 * La clase {@code Tienda} representa un establecimiento de comida y bebida
 * con un nombre predefinido, una dirección, una fecha de fundación y
 * un método estático que imprime un mensaje de bienvenida.
 * 
 * @author Alejandro M. González
 */
public class Tienda {
	
    private static final String NOMBRE = "Yum Snack Bar";
    private static final String DIRECCION = "Puerta del Sol, Km. 0, 28013 Madrid, España";
    private static final LocalDate FECHA_FUNDACION = LocalDate.of(1986, 1, 1);

    /**
     * Imprime un mensaje de bienvenida con cadenas formateadas que incluyen el nombre
     * la dirección y los años que el establecimiento lleva funcionando desde su fundación.
     */
    public static void imprimirBienvenida() {
        String decoracion = "+----------------------------------------------------------------+";
        LocalDate fechaPresente = LocalDate.now();
        int años = Period.between(FECHA_FUNDACION, fechaPresente).getYears();

        System.out.println(decoracion);
        System.out.printf("| Bienvenido/a al %-12s                                  |\n", NOMBRE);
        System.out.printf("| %-24s                    |\n", DIRECCION);
        System.out.printf("| Sirviendo palomitas, colesterol y alegría desde hace %-3d años. |\n", años);
        System.out.println(decoracion);
    }
    
    // Getters
    public static String getNombre() {
        return NOMBRE;
    }

    public static String getDireccion() {
        return DIRECCION;
    }

    public static LocalDate getFechaFundacion() {
        return FECHA_FUNDACION;
    }
}


