import java.io.*;import java.util.*;

public class SumIntegers {
    
    public static void main(String[] args) {
        List<String> stringNumbers = Arrays.asList("10", "20", "30", "40", "50");
        
        List<Integer> integers = parseStringsToIntegers(stringNumbers);
        int sum = calculateSum(integers);
        
        System.out.println("Sum of integers: " + sum);
    }
    
    public static List<Integer> parseStringsToIntegers(List<String> stringNumbers) {
        List<Integer> integers = new ArrayList<>();
        for (String str : stringNumbers) {
            integers.add(Integer.parseInt(str));
        }
        return integers;
    }
    
    public static int calculateSum(List<Integer> integers) {
        int sum = 0;
        for (Integer num : integers) {
            sum += num;  // Autoboxing and unboxing happen here
        }
        return sum;
    }
}

