package web.services.learn.multiThread.threadPool;

public class Joining {

    public static void main(String[] args) throws InterruptedException {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 10000);
        Joiner dopey = new Joiner("Dopey", sleepy);
        Joiner doc = new Joiner("Doc", grumpy);
        Thread.sleep(1000);
        grumpy.interrupt();
    }

    public static class Sleeper extends Thread {
        private int sleepTime;

        public Sleeper(String name, int sleepTime) {
            super(name);
            this.sleepTime = sleepTime;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println("Sleeper: " + this.getName() + " start to sleep.");
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                System.out.println("Sleeper: " + this.getName() + " is interrupted.");
            }
            System.out.println("Sleeper: " + this.getName() + " is awakened.");
        }
    }

    public static class Joiner extends Thread {

        private Sleeper sleeper;

        public Joiner(String name, Sleeper sleeper) {
            super(name);
            this.sleeper = sleeper;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println("Joiner: " + this.getName() + " start to be joined by sleeper: " + sleeper.getName());
                sleeper.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Joiner: " + this.getName() + " complete.");
        }
    }
}
