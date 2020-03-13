public class ColaSinLista<T>
{
    private Nodo<T> first;
    public ColaSinLista(){
        first = null;
    }
    public boolean isEmpty(){
        if (first==null){
            return true;
        }
        return false;
    }
    public T peek() {   // devuelve el primero
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        return first.getElemento();
    }
    public void enqueue(T elemento){    // inserta al último
        if (isEmpty()){
            first = new Nodo<>(elemento);
        }else{
            Nodo<T> temp = first;
            while(temp.getSiguiente()!=null){
                temp = temp.getSiguiente();
            }   // llega al último
            temp.setSiguiente(new Nodo<>(elemento));
        }
    }

    public T dequeue() {    // devuelve el primero y lo quita de la fila
        if (isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        T result = first.getElemento();
        first = first.getSiguiente();
        return result;
    }

    @Override
    public String toString() {
        if (isEmpty()){
            return "Queue is empty.";
        }
        String cadena = "[" + first.getElemento().toString();
        Nodo<T> temp = first;
        while(temp.getSiguiente()!=null){
            temp = temp.getSiguiente();
            cadena = cadena + " > " + temp.getElemento().toString();
        }
        cadena = cadena + "]";
        return cadena;
    }

}
