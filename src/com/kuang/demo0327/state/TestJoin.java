package com.kuang.demo0327.state;

//测试Join方法，想象成插队
public class TestJoin implements Runnable {

    @Override
    public void run() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args){
        //启动线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程:200之前是并发执行的，200之后vip线程先行。
        for (int i = 0; i < 500; i++) {

            if(i == 200) {
                try {
                    thread.join();//插队
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main" + i);
        }
    }
}
