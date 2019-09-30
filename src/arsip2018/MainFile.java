package arsip2018;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainFile {

    Scanner sc = new Scanner(System.in);

    public void SaveToFile() {
        Customer R = new Customer();
        double Saldoku = 0;
        String No = "", Namaku = "";
        int Password = 0;

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("E:\\Kuliah\\Nasabah.dat" + ""));

            BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("No Rekening : ");
            No = brInput.readLine();
            while (!No.equals("xxx")) {
                try {
                    System.out.print("Nama : ");
                    Namaku = brInput.readLine();
                    System.out.print("Saldo : ");
                    Saldoku = sc.nextDouble();
                    System.out.print("Pin : ");
                    Password = sc.nextInt();
                    R = new Customer(No, Namaku, (int)Saldoku, Password);
                    out.writeObject(R);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print("No Rekening : ");
                No = brInput.readLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewFile() {
        Customer R = new Customer();
        int total = 0;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("E:\\Kuliah\\Nasabah.dat"));
            Object CurR = in.readObject();
            try {
                while (true) {
                    R = (Customer) CurR;
//                    System.out.println("No Rekening : " + R.getNoRek());
//                    System.out.println("Nama : " + R.getNama());
//                    System.out.println("Saldo: " + R.getSaldo());
                    R.viewCustomer();
                    total++;
                    CurR = in.readObject();
                }
            } catch (EOFException e) {
            }
            System.out.println("Total Record : " + total);
        } catch (ClassNotFoundException e) {
            System.out.println("Class tidak ditemukan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CekSaldo(Customer A) {
        Customer R = new Customer();
        int total = 0;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("E:\\Kuliah\\Nasabah.dat"));
            Scanner sc = new Scanner(System.in);
            String NoRekCari = A.getNoRek();
            Object CurR = in.readObject();
            try {
                while (true) {
                    R = (Customer) CurR;
                    if (R.NoRek.equals(NoRekCari)) {
                        System.out.println("Isi dari rekening ");
                        System.out.println("No Rekening : " + R.getNoRek());
                        System.out.println("Nama : " + R.getNama());
                        System.out.println("Saldo: " + R.getSaldo());

                        MainFile B = new MainFile();
                        B.MenuYN(A);
                        break;
                    } else {
                        CurR = in.readObject();
                    }
                }
            } catch (EOFException e) {
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class tidak ditemukan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Penarikan(Customer A) {
        Customer R = new Customer();
        int total = 0;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("E:\\Kuliah\\Nasabah.dat"));
            Scanner sc = new Scanner(System.in);
            String NoRekCari = A.getNoRek();

            Object CurR = in.readObject();
            try {
                while (true) {
                    R = (Customer) CurR;
                    if (R.NoRek.equals(NoRekCari)) {
                        System.out.print("Jumlah yang akan ditarik : ");
                        int X = sc.nextInt();
                        R.Saldo = R.Saldo - X;
                        if (R.Saldo > 10000) {
                            System.out.println("Transaksi Berhasil");
                            System.out.println("Sisa Saldo: " + R.getNama() + ", " + R.getSaldo());
                        } else {
                            System.out.println("Saldo kurang");
                        }

                        MainFile B = new MainFile();
                        B.MenuYN(A);
                        break;
                    } else {
                        CurR = in.readObject();
                    }
                }
            } catch (EOFException e) {
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class tidak ditemukan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Deposit(Customer A) {
        Customer R = new Customer();
        int total = 0;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("E:\\Kuliah\\Nasabah.dat"));
            Scanner sc = new Scanner(System.in);
            String NoRekCari = A.getNoRek();

            Object CurR = in.readObject();
            try {
                while (true) {
                    R = (Customer) CurR;
                    if (R.NoRek.equals(NoRekCari)) {
                        System.out.print("Jumlah yang akan disimpan : ");
                        int X = sc.nextInt();
                        R.Saldo = R.Saldo + X;
                        System.out.println("Transaksi Berhasil");
                        System.out.println("Sisa Saldo: " + R.getNama() + ", " + R.getSaldo());

                        MainFile B = new MainFile();
                        B.MenuYN(A);
                        break;
                    } else {
                        CurR = in.readObject();
                    }
                }
            } catch (EOFException e) {
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class tidak ditemukan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Transfer(Customer A) {
        Customer R = new Customer();
        int total = 0;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("E:\\Kuliah\\Nasabah.dat"));
            Scanner sc = new Scanner(System.in);
            String NoRekCari = A.getNoRek();
            System.out.println("Jumlah yang ditransfer");
            int TR = sc.nextInt();
            System.out.println("No Rekening yang dituju:");
            String NoRekTuju = sc.next();
            Object CurR = in.readObject();
            try {
                while (true) {
                    R = (Customer) CurR;
                    if (R.NoRek.equals(NoRekCari)) {
                        R.Saldo = R.Saldo - TR;
                        System.out.println("Sisa Saldo: " + R.getNama() + ", " + R.getSaldo());
                    }

                    if (R.NoRek.equals(NoRekTuju)) {
                        R.Saldo = R.Saldo + TR;
                        System.out.println("Sisa Saldo: " + R.getNama() + ", " + R.getSaldo());
                                                MainFile B = new MainFile();
                        B.MenuYN(A);
                        break;
                    } else {
                        CurR = in.readObject();
                    }
                }

            } catch (EOFException e) {
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class tidak ditemukan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Login() {
        Customer R = new Customer();
        int total = 0;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("E:\\Kuliah\\Nasabah.dat"));
            Scanner sc = new Scanner(System.in);
            System.out.println("=== Login ===");
            System.out.println("Nomor Rekening : ");
            String Username = sc.next();
            System.out.println("Pin : ");
            int Passwordku = sc.nextInt();
            Object CurR = in.readObject();
            try {
                while (true) {
                    R = (Customer) CurR;
                    if (R.Password == (Passwordku) && R.NoRek.equals(Username)) {
                        System.out.println("Selamat datang " + R.Nama);
                        MainFile B = new MainFile();
                        B.ProsesMenu(R);
                        break;
                    } else {
                        CurR = in.readObject();
                    }

                }
            } catch (EOFException e) {
            }
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }
    }

    void MenuYN(Customer A) {
        int pil = 0;
        System.out.println("Melakukan Transaksi lagi?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        Scanner sc = new Scanner(System.in);
        int x = 0;
        x = sc.nextInt();
        if (x == 1) {
            MainFile B = new MainFile();
           
            B.ProsesMenu(A);
        } else {
            System.out.println("Terima kasih");
        }

    }

    int Menu() {
        int pil = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Pilih Transaksi");
        System.out.println("0. keluar");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Penarikan");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("Pilih Transaksi : ");
        pil = sc.nextInt();
        return pil;
    }

    void ProsesMenu(Customer A) {
        int P = Menu();
        switch (P) {
            case 0:
                System.exit(0);
                break;
            case 1:
                CekSaldo(A);
                break;
            case 2:
                Penarikan(A);
                break;
            case 3:
                Deposit(A);
                break;
            case 4:
                Transfer(A);
                break;

            default:
                System.out.println("Pilihan Salah");
        }
    }

    public static void main(String[] args) {
        MainFile M = new MainFile();
        //M.SaveToFile();
        M.viewFile();
        Customer A = null;
        M.Login();
        //M.Menu();
        //M.ProsesMenu(A);
        // M.CekSaldo();
    }
}
