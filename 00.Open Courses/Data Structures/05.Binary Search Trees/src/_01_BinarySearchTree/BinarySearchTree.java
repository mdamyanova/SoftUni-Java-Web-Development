package _01_BinarySearchTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;
    private int nodesCount;

    public BinarySearchTree() {
    }

    private BinarySearchTree(Node root) {
        this.preOrderCopy(root);
    }

    private void preOrderCopy(Node node) {
        if (node == null) {
            return;
        }

        this.insert(node.value);
        this.preOrderCopy(node.left);
        this.preOrderCopy(node.right);
    }

    public Node getRoot() {
        return this.root;
    }

    public int getNodesCount() {
        return this.nodesCount;
    }

    public void insert(T value) {
        this.nodesCount++;

        if (this.root == null) {
            this.root = new Node(value);
            return;
        }

        Node parent = null;
        Node current = this.root;

        while (current != null) {
            parent = current;
            parent.childrenCount++;

            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                return;
            }
        }

        Node newNode = new Node(value);

        if (value.compareTo(parent.value) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public boolean contains(T value) {
        Node current = this.root;

        while (current != null) {
            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }

        return current != null;
    }

    public BinarySearchTree<T> search(T item) {
        Node current = this.root;

        while (current != null) {
            if (item.compareTo(current.value) < 0) {
                current = current.left;
            } else if (item.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }

        return new BinarySearchTree<>(current);
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, consumer);
        consumer.accept(node.value);
        this.eachInOrder(node.right, consumer);
    }

    public Iterable<T> range(T from, T to) {
        Deque<T> queue = new LinkedList<>();
        this.range(this.root, queue, from, to);
        return queue;
    }

    private void range(Node node, Deque<T> queue, T startRange, T endRange) {
        if (node == null) {
            return;
        }

        int compareStart = startRange.compareTo(node.value);
        int compareEnd = endRange.compareTo(node.value);
        if (compareStart < 0) {
            this.range(node.left, queue, startRange, endRange);
        }
        if (compareStart <= 0 && compareEnd >= 0) {
            queue.addLast(node.value);
        }
        if (compareEnd > 0) {
            this.range(node.right, queue, startRange, endRange);
        }
    }

    private T minValue(Node root) {
        T minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }

        return minv;
    }

    public void deleteMin() {
        if (this.root == null) {
            throw new IllegalArgumentException("Tree is empty!");
        }

        Node min = this.root;
        Node parent = null;

        while (min.left != null) {
            parent = min;
            parent.childrenCount--;
            min = min.left;
        }

        if (parent == null) {
            this.root = this.root.right;
        } else {
            parent.left = min.right;
        }

        this.nodesCount--;
    }

    public void deleteMax() {
        if (this.root == null) {
            throw new IllegalArgumentException();
        }

        Node parrent = null;
        Node current = this.root;

        while (current.getRight() != null) {
            parrent = current;
            parrent.childrenCount--;
            current = current.getRight();
        }
        if (parrent == null) {
            this.root = current.getLeft();
        } else {
            parrent.setRight(current.getLeft());
        }

        this.nodesCount--;
    }

    public T ceil(T element) {
        Node parent = null;
        Node current = this.root;

        while (current != null) {
            if (current.getValue().compareTo(element) > 0) {
                parent = current;
                current = current.getLeft();
            } else if (current.getValue().compareTo(element) < 0) {
                if (parent != null && current.getRight() != null && current.getRight().getValue().compareTo(element) < 0) {
                    return parent.getValue();
                }
                parent = current;
                current = current.getRight();
            } else return current.getValue();
        }
        if (parent != null && parent.getValue().compareTo(element) >= 0) {
            return parent.getValue();
        }
        return null;
    }

    public T floor(T element) {
        Node parent = null;
        Node current = this.root;
        while (current != null) {
            if (current.getValue().compareTo(element) > 0) {
                if (parent != null && parent.getValue().compareTo(element) < 0) {
                    return parent.getValue();
                }
                parent = current;
                current = current.getLeft();
            } else if (current.getValue().compareTo(element) < 0) {
                parent = current;
                current = current.getRight();
            } else return current.getValue();
        }
        if (parent != null && parent.getValue().compareTo(element) <= 0) {
            return parent.getValue();
        }
        return null;
    }

    public void delete(T key) {
        if (this.getRoot() == null) {
            return;
        }

        Node parent = null;
        Node forDeleting = this.root;

        while (forDeleting != null) {
            forDeleting.childrenCount--;

            if (forDeleting.getValue() == key) {
                break;
            } else if (forDeleting.getValue().compareTo(key) > 0) {
                parent = forDeleting;
                forDeleting = forDeleting.getLeft();
            } else if (forDeleting.getValue().compareTo(key) < 0) {
                parent = forDeleting;
                forDeleting = forDeleting.getRight();
            }
        }

        if (forDeleting == null) {
            return;
        }

        if (forDeleting.getLeft() == null && forDeleting.getRight() == null) {
            changeParent(parent, forDeleting, null);
            if (parent == null) {
                this.root.setValue(null);
            }
            return;
        }
        if (forDeleting.getRight() == null) {
            forDeleting.getLeft().childrenCount = forDeleting.childrenCount - 1;
            changeParent(parent, forDeleting, forDeleting.getLeft());
            return;
        }
        if (forDeleting.getRight().getLeft() == null) {
            forDeleting.getRight().childrenCount = forDeleting.childrenCount - 1;
            forDeleting.getRight().setLeft(forDeleting.getLeft());
            changeParent(parent, forDeleting, forDeleting.getRight());
            return;
        }

        Node prev = forDeleting.getRight();
        Node crnt = prev.getLeft();

        while (crnt.getLeft() != null) {
            crnt.childrenCount--;
            prev = crnt;
            crnt = crnt.getLeft();
        }

        prev.setLeft(null);
        crnt.childrenCount = forDeleting.childrenCount - 1;
        crnt.setLeft(forDeleting.getLeft());
        crnt.setRight(forDeleting.getRight());
        changeParent(parent, forDeleting, crnt);
    }

    public T select(int n) {
        throw new UnsupportedOperationException();
    }

    private void changeParent(Node parent, Node forDeleting, Node newParent) {
        if (parent == null) {
            this.root = newParent;
        } else if (parent.getLeft() == forDeleting) {
            parent.setLeft(newParent);
        } else if (parent.getRight() == forDeleting) {
            parent.setRight(newParent);
        }
    }

    public int rank(T item) {
        return rank(this.root, item);
    }

    private int rank(Node node, T item) {
        if (node == null) {
            return 0;
        }

        if (node.getValue().compareTo(item) > 0) {
            return this.rank(node.getLeft(), item);
        } else if (node.getValue().compareTo(item) < 0) {
            return 1 + this.getChildrenCount(node.getLeft()) + this.rank(node.getRight(), item);
        }
        return this.getChildrenCount(node.getLeft());
    }

    private int getChildrenCount(Node node) {
        if (node == null) {
            return 0;
        }

        return node.childrenCount;
    }

    class Node {
        private T value;
        private Node left;
        private Node right;

        private int childrenCount;

        public Node(T value) {
            this.value = value;
            this.childrenCount = 1;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return this.value + "";
        }
    }
}