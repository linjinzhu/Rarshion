package ThinkingInJava;

/**
 * Author ： Martin
 * Date : 17/9/15
 * Description :
 * Version : 2.0
 */
//class Meal {
//    private final int orderNum;
//    public Meal(int orderNum) {this.orderNum = orderNum;}
//    public String toString() { return "Meal" + orderNum;}
//}
//
//class WaitPerson implements Runnable {
//
//    private Restaurant restaurant;
//    public WaitPerson(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (!Thread.interrupted()) {
//                synchronized (this) {
//                    while (restaurant.meal == null) {
//                        wait();
//                    }
//                }
//                System.out.println("waitperson got" + restaurant.meal);
//                synchronized (restaurant.chef) {
//                    restaurant.meal = null;
//                    restaurant.chef.notifyAll();
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class Chef implements Runnable {
//
//    private Restaurant restaurant;
//    private int count = 0;
//    public Chef(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (!Thread.interrupted()) {
//                synchronized (this) {
//                    while (restaurant.meal != null) {
//                        wait();
//                    }
//                }
//                if (++count == 10) {
//                    System.out.println("out of food, closing");
//                    restaurant.exec.shutdownNow();
//                }
//                System.out.println("Order up!");
//                synchronized (restaurant.waitPerson) {
//                    restaurant.meal = new Meal(count);
//                    restaurant.waitPerson.notifyAll();
//                }
//                TimeUnit.MICROSECONDS.sleep(100);
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Chef interrupted");
//        }
//    }
//}
//
//
//public class Restaurant {
//    Meal meal;
//    ExecutorService exec = Executors.newCachedThreadPool();
//    WaitPerson waitPerson = new WaitPerson(this);
//    Chef chef = new Chef(this);
//    public Restaurant() {
//        exec.execute(chef);
//        exec.execute(waitPerson);
//    }
//    public static void main(String[] args) {
//        new Restaurant();
//    }
//}
