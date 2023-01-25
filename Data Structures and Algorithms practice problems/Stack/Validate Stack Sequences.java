//https://leetcode.com/problems/validate-stack-sequences/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack <Integer> pushedStack =new Stack<> ();

        for(int i=0,j=0;i<popped.length ;i++){
           pushedStack.push(pushed[i]);
           while(!pushedStack.isEmpty()&& pushedStack.peek()==popped[j]){
               pushedStack.pop();
               j++;
           }

        }
        return pushedStack.isEmpty();
    }
}
