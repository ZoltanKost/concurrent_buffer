import java.util.*;

class Producer implements Runnable
{
    ConcurrentPool<Auftrag> pool;
    public Producer(ConcurrentPool<Auftrag> _pool)
    {
        pool = _pool;
    }

    public void run()
    {
        boolean work = true;
        while(work)
        {
            try
            {
                Random rand = new Random();
                Thread.sleep(rand.nextInt(10000));
                System.out.println("Adding auftrag");
                pool.add(new Auftrag());
            }catch(InterruptedException e)
            {
                System.out.println(e);
                return;
            }
        }
    }
}