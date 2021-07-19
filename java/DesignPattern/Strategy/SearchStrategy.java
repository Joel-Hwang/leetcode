package DesignPattern.Strategy;

public interface SearchStrategy{
    public void search();
}


class SearchStrategyAll implements SearchStrategy {
    @Override
    public void search() {
    System.out.println("SEARCH ALL");        
    }
}

class SearchStrategyImage implements SearchStrategy {
    @Override
    public void search() {
        System.out.println("Search Image");
    }
}

class SearchStrategyNews implements SearchStrategy {
    @Override
    public void search() {
        System.out.println("Search News");
    }
}

class SearchStrategyMap implements SearchStrategy {
    @Override
    public void search() {
        System.out.println("Search Map");
    }
}