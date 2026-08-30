public class Demo2 {
    
    static volatile boolean flag = false; // true

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {}
            flag = true; // cache --> flag = true
        });

        Thread t2 = new Thread(() -> { // cache --> flag = false
            while(!flag) {
                // System.out.println("Thread 2 Running..."); // synchronized
                // do nothing
            }
            System.out.println("Thread 2 finished");
        });

        t1.start();
        t2.start();
    }
}
/*
    main() {
        boolean flag = false;
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {}
            flag = true; // cache --> flag = true
        });

        Thread t2 = new Thread(() -> { // cache --> flag = false
            while(!flag) {
                // System.out.println("Thread 2 Running..."); // synchronized
                // do nothing
            }
            System.out.println("Thread 2 finished");
        });

        t1.start();
        t2.start();
    }
    OP of THis code : 
    1 seconds tak thread t1 sleep mode par hain , tab tak t2 thread Running Print Karege
    and after 1 seconds woh flag ki value ko true kar dege. and now thread t2 will be stop because
    and after 1 second Thread 2 finished print hoga.

    Ye Ruka isliye hain , Kyuki Ye Jo systen.println wali statement hain woh by deafult 
    synchornous statement hoti hain toh is synchronous ki wajah se ye threads us variable ki value 
    ko apne threads se read nahi karte hain balki direct RAM se read karte hain , so isliye thread 
    t2 after 1seconds flag ki value ko true read karta hain from RAM so while loop ends.

    due to this printing line ye hamare pure block ko synchoronise kar deta hain.
    so if we remove this line toh ab block synchoronise nahi hain ab thread t2 value of z ko cache 
    se read karege not from RAM , so ab yeh stop nahi hoga , kuki T1 main flag = 1 hain and T2 main 
    flag = false hain , 
    so op of this code is Infinetly Running in terminal.

    To Solve this Issue of Visibility : 
    * Use Keyword Volatile to declare the variable to overcome of Visibility Issue.
    * So if We use this Keyword for that variable then ALL threads read that variable directly from 
    RAM not from their stored value of that variable in their threads.
    * Ex : 
    static volatile boolean flag = 0;
    * Beacuse of Using this SO all Threads Read and Write Values into the RAM not their Cache.

    IMP : This Keyword do not solve the Problem of Race Condition , it only solve the Problem of 
    Visibility.
    * Synchornized also solve the Visibilty Problem
*/

