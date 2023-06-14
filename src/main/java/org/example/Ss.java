package org.example;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class Ss implements Observer<Integer>{

    private final int id;
    private boolean hasSeism;
    private final Dam dam;

    public Ss(int id, Dam dam){
        this.id = id;
        this.dam = dam;
        startMeasures();
    }

    // It is not part of the Observer pattern. It's just fancy method to emulate a sensor working by its own.
    private void startMeasures() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                final int random = ThreadLocalRandom.current().nextInt(0, 4);
                setSeism(random == 0);
            }
        };
        timer.scheduleAtFixedRate(task , 0, 2000);
    }

    private void setSeism(boolean value) {
        hasSeism = value;
        if(hasSeism) dam.increaseSeismCount();
        else dam.decreaseSeismCount();
    }

    public boolean hasSeism() {
        return hasSeism;
    }

    @Override
    public void update(Integer seismCount) {
        if(seismCount >= 2) startLuminousAlert();
    }

    private void startLuminousAlert() {
        System.out.printf("[SS Device - id = %d] Blinking in RED!\n", id);
    }
}
