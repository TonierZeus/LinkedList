import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumName;
    //private ArrayList<Song> songArrayList;
    private SongList songListArrayList;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songListArrayList = new SongList();
       // this.songArrayList = new ArrayList<Song>();
    }


    public String getAlbumName(){
        return albumName;
    }

    public static Album createAlbum(String albumName){
        return new Album(albumName);
    }

    public boolean addSong(String songName, double songDuration ){
        return this.songListArrayList.add(new Song(songName,songDuration));

    }

    public void addToPlaylist(String songName, LinkedList<Song> playlist){

        Song checkedSong = songListArrayList.findSong(songName);

        if(checkedSong != null){
            int position = songId(songName);
            Song songPosition = SongList.songArrayList.get(position);
            playlist.add(songPosition);
        }
    }


    private int songId(String name){
        for (int i = 0; i <SongList.songArrayList.size() ; i++) {
            if(SongList.songArrayList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static class SongList {


        private static ArrayList<Song> songArrayList;

        public SongList() {
            this.songArrayList = new ArrayList<Song>();
        }

        public Song findSong(String songName) {
            for (Song checkedSong : this.songArrayList) {
                if (checkedSong.getName().equals(songName)) {
                    return checkedSong;
                }
            }
            return null;
        }

        public boolean add(Song song) {
            if (songArrayList.contains(song)) {
                return false;
            }
            this.songArrayList.add(song);
            return true;
        }

    }
}


