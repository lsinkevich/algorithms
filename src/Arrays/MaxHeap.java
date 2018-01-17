package Arrays;

public class MaxHeap {

    private static int size = 1024;
    private static int k = 0;
    private static int auxiliary;
    private static int[] heap = new int[size];
    int[] newHeap;

    public void raiseHeap(int v) {
        heap[k] = v;
        int child = k;

        int parent = (child - 1) / 2;

        while (parent >= 0) {
            if (heap[child] > heap[parent]) {
                auxiliary = heap[parent];
                heap[parent] = heap[child];
                heap[child] = auxiliary;
                child = parent;
                parent = (child - 1) / 2;
            }
            else {
                break;
            }
        }

        k++;

        if(k > size) {
            newHeap = new int[2*size];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            size = size*2;
        }
    }

    public static void reductionHeap(int pos) {
        int parent = pos;
        auxiliary = heap[pos];
        int child = 2 * parent + 1;

        while (child < k) {
            if (child + 1 < k && heap[child + 1] > heap[child])
                child++;

            if (auxiliary < heap[child]) {
                heap[parent] = heap[child];
                parent = child;
                child = 2 * parent + 1;
            }
            else {
                break;
            }
        }

        heap[parent] = auxiliary;
    }

    public int queueHeap() {
        if (k != 0) {
            k--;
            auxiliary = heap[0];
            heap[0] = heap[k];
            heap[k] = auxiliary;
            reductionHeap(0);
            return auxiliary;
        }
        else {
            throw new RuntimeException("Empty heap");
        }
    }

    public static void main(String[] args) {

        MaxHeap mh = new MaxHeap();
        int [] arr = {1,2,4};
        String delimiter = " ";

        for (int i = 0; i < arr.length; i++)
            mh.raiseHeap(arr[i]);

        for(int i = 0; i < k/2; i++)
            reductionHeap(i);

        while(k != 0) {
            System.out.print(delimiter + mh.queueHeap());
        }
    }
}
