import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Diccionario {

    private Map<Character, Set<String>> palabrasPorInicial;

    public Diccionario() {
        palabrasPorInicial = new HashMap<>();
    } 
    public void añadirPalabra(String palabra) {
        palabra = Sanitizador.sanitizarPalabra(palabra);
        char inicial = palabra.charAt(0);
        palabrasPorInicial.putIfAbsent(inicial, new HashSet<>());
        palabrasPorInicial.get(inicial).add(palabra);
    }

    public boolean eliminarPalabra(String palabra) {
        palabra = Sanitizador.sanitizarPalabra(palabra);
        char inicial = palabra.charAt(0);
        Set<String> palabras = palabrasPorInicial.get(inicial);
        if (palabras != null && palabras.contains(palabra)) {
            palabras.remove(palabra);
            return true;
        }
        return false;
    }

    public boolean existePalabra(String palabra) {
        palabra = Sanitizador.sanitizarPalabra(palabra);
        char inicial = palabra.charAt(0);
        Set<String> palabras = palabrasPorInicial.get(inicial);
        return palabras != null && palabras.contains(palabra);
    }

    public Set<Character> getInicialesDisponibles() {
        return palabrasPorInicial.keySet();
    }

    public Set<String> getPalabrasPorInicial(char inicial) {
        return palabrasPorInicial.getOrDefault(inicial, new HashSet<>());
    }
}
