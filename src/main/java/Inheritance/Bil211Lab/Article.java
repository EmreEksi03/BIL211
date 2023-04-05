package Inheritance.Bil211Lab;

public class Article extends WritingPiece{
    public Article(String name, int wordCount) {
        super(name, wordCount);
        setType("Article");
        setReadingTimeMultiplier(1.5);
        setEstimatedReadingTime((int) Math.ceil(wordCount / 200 * getReadingTimeMultiplier()));
    }
    private String firstAuthor;
    private int citations;
}
