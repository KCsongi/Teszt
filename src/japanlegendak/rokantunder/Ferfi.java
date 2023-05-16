package japanlegendak.rokantunder;

public class Ferfi implements Ember {

    private String nev;
    private int szerelemkod;

    public Ferfi(String nev, int szerelemkod) {
        this.nev = nev;
        this.szerelemkod = szerelemkod;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getSzerelemkod() {
        return szerelemkod;
    }

    public void setSzerelemkod(int szerelemkod) {
        this.szerelemkod = szerelemkod;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean igazSzerelme(Ember ember) {
        if (ember.equals(szerelemkod)) {
            return true;
        }
        return false;
    }
}
