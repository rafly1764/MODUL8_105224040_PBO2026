abstract class Pembayaran {
    
    protected String namaPembayar;
    protected double nominal;
    public Pembayaran(String namaPembayar, double nominal) {
        this.namaPembayar = namaPembayar;
        this.nominal = nominal;
    }
    public void tampilkanDetail() {
        System.out.println("Nama Pembayar: " + namaPembayar);
        System.out.println("Nominal: " + nominal);
    }
    abstract void prosesPembayaran();
}
interface Keamanan {
    boolean autentikasi();
}
class KartuKredit extends Pembayaran implements Keamanan {
    private String nomorKartu;
    public KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }
    @Override
    void prosesPembayaran() {
        double biayaAdmin = nominal * 0.02;
        double total = nominal + biayaAdmin;
        System.out.println("Biaya Admin: " + biayaAdmin);
        System.out.println("Total Pembayaran: " + total);
    }
    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Nomor Kartu: " + nomorKartu);
    }
    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi PIN berhasil");
        return true;
    }
}
    class Ewallet extends Pembayaran implements Keamanan {
        private String nomorHP;
        public Ewallet(String namaPembayar, double nominal, String nomorHP) {
            super(namaPembayar, nominal);
            this.nomorHP = nomorHP;
        }
        @Override
        void prosesPembayaran() {
            System.out.println("Total Pembayaran: " + nominal);
        }
        @Override
        public void tampilkanDetail() {
            super.tampilkanDetail();
            System.out.println("Nomor HP: " + nomorHP);
        }
        @Override
        public boolean autentikasi() {
            System.out.println("Autentikasi berhasil");
            return true;
        }
}