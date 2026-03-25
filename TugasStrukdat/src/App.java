import java.util.Scanner;

// SUPER CLASS TOKO
class Toko{
    public void info(){
        System.out.println("Data Karyawan Toko");
    }
}

// CLASS KARYAWAN (SUBCLASS DARI CLASS TOKO)
class Karyawan extends Toko{
    private int ID;
    private String nama;
    private String jabatan;

    public Karyawan(int ID, String nama, String jabatan){
        this.ID = ID;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public int getID(){
        return ID;
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
        System.out.println("ID      : " + ID);
        System.out.println("Nama    : " + nama);
        System.out.println("jabatan : " + jabatan);
    }
}

// CLASS JADWAL (SUBCLASS DARI CLASS TOKO)
class Jadwal extends Toko{
    private int ID;
    private String hari;
    private String shift;

    public int getID(){
        return ID;
    }

    public Jadwal(int ID, String hari, String shift){
        this.ID  = ID;
        this.hari = hari;
        this.shift = shift;
    }

    @Override
    public void info(){
        System.out.println("ID      : " + ID);
        System.out.println("Hari    : " + hari);
        System.out.println("Shift   : " + shift);
    }
}

// CLASS GAJI (SUBCLASS DARI CLASS TOKO)
class Gaji extends Toko{
    private int ID;
    private double gaji;

    public int getID(){
        return ID;
    }

    public Gaji(int ID, double gaji){
        this.ID  = ID;
        this.gaji = gaji;
    }

    public double total(){
        return gaji;
    }

    @Override
    public void info(){
        System.out.println("ID      : " + ID);
        System.out.println("Gaji    : Rp " + String.format("%,.0f", gaji));
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
            System.out.println("2. Edit Karyawan");
            System.out.println("3. Hapus Karyawan");
            System.out.println("4. Tambah Jadwal");
            System.out.println("5. Tambah Gaji");
            System.out.println("6. Tampilkan Semua Data");
            System.out.println("7. Cari Pegawai (ID)");
            System.out.println("0. Keluar");
            System.out.println("Pilih Menu: ");
            pilih = input.nextInt();

            switch(pilih){
                case 1:
                    tambahKaryawan();
                break;
                case 2:
                    editKaryawan();
                break;
                case 3:
                    hapusKaryawan();
                break;
                case 4:
                    tambahJadwal();
                break;
                case 5:
                    tambahGaji();
                break;
                case 6:
                    tampilSemua();
                break;
                case 7:
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
    static boolean cekID(int id){
        for(int i=0 ; i<jumlahKaryawan ; i++){
            if(dataKaryawan[i].getID() == id){
                return true;
            }
        }
        return false;
    }

    // FUNGSI MENGEDIT DATA KARYAWAN
    static void editKaryawan(){
        int id;

        while(true){
        System.out.print("ID : ");
        id = input.nextInt();
        input.nextLine();

        if(cekID(id)){
            break;
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }

        for(int i=0 ; i<jumlahKaryawan ; i++){
            if(dataKaryawan[i].getID() == id){
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
        System.out.print("ID : ");
        id = input.nextInt();

        if(cekID(id)){
            break;
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }

        for(int i=0 ; i<jumlahKaryawan ; i++){
            if(dataKaryawan[i].getID() == id){
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
            System.out.println("\nJadwal Selama 1 Bulan");
        System.out.print("ID : ");
        id = input.nextInt();
        input.nextLine();

        if(cekID(id)){
            break;
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }

        System.out.print("Hari  : ");
        String hari = input.nextLine();

        System.out.println("Pagi/Malam");
        System.out.print("Shift : ");
        String shift = input.nextLine();

        dataJadwal[jumlahJadwal] = new Jadwal(id, hari, shift);
        jumlahJadwal++;
    }

    // FUNGSI MENGATUR GAJI KARYAWAN
    static void tambahGaji(){
        int id;

        while(true){
        System.out.print("ID : ");
        id = input.nextInt();
        input.nextLine();

        if(cekID(id)){
            break;
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }

        System.out.print("Gaji : Rp ");
        double gaji = input.nextDouble();

        dataGaji[jumlahGaji] = new Gaji(id, gaji);
        jumlahGaji++;
    }

    // FUNGSI MENAMPILKAN SEMUA DATA KARYAWAN
    static void tampilSemua(){
        if(jumlahKaryawan == 0){
            System.out.println("\nData tidak ditemukan");
        }
        
        for(int i=0 ; i<jumlahKaryawan ; i++){
            int id = dataKaryawan[i].getID();
            
            System.out.println("\n---------------------------");
            System.out.println("=== DATA KARYAWAN ===");
            // MENAMPILKAN DATA KARYAWAN
            dataKaryawan[i].info();

            // MENAMPILKAN JADWAL KARYAWAN
            for(int j=0 ; j<jumlahJadwal ; j++){
                    if(dataJadwal[j].getID() == 1){
                        System.out.println("=== DATA JADWAL ===");
                        dataJadwal[j].info();
                    }
                }
            
            // MENAMPILKAN DATA DAJI KARYAWAN
            for(int j=0 ; j<jumlahGaji ; j++){
                    if(dataGaji[j].getID() == 1){
                        System.out.println("=== DATA GAJI ===");
                        dataGaji[j].info();
                    }
                }
            System.out.println("---------------------------");
        }
    }
    
    // FUNGSI MENCARI KARYAWAN BERDASARKAN ID
    static void cariKaryawan(){
        int id;

        while(true){
        System.out.print("ID : ");
        id = input.nextInt();

        if(cekID(id)){
            break;
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }

        System.out.println("\n===== HASIL PENCARIAN =====");

        for(int i=0 ; i<jumlahKaryawan ; i++){
            if(dataKaryawan[i].getID() == id){
                System.out.println("\n--- DATA KARYAWAN ---");
                dataKaryawan[i].info();
            }
        }

        for(int i=0 ; i<jumlahJadwal ; i++){
            if(dataJadwal[i].getID() == id){
                System.out.println("\n--- DATA JADWAL ---");
                dataJadwal[i].info();
                }
        }

        for(int i=0 ; i<jumlahGaji ; i++){
            if(dataGaji[i].getID() == id){
                System.out.println("\n--- DATA GAJI ---");
                dataGaji[i].info();
            }
        }
    }
}