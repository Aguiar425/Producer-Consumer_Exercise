public class Chef implements Runnable{

    private int maxNumDishes;
    private int totalDishes;
    Container queue;

    public Chef(int maxNumDishes, Container queue) {
        this.maxNumDishes = maxNumDishes;
        this.totalDishes = 0;
        this.queue = queue;
    }

    private void chefWork() {
        int randomDish = RandomNumber.generateRandom(3, 1);
        switch (randomDish) {
            case 1:
                queue.addDish(Dishes.PASTA);

            case 2:
                queue.addDish(Dishes.LASAGNA);

            case 3:
                queue.addDish(Dishes.PIZZA);
        }
    }

    @Override
    public void run() {
        while(totalDishes != maxNumDishes){
            try{
                chefWork();
                totalDishes++;

            }catch (IllegalStateException ise){
                System.out.println("Can't add a dish, list is full");
                return;
            }
        }
    }
}
