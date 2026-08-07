package oop.video;

public class Visualization {
    private Viewer viewer;
    private Video video;

    public Visualization(Viewer viewer, Video video) {
        this.viewer = viewer;
        this.video = video;
        this.viewer.setWatchedVideos(getViewer().getWatchedVideos() + 1);
        this.video.setViews(getVideo().getViews() + 1);
    }

    public void rate(int rating){
        this.video.setRating(rating);
        this.viewer.setExperience(rating, this.viewer.getWatchedVideos());
    }

    public void rate(float percentage){
        int total;
        if(percentage <= 20)
            total = 3;
        else if(percentage <= 50)
            total = 5;
        else if(percentage <=90)
            total = 8;
        else
            total = 10;
        this.video.setRating(total);
        this.viewer.setExperience(total, this.viewer.getWatchedVideos());
    }

    @Override
    public String toString() {
        return "Visualization{" +
                "viewer=" + viewer +
                ", video=" + video +
                '}';
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
