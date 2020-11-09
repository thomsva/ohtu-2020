package ohtu.verkkokauppa;

public class Pankki implements PankkiInterface {

    private KirjanpitoInterface kirjanpito;

    public Pankki(KirjanpitoInterface kp) {
        kirjanpito = kp;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililt√§ " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // t‰‰ll‰ olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
