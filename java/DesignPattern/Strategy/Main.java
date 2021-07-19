package DesignPattern.Strategy;

public class Main {
    private static SearchButton sb = new SearchButton();
    public static void main(String[] args) {
        setModeAll();
        sb.onClick();
        setModeImage();
        sb.onClick();
        setModeNews();
        sb.onClick();
        setModeMap();
        sb.onClick();
    }

    public static void setModeAll(){
        sb.setSearchStragegy(new SearchStrategyAll());
    }

    public static void setModeImage(){
        sb.setSearchStragegy(new SearchStrategyImage());
    }

    public static void setModeNews(){
        sb.setSearchStragegy(new SearchStrategyNews());
    }

    public static void setModeMap(){
        sb.setSearchStragegy(new SearchStrategyMap());
    }
}
