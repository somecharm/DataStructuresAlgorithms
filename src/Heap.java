class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи
    private int HeapSize;

    public Heap() {
        HeapArray = null;
        HeapSize = 0;
    }

    public void MakeHeap(int[] a, int depth) {
        // создаём массив кучи HeapArray из заданного
        // размер массива выбираем на основе глубины depth
        int size = (int) (Math.pow(2, depth + 1) - 1);
        HeapArray = new int[size];
        for (int key : a) {
            Add(key);
        }
    }

    public int GetMax() {
        // вернуть значение корня и перестроить кучу
        if (HeapArray[0] == 0)
            return -1; // если куча пуста
        int i = HeapSize - 1;
        int root = HeapArray[0];
        HeapArray[0] = HeapArray[i];
        HeapArray[i] = 0;
        i = 0;
        while (true) {
            int max = i;
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (left < HeapSize && HeapArray[max] < HeapArray[left]) max = left;
            if (right < HeapSize && HeapArray[max] < HeapArray[right]) max = right;
            if (max == i) break;
            Swap(i, max);
            i = max;
        }
        HeapSize--;
        return root;
    }

    public boolean Add(int key) {
        // добавляем новый элемент key в кучу и перестраиваем её
        if (HeapSize == HeapArray.length) {
            return false; // если куча вся заполнена
        }
        int i = HeapSize;
        HeapArray[i] = key;

        while (key > HeapArray[(i - 1) / 2]) {
            Swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
        HeapSize++;
        return true;
    }

    void Swap(int a, int b) {
        int temp = HeapArray[a];
        HeapArray[a] = HeapArray[b];
        HeapArray[b] = temp;
    }
}