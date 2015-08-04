
public class HeapElement<K extends Comparable<K>, T> {
    private K comparablePart;
    private T mainPart;

    public HeapElement(K comparablePart, T mainPart) {
        this.comparablePart = comparablePart;
        this.mainPart = mainPart;
    }

    public K getComparablePart() {
        return comparablePart;
    }

    public T getMainPart() {
        return mainPart;
    }
}