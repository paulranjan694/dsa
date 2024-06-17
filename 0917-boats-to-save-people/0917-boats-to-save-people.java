class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int ans=0,l=0,r=n-1;
        Arrays.sort(people);
        while(l<=r){
            if(people[l] + people[r] <= limit){
                l++;
            }
            r--;
            ans++;
        }
        return ans;
    }
}