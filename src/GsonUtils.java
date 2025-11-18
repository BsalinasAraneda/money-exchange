import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    // Constructor privado para evitar instanciación
    private GsonUtils() {
        //Nada que declarar en este punto
    }

    // Retorna la instancia configurada de Gson.
    public static Gson getGson(){
        return gson;
    }

    // Convierte un JSON en un objeto del tipo especificado.

    /***
     * @param json
     * @param clazz
     * @return
     * @param <T> // <T> es un parámetro de tipo genérico.Este metodo es genérico y puede trabajar con cualquier clase que me digas”
     * @param "T" // El tipo de retorno será el mismo tipo genérico.Ejemplo: si llamas a fromJson(..., Movie.class),
     * el retorno será de tipo Movie.
     * @param "Class" <T> clazz
     * Class <T> // Es el tipo genérico que usará el método. // Ese tipo NO está definido en la clase, sino cuando llamas al método.
     * clazz // Es una instancia de la clase Class<T>, no del objeto T // ES UNA INSTANCIA DE LA CLASE Class<T>
     */
    public static <T> T fromJson(String json, Class<T> clazz){
        return gson.fromJson(json, clazz);
    }

    // Convierte un objeto a su representación JSON.
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }
}