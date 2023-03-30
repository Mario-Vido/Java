package sk.stuba.fei.uim.oop;

public class Vystrelit extends Karty{

    public Vystrelit() {
        this.name="Vystrelit";
    }
    public void pouzuKartuVystrelit(int pozicia, HraciePoleZamierit hraciePoleZamierit, Hrac[] poleHracov, Inicializacia inicializacia, HraciePoleRybnik hraciePoleRybnik, int indexHracaNaTahu){
        if (hraciePoleRybnik.getHraciePoleRybnik().get(pozicia) instanceof KartaKacky){
            KartaKacky kacky = (KartaKacky) hraciePoleRybnik.getHraciePoleRybnik().get(pozicia);
            System.out.println("Hrac " + poleHracov[indexHracaNaTahu].getMeno() + " zostrelil kacku hraca " + (kacky.getIndexUzivatela()));
            poleHracov[(kacky.getIndexUzivatela() - 1)].setZivoty(1);
            System.out.println("Hrac " + poleHracov[(kacky.getIndexUzivatela())-1].getMeno() + " ma " + poleHracov[kacky.getIndexUzivatela()-1].getZivoty() + " zivotov\n");
        }
        if (hraciePoleZamierit.getHraciePoleZamieritHodnotaPrvku(pozicia)){
            hraciePoleZamierit.setZamieritNaFalse(pozicia);
        }

        for (int i = 0; i < 3; i++) {
            if (poleHracov[indexHracaNaTahu].getKartyNaRuke().get(i).getName().equals(this.name)) {
                poleHracov[indexHracaNaTahu].vymazKartuSRukyHraca(i);
                inicializacia.akcneKarty.add(new Vystrelit());
                poleHracov[indexHracaNaTahu].getKartyNaRuke().add(0,inicializacia.akcneKarty.get(0));
                inicializacia.odoberJednuKartuZAkcnychKariet();
                hraciePoleRybnik.getHraciePoleRybnik().remove(pozicia);
                hraciePoleRybnik.getHraciePoleRybnik().add(0,hraciePoleRybnik.getKartyRybnik().get(0));
                hraciePoleRybnik.getKartyRybnik().remove(0);
                break;

            }
        }
    }
    public void zlePouzitieKartyVystrelit(Hrac[] poleHracov,int indexHracaNaTahu, Inicializacia inicializacia) {
        for (int i=0;i<3;i++) {
            if (poleHracov[indexHracaNaTahu].getKartyNaRuke().get(i).getName().equals(this.name)) {
                poleHracov[indexHracaNaTahu].vymazKartuSRukyHraca(i);
                inicializacia.akcneKarty.add(new Vystrelit());
                poleHracov[indexHracaNaTahu].getKartyNaRuke().add(0, inicializacia.akcneKarty.get(0));
                inicializacia.odoberKartyZAkcnychKariet();
                break;
            }
        }

    }

}
