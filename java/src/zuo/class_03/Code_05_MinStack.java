package zuo.class_03;

import java.util.Stack;

class MinStack {
    private Stack<Integer> valueStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int num) {
        valueStack.push(num);
        int min = (!minStack.isEmpty() && minStack.peek() < num) ? minStack.peek() : num;
        minStack.push(min);
    }

    public int pop() {
        if (valueStack.isEmpty()) {
            System.out.println("Stack Empty!");
            return -1;
        } else {
            minStack.pop();
            return valueStack.pop();
        }
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack Empty!");
            return -1;
        } else {
            return minStack.peek();
        }
    }

}

public class Code_05_MinStack {
    public static void main(String[] args) {
        MinStack stack1 = new MinStack();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

    }
}
