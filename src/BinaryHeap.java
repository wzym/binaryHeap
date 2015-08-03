
public class BinaryHeap<K extends Comparable<K>, T> implements PriorityQueue<K, T> {
    private int size = 0;
    private int height = 3;
    private HeapElement[] body = new HeapElement[getBodySize(height)];

    @Override
    public T getMax() {
        if (isEmpty()) return null;
        @SuppressWarnings("unchecked")
        T result = (T) body[0].getMainPart();
        body[0] = body[size - 1];
        --size;
        if (size > 1) {
            setElementDown(0);
        }
        return result;
    }

    private void setElementDown(int indexOfElementToFall) {

    }

    @Override
    public void insert(K index, T element) {
        body[size] = new HeapElement<K, T>(index, element);
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