package by.babanin.quoters;

public class T1000 extends TerminatorQuoter {
    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Я пршел убит Сару Конер!");
    }
}
