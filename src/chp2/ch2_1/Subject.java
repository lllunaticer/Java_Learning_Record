package chp2.ch2_1;

public interface Subject {
    //the visibility of the method in the interface must be public. the "public" description can be omitted by default.
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    void notifyObserver();
}
