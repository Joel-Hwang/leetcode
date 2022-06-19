package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class _1268_SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Map<String, List<String>> map = getMap(products);
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i<searchWord.length(); i++){
            String partWord = searchWord.substring(0, i+1);
            List<String> row = getSuggestions(partWord,map);
            res.add(row);
        }
        return res;
    }

    private List<String> getSuggestions(String searchWord, Map<String, List<String>> map){
        List<String> startWithProducts = map.get(searchWord);
        List<String> res = new ArrayList<>();
        for(int j = 0; startWithProducts != null &&  j<Math.min(startWithProducts.size(), 3); j++){
            res.add(startWithProducts.get(j));
        }
        return res;
    }

    private Map<String, List<String>> getMap(String[] products){
        Map<String, List<String>> map = new HashMap<>();
        for(String product : products){
            for(int i = 0; i<product.length(); i++){
                String part = product.substring(0, i+1);
                if(map.containsKey(part)){
                    map.get(part).add(product);
                }else{
                    List<String> row = new ArrayList<String>();
                    row.add(product);
                    map.put(part, row);
                }
            }
        }

        for(String key : map.keySet())
            Collections.sort(map.get(key));

        return map;
    }

    @Test
    public void test(){
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        suggestedProducts(products,searchWord);
    }
}
