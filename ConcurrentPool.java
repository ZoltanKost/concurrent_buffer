import java.util.*;

class ConcurrentPool<T>
{
    List<T> list;
    int everAdded = 0;
    int removed = 0;
    // todo: capacity = 5
    public ConcurrentPool()
    {
        list = new LinkedList<T>();
    }

    public synchronized void add(T obj) throws InterruptedException
    {
        while(list.size() >= 5) wait(); // wenn ein producer umsonst aufwaecht
        list.add(obj);
        everAdded++;
        if(list.size() < 5) notifyAll(); // wake up druckers who wait for these babies
    }

    public synchronized T pop()throws InterruptedException
    {
        T res;
        while(list.size() < 1) // wenn ein drucker umsonst aufwaecht
        {
            wait();
        }
        res = list.remove(0);
        removed++;
        notifyAll();    // alle schlafende producers und druckers aufwachen
        return res;
    }

    public int size() // nur im main aufgerufen wenn alles eh fertig ist
    {
        System.out.println("size: " + list.size() + " added: " + everAdded + " removed: " + removed);
        return list.size();
    }
}