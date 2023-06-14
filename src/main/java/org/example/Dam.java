package org.example;

public class Dam extends Subject<Integer>{

    private final String name;
    private Integer seismCount = 0;

    public Dam(String name){
        this.name = name;
    }

    @Override
    Integer getSubjectValue() {
        return seismCount;
    }

    public void increaseSeismCount(){
        seismCount++;
        notifyObservers();
    }

    public void decreaseSeismCount(){
        seismCount = seismCount > 1 ? seismCount - 1 : 0;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

}
