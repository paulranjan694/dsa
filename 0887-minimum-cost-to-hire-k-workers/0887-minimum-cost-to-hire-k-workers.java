class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<double[]> workers = new ArrayList<>();

        for(int i = 0; i < wage.length;i++){
            workers.add(new double[]{(double)wage[i]/quality[i],(double)quality[i]});
        }
        Collections.sort(workers, Comparator.comparingDouble(a -> a[0]));

        Queue<Double> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b, a));
        double totalQuality = 0.0,minCost=Double.MAX_VALUE;
        for(double[] worker : workers){
            totalQuality += worker[1];
            maxHeap.add(worker[1]);

            if(maxHeap.size() > k){
                double workQuality = maxHeap.poll();
                totalQuality -= workQuality;
            }

            if(maxHeap.size() == k){
                minCost = Math.min(minCost, worker[0]*totalQuality);
            }
        }
        return minCost;
       
    }
}