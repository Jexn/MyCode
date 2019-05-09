package Day01;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

public class StaticFactory {
    @Test
    public void method1(){
        BigInteger prime = BigInteger.probablePrime(5,new Random(1000));
        System.out.println(prime);
    }

    @Test
    public void builderModel(){
        NutritionFacts coaCola = new NutritionFacts.Builder(240,8).calories(100).sodium(35).carbohydrate(27).Builder();
        System.out.println(coaCola);
    }
}
