package Inheritance.Bil211Lab;

public class Book extends WritingPiece{
    public Book(String name, int wordCount) {
        super(name, wordCount);
        setType("Book");
        setReadingTimeMultiplier(1.2);
        setEstimatedReadingTime((int) Math.ceil(wordCount / 200 * getReadingTimeMultiplier()));
    }
    private int numberOfChapters;
    private String author;
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
