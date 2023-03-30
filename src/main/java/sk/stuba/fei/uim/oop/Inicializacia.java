package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Collections;

public class Inicializacia {
    public ArrayList<Karty> akcneKarty;
    public ArrayList<Karty> balicekVodyKacky;
    private int pocetHracov;

    public Inicializacia(int pocetHracov){
        this.pocetHracov = pocetHracov;
        this.akcneKarty = this.inicializaciaKarty();
        this.balicekVodyKacky = this.inicializaciaVodyKacky();

    }

    private ArrayList<Karty> inicializaciaKarty(){
        ArrayList<Karty> akcneKarty = new ArrayList<>();
        for (int i=0; i<10;i++){
            akcneKarty.add(new Zamierit());
        }
        for (int i=0; i<12;i++){
            akcneKarty.add(new Vystrelit());
        }
        for (int i=0; i<1;i++){
            akcneKarty.add(new TurboKacka());
        }
        for (int i=0; i<2;i++){
            akcneKarty.add(new Rosambo());
        }
        for (int i=0; i<1;i++){
            akcneKarty.add(new KacaciTanec());
        }
        for (int i=0; i<6;i++){
            akcneKarty.add(new KacaciPochod());
        }
        for (int i=0; i<2;i++){
            akcneKarty.add(new DivokyBill());
        }
        Collections.shuffle(akcneKarty);
        return akcneKarty;
    }

    private ArrayList<Karty> inicializaciaVodyKacky(){
        ArrayList<Karty> balicekVodyKacky = new ArrayList<>();
        for (int i=0; i<5;i++){
            balicekVodyKacky.add(new Voda());
        }
        for (int i=0; i< pocetHracov ;i++){
            for (int j=0; j<5;j++){
                balicekVodyKacky.add(new KartaKacky(i+1));

            }
        }
        Collections.shuffle(balicekVodyKacky);
        return  balicekVodyKacky;
    }

    public void odoberKartyZAkcnychKariet(){
        for (int j = 0; j < 3; j++) {
            akcneKarty.remove(0);
        }
    }
    public void odoberJednuKartuZAkcnychKariet(){
        akcneKarty.remove(0);
    }

    public void pridajKartyHracaDoAkcnychKariet(Hrac[] poleHracov,int idexHraca){
        for (int i=0;i<3;i++){
            akcneKarty.add(poleHracov[idexHraca].getKartyNaRuke().get(i));
        }
    }

}
