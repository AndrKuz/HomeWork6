public class PriorityQueue {
    private final int SIZE = 5;
    private int[] items = new int[SIZE];
    int front, rear;

    public PriorityQueue() {
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

    public void addPriQueue(int element) {
        if (isFull()) {
            System.out.println("Очередь заполнена!");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = element;
            boolean flag = true;
            int i = rear;
            while (flag && i != front) {
                if (items[i - 1] > element) {
                    items[i] = items[i - 1];
                    items[i - 1] = element;
                    i--;
                } else {
                    flag = false;
                }
            }
            System.out.println("Добавлен элемент " + element);
        }
    }

    public int delPriQueue() {
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
        PriorityQueue q = new PriorityQueue();
        System.out.println(q.delPriQueue());
        System.out.println();
        q.addPriQueue(4);
        q.addPriQueue(1);
        q.addPriQueue(3);
        q.addPriQueue(2);
        q.addPriQueue(5);
        q.addPriQueue(6);

        q.display();
        System.out.println();
        System.out.println(q.delPriQueue());
        System.out.println();
        q.display();
    }
}
