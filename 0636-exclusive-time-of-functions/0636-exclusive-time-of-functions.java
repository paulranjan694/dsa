class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<String[]> st = new Stack<>();
        for(String log:logs){
            String[] arr = log.split(":");
            String id = arr[0];
            String op = arr[1];
            String time = arr[2];

            if("start".equals(op)){
                String[] temp = new String[3];
                temp[0] = id;
                temp[1]=time;
                temp[2]= "0";
                st.push(temp);
            }else{
                String[] s = st.pop();
                int fid = Integer.parseInt(s[0]);
                int ftime = Integer.parseInt(s[1]);
                int gap = Integer.parseInt(s[2]);
                int interval = Integer.parseInt(time) - ftime +1;
                int tgap = interval-gap;
                if(!st.empty()){
                    String[] str = st.peek();
                    str[2] = Integer.toString(Integer.parseInt(str[2]) + interval);
                }
                res[fid] += tgap;
            }
        }

        return res;
    }
}