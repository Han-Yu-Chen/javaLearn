package com.kuang.demo0327;
//静态代理
/*真实对象和代理对象都要实现用一个接口
* 代理对象要代理真实角色*/
//好处：代理对象可以做很多真实对象做不了的事情，真实对象专注做自己的事情。
public class StaticProxy {
    public static void main(String arg[]) {
        //Thread 代理 一个真实的Runnable接口，共同的run（）方法
        new Thread ( ()-> System.out.println("我爱你")).start();
        new WeddingCompany(new You()).HappyMarry();

        //亲自结婚
        You you = new You();//你要结婚
        you.HappyMarry();
        //交给代理
//        WeddingCompany weddingCompany = new WeddingCompany(new You());
//        weddingCompany.HappyMarry();
    }
}
/*真实结婚角色*/
interface Marry {
    void HappyMarry();
}
 class You implements Marry{
    public void HappyMarry() {
        System.out.println("要结婚了！！");
     }
 }
 /*代理角色，帮助结婚*/
class WeddingCompany implements Marry {
    //真实目标角色
    private Marry target;
    public WeddingCompany (Marry target) {
        this.target = target;
    }
    @Override
    public void HappyMarry(){
        before();
        this.target.HappyMarry();//真实对象
        after();
    }
    private void before() {
        System.out.println("结婚之前，布置现场");
    }
    private void after() {
        System.out.println("结婚之后，打扫卫生");
    }
}