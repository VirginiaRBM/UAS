import java.util.Scanner;
 
public class Praktikum {
    String penerbit,pengarang,judul;
    Integer id,tanggal;
    Praktikum next;
    public static Scanner in=new Scanner(System.in);
    public static Scanner str=new Scanner(System.in);
    public void input(){
        System.out.print("id Buku            : ");
        id=in.nextInt();
        System.out.print("Judul Buku         : ");
        judul=str.nextLine();
        System.out.print("Pengarang          : ");
        pengarang=str.nextLine();
        System.out.print("Penerbit           : ");
        penerbit=str.nextLine();
        System.out.print("Tanggal Terbit     : ");
        tanggal=in.nextInt();
        next=null;
    }
    public void view(){
        System.out.println("| "+id+" | "+judul+" | "+pengarang+" | "+penerbit+" | "+tanggal+" |");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int menu=0,del;
        linkedlist ll=new linkedlist();
        while(menu!=4){
            System.out.print("1.Input\n2.View\n3.Delete\n4.Exit\n : ");
            menu=in.nextInt();
            if(menu==1) ll.add();
            else if(menu==2) ll.view();
            else if(menu==3){
                System.out.print("1.Data Pertama\n2.Data Terkahir\n : ");
                del=in.nextInt();
                if(del==1) ll.removeFirst();
                else if(del==2) ll.removeLast();
                else System.out.println("Salah");
            }
            else if(menu==4) System.out.println("Keluar");
            else System.out.println("Salah");
            System.out.println();
        }
    }
}

class linkedlist{
    Praktikum head,tail;
    public linkedlist(){
        head=null;
        tail=null;
    }
    public void add(){
        Praktikum baru=new Praktikum();
        baru.input();
        if(head==null) head=baru;
        else tail.next=baru;
        tail=baru;
    }
    public void view(){
        if(head==null){
            System.out.println("Kosong");
            return;
        }
        System.out.println("| Id | Nama | Kelas | Jadwal | Modul |");
        Praktikum ptr=head;
        while(ptr!=null){
            ptr.view();
            ptr=ptr.next;
        }
    }
    public void removeFirst(){
        if(head==null){
            System.out.println("Kosong");
            return;
        }
        System.out.println("Data "+head.judul+" Berhasil Dihapus");
        head=head.next;
    }
    public void removeLast(){
        if(head==null){
            System.out.println("Kosong");
            return;
        }
        System.out.println("Data "+tail.judul+" Berhasil Dihapus");
        if(head==tail){
            head=null;
            tail=null;
        }else{
            Praktikum ptr=head.next;
            Praktikum prev=head;
            while(ptr!=tail){
                ptr=ptr.next;
                prev=prev.next;
            }
            prev.next=null;
            tail=prev;
        }
    }
}
