import java.util.Scanner;

// SUPER CLASS TOKO
class Toko{
    public void info(){
        System.out.println("Data Karyawan Toko");
    }
}

// CLASS KARYAWAN (SUBCLASS DARI CLASS TOKO)
class Karyawan extends Toko{
    private int IDKaryawan;
    private String nama;
    private String jabatan;

    public Karyawan(int IDKaryawan, String nama, String jabatan){
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public int getIDKaryawan(){
        return IDKaryawan;
    }

    public String getNama(){
        return nama;
    }

    public String getJabatan(){
        return jabatan;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setJabatan(String jabatan){
        this.jabatan = jabatan;
    }

    @Override
    public void info(){
        System.out.println("ID      : " + IDKaryawan);
        System.out.println("Nama    : " + nama);
        System.out.println("jabatan : " + jabatan);
    }
}

// CLASS JADWAL (SUBCLASS DARI CLASS TOKO)
class Jadwal extends Toko{
    private int IDKaryawan;
    private String hari;
    private String shift;

    public int getIDKaryawan(){
        return IDKaryawan;
    }

    public Jadwal(int IDKaryawan, String hari, String shift){
        this.IDKaryawan  = IDKaryawan;
        this.hari = hari;
        this.shift = shift;
    }

    @Override
    public void info(){
        System.out.println("ID      : " + IDKaryawan);
        System.out.println("Hari    : " + hari);
        System.out.println("Shift   : " + shift);
    }
}

// CLASS GAJI (SUBCLASS DARI CLASS TOKO)
class Gaji extends Toko{
    private int IDKaryawan;
    private double gaji;
    private double lembur;

    public int getIDKaryawan(){
        return IDKaryawan;
    }

    public Gaji(int IDKaryawan, double gaji, double lembur){
        this.IDKaryawan  = IDKaryawan;
        this.gaji = gaji;
        this.lembur = lembur;
    }

    public double total(){
        return gaji + lembur;
    }

    @Override
    public void info(){
        System.out.println("ID      : " + IDKaryawan);
        System.out.println("Gaji    : " + gaji);
        System.out.println("Lembur  : " + lembur);
    }
}

// MAIN PROGRAM
public class App{
    static Scanner input = new Scanner(System.in);
    static Karyawan[] dataKaryawan = new Karyawan[100];
    static Jadwal[] dataJadwal = new Jadwal[100];
    static Gaji[] dataGaji = new Gaji[100];

    static int jumlahKaryawan = 0;
    static int jumlahJadwal = 0;
    static int jumlahGaji = 0;

    public static void main(String[] args){
        int pilih = -1;

        while (pilih != 0){
            System.out.println("\n===== SISTEM MANAJEMEN TOKO =====");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Tampilkan Karyawan");
            System.out.println("3. Edit Karyawan");
            System.out.println("4. Hapus Karyawan");
            System.out.println("5. Tambah Jadwal");
            System.out.println("6. Tambah Gaji");
            System.out.println("7. Tampilkan Semua Data");
            System.out.println("8. Cari Pegawai (ID)");
            System.out.println("0. Keluar");
            System.out.println("Pilih Menu: ");
            pilih = input.nextInt();

            switch(pilih){
                case 1:
                    tambahKaryawan();
                break;
                case 2:
                    tampilKaryawan();
                break;
                case 3:
                    editKaryawan();
                break;
                case 4:
                    hapusKaryawan();
                break;
                case 5:
                    tambahJadwal();
                break;
                case 6:
                    tambahGaji();
                break;
                case 7:
                    tampilSemua();
                break;
                case 8:
                    cariKaryawan();
                break; 
                case 0:
                break;
                default:
                    System.out.println("Input Tidak Valid");
            }
        }
    }
    
    // FUNGSI MENAMBAH KARYAWAN
    static void tambahKaryawan(){
        System.out.print("ID : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Nama : ");
        String nama = input.nextLine();

        System.out.print("Jabatan : ");
        String jabatan = input.nextLine();

        dataKaryawan[jumlahKaryawan] = new Karyawan(id, nama, jabatan); 
        jumlahKaryawan++;
    }

    // FUNGSI UNTUK MENGECEK ID KARYAWAN
    static boolean cekIDKaryawan(int id){
        for(int i=0 ; i<jumlahKaryawan ; i++){
            if(dataKaryawan[i].getIDKaryawan() == id){
                return true;
            }
        }
        return false;
    }

    // FUNGSI MENAMPILKAN SEMUA KARYAWAN
    static void tampilKaryawan(){
        System.out.println("---------------------------");
        if(jumlahKaryawan == 0){
            System.out.println("Data karyawan kosong");
            return;
        }

        for(int i=0 ; i<jumlahKaryawan ; i++){
            dataKaryawan[i].info();
            System.out.println("---------------------------");
        }
    }

    // FUNGSI MENGEDIT DATA KARYAWAN
    static void editKaryawan(){
        int id;

        while(true){
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        if(cekIDKaryawan(id)){
            break;
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }

        for(int i=0 ; i<jumlahKaryawan ; i++){
            if(dataKaryawan[i].getIDKaryawan() == id){
                System.out.print("Nama    :");
                dataKaryawan[i].setNama(input.nextLine());

                System.out.print("Jabatan :");
                dataKaryawan[i].setJabatan(input.nextLine());

                break;
            }
        }
    }

    // FUNGSI MENGHAPUS DATA KARYAWAN
    static void hapusKaryawan(){
        int id;

        while(true){
        System.out.print("Masukkan ID : ");
        id = input.nextInt();

        if(cekIDKaryawan(id)){
            break;
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }

        for(int i=0 ; i<jumlahKaryawan ; i++){
            if(dataKaryawan[i].getIDKaryawan() == id){
                for(int j=i ; j<jumlahKaryawan-1 ; j++){
                    dataKaryawan[j] = dataKaryawan[j+1];
                }
                
                jumlahKaryawan--;
                break;
            }
        }
    }

    // FUNGSI MENAMBAHKAN JADWAL KARYAWAN
    static void tambahJadwal(){
        int id;

        while(true){
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        if(cekIDKaryawan(id)){
            break;
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }

        System.out.print("Hari  : ");
        String hari = input.nextLine();

        System.out.print("Shift : ");
        String shift = input.nextLine();

        dataJadwal[jumlahJadwal] = new Jadwal(id, hari, shift);
        jumlahJadwal++;
    }

    // FUNGSI MENGATUR GAJI KARYAWAN
    static void tambahGaji(){
        int id;

        while(true){
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        if(cekIDKaryawan(id)){
            break;
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }

        System.out.print("Gaji   : ");
        double gaji = input.nextDouble();

        System.out.print("Lembur : ");
        double lembur = input.nextDouble();

        dataGaji[jumlahGaji] = new Gaji(id, gaji, lembur);
        jumlahGaji++;
    }

    // FUNGSI MENAMPILKAN SEMUA DATA KARYAWAN
    static void tampilSemua(){
        System.out.print("\n=== DATA KARYAWAN ===");

        if(jumlahKaryawan == 0){
            System.out.println("\nData tidak ditemukan");
        }
        else{
            tampilKaryawan(); // MEMANGGIL FUNGSI tampilKaryawan UNTUK MENAMPILKAN DATA KARYAWAN
        }

        System.out.print("\n=== DATA JADWAL ===");
        for(int i=0 ; i<jumlahJadwal ; i++){
            dataJadwal[i].info();
        }

        System.out.print("\n=== DATA GAJI ===");
        System.out.print("\n---------------------------");
        for(int i=0 ; i<jumlahGaji ; i++){
            dataGaji[i].info();
            System.out.print("\n---------------------------");
        }
    }
    

    // FUNGSI MENCARI KARYAWAN BERDASARKAN ID
    static void cariKaryawan(){
        int id;

        while(true){
        System.out.print("Masukkan ID Karyawan : ");
        id = input.nextInt();

        if(cekIDKaryawan(id)){
            break;
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }

        System.out.println("\n===== HASIL PENCARIAN =====");

        for(int i=0 ; i<jumlahKaryawan ; i++){
            if(dataKaryawan[i].getIDKaryawan() == id){
                System.out.println("\n--- DATA KARYAWAN ---");
                dataKaryawan[i].info();
            }
        }

        for(int i=0 ; i<jumlahJadwal ; i++){
            if(dataJadwal[i].getIDKaryawan() == id){
                System.out.println("\n--- DATA JADWAL ---");
                dataJadwal[i].info();
                }
        }

        for(int i=0 ; i<jumlahGaji ; i++){
            if(dataGaji[i].getIDKaryawan() == id){
                System.out.println("\n--- DATA GAJI ---");
                dataGaji[i].info();
            }
        }
    }
}