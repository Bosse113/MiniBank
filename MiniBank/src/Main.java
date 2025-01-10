import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanIn = new Scanner(System.in);
    public static void main(String[] args) {
boolean meny1=true;


/**
 * Meny 1 huvudmeny
 */
        while (meny1==true) {
            System.out.println("1. Skapa ny användare");
            System.out.println("2. Logga in.");
            System.out.println("3. Avsluta");
            System.out.print("Välj ett alternativ: ");
            int menyVal = scanIn.nextInt();

            switch (menyVal){
                case 1:
                    //skapa användare lön- och sparkonto
                    skapaKonto();
                    break;
                case 2:
                    //logga in
                    if(login()==true){
                        doBankStuff();
                    };
                    break;
                case 3:
                    meny1=false;
                    System.exit(0); //avslutar med status 0=OK (kanske redundant??)
                    break;
            }
        }


    }
    public static void skapaKonto(){
        scanIn.nextLine();//tömmer buffert.
        System.out.println("Skriv in ditt personnummer (XXXXXX-XXXX)");
        String nummer= scanIn.nextLine();
        System.out.println("Skriv in önskad pinkod (4 siffror)");
        int pinKoden=scanIn.nextInt();
        Konto kund1=MiniBank.openAccount(nummer,pinKoden);
    }

    /**
     * Lägg till koll mot arraylist konton.
     */
    static boolean login(){
        boolean svaret=false;
        scanIn.nextLine();
        System.out.println("*****Inloggning******");
        System.out.println("Skriv in ditt personnummer:");
        String name = scanIn.nextLine();

        System.out.println("Skriv in din pinkod:");
        int password = scanIn.nextInt();

        if(Objects.equals(name, "123456-1234") && Objects.equals(password, 1234)){
            System.out.println("Du är inloggad.");
            svaret=true;
        }
        return svaret;
    }

    /**
     * Meny2 meny om du är inloggad
     */
    static void doBankStuff(){
        boolean meny2=true;
        while (meny2==true) {

            System.out.println("1. Visa mina konton (visa kontonummer och saldo) ");
            System.out.println("2. Gör överföring .");
            System.out.println("3. Logga ut (gå tillbaka till huvudmenyn)");
            System.out.print("Välj ett alternativ: ");
            int menyVal = scanIn.nextInt();

            switch (menyVal){
                case 1:
                    //skapa användare lön- och sparkonto
                    MiniBank.printReport();
                    break;
                case 2:
                    //överföringar
                    System.out.println("Välj konto att ta ut från: ("+ Konto.lonKontoNr+" eller "+ Konto.getSparKontoNr()+")");
                    int kontoFrom=scanIn.nextInt();
                    System.out.println("Välj konto att sätta in på: ("+ Konto.lonKontoNr+" eller "+ Konto.getSparKontoNr()+")");
                    int kontoTill=scanIn.nextInt();
                    System.out.println("Skriv in beloppet du vill föra över:");
                    double belopp=scanIn.nextDouble();
                    if(kontoFrom==kontoTill){
                        System.out.println("Felaktigt kontonummer.");
                    }
                    else {

                        System.out.println("Test av överföring");
                        //gör överföringen
                        MiniBank.transfer(kontoFrom,kontoTill,belopp);
                    }
                    break;
                case 3:
                    meny2=false;
                    break;
            }
        }
    }

}