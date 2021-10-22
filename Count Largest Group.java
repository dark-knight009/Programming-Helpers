class Solution {
    public int countLargestGroup(int n) {
        int maxGroupSize = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
    
        for (int i = 1; i <= n; i++) {
            int val = i;
            if (i > 9) {
               
                val = sumOfDigits(i);
            }
            int totalVals = map.getOrDefault(val, 0) + 1;
            
            maxGroupSize = Math.max(maxGroupSize, totalVals);
            
            
            map.put(val, totalVals);
        }
        
        for(Integer cnt:map.values()) {
         
            if(cnt == maxGroupSize) {
                result++;
            }
        }
        
        return result;
    }
    
    private int sumOfDigits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
