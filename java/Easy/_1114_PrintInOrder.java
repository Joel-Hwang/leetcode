package Easy;

import org.testng.annotations.Test;

public class _1114_PrintInOrder {
    class Foo {
        private static boolean oneDone, secondDone;
        public Foo() {
            oneDone = false;
            secondDone = false;
        }
    
        public synchronized void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            oneDone = true;
            notifyAll();
        }
    
        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while(!oneDone){
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondDone = true;
            notifyAll();
        }
    
        public synchronized void third(Runnable printThird) throws InterruptedException {
            while(!secondDone){
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    @Test
    public void test() throws Exception{
        Foo foo = new Foo();
        foo.first( () ->{System.out.println("first");} );
        foo.second(()->{System.out.println("second");});        
        foo.third(()->{System.out.println("thrid");});        
    }
}


