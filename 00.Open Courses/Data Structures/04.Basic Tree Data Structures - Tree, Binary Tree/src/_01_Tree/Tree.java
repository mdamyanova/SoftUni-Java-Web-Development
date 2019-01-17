package _01_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public class Tree<T> {

    private T value;
    private List<Tree<T>> children;
    private Tree<T> parent;

    public Tree(T value, Tree<T>... children) {
        this.value = value;
        this.children = new ArrayList<>();

        for (Tree<T> child : children) {
            this.addChild(child);
        }
    }

    public Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Tree<T> getParent() {
        return this.parent;
    }

    public void setParent(Tree<T> parent) {
        this.parent = parent;
    }

    public List<Tree<T>> getChildren() {
        return this.children;
    }

    public void addChild(Tree<T> child) {
        this.children.add(child);
        child.setParent(this);
    }

    public String print(int indent, StringBuilder builder) {
        builder.append(
                new String(new char[indent * 2])
                        .replace("\0", " "))
                .append(this.value + "\n");

        for (Tree<T> child : this.children) {
            child.print(indent + 1, builder);
        }

        return builder.toString();
    }

    public void each(Consumer<T> consumer) {
        consumer.accept(this.getValue());

        for (Tree<T> child : this.children) {
            child.each(consumer);
        }
    }

    public Iterable<T> orderDFS() {
        List<T> dfsOrderedNodes = new ArrayList<T>();
        this.DFS(this, dfsOrderedNodes);

        return dfsOrderedNodes;
    }

    private void DFS(Tree<T> parentNode, List<T> dfsOrderedNodes) {
        for (Tree<T> child : parentNode.getChildren()) {
            DFS(child, dfsOrderedNodes);
        }

        dfsOrderedNodes.add(parentNode.getValue());
    }

    public Iterable<T> orderBFS() {
        List<T> bfsOrderedNodes = new ArrayList<T>();
        Deque<Tree<T>> queue = new ArrayDeque<Tree<T>>();
        queue.add(this);

        while (!queue.isEmpty()) {
            Tree<T> node = queue.poll();

            for (Tree<T> child : node.getChildren()) {
                queue.add(child);
            }

            bfsOrderedNodes.add(node.getValue());
        }

        return bfsOrderedNodes;
    }
}