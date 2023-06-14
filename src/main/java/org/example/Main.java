package org.example;

public class Main {
    public static void main(String[] args) {
        final Dam dam = new Dam("Brumadinho");

        dam.subscribe(new Ssa(1, dam, 300));
        dam.subscribe(new Ssa(2, dam, 300));
        dam.subscribe(new Ssa(3, dam, 300));
        dam.subscribe(new Ssa(4, dam, 300));
        dam.subscribe(new Ssa(5, dam, 300));

        dam.subscribe(new Ss(6, dam));
        dam.subscribe(new Ss(7, dam));
        dam.subscribe(new Ss(8, dam));
        dam.subscribe(new Ss(9, dam));
        dam.subscribe(new Ss(10, dam));

        dam.subscribe(new Ac(11));
        dam.subscribe(new Ac(12));
        dam.subscribe(new Ac(13));
        dam.subscribe(new Ac(14));
    }
}