package Threads;

import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import MyTransport.Car;
import Vehicle.Vehicle;

public class ReadFileRunnable implements Runnable{
    private String path;
    private BlockingQueue blockQueue;
    public ReadFileRunnable(BlockingQueue ab, String p){
        path = p;
        blockQueue = ab;
    }

    @Override
    public void run(){
        try{
            Scanner scanner = new Scanner(new FileReader(path));
            String mark = scanner.nextLine();
            Vehicle v = new Car(mark, 5);
            blockQueue.put(v);
        }
        catch(Exception e){
            System.err.println(e.toString());
        }
    }
}
