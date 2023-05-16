package japanlegendak.rokantunder;

import exception.NemIgazSzerelemException;

import java.util.ArrayList;
import java.util.Random;

public class Legenda {
    private Rokatunder rokantunder;
    private ArrayList<Ferfi> udvarlok;
    private Ferfi igazSzerelem;

    public static void main(String[] args) {
        /*
        Kiss Eugén:2847278
        Ady Endre:202020
        M. Tóth Károly:101516
         */

        ArrayList<Ferfi> ferfiak = new ArrayList<>();
        ferfiak.add(new Ferfi("Kiss Eugén", 2847278));
        ferfiak.add(new Ferfi("Ady Endre", 202020));
        ferfiak.add(new Ferfi("M. Tóth Károly", 101516));
        Rokatunder rokatunder = new Rokatunder(2847278, false);
        Legenda legenda = new Legenda(rokatunder, ferfiak);
        legenda.tortenet();
    }

    public Legenda(Rokatunder rokantunder, ArrayList<Ferfi> udvarlok) {
        this.rokantunder = rokantunder;
        this.udvarlok = udvarlok;
        igazSzerelem = null;
    }

    public Legenda() {
        rokantunder = null;
        udvarlok = new ArrayList<>();
        igazSzerelem = null;
    }

    public void tortenet() {
        double esely = 0.7;
        Random random = new Random();
        double valoszinuseg = random.nextDouble();
        for (int i = 0; i <= udvarlok.size(); i++) {
            if (valoszinuseg <= esely) {
                udvarol(udvarlok.get(i)); // udvarlok.get(i) kellene de ahhoz az udvarol metódusnak egy férfi paraméter kéne nem egy lista de akkor nem tudom törölni a listából...
            } else {
                System.out.println("Nem udvarol");
            }

        }
    }
/*    public void udvarol(Ferfi szerelem){
        NemIgazSzerelemException ex = new NemIgazSzerelemException();
        if(rokantunder.igazSzerelme(szerelem) == true) {
            szerelem.igazSzerelme(rokantunder);
        } else {

            System.out.println("Sajnos ez nem igaz szerelem " + ex);
        }
    }*/

    public void udvarol(Ferfi ferfi) {
        boolean vanSzerelme = true;
        NemIgazSzerelemException ex = new NemIgazSzerelemException();
        for (int i = 0; i < udvarlok.size() - 1; i++) {
            if (udvarlok.get(i).igazSzerelme(rokantunder) == true) {
                udvarlok.get(i).igazSzerelme(rokantunder);
                vanSzerelme = true;
            } else {
                rokantunder.aldozatNovel();
                //szerelem.remove(udvarlok.get(i));
                System.out.println("Sajnos ez nem igaz szerelem " + ex);
                vanSzerelme = false;
            }
        }
        /*for (Ferfi udvarlo : udvarlok) {
            if (udvarlo.igazSzerelme(rokantunder) == true) {
                udvarlo.igazSzerelme(rokantunder);
                vanSzerelme = true;
            }
            else {
                rokantunder.aldozatNovel();
                szerelem.remove(udvarlo);
                System.out.println("Sajnos ez nem igaz szerelem " + ex);
                vanSzerelme = false;
            }
        }*/
        if (vanSzerelme) {
            System.out.println("A rókatündér megtalálta a szerelmet");
        } else {
            System.out.println("A rókatündér nem talált szerelmet");
        }
    }
}
