//Fibonacci in o(n)
/*
find the nth number in a Fibonacci sequence(0 based) in o(n) 
example :
input: n=7      output: 8
Explanation :  
sequence is : 0 1 1 2 3 5 8 13 
the 7th number is 8 
*/

    public static int fibb(int n){
        return fibbH(n,1,0);
    }

    private static int fibbH(int n, int cur, int prv) {
        if(n==0)return prv;
        else if(n==1) return cur;
        return fibbH(n-1,cur+prv,cur);
    }
