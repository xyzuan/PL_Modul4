import java.util.Scanner;

public class Main {

    static Scanner inputData = new Scanner(System.in);
    private static boolean kabisat;

    public static void main(String[] args) {
        System.out.print("Apakah kabisat (y/N): ");
        setKabisat(inputData.next().charAt(0));
        System.out.print("Jumlah hari : ");
        int userDay = inputData.nextInt();
        System.out.printf("%d Hari = %d tahun %d bulan %d hari",
                          userDay,
                          dayConverter(userDay, isKabisat(), "year"),
                          dayConverter(userDay, isKabisat(), "month"),
                          dayConverter(userDay, isKabisat(), "day")
        );
    }

    static int dayConverter(int day, boolean kabisat, String params){
        int dayOfYear;
        if (kabisat) dayOfYear = 366 ; else dayOfYear = 365;
        return switch (params) {
            case "year" -> day / dayOfYear;
            case "month" -> (day % dayOfYear) / 30;
            case "day" -> (day % dayOfYear) % 30;
            default -> 0;
        };
    }

    public static boolean isKabisat() {
        return kabisat;
    }

    public static void setKabisat(Character params) {
        kabisat = params == 'y';
    }
}
