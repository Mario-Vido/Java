package sk.stuba.fei.uim.oop;



public class HraciePoleZamierit {
    private final boolean[] hraciePoleZamierit = new boolean[6];

    public HraciePoleZamierit() {

       this.inicializaciaZamierit();
    }

    private void inicializaciaZamierit(){
        for (int i=0;i<6;i++){
           hraciePoleZamierit[i]=false;
        }
    }

    public void vypisPole(int i){
        if (!hraciePoleZamierit[i]){
            System.out.print("Nezamierene " + (i+1) + " - ");
        }
        else if (hraciePoleZamierit[i]){
            System.out.print("Zamierene " + (i+1) + " - ");
        }
    }

    public boolean getHraciePoleZamieritHodnotaPrvku(int i) {
        return this.hraciePoleZamierit[i];
    }

    public void setZamieritNaTrue(int index){
        this.hraciePoleZamierit[index]=true;
    }

    public void setZamieritNaFalse(int index){
        this.hraciePoleZamierit[index]=false;
    }

    public int zistiKolkoPolicokJeZamierenych(){
        int pocetZamierenzchPolicok = 0;
        for(int i = 0; i<6; i++)
        if (hraciePoleZamierit[i]){
            pocetZamierenzchPolicok++;
            }

        return pocetZamierenzchPolicok;}

}
