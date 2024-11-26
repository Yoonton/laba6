import MyTransport.Car;
import Threads.PrintModelName;
import Threads.PrintModelNameRunnable;
import Threads.PrintModelPrice;
import Threads.PrintModelPriceRunnable;
import Threads.TransportSynchronizer;

public class mainClass {
    public static void main(String[] args) throws Exception{
        //!task1
        Car car1 = new Car("Lada", 10000);
        PrintModelName t1 = new PrintModelName(car1);
        PrintModelPrice t2 = new PrintModelPrice(car1);
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        // t1.start();
        // t2.start();
        
        //!task2
        TransportSynchronizer t = new TransportSynchronizer(car1);
        Thread t3 = new Thread(new PrintModelNameRunnable(t));
        Thread t4 = new Thread(new PrintModelPriceRunnable(t));
        t3.start();
        t4.start();
    }
}
