package Heap;
import java.util.*;

public class MinIntHeap {
    private int capacity =10;
    private int size =0;
    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) { return 2*parentIndex +1;}
    private int getRightChildIndex(int parentIndex) {return 2*parentIndex +2;}
    private int getParentIndex(int childIndex) {return (childIndex-1)/2;}

    private boolean hasLeftChild(int index) {return getLeftChildIndex(index)<size;}
    private boolean hasRightChild(int index) {return getRightChildIndex(index)<size;}
    private boolean hasParent(int index) {return getParentIndex(index)<size;}    

    private int leftChild(int index) {return items[getLeftChildIndex(index)];}
    private int rightChild(int index) {return items[getRightChildIndex(index)];}
    private int parent(int index) {return items[getParentIndex(index)];}

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne]=items[indexTwo];
        items[indexTwo]=temp;
    }

    private void ensureExtraCapacity() {
        // when the capacity is full, expand the capacity to 2*capacity.
        if (size == capacity) {
            items=Arrays.copyOf(items,capacity*2);
            capacity *=2;
        }
    }

    public int peek(){
        if (size ==0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size==0) throw new IllegalStateException();
        int item = items[0];
        // 1.delete items[0]
        // 2.convert items[size-1] (last item) to items[0]
        items[0]=items[size-1];
        size--;
        //if the new items[0] is large than childs, move down.
        heapifyDown();
        return item;
    }
    public void add(int item) {
        ensureExtraCapacity();
        // add new item at the last position items[size]
        items[size] = item;
        size++;
        // compare the new item with its parent, if larger than parent item, then move up
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size-1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index),index);
            index=getParentIndex(index);
        }
    }
    
    public void heapifyDown() {
        int index = 0 ;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index)<leftChild(index)) {
                smallerChildIndex=getRightChildIndex(index);
            }
        }
        if (items[index] < items[smallerChildIndex]) {
            break;
        } else {
            swap(index,smallerChildIndex);
        }
        index = smallerChildIndex;
    }
}

