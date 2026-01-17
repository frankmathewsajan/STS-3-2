public class Stack {
    private int[] stack;
    private int top = -1;

    public Stack(int capacity) {
        stack = new int[capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void push(int item) {
        if (isFull()) throw new StackOverflowError("Stack is full");
        stack[++top] = item;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Stack is empty";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10); // Create a stack with capacity 10

        // Push 4, 5, 6, 1
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(1);

        // Pop till 5 (inclusive)
        while (stack.peek() != 5) {
            System.out.println("Popped: " + stack.pop());
        }
        // Pop the element 5
        System.out.println("Popped: " + stack.pop());

        // Push 2, 3, 7, 8
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.push(8);

        // Pop till 3 (inclusive)
        while (stack.peek() != 3) {
            System.out.println("Popped: " + stack.pop());
        }
        // Pop the element 3
        System.out.println("Popped: " + stack.pop());

        // Push 9, 10
        stack.push(9);
        stack.push(10);

        // Pop till 4 (inclusive)
        while (stack.peek() != 4) {
            System.out.println("Popped: " + stack.pop());
        }
        // Pop the element 4
        System.out.println("Popped: " + stack.pop());

        // Final stack state
        System.out.println("Final Stack: " + stack);
    }
}
