public class Demo {
    public static void main(String[] args) throws InterruptedException {

        Counter c1 = new Counter();

        Thread t1 = new Thread(() -> {
            for(int i=1; i<=10000; i++) {
                c1.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=1; i<=10000; i++) {
                c1.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c1.count);
    }
}

class Counter {
    public int count = 0;

    void increment() {
        // normal code

        synchronized(this) {
            count++; // 3 operation
        }
        // normal code
    }
}

/*
    synchronized void increment() {
            count++; // 3 operation
    }

    So AB Humara Critical Section is Increment Method toh hume is par Synchronized Keyword 
    Lagana hain. 
    Toh Ab Jab Humne Synchorized Keyword Lagya is Method Par .
    * Toh Ab ye Critical Section Lock Ho gaya hain.
*/

/*
Critical Section : Ek esa Section Jisme Hum chahe hain ki usme Ek Time par sirf Ek Hi thread 
Enter kare. and Critical Section Main Hamare Pass Jo bhi Resource Ho ti hain usko Hum Shared 
Resources Khete hain.
Ex : 
Class Counter {
    int cnt = 0;
    void increment() {
        cnt++;
    }
};

Ye Jo Increment Method Hain Woh ek Crtical Section Hain.
and cnt++ is A shared Resource.
So Problem is That : 
Agar hum Multiple Threads ko iske Andar aane Do toh We have a problem of Race Condition.
this is arise due to because cnt++ is non Atomic Operation.
All non Atomic Opration Have Race Condition Problem.

So Solution of This Problem is Keyword : Synchornized.

*/
