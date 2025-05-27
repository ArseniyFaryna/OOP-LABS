package org.example;

public abstract class ClearenceHandler {

    protected ClearenceHandler next;

    public ClearenceHandler setNext(ClearenceHandler next) {
        this.next = next;
        return next;
    }
    protected abstract void process(ClearenceRequest request);

    public void handle(ClearenceRequest request) {
        process(request);
        if (next != null) {
            next.handle(request);
        }
    }
}
