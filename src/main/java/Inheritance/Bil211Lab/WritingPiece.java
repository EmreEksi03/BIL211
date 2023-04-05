package Inheritance.Bil211Lab;

public class WritingPiece {
    private String type;
    private String Name;
    private int wordCount;
    private int estimatedReadingTime;
    private double readingTimeMultiplier;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getEstimatedReadingTime() {
        return estimatedReadingTime;
    }

    public void setEstimatedReadingTime(int estimatedReadingTime) {
        this.estimatedReadingTime = estimatedReadingTime;
    }

    public double getReadingTimeMultiplier() {
        return readingTimeMultiplier;
    }

    public void setReadingTimeMultiplier(double readingTimeMultiplier) {
        this.readingTimeMultiplier = readingTimeMultiplier;
    }

    public WritingPiece(String name, int wordCount) {
        Name = name;
        this.wordCount = wordCount;
    }
}
