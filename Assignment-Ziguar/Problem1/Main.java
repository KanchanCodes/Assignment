package Problem1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> oldTaskQueue = Arrays.asList("A", "B", "C", "D", "E", "F", "A", "B", "C", "D", "A", "B", "C", "A", "B", "A");
        int currentIndex = 7;
        List<String> newTaskQueue = Arrays.asList("A", "B", "C", "D", "E", "F", "A", "B", "C", "D", "A", "B", "C", "A", "B", "A");

        int newIndex = findCurrentIndexMemberIndex(oldTaskQueue, currentIndex, newTaskQueue);
        System.out.println("New index of the Current Index Member: " + newIndex);
    }

    public static int findCurrentIndexMemberIndex(List<String> oldTaskQueue, int currentIndex, List<String> newTaskQueue) {
        Map<String, Integer> memberToIndexMap = new HashMap<>();
        int i = 0;
        for (String member : newTaskQueue) {
            if (!memberToIndexMap.containsKey(member)) {
                memberToIndexMap.put(member, i);
            }
            i++;
        }

        String currentMember = oldTaskQueue.get(currentIndex);
        int currentMemberIndex = memberToIndexMap.getOrDefault(currentMember, -1);

        if (currentMemberIndex == -1) {
            int nextIndex = currentIndex + 1;
            while (nextIndex < oldTaskQueue.size()) {
                String nextMember = oldTaskQueue.get(nextIndex);
                if (memberToIndexMap.containsKey(nextMember)) {
                    return memberToIndexMap.get(nextMember);
                }
                nextIndex++;
            }
        }

        return currentMemberIndex;
    }

    @Override
    public String toString() {
        return "Main []";
    }
}
