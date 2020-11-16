package demo.adt;

import java.util.Iterator;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月13日 14:57
 */
public class LinkedListArray<T> implements Iterable<T> {

    private static final int DEFAULT_SIZE = 8;
    private int NODE_SIZE;

    private long size;
    private ArrayNode<T> head;
    private ArrayNode<T> tail;

    public LinkedListArray() {
        this(DEFAULT_SIZE);
    }
    public LinkedListArray(int size) {
        NODE_SIZE = size;
        ArrayNode<T> arrayNode = new ArrayNode<>(NODE_SIZE);
        size = 0;
    }

    public void add(T val) {
        long remainder = (size % NODE_SIZE);
        if (remainder == 0) {
            ArrayNode<T> node = new ArrayNode<>(NODE_SIZE);
            node.set(0, val);
            tail.setNext(node);
            tail = node;
        } else {
            tail.set((int) (remainder - 1), val);
        }
        size += 1;
    }

    public T get(long index) {
        if (index < 0)
            throw new ArrayIndexOutOfBoundsException("" + index);

        long nodeCount = (index + 1) / NODE_SIZE;
        long remainder = (index + 1) % NODE_SIZE;
        if (remainder == 0) {
            remainder = NODE_SIZE - 1;
            nodeCount -= 1;
            ArrayNode<T> targetNode;
        } else {

        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class ArrayNode<T> {
        private Object[] data;
        private ArrayNode<T> next;

        public ArrayNode(int size) {
            this.data = new Object[size];
        }

        public void set(int index, T val) {
            data[index] = val;
        }
        public T get(int index) {
            return (T) data[index];
        }

        public void setNext(ArrayNode<T> arrayNode) {
            this.next = arrayNode;
        }
    }
}
