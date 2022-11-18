import java.util.*;


public class BoomPlay {
    private static ArrayList<Album> albums = new ArrayList<>();
   public static LinkedList<String> playList = new LinkedList<>();
    public static void main(String[] args) {
//        ADDING SONG TO ALBUM
        Album album = new Album("Love, Damini", "Burna Boy");
        album.addSong("Glory", 2.04);
        album.addSong("Science", 3.04);
        album.addSong("Last Last", 2.00);
        album.addSong("Kilometre", 3.09);
        album.addSong("Common person", 2.06);
        album.addSong("Wild Dreams", 3.00);
        album.addSong("Vanilla", 2.59);
        album.addSong("Dirty Secrets", 3.07);
        album.addSong("For my hand", 2.06);
        album.addSong("How bad could it be", 3.59);
        albums.add(album);

        album = new Album("Super Star", "BigWiz");
        album.addSong("Say my name", 1.45);
        album.addSong("Love my baby", 3.08);
        album.addSong("Don't dull", 2.08);
        album.addSong("Gidi girl", 1.39);
        album.addSong("Tease me", 2.08);
        album.addSong("Shout out", 2.08);
        album.addSong("Scatter the floor", 2.08);
        album.addSong("No lele", 3.08);
        album.addSong("Holla at your boy", 2.08);
        album.addSong("Whine for me", 3.08);
        albums.add(album);

//        ADDING SONG TO PLAYLIST
        albums.get(0).addSongToPlayList("Glory", playList);
        albums.get(0).addSongToPlayList("Last Last", playList);
        albums.get(0).addSongToPlayList("Vanilla", playList);
        albums.get(0).addSongToPlayList("Common person", playList);
        albums.get(0).addSongToPlayList("For my hand", playList);

        albums.get(1).addSongToPlayList(1, playList);
        albums.get(1).addSongToPlayList(3, playList);
        albums.get(1).addSongToPlayList(4, playList);
        albums.get(1).addSongToPlayList(6, playList);
        albums.get(1).addSongToPlayList(8, playList);

        play();

    }

    private static void play(){
        ListIterator<String> navigate = playList.listIterator();
        Scanner input = new Scanner(System.in);
        boolean  quit = false;
        boolean forward = true;

        if(playList.isEmpty()){
            System.out.println("No song in play list");
        }else{
            System.out.println("Now playing " + navigate.next());
            printMenu();
        }

        while(!quit){
            int action = input.nextInt();
            input.nextLine();

            switch(action){
                case 0:
                    System.out.println("Playlist is complete");
                    quit = true;
                break;
                case 1:
                    if(!forward){
                        if(navigate.hasNext()){
                            navigate.next();
                        }
                        forward = true;
                    }
                    if(navigate.hasNext()){
                        System.out.println("Now playing " + navigate.next());
                    }else {
                        System.out.println("END OF PLAYLIST");
                    }
                break;
                case 2:
                    if(forward){
                        if(navigate.hasPrevious()){
                            navigate.previous();
                        }
                        forward = false;
                    }
                    if(navigate.hasPrevious()){
                        System.out.println("Now playing " + navigate.previous());
                    }else{
                        System.out.println("TOP OF PLAYLIST");
                    }
                break;
                case 3:
                    if(forward){
                        if(navigate.hasPrevious()){
                            System.out.println("Now playing " + navigate.previous());
                            forward = false;
                        }
                    }else{
                        if(navigate.hasNext()){
                            System.out.println("Now playing " + navigate.next());
                            forward = true;
                        }
                    }
                break;
                case 4:
                    printPlaylist();
                break;
                case 5:
                    if(!playList.isEmpty()){
                        navigate.remove();
                        if(navigate.hasNext()){
                            System.out.println("Now playing " + navigate.next());
                        }else{
                            System.out.println("Now playing " + navigate.previous());
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
        System.out.println(
                "0 -> TO QUIT PLAYLIST \n" +
                "1 -> TO PLAY NEXT SONG \n" +
                "2 -> TO PLAY PREVIOUS SONG \n" +
                "3 -> REPLAY SONG \n" +
                "4 -> PRINT PLAYLIST \n" +
                "5 -> DELETE SONG \n" +
                "6 -> PRINT MENU"
        );
    }

    private static void printPlaylist(){
        Iterator<String> display = playList.iterator();
        while(display.hasNext()){
            System.out.println(display.next());
        }
    }
}
