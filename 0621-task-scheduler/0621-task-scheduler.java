class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> taskHash = new HashMap<>();
        Queue<Task> maxHeap = new PriorityQueue<>((t1,t2) -> Integer.compare(t2.count, t1.count));

        for(char task : tasks){
            taskHash.put(task, taskHash.getOrDefault(task, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : taskHash.entrySet()){
            maxHeap.offer(new Task(entry.getKey(), entry.getValue()));
        }

        Queue<Task> cooldown = new LinkedList<>();
        int time = 0;
        
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            // Re-add ready tasks from cooldown queue
            if (!cooldown.isEmpty() && cooldown.peek().nextAvailableTime <= time) {
                maxHeap.offer(cooldown.poll());
            }

            if (!maxHeap.isEmpty()) {
                Task current = maxHeap.poll();
                current.count--;
                if (current.count > 0) {
                    current.nextAvailableTime = time + n + 1;
                    cooldown.offer(current);
                }
            }
            // else idle (if no task can be scheduled now)
        }

        return time;
    }

    static class Task{
        char task;
        int nextAvailableTime=0;
        int count;
        Task(char t, int count){
            this.task=t;
            this.count=count;
        }
    }
}