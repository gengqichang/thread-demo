package 线程的实现方式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Gqc on 2018/12/26.
 * 线程的第三种实现方式,该方式实现的接口可以获得一个返回值
 * Callable<泛型>可以先返回值的泛型
 */
public class MyCallable implements Callable<Integer> {
    public Integer call() throws Exception {
        //与其他两种线程不同的是,这里是在call中写要执行的内容
        System.out.println("run in MyCallable");
        //我们接下来用该线程计算一下1-100以内的和
        int sum = 0;
        for(int i=1;i<=100;i++){
            sum+=i;
        }
        //将计算的结果返回
        return sum;
    }

    public static void main(String[] args){
        //先创建该实现类
        MyCallable mc = new MyCallable();
        //创建FutureTask对象,并将上面创建的mc类传递进去,该类的泛型为实现类的返回值类型
        FutureTask<Integer> ft = new FutureTask<Integer>(mc);
        //创建Thread线程类,并将ft对象传递进去,再次借助Thread的力量启动线程
        Thread t = new Thread(ft);
        //调用start方法启动线程
        t.start();
        System.out.println("run in main");
        try {
            //当我们需要得到该线程返回的结果时调用ft的get方法获取
            //该方法会抛异常,我们需要进行处理
            //调用该方法后主线程会进入阻塞状态,也就是只有该线程执行完后才会继续执行get方法后的代码
            Integer sum = ft.get();
            //打印得到的结果
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
