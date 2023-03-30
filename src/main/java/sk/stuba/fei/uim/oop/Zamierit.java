package sk.stuba.fei.uim.oop;

public class Zamierit extends Karty{
    public Zamierit() {
        this.name="Zamierit";
    }
    public void pouziKartuZamierit(int pozicia, HraciePoleZamierit hraciePoleZamierit, Hrac[] poleHracov, Inicializacia inicializacia, int indexHracaNaTahu){
        hraciePoleZamierit.setZamieritNaTrue(pozicia);
        inicializacia.akcneKarty.add(new Zamierit());
        for (int i = 0; i < 3; i++) {
            if (poleHracov[indexHracaNaTahu].getKartyNaRuke().get(i).getName().equals(this.name)) {
                poleHracov[indexHracaNaTahu].vymazKartuSRukyHraca(i);
                poleHracov[indexHracaNaTahu].getKartyNaRuke().add(0,inicializacia.akcneKarty.get(0));
                inicializacia.odoberJednuKartuZAkcnychKariet();
                System.out.println("Hrac " + poleHracov[indexHracaNaTahu].getMeno() + " zamieril na policko " + (pozicia+1) );
                break;
            }
        }
    }

    public void zlePouzitieKartyZamierit(Hrac[] poleHracov,int indexHracaNaTahu, Inicializacia inicializacia){
        for (int i=0;i<3;i++){
            if (poleHracov[indexHracaNaTahu].getKartyNaRuke().get(i).getName().equals(this.name)){
                poleHracov[indexHracaNaTahu].vymazKartuSRukyHraca(i);
                inicializacia.akcneKarty.add(new Zamierit());
                poleHracov[indexHracaNaTahu].getKartyNaRuke().add(0, inicializacia.akcneKarty.get(0));
                inicializacia.odoberJednuKartuZAkcnychKariet();
                break;
            }
        }
    }
}
