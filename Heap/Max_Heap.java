import java.util.*;

public class Max_Heap {
    private List<Integer> heap = new ArrayList<>();

    public void insert(int val){
        heap.add(val);
        int index = heap.size() - 1;
        while(index > 0){
            int parentIndex = (index - 1) / 2;
            if(heap.get(parentIndex) >= heap.get(index)) {
                break; // The heap property is satisfied
            }
            // Swap the current node with its parent
            Collections.swap(heap, parentIndex, index);
            index = parentIndex; // Move up the tree
        }
    }

    public int extractMax(){
        if(heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if(!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return max;
    }
    
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < size && heap.get(leftChild) > heap.get(largest)) {
                largest = leftChild;
            }
            if (rightChild < size && heap.get(rightChild) > heap.get(largest)) {
                largest = rightChild;
            }
            if (largest == index) {
                break; // The heap property is satisfied
            }
            // Swap the current node with the largest child
            Collections.swap(heap, index, largest);
            index = largest; // Move down the tree
        }
    }


    public void printHeap(){
        for(int val : heap){
            System.out.println(val);
        }
    }

    public static void main(String[] args){
        Max_Heap maxHeap = new Max_Heap();
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.printHeap();
        System.out.println("Max Element: " + maxHeap.extractMax());
        maxHeap.printHeap();
        maxHeap.insert(25);
        maxHeap.printHeap();
        System.out.println("Max Element: " + maxHeap.extractMax());
        maxHeap.printHeap();
    }
}
