package japanlegendak.rokantunder;

public class Rokatunder implements Ember {

    private int szerelemkod;
    private int aldozatokSzama;
    private boolean elkeseredett;

    public Rokatunder(int szerelemkod, boolean elkeseredett) {
        this.szerelemkod = szerelemkod;
        this.elkeseredett = elkeseredett;
        aldozatokSzama = 0;
    }

    public Rokatunder() {
    }

    public void aldozatNovel() {
        if (aldozatokSzama >= 10) {
            elkeseredett = true;
        }
        aldozatokSzama++;
    }

    public int getSzerelemkod() {
        return szerelemkod;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean igazSzerelme(Ember ember) {
        if (elkeseredett == true || ember.equals(szerelemkod)) {
            return true;
        }
        return false;
    }
}
