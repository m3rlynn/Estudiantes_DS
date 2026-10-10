public class nodo {
    private estudiante dato;
    private nodo siguiente;

    public nodo(estudiante dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public estudiante getdato() {
        return dato;
    }

    public nodo getsiguiente() {
        return siguiente;
    }

    public void setsiguiente(nodo siguiente) {
        this.siguiente = siguiente;
    }
}
