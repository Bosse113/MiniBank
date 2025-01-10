import java.util.ArrayList;

public class MiniBank {

    private static ArrayList<Konto> konton = new ArrayList<>();

    private MiniBank() {
    }
    public static Konto openAccount(String personNr,int pinKod) {
        Konto account = new Konto(personNr,pinKod);
        konton.add(account);
        System.out.println("Nytt konto " + account.personNr+ " med lönekonto: "+ account.getLonKontoNr()+" och sparkonto: "+account.getSparKontoNr()+" öppnat");
        return account;
    }

    public static void printReport() {

        System.out.println("--------Kontorapport--------------------------");
        System.out.println("Dina konton är:");
        System.out.println("Lönekonto: "+Konto.getLonKontoNr()+" med saldo: "+Konto.getLonSaldo());
        System.out.println("Sparkonto: "+Konto.getSparKontoNr()+" med saldo: "+Konto.getSparSaldo());
        System.out.println("-----------------------------------------------");
    }
    public static void transfer(int fromAcc, int toAcc,double amount)
    {
        //lägg till överföringsmetoden med felhantering ( saldo m.m.)


    }

}
