
package algorithm;

public class RabbitProblem {
    
    public static int rabbitPairsAfterMonths(int months) {
        if (months <= 0) return 0;
        if (months == 1 || months == 2) return 1;
        
        int prev1 = 1;
        int prev2 = 1;
        int current = 0;
        
        for (int i = 3; i <= months; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
    
    public static long rabbitPopulation(int months, int maturity, int offspring) {
        if (months <= 0) return 0;
        
        long[] population = new long[months + 1];
        
        population[0] = 0;
        population[1] = 1;
        
        for (int i = 2; i <= months; i++) {
            if (i < maturity) {
                population[i] = population[i - 1];
            } else {
                long newRabbits = offspring * population[i - maturity];
                population[i] = population[i - 1] + newRabbits;
            }
        }
        
        return population[months];
    }
    
    public static long rabbitPopulationWithDeath(int months, int maturity, int offspring, int lifespan) {
        if (months <= 0) return 0;
        
        long[] population = new long[months + 1];
        long[] births = new long[months + 1];
        
        population[0] = 0;
        births[0] = 0;
        
        if (months >= 1) {
            population[1] = 1;
            births[1] = 0;
        }
        
        for (int i = 2; i <= months; i++) {
            long newBirths = 0;
            if (i >= maturity) {
                for (int j = Math.max(1, i - lifespan + 1); j <= i - maturity; j++) {
                    newBirths += births[j] * offspring;
                }
            }
            births[i] = newBirths;
            
            population[i] = population[i - 1] + births[i];
            
            if (i > lifespan) {
                population[i] -= births[i - lifespan];
            }
        }
        
        return population[months];
    }
    
    public static int recursiveRabbitPairs(int months) {
        if (months <= 0) return 0;
        int[] memo = new int[months + 1];
        return recursiveRabbitPairs(months, memo);
    }
    
    private static int recursiveRabbitPairs(int months, int[] memo) {
        if (months <= 0) return 0;
        if (months == 1 || months == 2) return 1;
        
        if (memo[months] != 0) {
            return memo[months];
        }
        
        memo[months] = recursiveRabbitPairs(months - 1, memo) + 
                      recursiveRabbitPairs(months - 2, memo);
        return memo[months];
    }
    
    public static void displayRabbitSequence(int n) {
        System.out.println("Rabbit pairs for first " + n + " months:");
        System.out.println("Month\tPairs");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "\t" + rabbitPairsAfterMonths(i));
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Classic Rabbit Problem (Fibonacci) ===");
        displayRabbitSequence(12);
        
        System.out.println("\n=== Enhanced Rabbit Problems ===");
        
        int months = 12;
        System.out.println("\n1. After " + months + " months (classic): " + 
                          rabbitPairsAfterMonths(months));
        
        int maturity = 2;
        int offspring = 1;
        System.out.println("2. After " + months + " months, maturity " + maturity + 
                          " months: " + rabbitPopulation(months, maturity, offspring));
        
        maturity = 1;
        offspring = 3;
        System.out.println("3. After " + months + " months, " + offspring + 
                          " offspring per month: " + rabbitPopulation(months, maturity, offspring));
        
        int lifespan = 5;
        System.out.println("4. After " + months + " months, death after " + lifespan + 
                          " months: " + rabbitPopulationWithDeath(months, 1, 1, lifespan));
        
        System.out.println("\n=== Recursive Solution ===");
        System.out.println("Recursive result for " + months + " months: " + 
                          recursiveRabbitPairs(months));
        
        System.out.println("\n=== Verification ===");
        System.out.println("Iterative: " + rabbitPairsAfterMonths(months));
        System.out.println("Recursive: " + recursiveRabbitPairs(months));
        System.out.println("Match: " + (rabbitPairsAfterMonths(months) == recursiveRabbitPairs(months)));
    }
}


/*run:
=== Classic Rabbit Problem (Fibonacci) ===
Rabbit pairs for first 12 months:
Month	Pairs
1	1
2	1
3	2
4	3
5	5
6	8
7	13
8	21
9	34
10	55
11	89
12	144

=== Enhanced Rabbit Problems ===

1. After 12 months (classic): 144
2. After 12 months, maturity 2 months: 144
3. After 12 months, 3 offspring per month: 4194304
4. After 12 months, death after 5 months: 1

=== Recursive Solution ===
Recursive result for 12 months: 144

=== Verification ===
Iterative: 144
Recursive: 144
Match: true*/

