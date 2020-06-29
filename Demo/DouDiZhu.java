package Demo;

import java.util.*;

public class DouDiZhu {
    public static void main(String[] args) {
        //准备牌
        //用Map创建一个存储牌的牌库
        Map<Integer,String> poker = new HashMap<>();
        //创建每张牌对应的索引（也是value对应的key值）集合（方便取牌）
        List<Integer> pokerindex = new ArrayList<>();
        String[] colors = {"♠","♥","♦","♣"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        //先把特殊牌放到牌库里，并设置索引
        int index = 0;
        poker.put(index,"大王");
        pokerindex.add(index);
        index++;
        poker.put(index,"小王");
        pokerindex.add(index);
        index++;
        //组装牌号和花色以及对应的索引号，并放到牌库里
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index,color+number);
                pokerindex.add(index);
                index++;
            }
        }
//        System.out.println(poker);
//        System.out.println(pokerindex);

        //洗牌
        Collections.shuffle(pokerindex);

        //发牌
        //创建三个玩家的手牌库，以及底牌库
        List<Integer> play01 = new ArrayList<>();
        List<Integer> play02 = new ArrayList<>();
        List<Integer> play03 = new ArrayList<>();
        List<Integer> diPai = new ArrayList<>();
        for (int i = 0; i <pokerindex.size() ; i++) {
            if (i>=51){
                //给底牌发牌
                diPai.add(pokerindex.get(i));
            } else if (i%3==0) {
                //给一号玩家发牌
                play01.add(pokerindex.get(i));
            } else if (i%3==1) {
                //给二号玩家发牌
                play02.add(pokerindex.get(i));
            } else if (i%3==2) {
                //给三号玩家发牌
                play03.add(pokerindex.get(i));
            }
        }
        //为发好的牌进行排序
        Collections.sort(play01);
        Collections.sort(play02);
        Collections.sort(play03);
        Collections.sort(diPai);

        //看牌
        lookPoker("p1",poker,play01);
        lookPoker("p2",poker,play02);
        lookPoker("p3",poker,play03);
        lookPoker("底牌",poker,diPai);

    }

    private static void lookPoker(String name,Map<Integer,String> poker,List<Integer> list) {
        //玩家姓名：
        System.out.print(name+": ");
        //遍历list集合取出key值，通过key值在map中取出对应的value值并输出结果
        for (Integer key : list) {
            String value = poker.get(key);
            System.out.print(value+" ");
        }
        //打印一行之后进行换行
        System.out.println();
    }

}
