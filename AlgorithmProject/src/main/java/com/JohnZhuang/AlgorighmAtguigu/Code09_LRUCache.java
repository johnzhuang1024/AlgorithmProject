package com.JohnZhuang.AlgorighmAtguigu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/10 11:49
 */
public class Code09_LRUCache {
    // 用时：45ms
    // 内存：111.2M
    class LRUCache {
        private int capacity,sizeOfLink;
        private Map<Integer, LRUNode> map = new HashMap<>();

        private LRUNode firstNode = new LRUNode(-1, -1);
        private LRUNode lastNode = new LRUNode(-1, -1);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            sizeOfLink = 0;
        }

        public int get(int key) {
            if (map.get(key) == null) {
                return -1;
            }

            LRUNode node = map.get(key);
            moveToFirst(node);
            return node.value;
        }

        private void moveToFirst(LRUNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = firstNode.next;
            firstNode.next.pre = node;
            node.pre = firstNode;
            firstNode.next = node;
        }

        public void put(int key, int value) {
            if (map.get(key) == null) {
                if (sizeOfLink == 0) {
                    LRUNode node = new LRUNode(key, value);
                    map.put(key, node);

                    firstNode.next = node;
                    node.pre = firstNode;
                    lastNode.pre = node;
                    node.next = lastNode;

                    sizeOfLink++;
                } else if (sizeOfLink == capacity) {
                    LRUNode node = new LRUNode(key, value);
                    map.put(key, node);

                    node.next = firstNode.next;
                    firstNode.next.pre = node;
                    node.pre = firstNode;
                    firstNode.next = node;

                    int lastkey = lastNode.pre.key;
                    lastNode.pre = lastNode.pre.pre;
                    lastNode.pre.next = lastNode;
                    map.remove(lastkey);
                } else {
                    LRUNode node = new LRUNode(key, value);
                    map.put(key, node);

                    node.next = firstNode.next;
                    firstNode.next.pre = node;
                    node.pre = firstNode;
                    firstNode.next = node;

                    sizeOfLink++;
                }
            } else {
                LRUNode node = map.get(key);
                node.value = value;
                moveToFirst(node);
            }
        }

        private class LRUNode {
            Integer key;
            Integer value;

            LRUNode(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }

            LRUNode pre;
            LRUNode next;
        }
    }

    // 用时：31ms
    // 内存：108.4M
    class LRUCache_Ans {
        //0 <= key <= 10000
        public int cap,n;//容量，总量
        public DoubleLinkedList phead,ptail;//双链表
        public DoubleLinkedList hash[];//哈希表

        public void LRUCache(int capacity) {
            this.cap=capacity;
            this.n=0;
            hash=new DoubleLinkedList[10001];// //0 <= key <= 10000
            phead=new DoubleLinkedList(-1,0);
            ptail=new DoubleLinkedList(-2,0);
            phead.next=ptail;
            ptail.prev=phead;//双链表头尾相连

        }

        public int get(int key) {
            DoubleLinkedList node=hash[key];
            if(node==null){
                return -1;//返回-1
            }
            movefront(node);//往前增加一次
            return node.val;//返回数据
        }

        public void put(int key, int value) {
            DoubleLinkedList node=hash[key];
            if(node==null){
                if(n==cap){
                    node=ptail.prev;
                    hash[node.key]=null;
                    hash[key]=node;//保存节点
                    node.key=key;
                    node.val=value;
                    movefront(node);//删除节点


                }else{
                    node=new DoubleLinkedList(key,value);//构造节点
                    hash[key]=node;//标记
                    addfront(node);//增加节点
                    n++;//节点计数

                }


            }else{
                node.val=value;//赋值操作
                movefront(node);//往后移动
            }

        }
        public void movefront(DoubleLinkedList  node){//删除节点
            node.prev.next=node.next;//删除node,跳过node
            node.next.prev=node.prev;//删除node，跳过node
            addfront(node);//新增

        }
        public void addfront(DoubleLinkedList  node){//追加节点
            node.prev=phead;
            node.next=phead.next;
            phead.next.prev=node;
            phead.next=node;//前后关联

        }

        public class DoubleLinkedList{
            int key;
            int val;
            DoubleLinkedList prev;//指向上一个
            DoubleLinkedList next;//指向下一个
            public DoubleLinkedList(int key,int val){
                this.key=key;
                this.val=val;
                this.prev=null;//上一个
                this.next=null;//下一个
            }
        }




    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
