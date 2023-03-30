package sk.stuba.fei.uim.oop;


import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class PouzitieAkcnychKariet {

    public PouzitieAkcnychKariet() {

    }

    public void pouzitKartu(String kartaNaPouzitie, HraciePoleZamierit hraciePoleZamierit, Hrac[] poleHracov, Inicializacia inicializacia, HraciePoleRybnik hraciePoleRybnik,
                            int indexHracaNaTahu, Zamierit zamierit,Vystrelit vystrelit,DivokyBill divokyBill,KacaciPochod kacaciPochod,TurboKacka turboKacka,Rosambo rosambo,KacaciTanec kacaciTanec) {
        int pozicia =0;
        int pomocna=0;
        if (kartaNaPouzitie.equals("Rosambo") || kartaNaPouzitie.equals("KacaciPochod") || kartaNaPouzitie.equals("KacaciTanec")) {
        } else {
            while (pomocna == 0) {
                int poziciaZadanaHracom = ZKlavesnice.readInt("Napiste na ktoru poziciu chcete pouzit ");
                if (poziciaZadanaHracom >= 1 && poziciaZadanaHracom <= 6) {
                    pozicia = poziciaZadanaHracom - 1;
                    pomocna++;
                } else {
                    System.out.println("Zadal si nespravne cislo, zadaj cislo v rozmedzi od 1-6");
                }
            }
        }
        if (kartaNaPouzitie.equals("Zamierit") && !hraciePoleZamierit.getHraciePoleZamieritHodnotaPrvku(pozicia)) {
            zamierit.pouziKartuZamierit(pozicia, hraciePoleZamierit, poleHracov, inicializacia, indexHracaNaTahu);
        } else if (kartaNaPouzitie.equals("Vystrelit") && hraciePoleZamierit.getHraciePoleZamieritHodnotaPrvku(pozicia)) {
            vystrelit.pouzuKartuVystrelit(pozicia, hraciePoleZamierit, poleHracov, inicializacia, hraciePoleRybnik, indexHracaNaTahu);
        } else if (kartaNaPouzitie.equals("DivokyBill")) {
            divokyBill.pouziKartuDivokyBill(pozicia, hraciePoleZamierit, poleHracov, inicializacia, hraciePoleRybnik, indexHracaNaTahu);
        } else if (kartaNaPouzitie.equals("KacaciPochod")) {
            kacaciPochod.pouziKartuKacaciPochod(poleHracov, inicializacia, hraciePoleRybnik, indexHracaNaTahu);
        } else if (kartaNaPouzitie.equals("TurboKacka")) {
            turboKacka.pouziKartuTurboKacka(pozicia, poleHracov, inicializacia, hraciePoleRybnik, indexHracaNaTahu);
        } else if (kartaNaPouzitie.equals("Rosambo")) {
            rosambo.pouziKartuRosambo(poleHracov, inicializacia, hraciePoleRybnik, indexHracaNaTahu);
        } else if (kartaNaPouzitie.equals("KacaciTanec")) {
            kacaciTanec.pouziKartuKacaciTanec(poleHracov, inicializacia, hraciePoleRybnik, indexHracaNaTahu);
        } else {
            System.out.println("Zahral si " + kartaNaPouzitie + " nespravne, pouzita karta sa vracia do akcneho balika a dostavas novu akcnu kartu");
            if (kartaNaPouzitie.equals("Zamierit")) {
                zamierit.zlePouzitieKartyZamierit(poleHracov, indexHracaNaTahu, inicializacia);
            } else if (kartaNaPouzitie.equals("Vystrelit")) {
                vystrelit.zlePouzitieKartyVystrelit(poleHracov, indexHracaNaTahu, inicializacia);
            }
        }
    }
}


