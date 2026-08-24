public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts");

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            }
            catch(InterruptedException e) {}
            System.out.println("Thread-0 starts");
        });

        t1.start();

        //t1.join() // let the t1 thread first complete its execution
        t1.join(1000);  // we can also give time to wait main thread for execution of t1 thread 
        /* 
        t1.join(); 
        t1.join(x); Means ab hum apne main thread ko keh rahe hain ki sirf x seconds tak wait karana
        , agar thread t1 x seconds main khatam ho rahi hain toh thik hain warna , agar x seconds se
        jayada time laga rahi toh tum apna next line ke code ka execution start kar sakte hon
        
        Ye t1.join() method humne waha lagaya hain , jaha main thread chal rahi hain , toh hum 
        main thread ko keh rahe hain ki , tum main thread waiting state par chale jao jab tak 
        humare thread t1 khatam nahi ho jati means main thread waiting state par chale gayi jab tak 
        thread t1 khatam nahi ho jati hain so ab t1.join() ke line ke baad jo code likha hain woh tab
        tak nahi chalega or execute hoga jab tak thread t1 ka kaam khatam nahi ho jata hian.
        */

        /*
        t1.join(); Ye Main thread ko waiting state main le jata hain , jab tak humare thread t1 khatam
        nahi ho jati tab tak wait karta hian 

        t1.join(x); Ye Main thread ko timed-waited state main le jata hian , means main thread only wait
        for x seconds , agar woh x seconds ke andar khatam ho gayi toh sahi , warne phir main thread 
        chale jayege.
        */
        
        System.out.println("Main thread ends");
    }
}

// join()
/*
Main thread --> WAITING
t1 thread --> RUNNABLE --> TERMINATED
Main thread --> WAITING -> RUNNABLE --> TERMINATED
*/
