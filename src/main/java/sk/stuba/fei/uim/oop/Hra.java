package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Hra extends Karty {
    static int pomocna = 0;


    public Hra() {
        System.out.println("Vitajte v hre strelene kacky");
        while (pomocna == 0) {
            int pocetHracov = ZKlavesnice.readInt("Zadaj pocet hracov od 2-6");
            if (pocetHracov > 1 && pocetHracov < 6) {
                Hrac[] poleHracov = new Hrac[pocetHracov];
                for (int i = 0; i < pocetHracov; i++) {
                    poleHracov[i] = new Hrac(ZKlavesnice.readString("Hrac " + (i + 1) + " meno:"), 5);
                }

                Inicializacia inicializacia = new Inicializacia(pocetHracov);
                HraciePoleRybnik hraciePoleRybnik = new HraciePoleRybnik();
                HraciePoleZamierit hraciePoleZamierit = new HraciePoleZamierit();
                PouzitieAkcnychKariet pouzitieAkcnychKariet = new PouzitieAkcnychKariet();
                Zamierit zamierit = new Zamierit();
                Vystrelit vystrelit = new Vystrelit();
                DivokyBill divokyBill = new DivokyBill();
                KacaciPochod kacaciPochod = new KacaciPochod();
                TurboKacka turboKacka = new TurboKacka();
                Rosambo rosambo = new Rosambo();
                KacaciTanec kacaciTanec = new KacaciTanec();
                hraciePoleRybnik.setKartyRybnik(6, inicializacia.balicekVodyKacky);

                int pocetHracovVhre = pocetHracov;
                int indexPoslednehoHraca = 0;
                String kartaNaZahratie="pomocna";


                while (pocetHracovVhre > 1) {
                    pocetHracovVhre = 0;
                    System.out.println(" ");
                    vypisHraciePole(hraciePoleZamierit, hraciePoleRybnik);
                    for (int indexHraca = 0; indexHraca < pocetHracov; indexHraca++) {
                        if (poleHracov[indexHraca].getZivoty() > 0) {
                            int pocet_Kariet_Vystrel = 0;
                            int pocet_Zamierenych_poli=0;
                            System.out.println(" ");
                            System.out.println("Hrac menom " + poleHracov[indexHraca].getMeno() + " ma " + poleHracov[indexHraca].getZivoty() + " zivotov a na ruke ma karty");
                            if (poleHracov[indexHraca].getKartyNaRuke().size() == 3) {
                                poleHracov[indexHraca].vypisKartyNaRukeHraca();
                            } else if (poleHracov[indexHraca].getKartyNaRuke().size() < 3) {
                                poleHracov[indexHraca].pridajTriKartyNaRukuHraca(inicializacia.akcneKarty);
                                poleHracov[indexHraca].vypisKartyNaRukeHraca();
                                inicializacia.odoberKartyZAkcnychKariet();// Odoberie 3 karty kore sme pridali hracovi do ruky
                            }
                            System.out.println(" ");
                            for(int i=0;i<3;i++){  //sluzi na scitanie kariet vystrelu na ruke
                                if (poleHracov[indexHraca].getKartyNaRuke().get(i).getName().equals(vystrelit.getName())) {
                                    pocet_Kariet_Vystrel++;
                                }
                            }
                            for(int i=0;i<6;i++){ // sluzi scitanie zameranych poli
                                if (hraciePoleZamierit.getHraciePoleZamieritHodnotaPrvku(i)){
                                    pocet_Zamierenych_poli++;
                                }
                            }
                            if (pocet_Kariet_Vystrel!=3 || pocet_Zamierenych_poli>=1 ) {
                                while (pomocna == 0) {
                                    kartaNaZahratie = ZKlavesnice.readString("Hrac " + poleHracov[indexHraca].getMeno() + " ktoru kratu chcete pouzit? Napiste meno karty");
                                    if (kartaNaZahratie.equals("Vystrelit") || kartaNaZahratie.equals("Zamierit") || kartaNaZahratie.equals("TurboKacka") || kartaNaZahratie.equals("Rosambo") || kartaNaZahratie.equals("KacaciTanec") || kartaNaZahratie.equals("KacaciPochod") || kartaNaZahratie.equals("DivokyBill")) {
                                        zistiCiKartaSaNachadzaNaRuke(kartaNaZahratie, poleHracov, indexHraca, vystrelit, zamierit, turboKacka, rosambo, kacaciTanec, kacaciPochod, divokyBill);
                                    } else {
                                        System.out.println("Spravili ste chybu v slove,skuste znova");
                                    }
                                }
                                pomocna--;
                                pouzitieAkcnychKariet.pouzitKartu(kartaNaZahratie, hraciePoleZamierit, poleHracov, inicializacia, hraciePoleRybnik, indexHraca, zamierit, vystrelit, divokyBill, kacaciPochod, turboKacka, rosambo, kacaciTanec);
                                vypisHraciePole(hraciePoleZamierit, hraciePoleRybnik);
                            } else if (pocet_Kariet_Vystrel==3 && pocet_Zamierenych_poli==0) { //vykona sa vtedy ak mam na ruke 3 karty vystrel a 0 zameranuch policok
                                hracDostaneNovuKartu(poleHracov,indexHraca,inicializacia);
                            }
                        } else {
                            System.out.println("Hrac " + poleHracov[indexHraca].getMeno() + " prehral hru");
                            inicializacia.pridajKartyHracaDoAkcnychKariet(poleHracov,indexHraca);
                            poleHracov[indexHraca].odstranKartySRuky();
                        }
                    }
                    for (int indexHraca = 0; indexHraca < pocetHracov; indexHraca++)
                        if (poleHracov[indexHraca].getZivoty() > 0) {
                            System.out.println("V hre sa nachadza " + poleHracov[indexHraca].getMeno() + " s " + poleHracov[indexHraca].getZivoty() + " zivotami");
                            indexPoslednehoHraca=indexHraca;
                            pocetHracovVhre++;

                        }
                    if (pocetHracovVhre == 1) {
                        System.out.println("Vyhral hrac " + poleHracov[indexPoslednehoHraca].getMeno());
                        pomocna++;
                    }
                }
            }else {
                System.out.println("Zadali ste nespravne cislo");
            }
        }
    }
    public void vypisHraciePole(HraciePoleZamierit HraciePoleZamierit, HraciePoleRybnik HraciePoleRybnik){
        for (int i = 0;i<6;i++) {
            HraciePoleZamierit.vypisPole(i);
            HraciePoleRybnik.vypisPole(i);

        }
    }

    private void zistiCiKartaSaNachadzaNaRuke(String kartaNaZahratie, Hrac[] poleHracov, int indexHraca,Vystrelit vystrelit,
                                              Zamierit zamierit,TurboKacka turboKacka,Rosambo rosambo,KacaciTanec kacaciTanec,KacaciPochod kacaciPochod,DivokyBill divokyBill){
        if (kartaNaZahratie.equals("Vystrelit")) {
            prejdenieTrcohKarietNaRuke(poleHracov, indexHraca, vystrelit.getName());
        } else if (kartaNaZahratie.equals("Zamierit")){
            prejdenieTrcohKarietNaRuke(poleHracov, indexHraca, zamierit.getName());
        }else if (kartaNaZahratie.equals("TurboKacka")){
            prejdenieTrcohKarietNaRuke(poleHracov, indexHraca, turboKacka.getName());
        }else if (kartaNaZahratie.equals("Rosambo")){
            prejdenieTrcohKarietNaRuke(poleHracov, indexHraca, rosambo.getName());
        }else if (kartaNaZahratie.equals("KacaciTanec")){
            prejdenieTrcohKarietNaRuke(poleHracov, indexHraca, kacaciTanec.getName());
        }else if (kartaNaZahratie.equals("KacaciPochod")){
            prejdenieTrcohKarietNaRuke(poleHracov, indexHraca, kacaciPochod.getName());
        }else if (kartaNaZahratie.equals("DivokyBill")){
            prejdenieTrcohKarietNaRuke(poleHracov, indexHraca, divokyBill.getName());
        }
    }

    private void prejdenieTrcohKarietNaRuke(Hrac[] poleHracov, int indexHraca, String name) {
        for (int i = 0; i < 3; i++) {
            if (poleHracov[indexHraca].getKartyNaRuke().get(i).getName().equals(name)) {
                pomocna++;
                break;
            }
        }
        if (pomocna==0){
            System.out.println("Vybrali ste kartu ktoru nemate na ruke");
        }
    }

    private void hracDostaneNovuKartu(Hrac[] poleHracov,int indexHraca,Inicializacia inicializacia){
        poleHracov[indexHraca].getKartyNaRuke().remove(0);
        poleHracov[indexHraca].getKartyNaRuke().add(0,inicializacia.akcneKarty.get(0));
        inicializacia.odoberJednuKartuZAkcnychKariet();
        inicializacia.akcneKarty.add(new Vystrelit());
        System.out.println("Mas na ruke tri karty Vystrel a ani jednu nevies zahrat. Dostavas novu kartu");
    }
}
