public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clazz) {
        this.clazz = clazz; // нужен для безопасного приведения типов
//        new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        if (array == null) {
            array = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
        } else if (new_capacity > capacity) {
            T[] newArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        capacity = new_capacity;
    }

    public T getItem(int index) {
        if (index < 0 && index > capacity) {
            throw new IndexOutOfBoundsException();
        } else {
            return array[index];
        }
    }

    public void append(T itm) {
        if (count < capacity) {
            array[count] = itm;
            count++;
            return;
        }
        makeArray(capacity * 2);
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        } else if (index == count) {
            append(itm);
            return;
        }
        if (count >= capacity) {
            makeArray(capacity * 2);
        }
        append(itm);
        for (int i = count - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = itm;
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;

        if (count < capacity / 2 && capacity > 16 * 1.5) {
            capacity = (int) (capacity / 1.5);
            makeArray(capacity);
        }
    }

}