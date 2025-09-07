/**
    calculate the max difference in current average and new average(by adding 1 student) and to maximise, always add student to class where diff is max


 */
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxheap = new PriorityQueue<double[]>((a, b) -> Double.compare(b[3], a[3]));

        for(int [] cls : classes){
            double pass = cls[0];
            double total = cls[1];
            double avg = pass/total;
            double avg1 = (pass+1) / (total+1);
            double[] temp = {cls[0], cls[1], avg, avg1-avg};
            maxheap.add(temp);
        }

        while(extraStudents-- > 0){
            double[] temp = maxheap.poll();
            double passSt = temp[0]+1;
            double totalSt = temp[1]+1;
            double avg = passSt/totalSt;
            double avg1 = (passSt+1)/(totalSt+1);
            double[] t1 = {passSt, totalSt, avg, avg1-avg};
            maxheap.add(t1);
        }

        double answer=0.0;



        while(maxheap.size() > 0){
            answer += maxheap.poll()[2];
        }

        return Math.round((answer/classes.length) * 100000.0) / 100000.0;


    }
}