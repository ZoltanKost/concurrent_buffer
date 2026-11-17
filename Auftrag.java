import java.util.*;

class Auftrag
{
    public Auftrag()
    {

    }

    public void abarbeiten() throws InterruptedException
    {
        Random rand = new Random();
        Thread.sleep(rand.nextInt(3000) + 2000);
    }
}