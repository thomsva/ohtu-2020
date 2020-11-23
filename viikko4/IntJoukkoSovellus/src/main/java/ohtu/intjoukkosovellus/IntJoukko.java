package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustaulukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    private int kasvatuskoko;     // Uusi taulukko on t‰m‰n verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut s‰ilytet‰‰n taulukon alkup‰‰ss‰. 
    private int lukumaara;    // Tyhj‰ss‰ joukossa alkioiden m‰‰r‰ on nolla. 

    public IntJoukko() {
        luvut = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        luvut = new int[kapasiteetti];
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti v‰‰rin");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko v‰‰rin");
        }
        luvut = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (lukumaara == 0) {
            luvut[0] = luku;
            lukumaara++;
            return true;
        }
        if (!kuuluu(luku)) {
            luvut[lukumaara] = luku;
            lukumaara++;
            if (lukumaara == luvut.length) {
                //kasvatetaan taulukkoa
                this.kasvata();
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        boolean loytyi = false;
        for (int i = 0; i < lukumaara; i++) {
            if (luku == luvut[i]) {
                loytyi = true;
            }
        }
        return loytyi;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        for (int i = 0; i < lukumaara; i++) {
            if (luku == luvut[i]) {
                kohta = i; //luku lˆytyy tuosta kohdasta
                luvut[kohta] = 0;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < lukumaara - 1; j++) {
                int alkio = luvut[j];
                luvut[j] = luvut[j + 1];
            }
            lukumaara--;
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int getLukumaara() {
        return lukumaara;
    }

    @Override
    public String toString() {
        if (lukumaara == 0) {
            return "{}";
        } else if (lukumaara == 1) {
            return "{" + luvut[0] + "}";
        } else {
            String tuloste = "{";
            for (int i = 0; i < lukumaara - 1; i++) {
                tuloste += luvut[i];
                tuloste += ", ";
            }
            tuloste += luvut[lukumaara - 1];
            tuloste += "}";
            return tuloste;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[lukumaara];
        System.arraycopy(luvut, 0, taulu, 0, taulu.length);
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko result = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            result.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            result.lisaa(bTaulu[i]);
        }
        return result;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko result = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    result.lisaa(bTaulu[j]);
                }
            }
        }
        return result;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko result = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            result.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            result.poista(bTaulu[i]);
        }
        return result;
    }

    private void kasvata() {
        int[] taulukkoOld;
        taulukkoOld = luvut;
        kopioiTaulukko(luvut, taulukkoOld);
        luvut = new int[lukumaara + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, luvut);
    }

}
