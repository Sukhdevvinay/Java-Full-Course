public class Demo {
    public static void main(String[] args) {

        Test test = new Test();

        Thread t1 = new Thread(() -> test.show());

        Thread t2 = new Thread(() -> test.show());

        t1.start();
        t2.start();
    }
}

class Test {

    synchronized void show() {
        System.out.println(Thread.currentThread().getName() + "Inside show");

        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {}

        System.out.println(Thread.currentThread().getName() + "Show finish");
    }
}

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
