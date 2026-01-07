
package recursion;

public class towerOfHanoi {

    static void towerOfHanoi(int n,char fromRod, char toRod, char auxRod) {
        
        if (n==0) {
            return;
            
        }
        
        towerOfHanoi(n-1,fromRod,auxRod,toRod);
        
        System.out.println(" Move disk "+ n + " from rod " + fromRod + " torod " + toRod);
        
        towerOfHanoi( n-1,auxRod,toRod,fromRod);

    }
    
    public static void main(String[]args){
    
        int N=3; // number of disks
        towerOfHanoi(N,'A','C','B'); //A= Source C=Destination B= Auxiliary
    
    }
    
}

/*
run:
 Move disk 1 from rod A torod C
 Move disk 2 from rod A torod B
 Move disk 1 from rod C torod B
 Move disk 3 from rod A torod C
 Move disk 1 from rod B torod A
 Move disk 2 from rod B torod C
 Move disk 1 from rod A torod C
*/