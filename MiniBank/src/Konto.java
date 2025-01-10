import java.util.ArrayList;

public class Konto {
    String personNr;
    int pinKod;
    int lonKontoNummerStart=1000;
    int sparKontoNummerStart=5000;
    static int sparKontoNr;
    static int lonKontoNr;
    static double lonSaldo;
    static double sparSaldo;



    public Konto(String personNr, int pinKod) {
        this.personNr=personNr;
        this.pinKod=pinKod;
        lonKontoNr=lonKontoNummerStart++;
        lonSaldo=1000.0;
        sparKontoNr = sparKontoNummerStart++;
        sparSaldo = 1000.0;
        System.out.println("Lönekonto "+lonKontoNr+" skapat.");
        System.out.println("Sparkonto "+sparKontoNr+" skapat.");
    }

    public static double getLonSaldo() {
        return lonSaldo;
    }

    public static double getSparSaldo() {
        return sparSaldo;
    }

    public static int getLonKontoNr() {
        return lonKontoNr;
    }

    public static int getSparKontoNr() {
        return sparKontoNr;
    }

    public int getPinKod() {
        return pinKod;
    }

    public String getPersonNr() {
        return personNr;
    }

    public void depositLon(double amount) {
        lonSaldo += amount;
        System.out.println("Insättning av " + amount + " på lönekontot lyckades.");
    }

    public void withdrawLon(double amount) {
        lonSaldo -= amount;
        System.out.println("Uttag av " + amount + " från lönekontot lyckades.");
    }

    public void depositSpar(double amount) {
        sparSaldo += amount;
        System.out.println("Insättning av " + amount + " på sparkontot lyckades.");
    }

    public void withdrawSpar(double amount) {
        sparSaldo -= amount;
        System.out.println("Uttag av " + amount + " från sparkontot lyckades.");
    }

}
