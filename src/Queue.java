public class Queue {
    private final int SIZE = 5;
    private int[] items = new int[SIZE];
    int front, rear;

    public Queue() {
        front = -1;
        rear = -1;
    }

    private boolean isFull() {
        if (rear == SIZE - 1 && front == 0) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    public void addQueue(int element) {
        if (isFull()) {
            System.out.println("Очередь заполнена!");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = element;
            System.out.println("Добавлен элемент " + element);
        }
    }

    public int delQueue() {
        int element;
        if(isEmpty()) {
            System.out.println("Очередь пустая!");
            return -1;
        } else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Удалён элемент -> " + element);
            return element;
        }
    }

    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Пустая очередь.");
        } else {
            System.out.println("Индекс FRONT: " + front);
            System.out.println("Индекс REAR: " + rear);
            System.out.println("Элементы: ");
            for (i = front; i <= rear; i++) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.delQueue());
        System.out.println();
        q.addQueue(4);
        q.addQueue(1);
        q.addQueue(3);
        q.addQueue(2);
        q.addQueue(5);
        q.addQueue(6);

        q.display();
        System.out.println();
        System.out.println(q.delQueue());
        System.out.println();
        q.display();
    }
}
