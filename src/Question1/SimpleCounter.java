package Question1;

public class SimpleCounter
{
    private static volatile int counter=0;
    void incrementCounter(){
        counter++;
    }
    int printCounter(){
        return counter;
    }

    public static void main(String[] args) {

        SimpleCounter simpleCounter = new SimpleCounter();
        Thread mainThread = new Thread(()->{
            while (counter < 10) {
                simpleCounter.incrementCounter();
                System.out.println("The counter has changed");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }

        });

        Thread printingThread = new Thread(()->{
             while(counter<10) {

                 System.out.println("The incremented value is: "+ simpleCounter.printCounter());
                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException e) {

                 }

            }
        });
        mainThread.start();
        printingThread.start();

    }
}
