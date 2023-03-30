package sk.stuba.fei.uim.oop;

public class KartaKacky extends Karty{
    private int indexUzivatela;

    public KartaKacky(int indexUzivatela) {
        this.indexUzivatela = indexUzivatela;
        this.name = "KartaKacky";
    }

    public int getIndexUzivatela() {
        return this.indexUzivatela;
    }

}
