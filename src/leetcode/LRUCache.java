package leetcode;

import java.util.*;

/**
 * Created by rarshion on 16/8/31.
 */
public class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node  next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private  int capacity = 0;
    private  HashMap<Integer, Node> map;
    private Node head = null, end = null;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public void remove(Node n){
        if(n.prev != null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next != null){
            n.next.prev = n.prev;
        }else{
            end = n.prev;
        }
    }

    public void setHead(Node n){
        n.next = head;
        n.prev = null;

        if(head != null){
            head.prev = n;
        }

        head = n;

        if(end == null)
            end = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {//未包括该值
            Node node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        }else{
            Node newNode = new Node(key, value);
            if(map.size() >= this.capacity){
                map.remove(end.key);
                remove(end);
            }
            setHead(newNode);
            map.put(key, newNode);
        }
    }

}
