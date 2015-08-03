
public class BinaryHeap<K extends Comparable<K>, T> implements PriorityQueue<K, T> {
    private int size = 0;
    private int height = 3;
    private HeapElement[] body = new HeapElement[getBodySize(height)];

    @Override
    public T getMax() {
        return null;
    }

    @Override
    public void insert(K index, T element) {
        body[size] = new HeapElement(index, element);
        setElementUp(size);
        ++size;
        if (size == body.length) {
            changeBodySize(height + 1);
        }
    }

    private void changeBodySize(int neededHeight) {

    }

    private void setElementUp(int indexOfCurrentPlace) {

    }

    private int getBodySize(int neededHeight) {
        return (int) (Math.pow(2, neededHeight + 1) - 1);
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}