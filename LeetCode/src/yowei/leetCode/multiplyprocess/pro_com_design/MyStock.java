package yowei.leetCode.multiplyprocess.pro_com_design;

public class MyStock {
    private String name ;
    private boolean hasGoods = false;

    public synchronized void putOne(String name){
        while (hasGoods){
            try{
                this.wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        System.out.println("生产者生产了：" + name);
        this.hasGoods = true;
        this.notifyAll();
    }

    private synchronized void takeOne(){
        while (!hasGoods){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费了：" + this.name);
        this.hasGoods=false;
        this.notifyAll();
    }

    public static void main(String[] args) {
        MyStock myStock = new MyStock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    myStock.putOne("weiruan");
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    myStock.putOne("tx");
                }

            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    myStock.takeOne();
                }

            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    myStock.takeOne();
                }

            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
