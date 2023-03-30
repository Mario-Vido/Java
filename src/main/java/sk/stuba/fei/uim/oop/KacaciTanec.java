package sk.stuba.fei.uim.oop;

import java.util.Collections;

public class KacaciTanec extends Karty{

    public KacaciTanec() {
        this.name= "KacaciTance";
    }

    public void pouziKartuKacaciTanec(Hrac[] poleHracov, Inicializacia inicializacia, HraciePoleRybnik hraciePoleRybnik, int indexHracaNaTahu){
        hraciePoleRybnik.getKartyRybnik().addAll(hraciePoleRybnik.getHraciePoleRybnik());
        hraciePoleRybnik.getHraciePoleRybnik().removeAll(hraciePoleRybnik.getHraciePoleRybnik());
        Collections.shuffle(hraciePoleRybnik.getKartyRybnik());
        hraciePoleRybnik.setKartyRybnik(6,hraciePoleRybnik.getKartyRybnik());
        for (int i = 0; i < 3; i++) {
            if (poleHracov[indexHracaNaTahu].getKartyNaRuke().get(i).getName().equals(this.name)) {
                poleHracov[indexHracaNaTahu].vymazKartuSRukyHraca(i);
                inicializacia.akcneKarty.add(new KacaciTanec());
                poleHracov[indexHracaNaTahu].getKartyNaRuke().add(0,inicializacia.akcneKarty.get(0));
                inicializacia.odoberJednuKartuZAkcnychKariet();
                System.out.println("Hrac " + poleHracov[indexHracaNaTahu].getMeno() + " pouzil KacaciTanec");
                break;
            }
        }
    }
}
