class TaskManager {
    private static class Task {
        int userId, taskId, priority;

        Task(int u, int t, int p) {
            userId = u;
            taskId = t;
            priority = p;
        }
    }

    private final Map<Integer, Task> taskMap;
    private final PriorityQueue<Task> maxHeap;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        maxHeap = new PriorityQueue<>(
                (a, b) -> a.priority == b.priority
                        ? Integer.compare(b.taskId, a.taskId)
                        : Integer.compare(b.priority, a.priority));
        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        taskMap.put(taskId, t);
        maxHeap.offer(t);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        if (old == null)
            return;
        Task updated = new Task(old.userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        maxHeap.offer(updated);
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            Task valid = taskMap.get(top.taskId);
            if (valid != null
                    && valid.priority == top.priority
                    && valid.userId == top.userId) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
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