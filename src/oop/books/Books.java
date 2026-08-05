package oop.books;

public class Books implements Publication {
    private String title;
    private String author;
    private int totalPages;
    private int currentPage;
    private boolean status;
    private Person reader;

    public String detail() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", totalPages=" + totalPages +
                ", currentPage=" + currentPage +
                ", open=" + status +
                ", reader=" + reader.name +
                '}';
    }

    //Special Methods

    public Books(String title, String author, int totalPages, Person reader) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.status = false;
        this.currentPage = 0;
        this.reader = reader;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus(){return status;}

    public void setReader(Person reader) {
        this.reader = reader;
    }

    public Person getReader() {
        return reader;
    }

    @Override
    public void open() {
        setStatus(true);
    }

    @Override
    public void close() {
        setStatus(false);
    }

    @Override
    public void leafThrough(int p) {
        if (p > getTotalPages())
            setCurrentPage(0);
        else
            setCurrentPage(p);

    }

    @Override
    public void nextPage() {
        setCurrentPage(getCurrentPage() + 1);
    }

    @Override
    public void previousPage() {
        setCurrentPage(getCurrentPage() + 1);
    }
}
