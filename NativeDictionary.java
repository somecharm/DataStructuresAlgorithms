import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;
    int step;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        step = 3;
    }

    public int hashFun(String key) {
        // всегда возвращает корректный индекс слота
        return key.getBytes().length % size;
    }

    public boolean isKey(String key) {
        // возвращает true если ключ имеется,
        // иначе false
        return get(key) != null;
    }

    public void put(String key, T value) {
        // гарантированно записываем
        // значение value по ключу key
        int slot = hashFun(key);
        for (int i = 0; i < size; i++) {
            if (slots[slot] == null || slots[slot].equals(key)) {
                slots[slot] = key;
                values[slot] = value;
                return;
            }
            slot = slot + step;
            if (slot >= size) {
                slot = slot - size;
            }
        }
    }

    public T get(String key) {
        // возвращает value для key,
        // или null если ключ не найден
        int slot = hashFun(key);

        for (int i = 0; i < size; i++) {
            if (slots[slot] == null) {
                return null;
            } else if (slots[slot].equals(key)) {
                return values[slot];
            }
            slot = slot + step;
            if (slot >= size) {
                slot = slot - size;
            }
        }
        return null;
    }

}