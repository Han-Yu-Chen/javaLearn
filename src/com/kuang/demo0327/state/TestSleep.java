package com.kuang.demo0327.state;
//模拟网络延时
//抢票
//放大问题的发生性
public class TestSleep implements Runnable {
    //票数
    int ticketNums = 10;
    @Override
    public void run() {
        while(true) {
            if(ticketNums<=0) {
                break;}
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->get the "+ticketNums--+"ticket");
        }
    }
    public static void main(String arg[]) {
        TestSleep ticket = new TestSleep();
        new Thread(ticket,"xiaoming").start();
        new Thread(ticket,"xiaohong").start();
        new Thread(ticket,"xiaozhang").start();
    }
}
