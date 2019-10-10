package com.company;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    AtomicLong a;
    AtomicReference<String> ss;

    public static void main(String[] args) throws InterruptedException {
        DecompositionFactor decompositionFactor = new DecompositionFactor();
	    for (int i = 0; i < 10000; i++){
	         new Thread(new Runnable() {
                @Override
                public void run() {
                    decompositionFactor.service();
                }
            }, "Thread" + i).start();

        }

	    Parent11 parent11 = new Parent11();
	    parent11.getJ();

	    Thread.sleep(1000);
	    System.out.println(decompositionFactor.getClass().getName());
    }
}

//第二章，2.5节 活跃与性能 分解因子
class DecompositionFactor{
    private BigInteger lastNumber;
    private BigInteger[] lastFactors;
    private long hits;
    private long cacheHits;

    public void service(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + "  hits1:" + ++hits);
        }

        synchronized (this){
            System.out.println(Thread.currentThread().getName() + "  hits   2:" + ++hits);
        }
    }
}

class Parent{
    //synchronized是可重入锁
    public synchronized void doSomething(){
        System.out.println(Thread.currentThread().getName() + ":父类啪啪啪");
    }
}

 class Child extends Parent11 {
//    @Override
    public synchronized void doSomething() {
        System.out.println(Thread.currentThread().getName() + ":子类啪啪啪");
//        super.doSomething();
        System.out.println(Thread.currentThread().getName() + ":子类啪啪啪完事儿了");
    }
}

