class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int ans=0,l=0,r=n-1;
        Arrays.sort(people);
        while(l<=r){
            if(people[l] + people[r] > limit){
                ans++;
                r--;
            }else if(people[l] + people[r] <= limit){
                ans++;
                l++;r--;
            }else if(l==r){
                int temp = people[l];
                while(temp > 0 && temp <= limit){
                    ans++;
                    temp = limit-temp;
                }
                l++;
            }
        }
        return ans;
    }
}