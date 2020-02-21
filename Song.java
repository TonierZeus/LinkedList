public class Song {

    private String name;
    private double Duration;

    public Song(String name, double duration) {
        this.name = name;
        Duration = duration;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return Duration;
    }

    public static Song createSong(String name, Double duration){
        return new Song(name, duration);
    }
}
