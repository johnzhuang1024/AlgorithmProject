package com.JohnZhuang.AlgorighmTest.class03;

import java.util.HashMap;
import java.util.TreeMap;

public class Code05_HasMapTreeMap {

    public static class Node {
        public int value;

        public Node(int i) {
            value = i;
        }
    }

    // 基础类型只看值，并且这个HashMap会保存key和value的所有内存：map1,map2
    // 非基础类型看引用传递（地址），但是这个HashMap只会保存key和value的地址：map3
    public static void main(String[] args) {

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("zhuang", "我是zhuang");

        System.out.println(map1.get("zhuang"));
        System.out.println(map1.containsKey("zhuang"));//true
        System.out.println(map1.containsKey("zhuang000"));//false
        System.out.println(map1.containsValue("我是zhuang"));//true
        System.out.println(map1.containsValue("我是zhuang000"));

//        map1.remove("zhuang");
//        System.out.println(map1.get("zhuang"));//false
//        System.out.println(map1.containsKey("zhuang"));//false
//        System.out.println(map1.containsValue("我是zhuang"));//false

        String test1 = "zhuang";
        String test2 = "zhuang";
        System.out.println(map1.containsKey(test1));//true
        System.out.println(map1.containsKey(test2));//true

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(123456, "我是123456");

        Integer a = 123456;
        Integer b = 123456;
        System.out.println(a == b);// false,因为比较的是地址
        System.out.println(a.equals(b));//true,因为比较的是值
        System.out.println(map2.containsKey(a));//true
        System.out.println(map2.containsKey(b));//true

        System.out.println("=====================================");

        HashMap<Node, String> map3 = new HashMap<>();
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        map3.put(node1,"node1进来了！");
        System.out.println(map3.containsKey(node1));//true
        System.out.println(map3.containsKey(node2));//false

        System.out.println("=====================================");

        TreeMap<Integer, String> treeMap1 = new TreeMap<>();

        treeMap1.put(3,"我是3");
        treeMap1.put(6,"我是6");
        treeMap1.put(7,"我是7");
        treeMap1.put(8,"我是8");
        treeMap1.put(9,"我是9");
        treeMap1.put(0,"我是0");

        System.out.println(treeMap1.containsKey(7));
        System.out.println(treeMap1.containsKey(5));
        System.out.println(treeMap1.get(3));

        treeMap1.put(3,"他是3");
        System.out.println(treeMap1.get(3));

        treeMap1.remove(3);
        System.out.println(treeMap1.get(3));

        System.out.println(treeMap1.firstKey());
        System.out.println(treeMap1.lastKey());
        // <=6 离6最近的key
        System.out.println(treeMap1.floorKey(6));
        // <=5（不存在） 离5最近的key
        System.out.println(treeMap1.floorKey(5));
        // >=7 离7最近的key
        System.out.println(treeMap1.ceilingKey(7));
        // >=5（不存在） 离5最近的key
        System.out.println(treeMap1.ceilingKey(5));

//        // 会报错，因为key不知道怎么比较，需要自己构造怎么比较
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        TreeMap<Node, String> treeMap2 = new TreeMap<>();
//        treeMap2.put(node3,"我是node3");
//        treeMap2.put(node4,"我是node4");
    }
}
