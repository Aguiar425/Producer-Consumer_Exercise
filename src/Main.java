public class Main {
    public static void main(String[] args){

        Container queue = new Container(10);

        /*Thread[] chefs = new Thread[3];
        Thread[] clients = new Thread[5];

        for (int i = 0; i < chefs.length; i++) {
            int randomNumPlates = RandomNumber.generateRandom(10,3);
            chefs[i] = new Thread(new Chef(randomNumPlates, queue));
        }

        for (int i = 0; i < clients.length; i++) {
            int randomNumPlates = RandomNumber.generateRandom(5,1);
            clients[i] = new Thread(new Client(randomNumPlates, queue));
        }

        chefs[0].start();
        chefs[1].start();
        chefs[2].start();*/
        Thread p1 = new Thread(new Chef(10, queue));
        Thread p2 = new Thread(new Chef(5, queue));
        Thread p3 = new Thread(new Chef(10, queue));

        Thread c1 = new Thread(new Client(5, queue));
        Thread c2 = new Thread(new Client(3, queue));

        c1.start();
        c2.start();

        p1.start();
        p2.start();
        p3.start();
    }
}