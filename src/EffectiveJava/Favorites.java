package EffectiveJava;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rarshion on 16/11/9.
 */
public class Favorites {
    private Map<Class<?>, Object> favorites =
            new HashMap<Class<?>, Object>();


    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null)
            throw new NullPointerException("Type is null");
        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
