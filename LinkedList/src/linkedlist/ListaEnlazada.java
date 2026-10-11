
package linkedlist;

public class ListaEnlazada<T> implements IList<T>, Iterable<T> {
protected NodoSimple<T> inicio;
protected int nElementos;
private NodoSimple<T> actualIterador;
    
    public ListaEnlazada() {
        inicio = null;
        nElementos = 0;
    }
    
    private class NodoSimple<T>{
        private T dato;
        private NodoSimple<T> sig;
        
        public NodoSimple(T dato) {
            this.dato = dato;
        }
    }
    
    
    
    @Override
    public void append(T elemento) throws ListException {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
        
        if(inicio == null) {
            inicio = nodoNuevo;
            nodoNuevo.sig = inicio;
        }else{
            NodoSimple<T> nodo = inicio;
            while(nodo.sig != null){
                nodo = nodo.sig;
            }
            nodo.sig = nodoNuevo;
            nodoNuevo.sig = inicio;
        }
        nElementos++;
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        if(index < 0 || index > nElementos) {
            throw new ListException("Indice fuera de rango");
        }
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
        if(index == 0) {
            if(inicio == null) {
                inicio = nodoNuevo;
                nodoNuevo.sig = inicio;
            } else {
                NodoSimple<T> ultimo = inicio;
                while(ultimo.sig != inicio) {
                    ultimo = ultimo.sig;
                }
                nodoNuevo.sig = inicio;
                inicio = nodoNuevo;
                ultimo.sig = inicio;
            }
        } else {
            NodoSimple<T> actual = inicio;
            for(int i = 0; i < index - 1; i++) {
                actual = actual.sig;
            }
            nodoNuevo.sig = actual.sig;
            actual.sig = nodoNuevo;
        }
        nElementos++;
    }

    @Override
    public T remove(int index) throws ListException {
        if(index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de rango");
        }
        NodoSimple<T> eliminado;
        if(index == 0) {
            eliminado = inicio;
            NodoSimple<T> ultimo = inicio;
            while(ultimo.sig != inicio) {
                ultimo = ultimo.sig;
            }
        } else {
            NodoSimple<T> actual = inicio;
            for(int i = 0; i < index - 1; i++) {
                actual = actual.sig;
            }
            eliminado= actual.sig;
            actual.sig = eliminado.sig;
        }
        nElementos--;
        return eliminado.dato;
    }

    @Override
    public boolean removeObj(T elemento) throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T get(int index) throws ListException {
        if(index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de rango");
        }
        NodoSimple<T> actual = inicio;
        for(int i = 0; i < index; i++) {
            actual = actual.sig;
        }
        return actual.dato;
    }

    @Override
    public void set(T elemento, int index) throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        inicio = null;
        nElementos = 0;
    }

    @Override
    public boolean empty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public java.util.Iterator<T> Iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public java.util.Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void invertir() {
        NodoSimple<T> previo = null;
        NodoSimple<T> actual = inicio;
        NodoSimple<T> siguiente;
        NodoSimple<T> ultimo = inicio;
        while(ultimo.sig != inicio) {
            ultimo = ultimo.sig;
        }
        while(actual != null) {
            siguiente = actual.sig;
            actual.sig = previo;
            previo = actual;
            if(siguiente == inicio) break;
            actual = siguiente;
        }
        inicio.sig = previo;
        inicio = previo;
    }
    
    public void concatenar(ListaEnlazada<T> otraLista) {
        if(otraLista.inicio == null) return;
        if(inicio == null) {
            inicio = otraLista.inicio;
        } else {
            NodoSimple<T> actual = inicio;
            while(actual.sig != null) {
                actual = actual.sig;
            }
            actual.sig = otraLista.inicio;
            NodoSimple<T> ultimoOtra = otraLista.inicio;
            while(ultimoOtra.sig != otraLista.inicio) {
                ultimoOtra = ultimoOtra.sig;
            }
            ultimoOtra.sig = inicio;
        }
        nElementos += otraLista.nElementos;
    }
    public void irInicio() {
        actualIterador = inicio;
    }
    
    public void irFinal() {
        if(inicio == null) return;
        NodoSimple<T> ultimo = inicio;
        while(ultimo.sig != inicio) {
            ultimo = ultimo.sig;
        }
        actualIterador = ultimo;
    }
    
    public void anterior() {
        if(actualIterador == null) return;
        NodoSimple<T> previo = inicio;
        while(previo.sig != actualIterador) {
            previo = previo.sig;
        }
        actualIterador = previo;
    }
    
    public T getActual() {
        if(actualIterador == null) throw new ListException("Iterador no inicializado");
        return actualIterador.dato;
    }
}
