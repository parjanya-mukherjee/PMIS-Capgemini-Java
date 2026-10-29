//this is without threading
// package practice;

// class A{
//     public void show(){
//     for(int i = 0; i < 10; i++){
//         System.out.println("Hi");
//     }
// }
// }

// class B{
//     public void show(){
//     for(int i = 0; i < 10; i++){
//         System.out.println("Hello");
//     }
// }
// }

// public class Multithreading {
//     public static void main(String[] args) {
//         A obj1 = new A();
//         B obj2 = new B();
//         obj1.show();
//         obj2.show();
//     }
// }

////////////////////////////////////////////////////////////////////////////


// package practice;

// class A extends Thread {//we need to extend thread class to use threading
//     public void run(){
//     for(int i = 0; i < 10; i++){
//         System.out.println("Hi");
//     }
// }
// }

// class B extends Thread {//
//     public void run(){//called by start method directly from thread class
//     for(int i = 0; i < 10; i++){
//         System.out.println("Hello");
//     }
// }
// }

// public class Multithreading {
//     public static void main(String[] args) {
//         A obj1 = new A();
//         B obj2 = new B();
//         obj1.start();//own method of thread which calls run
//         obj2.start();
//     }
// }



// package practice;

// class A extends Thread {//we need to extend thread class to use threading
//     public void run(){
//     for(int i = 0; i < 100; i++){
//         System.out.println("Hi");
//         try {
//             Thread.sleep(10);//waiting for the other one to execute
//         } catch (InterruptedException e) {
//             // TODO: handle exception
//             e.printStackTrace();
//         }
//     }
// }
// }

// class B extends Thread {//
//     public void run(){//called by start method directly from thread class
//     for(int i = 0; i < 100; i++){
//         System.out.println("Hello");
//         try {
//             Thread.sleep(10);
//         } catch (InterruptedException e) {
//             // TODO: handle exception
//             e.printStackTrace();
//         }
//     }
// }
// }

// public class Multithreading {
//     public static void main(String[] args) {
//         A obj1 = new A();
//         try {
//             Thread.sleep(5);
//         } catch (InterruptedException e) {
//             // TODO: handle exception
//             e.printStackTrace();
//         }
//         B obj2 = new B();
        
//         System.out.println(obj1.getPriority());

//         obj1.start();//own method of thread which calls run
//         obj2.start();
//     }
// }

////////////////////////////////////////////////////



package practice;

class A implements Runnable {//we need to extend thread class to use threading
    public void run(){
    for(int i = 0; i < 100; i++){
        System.out.println("Hi");
        try {
            Thread.sleep(10);//waiting for the other one to execute
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
}

class B extends Thread {//
    public void run(){//called by start method directly from thread class
    for(int i = 0; i < 100; i++){
        System.out.println("Hello");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
}

public class Multithreading {
    public static void main(String[] args) {
        Runnable obj1 = new A();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        Runnable obj2 = new B();
        Thread t1 = new Thread();//
        Thread t2 = new Thread();
        
        System.out.println(obj1.getPriority());

        t1.start();//own method of thread which calls run
        t2.start();

    }
}
