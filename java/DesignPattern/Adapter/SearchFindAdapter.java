package DesignPattern.Adapter;

import DesignPattern.Strategy.SearchStrategy;

public class SearchFindAdapter implements SearchStrategy {
    private FindAlgorithm findAlgorithm;
    public SearchFindAdapter(FindAlgorithm findAlgorithm){
        this.findAlgorithm = findAlgorithm;
    }
    @Override
    public void search() {
        findAlgorithm.find(true);
    }
}
