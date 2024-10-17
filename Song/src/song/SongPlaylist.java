package song;
import java.util.Scanner;

public class SongPlaylist {
    private static class Song {
        String title;
        Song next;

        Song(String title) {
            this.title = title;
            this.next = null;
        }
    }

    private Song head;
    private Scanner scanner;

    public SongPlaylist() {
        scanner = new Scanner(System.in);
    }

    public void addSong(String title) {
        Song newSong = new Song(title);
        if (head == null) {
            head = newSong;
        } else {
            Song current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong;
        }
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist kosong");
            return;
        }
        
        System.out.println("\nLagu dalam playlist:");
        Song current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.title);
            current = current.next;
            index++;
        }
        System.out.println();
    }

    public void run() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah lagu");
            System.out.println("2. Tampilkan playlist");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul lagu: ");
                    String title = scanner.nextLine();
                    addSong(title);
                    System.out.println("Lagu '" + title + "' telah ditambahkan ke playlist.");
                    break;
                case 2:
                    displayPlaylist();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void main(String[] args) {
        SongPlaylist myPlaylist = new SongPlaylist();
        myPlaylist.run();
    }
}