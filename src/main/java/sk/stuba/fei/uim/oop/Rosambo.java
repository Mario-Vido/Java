package sk.stuba.fei.uim.oop;

import java.util.Collections;

public class Rosambo extends Karty {

    public Rosambo() {
        this.name="Rosambo";
    }

    public void pouziKartuRosambo(Hrac[] poleHracov, Inicializacia inicializacia, HraciePoleRybnik hraciePoleRybnik, int indexHracaNaTahu){
        Collections.shuffle(hraciePoleRybnik.getHraciePoleRybnik());
        for (int i = 0; i < 3; i++) {
            if (poleHracov[indexHracaNaTahu].getKartyNaRuke().get(i).getName().equals(this.name)) {
                poleHracov[indexHracaNaTahu].vymazKartuSRukyHraca(i);
                inicializacia.akcneKarty.add(new Rosambo());
                poleHracov[indexHracaNaTahu].getKartyNaRuke().add(0,inicializacia.akcneKarty.get(0));
                inicializacia.odoberJednuKartuZAkcnychKariet();
                System.out.println("Hrac " + poleHracov[indexHracaNaTahu].getMeno() + " pouzil Rosambo");
                break;
            }
        }
    }
}
