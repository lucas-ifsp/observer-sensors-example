package org.example;

public interface Observer <T> {
    //An observer must update (or not) its state based on the subject value
    void update(T value);
}
