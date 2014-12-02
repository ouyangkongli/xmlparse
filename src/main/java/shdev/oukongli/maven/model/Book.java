package shdev.oukongli.maven.model;

/**
 * Created by kouyang on 12/2/2014.
 */
public class Book {
    private String id;
    private String title;
    private String author;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
