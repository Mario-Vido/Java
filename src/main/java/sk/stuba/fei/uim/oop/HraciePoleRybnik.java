package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class HraciePoleRybnik extends Karty {
    private ArrayList<Karty> kartyRybnik;
    private ArrayList<Karty> hraciePoleRybnik;


    public HraciePoleRybnik() {
      this.kartyRybnik= null;
      this.kartyRybnik = this.inicializaciaRybnika();
    }

    private ArrayList<Karty> inicializaciaRybnika(){

        return new ArrayList<>();
    }

    public ArrayList<Karty> getKartyRybnik() {
        return kartyRybnik;
    }

    public ArrayList<Karty> getHraciePoleRybnik() {
        return hraciePoleRybnik;
    }

    public void setKartyRybnik(int velkostPola, ArrayList<Karty> kartyRybnik) {
        ArrayList<Karty> hraciePoleRybnik = new ArrayList<>();
        for (int j=0; j < velkostPola;j++){
            hraciePoleRybnik.add(kartyRybnik.get(j));
        }
        this.kartyRybnik = kartyRybnik;
        this.hraciePoleRybnik = hraciePoleRybnik;
        for (int i=0;i<velkostPola;i++) {
            kartyRybnik.remove(0);
        }
    }

    public void vypisPole(int i) {

            if (hraciePoleRybnik.get(i) instanceof KartaKacky) {
                KartaKacky kacky = (KartaKacky) hraciePoleRybnik.get(i);
                System.out.println("Kacka hraca " + kacky.getIndexUzivatela());
            }
            else if (hraciePoleRybnik.get(i) instanceof Voda){
                Voda voda = (Voda) hraciePoleRybnik.get(i);
                System.out.println("Voda");
            }


    }
}
