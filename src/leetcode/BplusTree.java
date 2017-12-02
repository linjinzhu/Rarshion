package leetcode;

/**
 * Author ： Martin
 * Date : 17/11/5
 * Description :
 * Version : 2.0
 */
public class BplusTree <K extends Comparable<K>, V> {
    protected BplusNode<K, V> root;
    protected int order;
    protected BplusNode<K, V> head;
    protected int height = 0;

    public BplusTree(int order) {
        if (order < 3) {
            System.out.println("order must be greater than 2");
            System.exit(0);
        }
        this.order = order;
        root = new BplusNode<>(true, true);
        head = root;
    }

    public V remove(K key) {
        return null;
    }

    public V get(K key) {
        return root.get(key);
    }

    public BplusNode<K, V> getRoot() {
        return root;
    }

    public int getOrder() {
        return order;
    }

    public BplusNode<K, V> getHead() {
        return head;
    }

    public int getHeight() {
        return height;
    }

    public void setRoot(BplusNode<K, V> root) {
        this.root = root;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setHead(BplusNode<K, V> head) {
        this.head = head;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
