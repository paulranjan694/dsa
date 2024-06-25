class SortCompare implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        String s1 = a+b;
        String s2 = b+a;
        return s2.compareTo(s1);
    }

}

class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(str, new SortCompare());

        if(str[0].equals("0"))
            return "0";
        String ans = new String();
        for(String s: str){
            ans+=s;
        }
        return ans;
    }
}