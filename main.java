import java.util.*;

class Main
{
    public static void main() throws InterruptedException
    {
        ConcurrentPool<Auftrag> pool = new ConcurrentPool<Auftrag>();
        List<Drucker> druckers = new ArrayList<Drucker>();
        List<Producer> prods = new ArrayList<Producer>();
        List<Thread> threads = new ArrayList<Thread>();
        for(int i = 0; i < 3; i++)
        {
            druckers.add(new Drucker(pool));
        }
        for(int i = 0; i < 3; i++)
        {
            prods.add(new Producer(pool));
        }

        for(Producer p : prods)
        {
            Thread t = new Thread(p);
            t.start();
            threads.add(t);
        }

        for(Drucker d : druckers)
        {
            Thread t = new Thread(d);
            t.start();
            threads.add(t);
        }

        // Program nach 20 sek beenden
        
        int time = 20000;
        Thread.sleep(time);
        for(Thread t : threads)
        {
            t.interrupt();
        }
        System.out.println(pool.size());
    }
}