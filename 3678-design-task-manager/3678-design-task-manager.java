class TaskManager {
    private final int[] priorities = new int[100001];
    private final int[] userIds = new int[100001];
    private final PriorityQueue<Long> PQ = new PriorityQueue<>((a, b) -> Long.compare(b, a));

    public TaskManager(List<List<Integer>> tasks) {
        Arrays.fill(priorities, -1);
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            priorities[taskId] = priority;
            userIds[taskId] = userId;
            PQ.offer(((long) priority) * 100001 + taskId);
        }
    }

    public void add(int userId, int taskId, int priority) {
        if (priorities[taskId] != -1) return; // already exists
        priorities[taskId] = priority;
        userIds[taskId] = userId;
        PQ.offer(((long) priority) * 100001 + taskId);
    }

    public void edit(int taskId, int newPriority) {
        if (priorities[taskId] == -1) return; // doesn't exist
        priorities[taskId] = newPriority;
        PQ.offer(((long) newPriority) * 100001 + taskId);
    }

    public void rmv(int taskId) {
        priorities[taskId] = -1;
    }

    public int execTop() {
        while (!PQ.isEmpty()) {
            long current = PQ.poll();
            int taskId = (int) (current % 100001);
            int priority = (int) (current / 100001);
            if (priorities[taskId] != priority) continue; // outdated
            priorities[taskId] = -1;
            return userIds[taskId];
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */