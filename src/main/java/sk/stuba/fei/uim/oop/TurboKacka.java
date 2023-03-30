package sk.stuba.fei.uim.oop;

public class TurboKacka extends Karty{
    public TurboKacka() {
        this.name="TurboKacka";
    }

    public void pouziKartuTurboKacka(int pozicia, Hrac[] poleHracov, Inicializacia inicializacia, HraciePoleRybnik hraciePoleRybnik, int indexHracaNaTahu){
        if (hraciePoleRybnik.getHraciePoleRybnik().get(pozicia) instanceof KartaKacky){
            KartaKacky kacky = (KartaKacky) hraciePoleRybnik.getHraciePoleRybnik().get(pozicia);
            hraciePoleRybnik.getHraciePoleRybnik().remove(pozicia);
            hraciePoleRybnik.getHraciePoleRybnik().add(5,new KartaKacky(kacky.getIndexUzivatela()));
            for (int i = 0; i < 3; i++) {
                if (poleHracov[indexHracaNaTahu].getKartyNaRuke().get(i).getName().equals(this.name)) {
                    poleHracov[indexHracaNaTahu].vymazKartuSRukyHraca(i);
                    inicializacia.akcneKarty.add(new TurboKacka());
                    poleHracov[indexHracaNaTahu].getKartyNaRuke().add(0,inicializacia.akcneKarty.get(0));
                    inicializacia.odoberJednuKartuZAkcnychKariet();
                    System.out.println("Hrac " + poleHracov[indexHracaNaTahu].getMeno() + " pouzil TurboKacku na poziciu " + (pozicia+1) );
                    break;
                }
            }
        }
    }
}
