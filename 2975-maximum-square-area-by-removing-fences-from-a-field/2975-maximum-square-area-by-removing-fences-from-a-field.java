class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int l1 = hFences.length, l2 = vFences.length;

        int[] hFen = new int[l1+2];
        int[] vFen = new int[l2+2];

        hFen[0]=1;
        hFen[1] = m;
        vFen[0] = 1;
        vFen[1] = n;

        for(int i=0;i<l1;i++){
            hFen[i+2] = hFences[i];
        }

        for(int i=0;i<l2;i++){
            vFen[i+2] = vFences[i];
        }

        Set<Integer> seen = new HashSet<>();

        for(int i=0;i<hFen.length;i++){
            for(int j=i+1;j<hFen.length;j++){
                seen.add(Math.abs(hFen[i]-hFen[j]));
            }
        }
        //System.out.println(seen);
        long area = -1;
        for(int i=0;i<vFen.length;i++){
            for(int j=i+1;j<vFen.length;j++){
               int l = Math.abs(vFen[i]-vFen[j]);

                if(seen.contains(l)){
                    area = Math.max(area, (long)l*l);    
                }
            }
        }

        return (int)(area % 1_000_000_007);
    }
}