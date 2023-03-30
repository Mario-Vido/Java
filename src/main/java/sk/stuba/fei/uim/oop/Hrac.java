package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Hrac {
    private final String meno;
    private int zivoty;
    private ArrayList<Karty> kartyNaRuke = new ArrayList<>();

    public Hrac(String meno, int zivoty) {
        this.meno = meno;
        this.zivoty = zivoty;

    }
    public String getMeno() {
        return meno;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivotDole) {
        this.zivoty = zivoty-zivotDole;
    }

    public ArrayList<Karty> getKartyNaRuke() {
        return kartyNaRuke;
    }

    public void vymazKartuSRukyHraca(int poziciaKarty){
        kartyNaRuke.remove(poziciaKarty);

    }

    public void vypisKartyNaRukeHraca(){
        for (int i=0;i<3;i++) {
            if (kartyNaRuke.get(i) instanceof Zamierit) {
                System.out.print("Zamierit, ");
            } else if (kartyNaRuke.get(i) instanceof Vystrelit) {
                System.out.print("Vystrelit, ");
            } else if (kartyNaRuke.get(i) instanceof TurboKacka) {
                System.out.print("TurboKacka, ");
            } else if (kartyNaRuke.get(i) instanceof Rosambo) {
                System.out.print("Rosambo, ");
            } else if (kartyNaRuke.get(i) instanceof KacaciTanec) {
                System.out.print("KacaciTanec, ");
            } else if (kartyNaRuke.get(i) instanceof KacaciPochod) {
                System.out.print("KacaciPochod, ");
            } else if (kartyNaRuke.get(i) instanceof DivokyBill) {
                System.out.print("DivokyBill, ");
            }
        }
    }

    public void pridajTriKartyNaRukuHraca(ArrayList<Karty> akcneKarty) {
        ArrayList<Karty> kartyNaRuke = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            kartyNaRuke.add(i, akcneKarty.get(i));
            this.kartyNaRuke = kartyNaRuke;
        }
    }

    public void odstranKartySRuky(){
        for (int i=0;i<3;i++){
            kartyNaRuke.remove(i);
        }
    }

}
