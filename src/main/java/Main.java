/// 8

/// TESTS, DISC
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyThread extends Thread {    // the entry point of a thread is run

    final int LOOP_MAX = 1000000;
    int instanceCouter;
    static int sharedCounter;

    @Override
    public void run() {
        for (int i = 0; i < LOOP_MAX; i++) {
            instanceCouter++;
            synchronized("BathroomKey"){ /// no synchronizatuion for this hw..that is what is being tested!
            MyThread.sharedCounter++;
            }
            //System.out.println("T2: " + i);
            //Main.threadSleep(100);
        }
    }

}

public class Main {

    public static void threadSleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

        ArrayList<MyThread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyThread t = new MyThread();
            threadList.add(t);
            t.start();
        }
        Main.threadSleep(1000);
        
        for(MyThread t : threadList){
            System.out.println(t.instanceCouter + ", " + t.sharedCounter);
        }
        
    }
}
