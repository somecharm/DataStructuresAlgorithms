class aBST {
    public Integer[] Tree; // массив ключей

    public aBST(int depth) {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = (int) (Math.pow(2, depth + 1) - 1);
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key) {
        // ищем в массиве индекс ключа
        Integer index = searchIndex(0, key);
        return index;
    }

    Integer searchIndex(int index, int key) {
        if (index >= Tree.length) {
            return null;
        }
        if (Tree[index] == null) {
            return -index;
        }
        if (Tree[index] == key) {
            return index;
        }
        if (key < Tree[index]) {
            return searchIndex(2 * index + 1, key);
        }
        if (key > Tree[index]) {
            return searchIndex(2 * index + 2, key);
        }
        return null;
    }

    public int AddKey(int key) {
        // добавляем ключ в массив
        Integer index = FindKeyIndex(key);
        if (index == null) {
            return -1;
        }
        if (index <= 0) {
            Tree[-index] = key;
            return -index;
        }
        return index;
        // индекс добавленного/существующего ключа или -1 если не удалось
    }

}