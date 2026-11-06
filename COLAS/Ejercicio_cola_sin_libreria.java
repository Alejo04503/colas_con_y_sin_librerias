
public class Ejercicio_cola_sin_libreria {

    public static void main(String[] args) {
        System.out.println("bienvenido, ejercicio de cola sin libreria");
        simple();
        circular();
        prioridad();
        doble();
    }

    static void simple() {
        System.out.println("1. cola simple: primero en llegar, primero en salir");
        encolarsimple("ana");
        encolarsimple("luis");
        encolarsimple("marta");
        System.out.println("sale: " + desencolarsimple());
        System.out.println("sale: " + desencolarsimple());
    }

    static void circular() {
        System.out.println("2. cola circular");
        encolarcircular("a");
        encolarcircular("b");
        encolarcircular("c");
        System.out.println("sale: " + desencolarcircular());
        encolarcircular("d"); // reutiliza el espacio liberado
        System.out.println("sale: " + desencolarcircular());
    }

    static void prioridad() {
        System.out.println("3. cola de prioridad (menor numero = mayor prioridad)");
        encolarprioridad(4);
        encolarprioridad(1);
        encolarprioridad(3);
        System.out.println("sale: " + desencolarprioridad());
        System.out.println("sale: " + desencolarprioridad());
    }

    static void doble() {
        System.out.println("4. cola doble");
        // reutiliza datossimple: agregarinicio y retirarfinal
        encolarsimple("x");
        agregarinicio("y");
        System.out.println("sale por el final: " + retirarfinalsimple());
    }

    // ---------- SIMPLE ----------
    private static final String[] datossimple = new String[5];
    private static int cantidadsimple = 0;

    static void encolarsimple(String nombre) {
        if (cantidadsimple == datossimple.length) throw new IllegalStateException("cola llena");
        datossimple[cantidadsimple++] = nombre;
    }

    static String desencolarsimple() {
        if (cantidadsimple == 0) return null;
        String primero = datossimple[0];
        for (int i = 0; i < cantidadsimple - 1; i++) datossimple[i] = datossimple[i + 1];
        datossimple[--cantidadsimple] = null;
        return primero;
    }

    static void agregarinicio(String nombre) {
        if (cantidadsimple == datossimple.length) throw new IllegalStateException("cola llena");
        for (int i = cantidadsimple; i > 0; i--) datossimple[i] = datossimple[i - 1];
        datossimple[0] = nombre;
        cantidadsimple++;
    }

    static String retirarfinalsimple() {
        if (cantidadsimple == 0) return null;
        String ultimo = datossimple[--cantidadsimple];
        datossimple[cantidadsimple] = null;
        return ultimo;
    }

    // ---------- CIRCULAR ----------
    private static final String[] datoscircular = new String[3];
    private static int frentecircular = 0;
    private static int fincircular = 0;
    private static int cantidadcircular = 0;

    static void encolarcircular(String nombre) {
        if (cantidadcircular == datoscircular.length) throw new IllegalStateException("cola llena");
        datoscircular[fincircular] = nombre;
        fincircular = (fincircular + 1) % datoscircular.length;
        cantidadcircular++;
    } // <- esta llave te faltaba

    static String desencolarcircular() {
        if (cantidadcircular == 0) return null;
        String primero = datoscircular[frentecircular];
        datoscircular[frentecircular] = null;
        frentecircular = (frentecircular + 1) % datoscircular.length;
        cantidadcircular--;
        return primero;
    }

    // ---------- PRIORIDAD ----------
    private static final Integer[] datosprioridad = new Integer[5];
    private static int cantidadprioridad = 0;

    static void encolarprioridad(int prioridad) {
        if (cantidadprioridad == datosprioridad.length) throw new IllegalStateException("cola llena");
        datosprioridad[cantidadprioridad++] = prioridad;
    }

    static Integer desencolarprioridad() {
        if (cantidadprioridad == 0) return null;
        int mejor = 0;
        for (int i = 1; i < cantidadprioridad; i++) {
            if (datosprioridad[i] < datosprioridad[mejor]) mejor = i;
        }
        Integer resultado = datosprioridad[mejor];
        for (int i = mejor; i < cantidadprioridad - 1; i++) datosprioridad[i] = datosprioridad[i + 1];
        datosprioridad[--cantidadprioridad] = null;
        return resultado;
    }
} 

