class Drucker implements Runnable
{
    ConcurrentPool<Auftrag> pool;
    public Drucker(ConcurrentPool<Auftrag> _pool)
    {
        pool = _pool;
    }
    public void run()
    {
        boolean work = true;
        while(work)
        {
            try{
                Auftrag a = pool.pop();
                a.abarbeiten();
                System.out.println("Auftrag abarbeitet");
            }catch(InterruptedException e)
            {
                System.out.println(e);
                return;
            }
        }
        
    }
}