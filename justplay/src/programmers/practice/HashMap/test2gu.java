package programmers.practice.HashMap;

import java.lang.reflect.Field;
import java.util.HashMap;

// 과제 3) 원소 수가 capacity * 0.75를 넘으면 table 크기가 2배가 되는지 관찰
// 실행 시 VM 옵션 필요: --add-opens java.base/java.util=ALL-UNNAMED
public class test2gu {

    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();

        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Field thresholdField = HashMap.class.getDeclaredField("threshold");
        thresholdField.setAccessible(true);

        int prevCapacity = capacity(tableField, map);
        System.out.printf("생성 직후: size=0, capacity=%d (table은 첫 put 때 만들어짐)%n", prevCapacity);

        for (int i = 1; i <= 200; i++) {
            map.put(i, i);
            int cap = capacity(tableField, map);
            if (cap != prevCapacity) {
                System.out.printf("size=%d 넣는 순간  capacity %3d -> %d   (새 threshold=%d)%n",
                        map.size(), prevCapacity, cap, thresholdField.getInt(map));
                prevCapacity = cap;
            }
        }
    }

    static int capacity(Field tableField, HashMap<?, ?> map) throws Exception {
        Object[] table = (Object[]) tableField.get(map);
        return table == null ? 0 : table.length;
    }
}