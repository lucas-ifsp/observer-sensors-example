package org.example;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class Ssa implements Observer<Integer>{

    private final int id;
    private final Dam dam;
    private double level;
    private final double THRESHOLD;

    public Ssa(int id, Dam dam, double levelThreshold){
        this.id = id;
        this.dam = dam;
        this.THRESHOLD = levelThreshold;
        startMeasures();
    }

    // It is not part of the Observer pattern. It's just fancy method to emulate a sensor working by its own.
    private void startMeasures() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                final double fakeMeasure = ThreadLocalRandom.current().nextDouble(THRESHOLD - 10, THRESHOLD + 10);
                setLevel(fakeMeasure);
            }
        };
        timer.scheduleAtFixedRate(task , 0, 2000);
    }

    private void setLevel(double level) {
        this.level = level;
        if(this.level > THRESHOLD) dam.increaseSeismCount();
        dam.decreaseSeismCount();
    }

    public double getLevel() {
        return level;
    }

    @Override
    public void update(Integer seismCount) {
        if(seismCount >= 3) startAlertSound();
    }

    private void startAlertSound() {
        System.out.printf("[SSA Device - id = %d] Attention all workers, the dam is in high risk of collapse!\n", id);
    }
}
