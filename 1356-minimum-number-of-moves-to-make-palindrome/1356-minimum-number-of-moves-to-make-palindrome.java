class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] arr = s.toCharArray();
        int left=0,right =arr.length-1;
        int moves = 0;

        while(left<=right){
            if(arr[left] != arr[right]){
                int temp = right-1;
                while(temp>left && arr[temp]!= arr[left]){
                    if(arr[left] == arr[temp]){
                        break;
                    }
                    temp--;
                }
                if(temp!=left && arr[temp]==arr[left]){
                    while(temp<right){
                        char c = arr[temp];
                        arr[temp] = arr[temp+1];
                        arr[temp+1] = c;
                        temp++;
                        moves++;
                    }
                    right--;
                }else{
                    int mid = arr.length / 2;
                    moves+= mid - left;
                }
                left++;
            }else{
                left++;
                right--;
            }
        }

        return moves;
    }
}