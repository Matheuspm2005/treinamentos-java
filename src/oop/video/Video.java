package oop.video;

public class Video implements VideoAction{
    private String title;
    private int rating;
    private long views;
    private long likes;
    private boolean playing;

    public Video(String title) {
        this.title = title;
        this.rating = 0;
        this.views = 0;
        this.likes = 0;
        this.playing = false;
    }

    @Override
    public void play() {
        setPlaying(true);
    }

    @Override
    public void pause() {
        setPlaying(false);
    }

    @Override
    public void like() {
        setLikes(getLikes() + 1);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        int newRate;
        newRate = (int) ((this.rating + rating) / this.views);
        this.rating = newRate;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", views=" + views +
                ", likes=" + likes +
                ", playing=" + playing +
                '}';
    }
}
