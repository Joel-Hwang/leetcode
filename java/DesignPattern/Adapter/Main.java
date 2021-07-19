package DesignPattern.Adapter;

import DesignPattern.Strategy.SearchButton;

public class Main {
    private static SearchButton sb = new SearchButton();
    public static void main(String[] args) {
        setModeFind();
        sb.onClick();
    }

    public static void setModeFind(){
        sb.setSearchStragegy(new SearchFindAdapter(new FindAlgo()));
    }
}
