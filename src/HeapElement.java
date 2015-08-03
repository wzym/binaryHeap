
public class HeapElement<K extends Comparable<K>, T> {
    private K indexPart;
    private T mainPart;

    public HeapElement(K indexPart, T mainPart) {
        this.indexPart = indexPart;
        this.mainPart = mainPart;
    }

    public K getIndexPart() {
        return indexPart;
    }

    public T getMainPart() {
        return mainPart;
    }
}