package suanfa;

/**
 * Author ： Martin
 * Date : 17/10/3
 * Description :
 * Version : 2.0
 */
public class Chapter3 {
    private static class BST<Key extends Comparable<Key>, Value> {
        private Node root;
        private class Node{
            private Key key;
            private Value value;
            private Node left, right;
            private int N;
            public Node(Key key, Value value, int N) {
                this.key = key;
                this.value = value;
                this.N = N;
            }
        }

        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) return 0;
            else return x.N;
        }

        public Value get(Key key) {
            return get(root, key);
        }

        private Value get(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) return get(x.left, key);
            else if (cmp > 0) return get(x.right, key);
            else return x.value;
        }

        public void put(Key key, Value value) {
            root = put(root, key, value);
        }

        private Node put(Node node, Key key, Value value) {
            if (node == null) return new Node(key, value, 1);
            int cmp = key.compareTo(node.key);
            if (cmp < 0) put(node.left, key, value);
            else if (cmp > 0) put(node.right, key, value);
            else node.value = value;
            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }

        public void deleteMin() {
        }

        private Node deleteMin(Node x) {
            if (x.left == null) return x.right;
            x.left = deleteMin(x.left);
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public void delete(Key key) {
            root = delete(root, key);
        }

        private Node delete(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x.left = delete(x.left, key);
            else if (cmp > 0) x.right = delete(x.right, key);
            else {
                if (x.right == null) return x.left;
                if (x.left == null) return x.right;
            }
            return null;
        }

    }
}
