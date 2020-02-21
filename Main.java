import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Album> albums = new LinkedList<Album>();

        Album album = new Album("Blue");
        album.addSong("baby blue", 3.14);
        album.addSong("JJ",4.4);
        album.addSong("asdf Movie",40.34);

        Album secoundAlbum = new Album("secAlb");
        secoundAlbum.addSong("cat",3.43);
        secoundAlbum.addSong("qwert",1.23);
        secoundAlbum.addSong("ytu",6.7);

        albums.add(album);
        albums.add(secoundAlbum);


        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("JJ",playlist);
        albums.get(1).addToPlaylist("cat",playlist);
        albums.get(0).addToPlaylist("baby blue",playlist);
        albums.get(1).addToPlaylist("ytu",playlist);
        albums.get(1).addToPlaylist("qwert",playlist);




        printList(playlist);
        listening(playlist);
    }



        // checking working if playlist works
    private static void printList(LinkedList<Song> linkedList){
        Iterator<Song> i = linkedList.iterator();
        while(i.hasNext()){
            System.out.println("In playlist " + i.next().getName());
        }
        System.out.println("#################################");
    }




    private static void listening(LinkedList playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        printMenu();
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.isEmpty()){
            System.out.println("No songs in playlist");
            return;
        }else{
            System.out.println("Now listening " + listIterator.next().getName());
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Playlist Over");
                    quit=true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now listening " + listIterator.next().getName());
                    }else {
                        System.out.println("Reached the end of list");
                        goingForward=false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now listening " + listIterator.previous().getName());
                    }else{
                        System.out.println("We are at the start of the list");
                        goingForward=true;
                    }
                    break;
                case 3:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().getName());
                            goingForward=false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().getName());
                            goingForward =true;
                        }else{
                            System.out.println("Reached the end of list");
                        }
                    }

                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                   if(playlist.size() >0){
                       listIterator.remove();
                       if(listIterator.hasNext()){
                           System.out.println("Now playing " + listIterator.next().getName());
                       }else if(listIterator.hasPrevious()){
                           System.out.println("Now playing " + listIterator.previous().getName());
                       }
                   }
                    break;
                case 6:
                    printMenu();
                    break;
            }

        }

    }

    private static void printMenu(){
        System.out.println("Available action:\npress ");
        System.out.println("0- to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay current song\n"+
                "4 - print playlist\n"+
                "5 - delete song from playlist\n"+
                "6 - print menu");
    }


}


