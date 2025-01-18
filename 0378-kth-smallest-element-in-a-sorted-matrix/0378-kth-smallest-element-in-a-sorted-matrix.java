class Node{
    int row,col,value;
    Node(int row, int col, int value){
        this.row = row;
        this.col = col;
        this.value = value;
    }
}

class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node a, Node b){
        return a.value-b.value;
    }

}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Node> pq = new PriorityQueue<>(new NodeComparator());
        int n = matrix.length;
        for(int i = 0;i<Math.min(n,k);i++){
            pq.offer(new Node(i,0,matrix[i][0]));
        }
        Node element = pq.peek();
        while(k-- > 0){
            element = pq.poll();
            int row = element.row;
            int col = element.col;
            if(col + 1 < n){
                pq.offer(new Node(row,col+1,matrix[row][col+1]));
            }
        }

        return element.value;
    }
}