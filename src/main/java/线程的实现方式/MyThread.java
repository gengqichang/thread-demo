package 线程的实现方式;

/**
 * Created by Gqc on 2018/12/26.
 * 线程的第一种实现方式,继承Thread类,并重写run方法
*/
public class MyThread extends Thread {
    @Override
    public void run() {
        //run方法中写我们需要线程执行的内容
        System.out.println("run in MyThread");
    }

    public static void main(String[] args) {
        //创建线程对象
        MyThread t = new MyThread();
        //启动一个线程的正确方法是调用该线程对象的start方法,而不是我们重写的run方法
        t.start();
        System.out.println("run in main");
    }

}
