import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Container {

    Queue<Dishes> allDishes;

    public Container(int capacity) {
        this.allDishes = new LinkedBlockingQueue<>(10);
    }

    public synchronized void addDish(Dishes dish) throws IllegalStateException {
            allDishes.add(dish);
            System.out.println("Adding dish : " +dish.getName());
            printList();
            notifyAll();
        }

    public synchronized void removeDish() throws NoSuchElementException{
            System.out.println("Removing first dish");
            allDishes.poll();
            printList();
            notifyAll();
        }

    public Queue<Dishes> getAllDishes() {
        return allDishes;
    }

    public synchronized void printList() {
        System.out.println("DISH LIST :");
        for (Dishes finalDish :
                allDishes) {
            System.out.println(finalDish.getName() + " ");
        }
        System.out.println("=".repeat(100));
    }
}
