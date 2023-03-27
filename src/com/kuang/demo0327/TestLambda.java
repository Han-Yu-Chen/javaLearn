package com.kuang.demo0327;

public class TestLambda {
    //3.静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like Lambda2.");
        }
    }

    public static void main(String[] args) {
        //类的最外面
        ILike like = new Like();
        like.lambda();
        //静态内部类
        like = new Like2();
        like.lambda();

        //4.局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like Lambda3.");
            }
        }

        like = new Like3();
        like.lambda();

        //5.匿名内部类，没有类名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like Lambda4.");
            }
        };//必须用分号，因为是一行语句了。
        like.lambda();

        //6.用lambda简化
        like = () -> {
            System.out.println("I like Lambda5.");
        };//用lambda简化
        like.lambda();
    }
}
//定义一个函数式接口
interface ILike{
    void lambda();
}
//实现类
class Like implements ILike{
    @Override
     public void lambda(){
        System.out.println("I like Lambda.");
    }

}