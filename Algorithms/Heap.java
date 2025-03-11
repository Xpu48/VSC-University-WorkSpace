import java.util.ArrayList;
import java.util.List;

class Heap {
    // public for JUnit testing purposes
    public ArrayList<Integer> array;
    public int heap_size;

    public Heap(int size) {
        array = new ArrayList<>(size);
        heap_size = 0;
    }
    public Heap(List<Integer> source) {
        this(source, false);
    }
    public Heap(List<Integer> source, boolean incremental) {
        array = new ArrayList<>(source.size());
        heap_size = source.size();
        for (int i = 0; i < source.size(); i++) {
            array.add(source.get(i));
        }
        if (incremental) {
            initializeHeap();
        }
    }

    public static int parent(int index) {
        return 0;
    }
    public static int left(int index) {
        return 0;
    }
    public static int right(int index) {

        return 0;
    }
    
    public void maxHeapify(int i) {
        //max heap
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heap_size && array.get(l) > array.get(i)) {
            largest = l;
        }
        if (r < heap_size && array.get(r) > array.get(largest)) {
            largest = r;
        }
        if (largest != i) {
            int temp = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, temp);
            maxHeapify(largest);
        }
    }
    private void initializeHeap() {
        buildMaxHeap();
    }

    public void buildMaxHeap() {
        for (int i = heap_size / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }
    public void insert(Integer k) {
        heap_size++;
        array.add(Integer.MIN_VALUE);
        increaseKey(heap_size - 1, k);
    }

    public void increaseKey(int i, Integer key) {
        if (key < array.get(i)) {
            throw new IllegalArgumentException("New key is smaller than current key");
        }
        array.set(i, key);
        while (i > 0 && array.get(parent(i)) < array.get(i)) {
            int temp = array.get(i);
            array.set(i, array.get(parent(i)));
            array.set(parent(i), temp);
            i = parent(i);
        }
    }
    public Integer maximum() {
        return array.get(0);
    }
    public Integer extractMax() {
        return 0;
    }
}
