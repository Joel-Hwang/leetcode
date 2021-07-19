package DesignPattern.Singleton;

public class FirstPage {
    private Settings settings = Settings.getSettings();
    public FirstPage(){
        settings.print();
    }
}
