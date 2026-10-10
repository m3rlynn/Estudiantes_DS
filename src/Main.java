import java.util.ArrayList;

public class Main {

    private static int fallos = 0;
    private static int total = 0;

    private static void comprobar(String descripcion, boolean ok) {
        total++;
        if (!ok) {
            fallos++;
        }
        System.out.println((ok ? "[ok]    " : "[fallo] ") + descripcion);
    }

    private static ArrayList<String> listade(String... valores) {
        ArrayList<String> r = new ArrayList<>();
        for (int i = 0; i < valores.length; i++) {
            r.add(valores[i]);
        }
        return r;
    }

    private static listaestudiantes datos() {
        listaestudiantes l = new listaestudiantes();
        // ci: aammdd + 5 digitos
        l.insertar(new estudiante("04051212345", "ana", "perez", 'f', 3, true, true));
        l.insertar(new estudiante("03120598765", "luis", "gomez", 'm', 1, false, true));
        l.insertar(new estudiante("04051111111", "maria", "diaz", 'f', 2, true, false));
        l.insertar(new estudiante("02082222222", "pedro", "lopez", 'm', 4, true, true));
        l.insertar(new estudiante("03120233333", "rosa", "ruiz", 'f', 1, true, false));
        l.insertar(new estudiante("04070744444", "juan", "mesa", 'm', 2, false, false));
        return l;
    }

    private static boolean todosmilitantes(ArrayList<estudiante> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).esmilitante()) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        listaestudiantes l = datos();
        listaestudiantes vacia = new listaestudiantes();

        System.out.println("--- cumpleanos ---");
        comprobar("mayo", l.cumpleanos("mayo").equals(listade("ana perez", "maria diaz")));
        comprobar("diciembre", l.cumpleanos("diciembre").equals(listade("luis gomez", "rosa ruiz")));
        comprobar("agosto", l.cumpleanos("agosto").equals(listade("pedro lopez")));
        comprobar("mes en mayusculas", l.cumpleanos("MAYO").equals(listade("ana perez", "maria diaz")));
        comprobar("mes sin estudiantes", l.cumpleanos("enero").isEmpty());
        comprobar("mes invalido", l.cumpleanos("xyz").isEmpty());
        comprobar("mes nulo", l.cumpleanos(null).isEmpty());
        comprobar("lista vacia", vacia.cumpleanos("mayo").isEmpty());

        System.out.println("--- cantmilitantes ---");
        ArrayList<estudiante> m = l.cantmilitantes();
        comprobar("cantidad de militantes", m.size() == 4);
        comprobar("orden por anio", m.get(0).getanio() == 1 && m.get(1).getanio() == 2
                && m.get(2).getanio() == 3 && m.get(3).getanio() == 4);
        comprobar("primero es rosa", m.get(0).getnombre().equals("rosa"));
        comprobar("todos militantes", todosmilitantes(m));
        comprobar("lista vacia", vacia.cantmilitantes().isEmpty());
        for (int i = 0; i < m.size(); i++) {
            System.out.println("    " + m.get(i).informacion());
        }

        System.out.println("--- cantbecados ---");
        comprobar("becados en la lista", l.cantbecados() == 3);
        comprobar("lista vacia", vacia.cantbecados() == 0);
        listaestudiantes sinbecados = new listaestudiantes();
        sinbecados.insertar(new estudiante("04051111111", "maria", "diaz", 'f', 2, true, false));
        comprobar("sin becados", sinbecados.cantbecados() == 0);

        System.out.println("--- validaciones ---");
        boolean lanzo = false;
        try {
            new estudiante("123", "x", "y", 'm', 1, false, false);
        } catch (IllegalArgumentException e) {
            lanzo = true;
        }
        comprobar("ci invalido lanza excepcion", lanzo);

        System.out.println();
        System.out.println("total: " + total + ", fallos: " + fallos);
        if (fallos > 0) {
            System.exit(1);
        }
    }
}
