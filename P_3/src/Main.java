import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {
    synchronized static void mySet(){
        List<String> list = new ArrayList<String>();
        list.add("string1");
        list.add("string2");
        list.add("string3");
        list.add("string4");
        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    static void myList(){
        final Lock lock = new ReentrantLock();
        lock.lock();
        List list = new ArrayList();
        list.add("Object 1");
        list.add("Object 2");
        list.add("Object 3");
        list.add("Object 4");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        lock.unlock();
    }

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        mySet();
        myList();


    }


}

