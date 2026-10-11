
package linkedlist;

public class LinkedList {

    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.insert(10, 0);
        lista.insert(20, 1);
        lista.insert(30, 2);
        
        System.out.println("Lista: " +lista.size());
        for(int i = 0; i < lista.size(); i++){
            System.out.println("Elemento "+i+ ": "+lista.get(i));
        }
        
        lista.invertir();
        System.out.println("Invertir:");
        for(int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        
        lista.irInicio();
        System.out.println("Iterador inicio: "+ lista.getActual());
        lista.irFinal();
        System.out.println("Iterador final: "+ lista.getActual());
        lista.anterior();
        System.out.println("Iterador anterior: "+ lista.getActual());
        
        ListaEnlazada<String> palabras = new ListaEnlazada<>();
        palabras.insert("hola", 0);
        palabras.insert("ola", 1);
        palabras.insert("bola", 2);
        
        System.out.println("Lista: " +palabras.size());
        for(int i = 0; i < palabras.size(); i++) {
            System.out.println("Elemento "+i+": "+palabras.get(i));
        }
        palabras.invertir();
        System.out.println("Invertir:");
        for(int i = 0; i < palabras.size(); i++) {
            System.out.println(palabras.get(i));
        }
    }
    
}
