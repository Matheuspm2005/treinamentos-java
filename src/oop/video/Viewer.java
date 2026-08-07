package oop.video;

public class Viewer extends Person{
    private String login;
    private int watchedVideos;

    public Viewer(String name, int age, char sex, String login) {
        super(name, age, sex);
        this.login = login;
        this.watchedVideos = 0;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getWatchedVideos() {
        return watchedVideos;
    }

    public void setWatchedVideos(int watchedVideos) {
        this.watchedVideos = watchedVideos;
    }

    @Override
    public String toString() {
        return "Viewer{" +
                "login='" + login + '\'' +
                ", watchedVideos=" + watchedVideos +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", experience=" + experience +
                '}';
    }
}
