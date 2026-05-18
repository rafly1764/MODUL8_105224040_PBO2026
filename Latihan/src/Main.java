import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Pembayaran kartu = new KartuKredit("Goldship", 500000, "123456789");
        Pembayaran ewallet = new Ewallet("Rafly", 250000, "082228575889");
        ArrayList<Pembayaran> list = new ArrayList<>();

        list.add(kartu);
        list.add(ewallet);

        for (Pembayaran p : list) {
            p.tampilkanDetail();
            if (p instanceof Keamanan) {
                Keamanan k = (Keamanan) p;
                if (k.autentikasi()) {
                    p.prosesPembayaran();
                }
            }
            System.out.println();
        }
    }
}