package Question2;

import java.util.concurrent.*;

public class Task implements Runnable
{
    private int number;
    Task(int number){
        this.number = number;
    }

    public void run()
    {
        System.out.println("The number is: "+number);
    }
}

class ExecutorDemo
{

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int index=0; index<10; index++)
        {
            Task task = new Task(index);
            Future<?> future = executorService.submit(task);
            try {
                future.get();
            } catch (Exception e) {
            }
        }
    }
}