public class PilaSinLista<T>
{
    // usando Nodos únicamente.
    private Nodo<T> bottom;

    public PilaSinLista(){
        bottom = null;
    }

    public boolean isEmpty(){
        if (bottom==null){
            return true;
        }
        return false;
    }

    public T peek() {
        if (isEmpty()){
            return null;
        }else {
            Nodo<T> temp = bottom;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            return temp.getElemento();
        }
    }
    public T pop(){         // obtener el último, eliminarlo y luego regresarlo.
        if (isEmpty()){
            System.out.println("Nothing to pop");
            return null; // caso 1: está vacía
        }else {
            Nodo<T> nodoActual = bottom;
            if(nodoActual.getSiguiente() == null){
                // colección es de tamaño 1, quitamos el único elemento
                T popped = nodoActual.getElemento();
                this.bottom = null;
                return popped;  // caso 2: hay un solo elemento. Quitamos y regresamos ese.
            }
            while(nodoActual.getSiguiente().getSiguiente()!=null){  //mientras existan dos adelante
                nodoActual = nodoActual.getSiguiente();
            }   // al final estamos en el penúltimo elemento
            T popped = nodoActual.getSiguiente().getElemento();        // se sabe que el siguiente NO es null
            nodoActual.setSiguiente(null);
            return popped;
            /* Nodo<T> temp = bottom;
            bottom = null;
            return temp.getElemento();
            * */
        }
    }
    public void push(T elemento){
        if (isEmpty()){
            this.bottom = new Nodo<>(elemento);
        }else{
            Nodo<T> temp = bottom;
            while(temp.getSiguiente()!=null){
                temp = temp.getSiguiente();         // al final llegamos al úlltimo nodo, cuyo siguiente es null
            }
            temp.setSiguiente(new Nodo<>(elemento));
        }
    }

    @Override
    public String toString() {
        if (isEmpty()){
            return "Stack is empty.";
        }
        String cadena = "[" + bottom.getElemento().toString();
        Nodo<T> temp = bottom;
        while(temp.getSiguiente()!=null){
            temp = temp.getSiguiente();
            cadena = cadena + " > " + temp.getElemento().toString();
        }
        cadena = cadena + "]";
        return cadena;
    }
}
