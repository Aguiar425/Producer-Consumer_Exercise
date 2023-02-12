import java.util.NoSuchElementException;

public class Client implements Runnable{

    private int maxNumDishes;
    private int totalDishes;
    Container queue;

    public Client(int maxNumDishes, Container queue) {
        this.maxNumDishes = maxNumDishes;
        this.totalDishes = 0;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (totalDishes != maxNumDishes){
            if(!queue.getAllDishes().isEmpty()){
                try{
                    queue.removeDish();
                    totalDishes++;
                }catch (NoSuchElementException nse){
                    System.out.println("List is empty");
                }
            }
        }
    }
}
