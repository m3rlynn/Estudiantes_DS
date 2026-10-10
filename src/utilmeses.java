import java.text.Normalizer;

public class utilmeses {
    private static final String[] meses = {
        "enero", "febrero", "marzo", "abril", "mayo", "junio",
        "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
    };

    // devuelve el numero del mes (1 a 12) o -1 si no es valido
    // acepta nombre del mes (con o sin tilde) o el numero como texto
    public static int anumero(String mes) {
        if (mes == null) {
            return -1;
        }
        String limpio = Normalizer.normalize(mes.trim().toLowerCase(), Normalizer.Form.NFD);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < limpio.length(); i++) {
            char c = limpio.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        limpio = sb.toString();
        if (limpio.length() == 0) {
            return -1;
        }
        if (limpio.charAt(0) >= '0' && limpio.charAt(0) <= '9') {
            try {
                int n = Integer.parseInt(limpio);
                return (n >= 1 && n <= 12) ? n : -1;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equals(limpio)) {
                return i + 1;
            }
        }
        return -1;
    }
}
