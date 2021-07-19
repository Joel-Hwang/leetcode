package DesignPattern.Strategy;

public class SearchButton {
    public SearchButton(){

    }

    private SearchStrategy searchStrategy = new SearchStrategyAll();

    public void setSearchStragegy(SearchStrategy searchStrategy){
        this.searchStrategy = searchStrategy;
    }

    public void onClick(){
        searchStrategy.search();
    }
}
