
package linkedlist;

import java.util.Iterator;

public interface IList<T> {
    public void append(T elemento) throws ListException; //agg elemnto
    public void insert(T elemento, int index) throws ListException; //agg elemnto y lo sobrepone en otro
    public T remove(int index) throws ListException; //quita elemnto / throw retira la orden si sale False
    public boolean removeObj(T elemento) throws ListException; 
    public int indexOf(T elemento);
    public T get(int index) throws ListException;
    public void set(T elemento, int index) throws ListException;
    public void clear();
    public boolean empty();
    public int size();
    public Iterator<T> Iterator();
}
