// 167. Two Sum II - Input Array Is Sorted - medium
//my soln
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans[] = new int[2];
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            if(hm.containsKey(target-num)){
                ans[0] = hm.get(target-num);
                ans[1] = i;
            }
            hm.put(num, i);
        }
        ans[0]++;
        ans[1]++;
        return ans;
    }
}

//better soln 
//optimised
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int ans[] = new int[2];
        while(numbers[left]+numbers[right]!=target){
            int calc = numbers[left]+numbers[right];
            if(calc<target){
                left++;
            }else{
                right--;
            }
        }
        ans[0] = left+1;
        ans[1] = right+1;
        return ans;
    }
}