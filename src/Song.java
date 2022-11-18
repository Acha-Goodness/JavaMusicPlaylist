
public class Song {
        private String title;
        private double duration;

        public Song(String title, double duration){
            if(duration < 0) System.out.println("INVALID SONG DURATION");
            this.title = title;
            this.duration = duration;
        }

        public void setTile(String title){
            this.title = title;
        }
        public String getTitle(){
            return title;
        }

        public void setDuration(int duration){
            this.duration = duration;
        }

        @Override
        public String toString(){
            return this.title + ": " + this.duration;
        }
}
