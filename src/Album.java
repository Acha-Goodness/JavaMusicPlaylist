import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
        private String name;
        private String artist;
        private ArrayList<Song> songs;

    public Album(String name, String artist){
            this.name = name;
            this.artist = artist;
            songs = new ArrayList<>();
        }

        //   ADD SONGS
    public boolean addSong(String title, double duration){
            Song result = findSong(title);
            if(result == null){
                songs.add(new Song(title, duration));
                return true;
            }else{
                System.out.println("The Song " + title + " already in album");
                return false;
            }
        }

        //   FIND SONGS
    private Song findSong(String title){
           for(Song checkedSong : songs){
               if(checkedSong.getTitle().equals(title)){
                   return checkedSong;
               }
           }
           return null;
        }

        //   ADD ALBUM TO PLAYLIST WITH INDEX
    public boolean addSongToPlayList(int trackNumber, LinkedList<String> playList){
        int track = trackNumber - 1;
            if(track >= 0 && track <= songs.size()){
                playList.add(this.songs.get(track).toString());
                return true;
            }
            System.out.println("This track number " + track + " does not exist");
            return false;
        }

        //   ADD ALBUM TO PLAYLIST WITH TITLE
    public boolean addSongToPlayList(String title, LinkedList<String> playList){
            if(findSong(title) != null){
                playList.add(title);
                return true;
            }
            System.out.println("The Song " + title + " does not exist");
            return false;
    }
}
