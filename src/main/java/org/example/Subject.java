package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject <T>{
    protected final List<Observer<T>> observers = new ArrayList<>();

    abstract T getSubjectValue();

    //Subject must be able to notify its observers
    void notifyObservers(){
        observers.forEach(o -> o.update(getSubjectValue()));
    }

    //To be notified, all observers must subscribe to the Subject
    public void subscribe(Observer<T> observer){
        observers.add(observer);
    }

    //By unsubscribing, the observer stop receiving subject notifications
    public void unsubscribe(Observer<T> observer){
        observers.remove(observer);
    }
}
