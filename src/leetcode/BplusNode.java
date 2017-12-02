package leetcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/11/5
 * Description :
 * Version : 2.0
 */
public class BplusNode <K  extends Comparable<K>, V> {
    protected boolean isLeaf;  // 是否为叶子节点
    protected boolean isRoot;   // 是否为根节点
    protected BplusNode<K, V> parent; //父节点
    protected BplusNode<K, V> previous; //前节点
    protected BplusNode<K, V> next; //后节点
    protected List<Map.Entry<K, V>> entries; //节点的关键字
    protected List<BplusNode<K, V>> children; //子节点

    public BplusNode(boolean isLeaf) {
        this.isLeaf = isLeaf;
        entries = new ArrayList<>();
        if (!isLeaf) {
            children = new ArrayList<>();
        }
    }

    public BplusNode(boolean isLeaf, boolean isRoot) {
        this(isLeaf);
        this.isRoot = isRoot;
    }

    public V get(K key) {
        if (isLeaf) {
            int low = 0, high = entries.size() - 1, mid = 0;
            int comp;
            while (low <= high) {
                mid = (low + high) / 2;
                comp = entries.get(mid).getKey().compareTo(key);
                if (comp == 0) {
                    return entries.get(mid).getValue();
                } else if (comp < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return null;
        }

        int comp = key.compareTo(entries.get(0).getKey());
        if (comp < 0) {
            return children.get(0).get(key);
        } else if (comp >= 0){
            return children.get(children.size() - 1).get(key);
        } else {
            int low = 0, high = entries.size() - 1, mid = 0;
            while (low <= high) {
                mid = (low + high) / 2;
                comp = entries.get(mid).getKey().compareTo(key);
                if (comp == 0) {
                    return children.get(mid + 1).get(key);
                } else if (comp < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return children.get(low).get(key);
        }
    }

    public void insertOrUpdate(K key, V value, BplusTree<K, V> tree) {
        if (isLeaf) {
            if (contains(key) != -1 || entries.size() < tree.getOrder()) {
                insertOrUpdate(key,value);
                if (tree.getHeight() == 0) {
                    tree.setHeight(1);
                }
                return;
            }
        }

        BplusNode<K, V> left = new BplusNode<>(true);
        BplusNode<K, V> right = new BplusNode<>(true);

        if (previous != null) {
            previous.next = left;
            left.previous = previous;
        }

        if (next != null) {
            next.previous = right;
            right.next = next;
        }

        if (previous == null) {
            tree.setHead(left);
        }

        left.next = right;
        right.previous = left;
        previous = null;
        next = null;

        copy2Nodes(key, value, left, right, tree);

        if (parent != null) {
            int index = parent.children.indexOf(this);
            parent.children.remove(this);
            left.parent = parent;
            right.parent = parent;
            parent.children.add(index, left);
            parent.children.add(index + 1, right);
            parent.entries.add(index, right.entries.get(0));
            entries = null;
            children = null;
            parent.updateInsert(tree);
            parent = null;
        } else {
            isRoot = false;
            BplusNode<K, V> parent = new BplusNode<K, V>(false, true);
            tree.setRoot(parent);
            left.parent = parent;
            right.parent = parent;
            parent.children.add(left);
            parent.children.add(right);
            parent.entries.add(right.entries.get(0));
            entries = null;
            children = null;
        }

        if (key.compareTo(entries.get(0).getKey()) < 0) {
            children.get(0).insertOrUpdate(key, value, tree);
        } else if (key.compareTo(entries.get(0).getKey()) >= 0) {
            children.get(children.size() - 1).insertOrUpdate(key, value, tree);
        } else {
            int low = 0, high = entries.size() - 1, mid = 0;
            int comp;
            while (low <= high) {
                mid = (low + high) / 2;
                comp = entries.get(0).getKey().compareTo(key);
                if (comp == 0) {
                    children.get(mid + 1).insertOrUpdate(key, value, tree);
                    break;
                } else if (comp > 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (low > high) {
                children.get(low).insertOrUpdate(key, value, tree);
            }
        }

        return;
    }

    private void copy2Nodes(K key, V value, BplusNode<K, V> left, BplusNode<K, V> right, BplusTree<K, V> tree) {
        int leftSize = (tree.getOrder() + 1) / 2 + (tree.getOrder() + 1) % 2;
        boolean b = false;
        for (int i = 0; i < entries.size(); i++) {
            if (leftSize != 0) {
                leftSize--;
                if (!b && entries.get(i).getKey().compareTo(key) > 0) {
                    left.entries.add(new AbstractMap.SimpleEntry<>(key, value));
                    b = true;
                    i--;
                } else {
                    right.entries.add(entries.get(i));
                }
            } else {
                if (!b && entries.get(i).getKey().compareTo(key) > 0) {
                    right.entries.add(new AbstractMap.SimpleEntry<>(key, value));
                    b = true;
                    i--;
                } else {
                    right.entries.add(entries.get(i));
                }
            }
        }

        if(!b) {
            right.entries.add(new AbstractMap.SimpleEntry<>(key, value));
        }
    }

    protected void updateInsert(BplusTree<K, V> tree) {
        if (children.size() > tree.getOrder()) {
            BplusNode<K, V> left = new BplusNode<K, V>(false);
            BplusNode<K, V> right = new BplusNode<K, V>(false);
            int leftSize = (tree.getOrder() + 1) / 2 + (tree.getOrder() + 1) % 2;
            int rightSize = (tree.getOrder() + 1) / 2;
            for (int i = 0; i < leftSize; i++) {
                left.children.add(children.get(i));
                children.get(i).parent = right;
            }

            for (int i = 0; i < rightSize; i++) {
                right.children.add(children.get(i));
                children.get(leftSize + i).parent = right;
            }

            for (int i = 0; i < leftSize - 1; i++) {
                left.entries.add(entries.get(i));
            }

            for (int i = 0; i < rightSize - 1; i++) {
                right.entries.add(entries.get(leftSize + i));
            }

            if (parent != null) {
                int index = parent.children.indexOf(this);
                parent.children.remove(this);
                left.parent = parent;
                right.parent = parent;
                parent.children.add(index, left);
                parent.children.add(index + 1, right);
                parent.entries.add(index, entries.get(leftSize - 1));
                entries = null;
                children = null;
            } else {
                isRoot = false;
                BplusNode<K, V> parent = new BplusNode<K, V>(false, true);
                tree.setRoot(parent);
                tree.setHeight(tree.getHeight() + 1);
                left.parent = parent;
                right.parent = parent;
                parent.children.add(left);
                parent.children.add(right);
                parent.entries.add(entries.get(leftSize - 1));
                entries = null;
                children = null;;
            }
        }
    }

    protected void updateRemove(BplusTree<K, V> tree) {
        if (children.size() < tree.getOrder() / 2 || children.size() < 2) {
            if (isRoot) {
                if (children.size() >= 2) return;
                BplusNode<K, V> root = children.get(0);
                tree.setRoot(root);
                tree.setHeight(tree.getHeight() - 1);
                root.parent = null;
                root.isRoot = true;
                entries = null;
                children = null;
                return;
            }
            int currIdx = parent.children.indexOf(this);
            int preIdx = currIdx - 1;
            int nextIdx =  currIdx + 1;
            BplusNode<K, V> previous = null, next = null;
            if (preIdx >= 0) {
                previous = parent.children.get(preIdx);
            }
            if (nextIdx < parent.children.size()) {
                next = parent.children.get(nextIdx);
            }
            if (previous != null
                    && previous.children.size() > tree.getOrder() / 2
                    && previous.children.size() > 2) {
                int idx = previous.children.size() - 1;
                BplusNode<K, V>  borrow = previous.children.get(idx);
                previous.children.remove(idx);
                borrow.parent = this;
                children.add(0, borrow);
                int preIndex = parent.children.indexOf(previous);
                entries.add(0, parent.entries.get(preIndex));
                parent.entries.set(preIndex, previous.entries.remove(idx - 1));
                return;
            }

            if (next != null
                    && next.children.size() > tree.getOrder() / 2
                    && next.children.size() > 2) {
                BplusNode<K, V> borrow = next.children.get(0);
                next.children.remove(0);
                borrow.parent = this;
                children.add(borrow);
                int preIndex = parent.children.indexOf(this);
                entries.add(parent.entries.get(preIndex));
                parent.entries.set(preIndex, next.entries.remove(0));
                return;
            }

            if (previous != null
                    && (previous.children.size() <= tree.getOrder() / 2
                        || previous.children.size() <= 2)) {
                for (int i = 0; i < children.size(); i++) {
                    previous.children.add(children.get(i));
                }
                for (int i = 0; i < previous.children.size(); i++) {
                    previous.children.get(i).parent = this;
                }
                int indexPre = parent.children.indexOf(previous);
                previous.entries.add(parent.entries.get(indexPre));
                for (int i = 0; i < entries.size(); i++) {
                    previous.entries.add(entries.get(i));
                }
                children = previous.children;
                entries = previous.entries;

                parent.children.remove(previous);
                previous.parent = null;
                previous.children = null;
                previous.entries = null;
                parent.entries.remove(parent.children.indexOf(this));
                if (!parent.isRoot
                        && (parent.children.size() >= tree.getOrder() / 2)) {

                }
            }
        }
    }

    public V remove(K key, BplusTree<K, V> tree) {
        if (isLeaf) {
            if (contains(key) == -1) {
                return null;
            }

            if (isRoot) {
                if (entries.size() == 1) {
                    tree.setHeight(0);
                }
                return remove(key);
            }

            if (entries.size() > tree.getOrder() / 2 && entries.size() > 2) {
                return remove(key);
            }
        }

        return null;
    }

    protected int contains(K key) {
        int low = 0, high = entries.size() - 1, mid;
        int comp;
        while (low <= high) {
            mid = (low + high) / 2;
            comp = entries.get(mid).getKey().compareTo(key);
            if (comp == 0) {
                return mid;
            } else if (comp > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    protected void insertOrUpdate(K key, V value) {
        int low = 0, high = entries.size() - 1, mid;
        int comp;
        while (low <= high) {
            mid = (low + high) / 2;
            comp = entries.get(mid).getKey().compareTo(key);
            if (comp == 0) {
                entries.get(0).setValue(value);
                break;
            } else if (comp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (low > high) {
            entries.add(low, new AbstractMap.SimpleEntry<>(key, value));
        }
    }

    protected V remove(K key) {
        int low = 0, high = entries.size() - 1, mid;
        int comp;
        while (low <= high) {
            mid = (low + high) / 2;
            comp = entries.get(mid).getKey().compareTo(key);
            if (comp == 0) {
                return entries.remove(mid).getValue();
            } else if (comp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("isRoot: ");
        sb.append(isRoot);
        sb.append(", ");
        sb.append("isLeaf: ");
        sb.append(isLeaf);
        sb.append(", ");
        sb.append("keys: ");
        for (Map.Entry<K,V> entry : entries){
            sb.append(entry.getKey());
            sb.append(", ");
        }
        sb.append(", ");
        return sb.toString();
    }

}
