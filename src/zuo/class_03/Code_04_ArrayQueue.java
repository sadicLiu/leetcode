package zuo.class_03;

class ArrayQueue {
    private int size;
    private int start, end;
    private int[] queue;

    public ArrayQueue(int initSize) {
        if (initSize <= 0) {
            System.out.println("Init size should be greater than 0");
        } else {
            queue = new int[initSize];
            size = 0;
            start = 0;
            end = 0;
        }
    }

    public void enqueue(int num) {
        if (size == queue.length) {
            System.out.println("Queue full");
            return;
        } else {
            queue[end++] = num;
            size++;
        }
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue empty");
            return -1;
        } else {
            int res = queue[start];
            start = start == queue.length - 1 ? 0 : start + 1;
            size--;
            return res;
        }
    }
}

public class Code_04_ArrayQueue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
