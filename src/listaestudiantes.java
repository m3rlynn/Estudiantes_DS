import java.util.ArrayList;

public class listaestudiantes {
    private nodo cabeza;
    private int tamanio;

    public listaestudiantes() {
        cabeza = null;
        tamanio = 0;
    }

    public int tamanio() {
        return tamanio;
    }

    public boolean estavacia() {
        return cabeza == null;
    }

    // inserta al final de la lista
    public void insertar(estudiante e) {
        if (e == null) {
            throw new IllegalArgumentException("estudiante nulo");
        }
        nodo nuevo = new nodo(e);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            nodo aux = cabeza;
            while (aux.getsiguiente() != null) {
                aux = aux.getsiguiente();
            }
            aux.setsiguiente(nuevo);
        }
        tamanio++;
    }

    // a) nombres de los estudiantes que cumplen anios en el mes dado
    public ArrayList<String> cumpleanos(String mes) {
        ArrayList<String> resultado = new ArrayList<>();
        int numero = utilmeses.anumero(mes);
        if (numero == -1) {
            return resultado;
        }
        nodo aux = cabeza;
        while (aux != null) {
            if (aux.getdato().mesnacimiento() == numero) {
                resultado.add(aux.getdato().nombrecompleto());
            }
            aux = aux.getsiguiente();
        }
        return resultado;
    }

    // b) estudiantes militantes de la ujc ordenados por anio de menor a mayor
    public ArrayList<estudiante> cantmilitantes() {
        ArrayList<estudiante> resultado = new ArrayList<>();
        nodo aux = cabeza;
        while (aux != null) {
            if (aux.getdato().esmilitante()) {
                resultado.add(aux.getdato());
            }
            aux = aux.getsiguiente();
        }
        // ordenamiento por insercion (estable)
        for (int i = 1; i < resultado.size(); i++) {
            estudiante clave = resultado.get(i);
            int j = i - 1;
            while (j >= 0 && resultado.get(j).getanio() > clave.getanio()) {
                resultado.set(j + 1, resultado.get(j));
                j--;
            }
            resultado.set(j + 1, clave);
        }
        return resultado;
    }

    // c) cantidad de estudiantes becados
    public int cantbecados() {
        int cantidad = 0;
        nodo aux = cabeza;
        while (aux != null) {
            if (aux.getdato().esbecado()) {
                cantidad++;
            }
            aux = aux.getsiguiente();
        }
        return cantidad;
    }
}
