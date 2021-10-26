package newcoder;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/25/19:12
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        while (scanner.hasNext()) {
            try {
                int nextInt = scanner.nextInt();
//                System.out.println("nextInt = " + nextInt);
                ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
                Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue().hashCode() - o1.getValue().hashCode();
                    }
                });
                for (int i = 0; i < nextInt; i++) {
                    Map.Entry<String, Integer> entry = list.get(i);
                    /*StringBuilder sb = new StringBuilder(entry.getKey());
                    if (i != nextInt-1) {
                        sb.append(",");
                    }
                    result.add(sb.toString());*/
                    System.out.print(entry.getKey());
                    if (i != nextInt-1) {
                        System.out.print(",");
                    }
                }
                System.out.println();
            } catch (Exception e){
                String nextLine = scanner.nextLine();
                //System.out.println("nextLine = " + nextLine);
                if (nextLine.length()<=127) {
                    if (map.containsKey(nextLine)) {
                        //如果存在，在基础上+1
                        map.put(nextLine,map.get(nextLine)+1);
                    } else {
                        //如果不存在，则赋值为1
                        map.put(nextLine,1);
                    }
                }
            }
        }
        /*for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }*/
        scanner.close();
    }
}
