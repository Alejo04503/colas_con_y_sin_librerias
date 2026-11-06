import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;
import java.util.PriorityQueue;

public class colaslibreria {
    public static void main(String[] args) {
        System.out.println("Ejercicios Colas con librerias de JAVA\n");
        Colasimple(); 
        ColasCircular();
        ColasPrioridad();
        ColaDoble();
        }
    
    static void Colasimple() {
        System.out.println("Ejercicios colas simple: primero en entrar primero en salir (FIFO)\n");
        Queue<String> java = new ArrayDeque<>();
        java.offer("ANA"); 
        java.offer("VIVIANA");
        java.offer("MARIA");
        System.out.println("Java: " + java.poll() + ", "+ java.poll() + "\n");
    }
    static void ColasCircular() {
        System.out.println("Ejercicios colas circular: reutiliza los espacios del arreglo \n");
        Queue<String> java = new ArrayDeque<>();
        java.offer("ANA"); 
        java.offer("VIVIANA");
        java.offer("MARIA");
        System.out.println("SALE: " + java.poll()); 
        java.offer("FABIOLA");
        System.out.println("java: " + java.poll() + ", "+ java.poll() + java.poll() + "\n");
    }
    static void ColasPrioridad() {
        System.out.println("Ejercicios colas de prioridad: los elementos se ordenan según su prioridad \n");
        Queue<Integer> java = new PriorityQueue<>();
        java.offer(3); 
        java.offer(1);
        java.offer(2);
        System.out.println("java: " + java.poll() + ", "+ java.poll() +", " + java.poll() + "\n");
    }
    static void ColaDoble() {
        System.out.println("ColaDoble (DEQUE): permite usar ambos extremos \n");
        Deque<String> java = new ArrayDeque<>();
        java.offerLast("ANA"); 
        java.offerLast("VIVIANA");
        java.offerFirst("MARIA");
        System.out.println("java: sale del inicio " + java.pollFirst() + ", sale del final "+ java.pollLast());
    }

}