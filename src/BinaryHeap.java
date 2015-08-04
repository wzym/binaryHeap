
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

    @Override
    public void insert(K index, T element) {
        body[size] = new HeapElement<>(index, element);
        setElementUp(size);
        ++size;
        if (size == body.length - 1) {
            changeBodySize(++height);
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    private void setElementDown(int indexOfElementToFall) {
        int currentIndex = indexOfElementToFall;
        int maxChildIndex = getBiggestChildIndex(indexOfElementToFall);
        while (maxChildIndex >= 0 && body[currentIndex].getIndexPart().compareTo(body[maxChildIndex].getIndexPart()) <= 0) {
            moveElement(currentIndex, maxChildIndex);
            currentIndex = maxChildIndex;
            maxChildIndex = getBiggestChildIndex(maxChildIndex);
        }
    }

    private void setElementUp(int indexOfCurrentPlace) {
        int currentIndex = indexOfCurrentPlace;
        int indexOfCurrentParent = getParentIndex(indexOfCurrentPlace);
        while (currentIndex > 0 && body[currentIndex].getIndexPart().compareTo(body[indexOfCurrentParent].getIndexPart()) >= 0) {
            moveElement(currentIndex, indexOfCurrentParent);
            currentIndex = indexOfCurrentParent;
            indexOfCurrentParent = getParentIndex(indexOfCurrentParent);
        }
    }

    private int getParentIndex(int elementIndex) {
        return (elementIndex - 1) / 2;
    }

    private void moveElement(int statrIndex, int fifnshIndex) {
        HeapElement tempElement = body[statrIndex];
        body[statrIndex] = body[fifnshIndex];
        body[fifnshIndex] = tempElement;
    }

    private int getBiggestChildIndex(int parentIndex) {
        int leftChildIndex = getLeftChildIndex(parentIndex);
        int rightChildIndex = getRightChildIndex(parentIndex);
        @SuppressWarnings("unchecked")
        HeapElement<K, T> leftChild = (leftChildIndex < size) ? (body[leftChildIndex]) : null;
        @SuppressWarnings("unchecked")
        HeapElement<K, T> rightChild = (rightChildIndex < size) ? (body[rightChildIndex]) : null;
        if (leftChild == null & rightChild != null) return rightChildIndex;
        if (rightChild == null & leftChild != null) return leftChildIndex;
        if (leftChild == null & rightChild == null) return -1;
        K leftIndex = leftChild.getIndexPart();
        K rightIndex = rightChild.getIndexPart();
        return (leftIndex.compareTo(rightIndex) >= 0) ? (leftChildIndex) : (rightChildIndex);
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private void changeBodySize(int neededHeight) {
        int newBodySize = getBodySize(neededHeight);
        HeapElement[] bufferedBody = new HeapElement[newBodySize];
        System.arraycopy(body, 0, bufferedBody, 0, body.length);
        body = bufferedBody;
    }

    private int getBodySize(int neededHeight) {
        return (int) (Math.pow(2, neededHeight + 1) - 1);
    }
}