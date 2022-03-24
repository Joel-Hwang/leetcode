package CS;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

public class VendingMachine {
    private int balance;
    public int[] getCoins(int balance){
        int[] coins = {500,100,50,10};
        int[] count = new int[coins.length];
        for(int i = 0; i<coins.length; i++){
            if(balance < 10) break;
            count[i] = balance/coins[i];
            balance -= count[i]*coins[i];
        }
        return count;
    }

    public int getBalance(int price, int curBalance){
        if(price > curBalance) return curBalance;
        curBalance -= price;
        return curBalance;
    }

    public void buy(int price){
        balance = getBalance(price, balance);
        int[] coins = getCoins(balance);
        System.out.println(Arrays.toString(coins) + "=>" + balance));
    }

    @Test
    public void testGetCoins(){
        assertArrayEquals(new int[]{0,0,0,0}, getCoins(6));
        assertArrayEquals(new int[]{0,1,0,0}, getCoins(101));
        assertArrayEquals(new int[]{2,0,0,0}, getCoins(1000));
        assertArrayEquals(new int[]{1,1,0,0}, getCoins(600));
        assertArrayEquals(new int[]{1,2,0,0}, getCoins(700));
    } 

    @Test
    public void testSetBalance(){
        assertEquals(100, getBalance(100,200));
        assertEquals(200, getBalance(100,300));
    }
}

