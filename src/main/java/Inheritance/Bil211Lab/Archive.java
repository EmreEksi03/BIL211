package Inheritance.Bil211Lab;

public class Archive {
    private WritingPiece[] archive;
    private int getTotalNumberOfWords(){
        int x = 0;
        for (int i=0;i<archive.length;i++){
            x += archive[i].getWordCount();
        }
        return x;
    }
    private String getTotalEstimatedReadingTime(){
        return "";
    }
    private int getNumberOfBooksInGenre(String targetGenre){
        int x = 0;
        for (int i=0;i<archive.length;i++){
            if (archive[i].getType().equals("Book")){
                Book book = (Book) archive[i];
                if (book.getGenre().equals(targetGenre))
                    x++;
            }
        }
        return x;
    }
    private int getTotalNumberOfArticles(){
        int x = 0;
        for (int i=0;i<archive.length;i++){
            if (archive[i].getType().equals("article"))
                x++;
        }
        return x;
    }
    private void printJournalsOverCitation(double targetAVGCitations){

    }
    private void printArticlesOverCitation(double targetCitation){

    }
}
