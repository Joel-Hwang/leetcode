package DesignPattern.Singleton;

public class SecondPage {
    private Settings settings = Settings.getSettings();
    public SecondPage(){
        settings.print();
    }
}
