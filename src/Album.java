import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class Album {

    private String artist;
    private String name;

    private List<Song> songs ;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs=new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // functionality
    public boolean findSong(String title){

        for(Song song:songs){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String title,double duration){
        if(!findSong(title)){
            Song song=new Song(title,duration);
            this.songs.add(song);
            return "Song has been added to Successfully";
        }
        return "Song already exists";
    }

    public String addSongPlaylistFromAlbum(String title, LinkedList<Song> myPlaylist){
        for(Song song:songs){
            if(song.getTitle().equals(title)){
                myPlaylist.add(song);
                return "song added in playlist ";
            }
        }
        return " Song does not exist in Album";
    }
   /** polymorphism */
    public String addSongPlaylistFromAlbum(int songNo, LinkedList<Song>myPlaylist){
        int index=songNo-1;
        if(index>=0&&index<songs.size()){
            myPlaylist.add(songs.get(index));
            return "Song added in playlist";
        }
        return "Incorrect songNo : Press Correct songNO";
    }
}
