package 연습문제;

import java.util.*;

public class 과제_진행하기 {

    public static String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        Map<String, Task> tasks = new HashMap<>();

        for (String[] plan : plans) {
            String name = plan[0];
            int start = toMinutes(plan[1]);
            int playtime = Integer.parseInt(plan[2]);

            if (tasks.containsKey(name)) { // 이미 등록된 과제가 있을 때
                Task task = tasks.get(name);
                if (task.state == State.PLAYING) { // 진행 중인 과제일 때
                    task.stop = start; // 중지 시간을 현재 과제의 시작 시간으로 설정
                    task.state = State.STOPPED; // 상태를 멈춘 상태로 변경
                } else { // 멈춰져 있는 과제일 때
                    task.playtime += task.stop - task.start; // 이전에 멈췄던 시간만큼 playtime에 추가
                    task.start = start; // 시작 시간을 현재 과제의 시작 시간으로 변경
                    task.stop = 0; // 중지 시간 초기화
                    task.state = State.PLAYING; // 상태를 진행 중인 상태로 변경
                }
            } else { // 새로운 과제일 때
                for (Task task : tasks.values()) { // 멈춘 과제가 있는지 확인
                    if (task.state == State.STOPPED && task.stop < start) { // 가장 최근에 멈췄고, 멈췄던 시간이 현재 과제 시작 시간보다 작을 때
                        task.start = start; // 시작 시간 변경
                        task.playtime = playtime; // playtime 변경
                        task.stop = 0; // 중지 시간 초기화
                        task.state = State.PLAYING; // 상태를 진행 중인 상태로 변경
                        tasks.put(name, task);
                        break;
                    }
                }
                // 멈춘 과제가 없으면 새로 등록
                if (!tasks.containsKey(name)) {
                    Task task = new Task(name, start, playtime, 0, State.PLAYING);
                    tasks.put(name, task);
                }
            }
        }

        // 과제를 마친 순서대로 리스트에 추가
        for (Task task : tasks.values()) {
            if (task.state == State.PLAYING) {
                task.playtime += 1440 - task.stop; // 마지막 과제는 23:59분에 끝나므로, 1440(24시간)에서 stop 시간만큼 빼주어야 함
            }
            result.add(task.name);
        }

        return result.toArray(String[]::new);
    }

    private static int toMinutes(String time) {
        String[] tokens = time.split(":");
        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        return hours * 60 + minutes;
    }

    public static class Task {
        public String name;
        public int start;
        public int playtime;
        public int stop;
        public State state;

        public Task(String name, int start, int playtime, int stop, State state) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
            this.stop = stop;
            this.state = state;
        }
    }

    public enum State {
        PLAYING,
        STOPPED
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new 과제_진행하기().solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}}))
        );
    }
}
