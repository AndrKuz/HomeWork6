public class Stack {
    private int capacity;
    private int[] items;
    int top;

    public Stack(int size) {
        items = new int[size];
        capacity = size;
        top = -1;
    }

    private boolean isFull() {
        return top == capacity - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Стек заполнен!");
            System.exit(1);
        }
        items[++top] = x;
        System.out.println("Добавлен элемент " + x);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Стек пустой!");
            System.exit(1);
        }
        return items[top--];
    }

    public int size() {
        return top + 1;
    }

    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Стек пустой.");
        } else {
            System.out.println("Индекс TOP: " + top);
            System.out.println("Элементы: ");
            for (i = top; i >= 0; i--) {
                System.out.println(items[i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println("\nПосле удаления");

        stack.display();
    }
}
