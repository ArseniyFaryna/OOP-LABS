package org.example;

public class ClearenceRequest {

    private final Car car;
    private boolean isDocumentsOk;

//    Constructor
    public ClearenceRequest(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
    public boolean isDocsOk(){
        return isDocumentsOk;
    }
    public boolean setDocsOk() {
        return isDocumentsOk = true;
    }
}
