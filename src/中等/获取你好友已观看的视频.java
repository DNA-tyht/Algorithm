package 中等;

import java.util.*;

/**
 * @Description 1311
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 20:41
 */
public class 获取你好友已观看的视频 {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

        //获取level等级的id
        Queue<Integer> queueId = new LinkedList<>(); //记录id
        HashSet<Integer> setId = new HashSet<>(); //id去重
        queueId.add(id);
        setId.add(id);
        int size = queueId.size();
        while (level > 0) {
            int curId = queueId.poll();
            for (int friendId : friends[curId]) {
                if (!setId.contains(friendId)) {
                    queueId.add(friendId);
                    setId.add(friendId);
                }
            }
            size--;
            if (size == 0) {
                level--;
                size = queueId.size();
            }
        }
        //对视频计数
        HashMap<String, Integer> map = new HashMap<>();
        while (!queueId.isEmpty()) {
            List<String> videos = watchedVideos.get(queueId.poll());
            for (String item : videos) {
                if (map.get(item) == null)
                    map.put(item, 1);
                else
                    map.put(item, map.get(item) + 1);
            }
        }
        ArrayList<String> list = new ArrayList<>(map.keySet());
        //对list排序
        list.sort((a, b) ->{
            if (map.get(a) == map.get(b))  //出现次数相同时
                return a.compareTo(b);
            return map.get(a) - map.get(b);
        });
        return list;
    }
}
