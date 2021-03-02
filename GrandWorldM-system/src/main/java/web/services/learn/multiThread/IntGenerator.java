package web.services.learn.multiThread;

import web.services.learn.containers.Generator;

public abstract class IntGenerator implements Generator<Integer> {
    private volatile boolean canceled;

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
