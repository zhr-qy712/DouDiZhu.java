# 用Java集合写的斗地主案例
##### 1.准备牌<br>
总共54张牌<br>
特殊牌：大王，小王<br>
52张牌：循环嵌套遍历两个集合/数组，组装52张牌，并创建牌的索引集合<br>
List<Integer> pokerindex = new ArrayList<>();<br>
String[] colors = {"♠","♥","♦","♣"};<br>
String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};<br>
//List<String> colors = {"♠","♥","♦","♣"};<br>
//List<String> numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};<br><br>
##### 2.洗牌<br>
使用Collections中的方法shuffle(pokerindex)<br><br>
##### 3.发牌<br>
一人一张轮流发牌，每人17张，集合索引%3，剩余3张给底牌<br><br>
##### 4.排序<br>
使用Collections中的方法sort(List)<br><br>
##### 5.看牌<br>
遍历玩家和底牌的List集合，获取到Map集合的key，通过key找到value值


