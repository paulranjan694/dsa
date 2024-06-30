class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
       int h1 = height(red,blue);
       //int h1 = 1;
        int h2 = height(blue,red);

       // System.out.println(h1+"---"+h2);
        return Math.max(h1,h2);
    }

    public int height(int f, int s){
        int count=0;
        while(f>=0 && s>=0){
            if(count%2==0 && f>=count+1){
                f-=count+1;
                count++;
            }else if(count%2!=0 && s>=count+1){
                s-=count+1;
                count++;
            }else{
                //System.out.println(f+"-----"+s+"---"+count);
                break;
            }
            //System.out.println(f+"-----"+s+"---"+count);
        }

        return count;
    }
}