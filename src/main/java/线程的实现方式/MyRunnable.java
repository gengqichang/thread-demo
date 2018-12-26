package 线程的实现方式;

/**
 * Created by Gqc on 2018/12/26.
 * 线程的第二种实现方式,实现Runnable接口中的run方法
 */
public class MyRunnable implements Runnable {

    public void run() {
        //run方法中写我们需要线程执行的内容
        System.out.println("run in MyThread");
    }

    public static void main(String[] args) {
        //先创建我们写的实现类
        MyRunnable r = new MyRunnable();
        //我们的对象r中并没有start方法,我们需要借助Thread的力量
        //创建Thread对象并将我们的r对象传递进去
        Thread t = new Thread(r);
        //调用该对象的start方法
        t.start();
        System.out.println("run in main");
    }

}
