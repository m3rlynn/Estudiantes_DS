public class estudiante {
    private String ci;
    private String nombre;
    private String apellido;
    private char sexo;
    private int anio;
    private boolean militante;
    private boolean becado;

    public estudiante(String ci, String nombre, String apellido, char sexo,
                      int anio, boolean militante, boolean becado) {
        if (ci == null || ci.length() != 11) {
            throw new IllegalArgumentException("ci invalido");
        }
        for (int i = 0; i < ci.length(); i++) {
            if (ci.charAt(i) < '0' || ci.charAt(i) > '9') {
                throw new IllegalArgumentException("ci invalido");
            }
        }
        int mes = Integer.parseInt(ci.substring(2, 4));
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("ci invalido");
        }
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.anio = anio;
        this.militante = militante;
        this.becado = becado;
    }

    public String getci() {
        return ci;
    }

    public String getnombre() {
        return nombre;
    }

    public String getapellido() {
        return apellido;
    }

    public char getsexo() {
        return sexo;
    }

    public int getanio() {
        return anio;
    }

    public boolean esmilitante() {
        return militante;
    }

    public boolean esbecado() {
        return becado;
    }

    public String nombrecompleto() {
        return nombre + " " + apellido;
    }

    // el mes de nacimiento son los digitos 3 y 4 del ci
    public int mesnacimiento() {
        return Integer.parseInt(ci.substring(2, 4));
    }

    public String informacion() {
        return "ci: " + ci + ", nombre: " + nombre + ", apellido: " + apellido
                + ", sexo: " + sexo + ", anio: " + anio
                + ", militante: " + (militante ? "si" : "no")
                + ", becado: " + (becado ? "si" : "no");
    }
}
