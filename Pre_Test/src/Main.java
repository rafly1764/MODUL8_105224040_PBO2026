abstract class Karyawan {
    protected String nama;
    Karyawan(String nama) {
        this.nama = nama;
    }
    abstract double hitungGaji();
}

class Programmer extends Karyawan {
    private double gajiPokok;
    Programmer(String nama, double gajiPokok) {
        super(nama);
        this.gajiPokok = gajiPokok;
    }
    @Override
    double hitungGaji() {
        return gajiPokok;
    }
}

public class Main {
    public static void main(String[] args) {
        Programmer p1 = new Programmer("Rafly", 6700000);
        System.out.println("Nama: " + p1.nama);
        System.out.println("Total Gaji: Rp" + p1.hitungGaji());
    }
}