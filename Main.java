import piyush.Album;
import piyush.Songs;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1","Shawn Mendes");

        album.addSong("Senorita",3.25);
        album.addSong("Imagination",3.02);
        album.addSong("Treat You Better",4.17);
        albums.add(album);

        album = new Album("Album2","Justin Bieber");

        album.addSong("Stay",2.27);
        album.addSong("Peaches",3.45);
        album.addSong("Baby",3.15);
        albums.add(album);

        album = new Album("Album3","Imagine Dragon");

        album.addSong("Thunder",4.10);
        album.addSong("Believer",3.35);
        album.addSong("Bad Liar",3.47);
        albums.add(album);

        LinkedList<Songs> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Senorita",playList_1);
        albums.get(0).addToPlayList("Imagination",playList_1);
        albums.get(1).addToPlayList("Stay",playList_1);
        albums.get(1).addToPlayList("Peaches",playList_1);
        albums.get(2).addToPlayList("Believer",playList_1);
        albums.get(2).addToPlayList("Thunder",playList_1);

        play(playList_1);

    }

    private static void play(LinkedList<Songs> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Songs> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("\nThis playlist have no song");
        }else {
            System.out.println("\nNow playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("\nPlaylist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("\nNow playing "+listIterator.next().toString());
                    }else {
                        System.out.println("\nno song available, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("\nNow playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("\nwe are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("\nNow playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("\nwe are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("\nNow playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("\nwe have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                                System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("\nPress any availabe options");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }

    private static void printList(LinkedList<Songs> playList){
        Iterator<Songs> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }

}