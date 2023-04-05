package Inheritance.Bil211Lab;

public class Journal extends WritingPiece{
    public Journal(String name, int wordCount) {
        super(name, wordCount);
        setType("Journal");
        setReadingTimeMultiplier(1.0);
        setEstimatedReadingTime((int) Math.ceil(wordCount / 200 * getReadingTimeMultiplier()));
    }
    private Article[] articles;
    private double averageCitations;
}
