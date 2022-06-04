import java.util.Scanner;

public class main {
    public static void menu() {
        System.out.println("Menu");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Cetak Antrian");
        System.out.println("3. Hapus Antrian");
        System.out.println("4. Laporan Pengurutan pesanan by nama");
        System.out.println("5. Hitung total pendapatan");
        System.out.println("6. Keluar");
    }

    public static void main(String[] args) {
        dll_08 dllO = new dll_08();
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        int pilihan = 0;
        int kodePesanan, harga;
        String namaPembeli, noHp, namaPesanan;

        while (pilihan != 6) {
            menu();
            System.out.print("Pilih Menu : ");
            pilihan = sc.nextInt();
            System.out.println("---------------------------------------");
            
            switch(pilihan) {
                case 1: 
                    System.out.println("Masukkan Data Pembeli");
                    System.out.print("No antrian : ");
                    kp = sc.nextInt();
                    System.out.print("Nama : ");
                    np = scn.next();
                    System.out.print("No Hp : ");
                    np = s.next();
                    System.out.println("");
                    dllO.addLast(new pembeli(kp, np, nh));
                    break;
                    
                case 2:
                    System.out.println("Cetak Data");
                    System.out.println("Size : " + dll_08.size);
                    System.out.println("");
                    dllO.print();
                    System.out.println("");
                    break;
                
                case 3:
                    pesanan temp = dll_08.removeFirst();
                    if(temp == null)System.out.println("Antrian Kosong");
                    else System.out.println("Masukan Nama Pesanan : ");
                    temp.namaPesanan = new sc.next();
                    System.out.println("Masukan Harga : ");
                    temp.harga = new scn.nextInt();
                    System.out.println("|Nama Pesanan\t\t|Harga");
                    System.out.println(temp.namaPesanan+"\t\t"+temp.harga);
                    break;

                case 4:
                    dllO.printDesc();
                    System.out.println("");
                    break;
                    
                case 6:
                    System.out.println("Terima kasih");
                    sc.close();
            }
        }
    }
}