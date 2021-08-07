package com.my.common.thinkinginjava.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * wait和notify练习
 * wait和sleep不同之处是, sleep不释放锁,wait释放锁
 */
public class Kitchen{
    static Executor executors = Executors.newCachedThreadPool();

    public static void cook(String menuName){
        Menu menu = new Menu(menuName);
        //下单后，各干各的
        Cooker cooker = new Cooker(menu);
        Helper helper = new Helper(menu);
        executors.execute(helper);
        executors.execute(cooker);
    }

    static class Menu{
        private Boolean ready = false;
        private String menuName = null;
        public Menu(String menuName){
            this.menuName = menuName;
        }

        public Boolean getReady() {
            return ready;
        }

        public void setReady(Boolean ready) {
            this.ready = ready;
        }

        public String getMenuName() {
            return menuName;
        }
    }

    /**
     * 厨师负责Cook美食，
     * 但当发现还没有准备好食材时，就先休息一下
     */
    static class Cooker implements Runnable {
        private Menu menu = null;
        public Cooker(Menu menu){
            this.menu = menu;
        }
        public  void cook(){
            synchronized(this.menu) {
                try {
                    //wait的惯用写法，
                    // 一是判断notifyAll是否和自己有关系，
                    // 二是为了并发时发生线程切换而发生信号丢失
                    while(!this.menu.getReady()){
                        //还没洗好就先坐一下
                        System.out.println("Wait for (" + this.menu.getMenuName() + ")");
                        this.menu.wait();
                    }
                    //如果有先洗好的，就直接煮
                    if (this.menu.getReady()) {
                        System.out.println("Cook... for (" + this.menu.getMenuName() + ")");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            cook();
        }
    }

    /**
     * 助手负责给主厨准备食材
     * 准备好之后通知主厨下锅
     */
    static class Helper implements Runnable{
        Menu menu = null;
        public Helper(Menu menu){
            this.menu = menu;
        }
        public void watch() {
            //
            synchronized(this.menu) {
                if (!this.menu.getReady()) {
                    System.out.println("Wash vegetables for ("+this.menu.getMenuName()+")");

                    //准备好了，喊一下
                    this.menu.setReady(true);
                    this.menu.notify();
                }
            }
        }

        @Override
        public void run() {
            watch();
        }
    }


    public static void main(String[] args) {
        /**
         * 给我都20份红烧鲍鱼
         */
        for(int i=0; i<20; i++) {
            Kitchen.cook("红烧鲤鱼<第"+i+"份>");
        }
    }
}
