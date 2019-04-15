package zuo.class_03;


class ArrayStack {
    private int index;
    private int size;
    private int[] stack;

    public ArrayStack(int initSize) {
        if (initSize <= 0) {
            System.out.println("Init size should greater than 0");
            return;
        } else {
            stack = new int[initSize];
            index = 0;
            size = 0;
        }
    }

    public void push(int num) {
        if (size == stack.length) {
            System.out.println("Stack full");
            return;
        } else {
            stack[index++] = num;
            size++;
        }
    }

    public int pop() {
        if (size == 0) {
            System.out.println("Stack empty");
            return -1;
        } else {
            return stack[--index];
        }
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Stack empty");
            return -1;
        } else {
            return stack[index - 1];
        }
    }
}

public class Code_03_ArrayStack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.peek());
    }
}

