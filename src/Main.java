import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Album ArjitAlbum = new Album("Arjit Singh", "Arijit's album");
        Album PawanSinghALbum = new Album("Pawan Singh", "Pawan Album");

        ArjitAlbum.addSongToAlbum("kesaria", 3.5);
        ArjitAlbum.addSongToAlbum("Tum Kya MIle", 4.1);
        ArjitAlbum.addSongToAlbum("Tum hi ho", 3.8);

        PawanSinghALbum.addSongToAlbum("Raja Ji", 3.8);
        PawanSinghALbum.addSongToAlbum("Dasehri Amwa", 3.2);
        PawanSinghALbum.addSongToAlbum("Tu Hamar dekha", 2.8);

        LinkedList<Song> playlist = new LinkedList<>();

        System.out.println(ArjitAlbum.addSongPlaylistFromAlbum("kesaria", playlist));
        System.out.println(ArjitAlbum.addSongPlaylistFromAlbum(2, playlist));
        System.out.println(ArjitAlbum.addSongPlaylistFromAlbum(3, playlist));

        System.out.println(PawanSinghALbum.addSongPlaylistFromAlbum("Raja ji", playlist));
        System.out.println(PawanSinghALbum.addSongPlaylistFromAlbum(3, playlist));

        play(playlist);
    }
        private static void play(LinkedList<Song> playlist){

            if(playlist.size()==0){
                System.out.println("Your playlist is empty");
                return;
            }

            ListIterator<Song> itr = playlist.listIterator();
            System.out.println("Now Playing :- " +itr.next());

            Scanner sc= new Scanner(System.in);
            printMenu();
            boolean wasNext=true;
            boolean quit=false;
            while(!quit){
                System.out.println("Please Enter Your Choice");
                int choice=sc.nextInt();

                switch(choice){
                    case 1:
                        printMenu();
                        break;
                    case 2:
                        if(!wasNext){
                            itr.next();
                            wasNext=true;
                        }
                        if(!itr.hasNext()){
                            System.out.println("You reachead the end of the Playlist");
                        }
                        else{
                            System.out.println("Current Play :- "+itr.next());
                            wasNext=true;
                        }
                        break;
                    case 3:
                        if(wasNext){
                            itr.previous();
                            wasNext=false;
                        }
                        if(!itr.hasPrevious()){
                            System.out.println("you are at the start of the playlist");
                        }else{
                            System.out.println("Current Play:- "+itr.previous());
                            wasNext=false;
                        }
                        break;
                    case 4:
                        if(wasNext==true){
                            System.out.println("Current Playing :- "+itr.previous());
                            wasNext=false;
                        }else{
                            System.out.println("Current Playing :- "+itr.next());
                            wasNext=true;
                        }
                        break;
                    case 5:
                        if(wasNext==true){
                            itr.previous();
                          itr.remove();
                            wasNext=false;
                        }else{
                            itr.next();
                            itr.remove();
                            wasNext=true;
                        }
                        break;
                    case 6:
                        printSongs(playlist);
                        break;
                    case 7:
                        quit=true;
                    default:
                        System.out.println("You Select Incorrect choices");

             }
            }
            return;
        }
        private static void printSongs(LinkedList<Song> myPlayList) {

            for(Song song: myPlayList){
                System.out.println(song);
            }
            return;
        }
        private static void printMenu() {

            System.out.println("1. Show the menu again");
            System.out.println("2. Play next song");
            System.out.println("3. Play previous song");
            System.out.println("4. Play current song again");
            System.out.println("5. Delete current song from playlist");
            System.out.println("6. Print all the songs in playlist");
            System.out.println("7. Quit application");
        }

    }
