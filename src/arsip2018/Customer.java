package arsip2018;

import java.util.Scanner;

public class Customer implements java.io.Serializable {
    String NoRek, Nama;
    int Saldo;
    int Password;

    Customer() {
    }

    Customer(String Rek, String Name, int Saldonya, int Pass) {
        NoRek = Rek;
        Nama = Name;
        Saldo = Saldonya;
        Password = Pass;
    }

    Customer(String No, String Namaku, int Saldoku) {
          }
    
    int getPass(){
        return Password;
    }
    
    void SetPass(int Pass){
        Password = Pass;
    }
    
    String getNoRek(){
        return NoRek;
    }
    
    void setNoRek(String No){
        NoRek=No;
    }
    
    String getNama(){
        return Nama;
    }
    
    void setNama(String Namaku){
        Nama= Namaku;
    }
    
    int getSaldo(){
        return Saldo;
    }
    
    void setSaldo(int Saldoku){
        Saldo=Saldoku;
    }
    
    void Login (String nama, String Pass){
        
    }
    
    void baca(){
        Scanner sc = new Scanner(System.in);
        System.out.println("NoRek : ");NoRek=sc.next();
        System.out.println("Saldo : ");Saldo=sc.nextInt();
        System.out.println("Nama : ");Nama=sc.nextLine();
        System.out.println("Password : ");Password=sc.nextInt();
    }
    
    void viewCustomer(){
        System.out.println("Nomor Rekening " +NoRek+", "+Nama+", "+Saldo + " ," + Password);
    }

    
    public static void main(String[] args) {
        Customer T=new Customer();
        
        T.baca();
        T.viewCustomer();
    }
}
