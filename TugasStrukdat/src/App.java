import java.util.Scanner;

class Toko{
    public void info(){
        System.out.println("Data Karyawan Toko");
    }
}

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

class Jadwal extends Toko{
    private int IDKaryawan;
    private String hari;
    private String shift;

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

class Gaji extends Toko{
    private int IDKaryawan;
    private double gaji;
    private double lembur;

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
                case 0:
                break;
                default:
                    System.out.println("Input Tidak Valid");
            }
        }
    }

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

    static void editKaryawan(){
        System.out.print("Masukkan ID : ");
        int id = input.nextInt();
        input.nextLine();

        boolean ditemukan=false;

        for(int i=0 ; i<jumlahKaryawan ; i++){
            if(dataKaryawan[i].getID() == id){
                System.out.print("Nama    :");
                dataKaryawan[i].setNama(input.nextLine());

                System.out.print("Jabatan :");
                dataKaryawan[i].setJabatan(input.nextLine());

                ditemukan=true;
                break;
            }
        }

        if (!ditemukan){
            System.out.println("Data tidak ditemukan");
        }
    }

    static void hapusKaryawan(){
        System.out.print("Masukkan ID : ");
        int id = input.nextInt();

        boolean ditemukan=false;

        for(int i=0 ; i<jumlahKaryawan ; i++){
            if(dataKaryawan[i].getID() == id){
                for(int j=i ; j<jumlahKaryawan-1 ; j++){
                    dataKaryawan[j] = dataKaryawan[j+1];
                }
                
                jumlahKaryawan--;
                ditemukan=true;
                break;
            }
        }

        if (!ditemukan){
            System.out.println("Data tidak ditemukan");
        }
    }

    static void tambahJadwal(){
        System.out.print("Masukkan ID : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Hari  : ");
        String hari = input.nextLine();

        System.out.print("Shift : ");
        String shift = input.nextLine();

        dataJadwal[jumlahJadwal] = new Jadwal(id, hari, shift);
        jumlahJadwal++;
    }

    static void tambahGaji(){
        System.out.print("Masukkan ID : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Gaji   : ");
        double gaji = input.nextDouble();

        System.out.print("Lembur : ");
        double lembur = input.nextDouble();

        dataGaji[jumlahGaji] = new Gaji(jumlahKaryawan, gaji, lembur);
        jumlahGaji++;
    }

    static void tampilSemua(){
        System.out.print("\n=== DATA KARYAWAN ===");
        tampilKaryawan();

        System.out.print("\n=== DATA JADWAL ===");
        for(int i=0 ; i<jumlahJadwal ; i++){
            dataJadwal[i].info();
        }

        System.out.print("\n=== DATA GAJI ===");
        System.out.print("---------------------------");
        for(int i=0 ; i<jumlahGaji ; i++){
            dataGaji[i].info();
            System.out.print("---------------------------");
        }
    }
}