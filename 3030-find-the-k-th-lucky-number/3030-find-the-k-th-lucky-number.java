class Solution {
    public String kthLuckyNumber(int k) {
        StringBuilder luckynum = new StringBuilder();
        k++;
        // StringBuilder binaryrep = new StringBuilder();

        // k++;

        // while(k>0){
        //     binaryrep.append(k%2);
        //     k=k/2;
        // }

        // binaryrep.reverse();
        // int skip=0;
        // for(;skip<binaryrep.length();skip++){
        //     if(binaryrep.charAt(skip)=='1'){
        //         break;
        //     }
        // }

        // String binary = binaryrep.substring(skip+1);

        // for(int i=0;i<binary.length();i++){
        //     if(binary.charAt(i) == '0'){
        //         luckynum.append('4');
        //     }else{
        //         luckynum.append('7');
        //     }
        // }

        // return luckynum.toString();
        String binaryString = Integer.toBinaryString(k).substring(1);
        for(int i=0;i<binaryString.length();i++){
            if(binaryString.charAt(i) == '0'){
                luckynum.append('4');
            }else{
                luckynum.append('7');
            }
        }

        return luckynum.toString();
    }
}