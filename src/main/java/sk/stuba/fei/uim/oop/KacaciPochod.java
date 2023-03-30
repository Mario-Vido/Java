package sk.stuba.fei.uim.oop;

public class KacaciPochod extends Karty {
    public KacaciPochod() {
        this.name="KacaciPochod";
    }
    public void pouziKartuKacaciPochod(Hrac[] poleHracov, Inicializacia inicializacia, HraciePoleRybnik hraciePoleRybnik, int indexHracaNaTahu){
        if (hraciePoleRybnik.getHraciePoleRybnik().get(5) instanceof KartaKacky) {
            KartaKacky kacky = (KartaKacky) hraciePoleRybnik.getHraciePoleRybnik().get(5);
            hraciePoleRybnik.getHraciePoleRybnik().remove(5);
            hraciePoleRybnik.getKartyRybnik().add(new KartaKacky(kacky.getIndexUzivatela()));
            pridanieKartyDoRukyPoKacacomPochode(poleHracov, inicializacia, hraciePoleRybnik, indexHracaNaTahu);
        }
        else if (hraciePoleRybnik.getHraciePoleRybnik().get(5) instanceof Voda){
            hraciePoleRybnik.getHraciePoleRybnik().remove(5);
            hraciePoleRybnik.getKartyRybnik().add(new Voda());
            pridanieKartyDoRukyPoKacacomPochode(poleHracov, inicializacia, hraciePoleRybnik, indexHracaNaTahu);
        }
    }

    private void pridanieKartyDoRukyPoKacacomPochode(Hrac[] poleHracov, Inicializacia inicializacia, HraciePoleRybnik hraciePoleRybnik, int indexHracaNaTahu) {
        hraciePoleRybnik.getHraciePoleRybnik().add(0,hraciePoleRybnik.getKartyRybnik().get(0));
        hraciePoleRybnik.getKartyRybnik().remove(0);
        for (int i = 0; i < 3; i++) {
            if (poleHracov[indexHracaNaTahu].getKartyNaRuke().get(i).getName().equals(this.name)) {
                poleHracov[indexHracaNaTahu].vymazKartuSRukyHraca(i);
                inicializacia.akcneKarty.add(new KacaciPochod());
                poleHracov[indexHracaNaTahu].getKartyNaRuke().add(0,inicializacia.akcneKarty.get(0));
                inicializacia.odoberJednuKartuZAkcnychKariet();
                System.out.println("Hrac " + poleHracov[indexHracaNaTahu].getMeno() + " pouzil kartu KacaciPochod ");
                break;
            }
        }
    }
}
