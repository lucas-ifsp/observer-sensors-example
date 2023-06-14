package org.example;

public class Ac implements Observer<Integer>{

    private final int id;

    public Ac (int id){
        this.id = id;
    }

    @Override
    public void update(Integer seismCount) {
        if(seismCount >= 6) startEvacuationAlert();
    }

    private void startEvacuationAlert() {
        System.out.printf("[AC Device - id = %d] Dam is collapsing, start evacuation!\n", id);
    }
}
