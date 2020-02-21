import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumName;
     private ArrayList<Song> songArrayList;


    public Album(String albumName) {
        this.albumName = albumName;
        this.songArrayList = new ArrayList<Song>();
    }


    public String getAlbumName(){
        return albumName;
    }

    public static Album createAlbum(String albumName){
        return new Album(albumName);
    }

    public boolean addSong(String songName, double songDuration ){
        if(findSong(songName) == null){
            this.songArrayList.add(new Song(songName,songDuration));
            return true;
        }
        return false;
    }

    private Song findSong(String songName){
        for(Song checkedSong: this.songArrayList){
            if(checkedSong.getName().equals(songName)){
                return checkedSong;
            }
        }
        return null;
    }

    public void addToPlaylist(String songName, LinkedList<Song> playlist){
        if(findSong(songName) != null){
            int position = songId(songName);
            Song songPosition = songArrayList.get(position);
            playlist.add(songPosition);
        }
    }


    private int songId(String name){
        for (int i = 0; i <songArrayList.size() ; i++) {
            if(songArrayList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

}
