package web.services.learn.multiThread;

import static net.mindview.util.Print.print;

public class Joining {

    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 2000);
        Joiner dopey = new Joiner("Dopey",sleepy);
        Joiner doc = new Joiner("Doc",grumpy);
        grumpy.interrupt();
    }

    public static class Sleeper extends Thread {
        int duration;

        public Sleeper(String name, int sleepTime) {
            super(name);
            duration = sleepTime;
            start();
        }

        @Override
        public void run() {
            try {
                sleep(duration);
            } catch (InterruptedException e) {
                print(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
            }
            print(getName() + " has awakened.");
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
                sleeper.join();
            } catch (InterruptedException e) {
                print("Interrupted.");
            }
            print(getName() + " join completed.");
        }
    }
}
