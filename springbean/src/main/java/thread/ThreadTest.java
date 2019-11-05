package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description Java线程基础
 * <p>
 * 线程和进程的区别
 * 1、进程是指一个内存中运行的应用程序，每个进程都有自己独立的一块内存空间，一个进程中可以启动多个线程
 * 2、线程是指进程中的一个执行流程，一个进程中可以运行多个线程。比如java.exe进程中可以运行很多线程
 * 线程总是属于某个进程，进程中的多个线程共享进程的内存
 * </p>
 * @Author wangpeijin
 * @Date 2019/11/5 17:45
 * @Version 1.0
 **/
public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Thread1 thread1 = new Thread1("线程1");
        // thread1.start();
        // Thread1 thread2 = new Thread1("线程2");
        // thread2.start();

        // Thread thread1 = new Thread(new Thread2("线程1"));
        // thread1.start();
        // Thread thread2 = new Thread(new Thread2("线程2"));
        // thread2.start();

        // ExecutorService pool = Executors.newFixedThreadPool(8);
        // Future<Boolean> future1 = pool.submit(new Thread3(24));
        // System.out.println(future1.get());
        // Future<Boolean> future2 = pool.submit(new Thread3(25));
        // System.out.println(future2.get());
    }

    // 线程实现的三种形式
    // 1、继承Thread类,重写run()方法
    public static class Thread1 extends Thread {

        public Thread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(this.getName() + "开始启动。。。");
        }
    }

    // 2、实现Runnable接口
    public static class Thread2 implements Runnable {

        private String name;

        public Thread2(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "开始启动。。。");
        }
    }

    // 3、使用Callable和Future接口
    public static class Thread3 implements Callable<Boolean> {

        private int age;

        public Thread3(int age) {
            this.age = age;
        }

        @Override
        public Boolean call() throws Exception {
            return age > 24;
        }
    }

}
