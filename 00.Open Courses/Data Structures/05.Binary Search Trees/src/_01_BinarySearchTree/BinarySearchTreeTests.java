package  _01_BinarySearchTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeTests {

    @Test
    public void createBinaryTree_testStructure_leftSubTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        BinarySearchTree<Integer>.Node root = bst.getRoot();

        Assertions.assertEquals(Integer.valueOf(12), root.getValue());

        BinarySearchTree<Integer>.Node left = root.getLeft();

        Assertions.assertEquals(Integer.valueOf(5), left.getValue());

        BinarySearchTree<Integer>.Node left_left = left.getLeft();
        BinarySearchTree<Integer>.Node left_right = left.getRight();

        Assertions.assertEquals(Integer.valueOf(1), left_left.getValue());
        Assertions.assertEquals(Integer.valueOf(8), left_right.getValue());
    }

    @Test
    public void createBinaryTree_testStructure_rightSubTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        BinarySearchTree<Integer>.Node root = bst.getRoot();

        Assertions.assertEquals(Integer.valueOf(12), root.getValue());

        BinarySearchTree<Integer>.Node right = root.getRight();

        Assertions.assertEquals(Integer.valueOf(21), right.getValue());

        BinarySearchTree<Integer>.Node right_left = right.getLeft();
        BinarySearchTree<Integer>.Node right_right = right.getRight();

        Assertions.assertEquals(Integer.valueOf(18), right_left.getValue());
        Assertions.assertEquals(Integer.valueOf(23), right_right.getValue());
    }

    @Test
    public void testContainsMethod_shouldReturnFalse() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        boolean contains = bst.contains(-10);
        Assertions.assertEquals(false, contains);
    }

    @Test
    public void testContainsMethod_shouldReturnTrue() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        boolean contains = bst.contains(21);
        Assertions.assertEquals(true, contains);
    }

    @Test
    public void testSearch_CheckReturnedTreeStructure1() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        BinarySearchTree<Integer> search = bst.search(5);

        BinarySearchTree<Integer>.Node root = search.getRoot();
        Assertions.assertEquals(Integer.valueOf(5), root.getValue());

        BinarySearchTree<Integer>.Node left = root.getLeft();
        BinarySearchTree<Integer>.Node right = root.getRight();

        Assertions.assertEquals(Integer.valueOf(1), left.getValue());
        Assertions.assertEquals(Integer.valueOf(8), right.getValue());
    }

    @Test
    public void testSearch_CheckReturnedTreeStructure2() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        bst.insert(50);
        bst.insert(100);
        bst.insert(75);
        bst.insert(60);

        BinarySearchTree<Integer> search = bst.search(23);

        BinarySearchTree<Integer>.Node root = search.getRoot();
        Assertions.assertEquals(Integer.valueOf(23), root.getValue());

        BinarySearchTree<Integer>.Node left = root.getLeft();
        BinarySearchTree<Integer>.Node right = root.getRight();

        Assertions.assertEquals(null, left);
        Assertions.assertEquals(Integer.valueOf(50), right.getValue());

        BinarySearchTree<Integer>.Node right_left = right.getLeft();
        BinarySearchTree<Integer>.Node right_right = right.getRight();

        Assertions.assertEquals(null, right_left);
        Assertions.assertEquals(Integer.valueOf(100), right_right.getValue());

        BinarySearchTree<Integer>.Node right_right_left = right_right.getLeft();
        BinarySearchTree<Integer>.Node right_right_right = right_right.getRight();

        Assertions.assertEquals(Integer.valueOf(75), right_right_left.getValue());
        Assertions.assertEquals(null, right_right_right);

        BinarySearchTree<Integer>.Node right_right_left_left = right_right_left.getLeft();
        Assertions.assertEquals(Integer.valueOf(60), right_right_left_left.getValue());
    }

    @Test
    public void testRange_getAllNodes() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        Iterable<Integer> range = bst.range(0, 100);

        Integer[] values = new Integer[]{1, 5, 8, 12, 18, 21, 23};
        int index = 0;
        for (Integer integer : range) {
            Assertions.assertEquals(values[index++], integer);
        }
    }

    @Test
    public void testRange_shouldNotFindAnyNodes() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        Iterable<Integer> range = bst.range(-1, -1);

        List<Integer> foundValues = new ArrayList<>();
        for (Integer value : range) {
            foundValues.add(value);
        }

        Assertions.assertEquals(0, foundValues.size());
    }

    @Test
    public void testRange_shouldFindOnlyOneElement() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        Iterable<Integer> range = bst.range(12, 12);

        int index = 0;
        Integer[] values = new Integer[] { 12 };
        for (Integer value : range) {
            Assertions.assertEquals(values[index], value);
        }
    }

    @Test
    public void testRange_shouldFindNodes() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        Iterable<Integer> range = bst.range(5, 18);

        int index = 0;
        Integer[] values = new Integer[]{5, 8, 12, 18};
        for (Integer value : range) {
            Assertions.assertEquals(values[index++], value);
        }
    }

    @Test
    public void deleteMin_shouldThrowException() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bst.deleteMin();
        });
    }

    @Test
    public void testDeleteMin_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        bst.deleteMin();

        BinarySearchTree<Integer>.Node root = bst.getRoot();
        BinarySearchTree<Integer>.Node left = root.getLeft().getLeft();

        Assertions.assertEquals(null, left);
    }

    @Test
    public void testDeleteMin1_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        bst.deleteMin();

        BinarySearchTree<Integer>.Node root = bst.getRoot();
        BinarySearchTree<Integer>.Node left = root.getLeft();

        Assertions.assertEquals(Integer.valueOf(8), left.getValue());
    }

    // ##### EXERCISES #####

    @Test
    public void testDeleteMax_shouldThrowException() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bst.deleteMax();
        });
    }

    @Test
    public void testDeleteMax1_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        bst.deleteMax();

        BinarySearchTree<Integer>.Node right_node = bst.getRoot().getRight().getRight();
        Assertions.assertEquals(null, right_node);

        BinarySearchTree<Integer>.Node left_node = bst.getRoot().getRight().getLeft();
        Assertions.assertEquals(Integer.valueOf(18), left_node.getValue());
    }

    @Test
    public void testDeleteMax2_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);

        bst.deleteMax();

        BinarySearchTree<Integer>.Node right_node = bst.getRoot().getRight();
        Assertions.assertEquals(Integer.valueOf(18), right_node.getValue());
    }

    @Test
    public void testCeil1_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);

        Integer ceil = bst.ceil(8);
        Assertions.assertEquals(Integer.valueOf(8), ceil);
    }

    @Test
    public void testCeil2_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);

        Integer ceil = bst.ceil(13);
        Assertions.assertEquals(Integer.valueOf(18), ceil);
    }

    @Test
    public void testCeil3_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);

        Integer ceil = bst.ceil(9);
        Assertions.assertEquals(Integer.valueOf(12), ceil);
    }

    @Test
    public void testCeil4_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer ceil = bst.ceil(9);
        Assertions.assertEquals(null, ceil);
    }

    @Test
    public void testFloor1_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        Integer floor = bst.floor(0);
        Assertions.assertEquals(null, floor);
    }

    @Test
    public void testFloor2_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        Integer floor = bst.floor(21);
        Assertions.assertEquals(Integer.valueOf(21), floor);
    }

    @Test
    public void testFloor3_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        Integer floor = bst.floor(11);
        Assertions.assertEquals(Integer.valueOf(8), floor);
    }

    @Test
    public void testFloor4_shouldWorkCorrectly() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        Integer floor = bst.floor(17);
        Assertions.assertEquals(Integer.valueOf(12), floor);
    }

    @Test
    public void testDelete_deleteRoot_setInorderSuccessor() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(17);
        bst.insert(16);
        bst.insert(23);

        bst.delete(12);

        BinarySearchTree<Integer>.Node root = bst.getRoot();
        Assertions.assertEquals(Integer.valueOf(16), root.getValue());
    }

    @Test
    public void testDelete_deleteLeaf() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        bst.delete(1);

        BinarySearchTree<Integer>.Node left = bst.getRoot().getLeft().getLeft();
        Assertions.assertEquals(null, left);
    }

    @Test
    public void testDelete_OnlyLeftChild() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(18);
        bst.insert(23);

        bst.delete(5);

        BinarySearchTree<Integer>.Node left = bst.getRoot().getLeft();
        BinarySearchTree<Integer>.Node right = left.getRight();

        Assertions.assertEquals(Integer.valueOf(1), left.getValue());
        Assertions.assertEquals(null, right);
    }

    @Test
    public void testDelete_OnlyRightChild() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);
        bst.insert(23);

        bst.delete(21);

        BinarySearchTree<Integer>.Node root = bst.getRoot();
        Assertions.assertEquals(Integer.valueOf(12), root.getValue());

        BinarySearchTree<Integer>.Node right = root.getRight();
        Assertions.assertEquals(Integer.valueOf(23), right.getValue());

        BinarySearchTree<Integer>.Node left = right.getLeft();
        Assertions.assertEquals(null, left);
    }

    @Test
    public void testDelete_NodeNotInTree_structureShouldBeSame() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);
        bst.insert(18);
        bst.insert(23);

        List<Integer> elements = new ArrayList<>();
        Iterable<Integer> range = bst.range(1, 23);
        for (Integer element : range) {
            elements.add(element);
        }

        int index = 0;
        int[] expectedResult = new int[elements.size()];
        for (Integer element : elements) {
            expectedResult[index++] = element;
        }

        bst.delete(-1);
        range = bst.range(1, 23);
        List<Integer> elementsAfterDelete = new ArrayList<>();
        for (Integer integer : range) {
            elementsAfterDelete.add(integer);
        }

        index = 0;
        int[] result = new int[elementsAfterDelete.size()];
        for (Integer integer : elementsAfterDelete) {
            result[index++] = integer;
        }

        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testRank_rootRank() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(8);
        bst.insert(0);
        bst.insert(-1);
        bst.insert(1);
        bst.insert(18);
        bst.insert(23);

        int rank = bst.rank(12);
        Assertions.assertEquals(5, rank);
    }

    @Test
    public void testRank_nodeWithNoRightChild() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(0);
        bst.insert(-1);
        bst.insert(1);
        bst.insert(18);
        bst.insert(23);

        int rank = bst.rank(5);
        Assertions.assertEquals(3, rank);
    }

    @Test
    public void testRank_highestRankNode() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);
        bst.insert(18);
        bst.insert(23);

        int rank = bst.rank(23);
        Assertions.assertEquals(6, rank);
    }

    @Test
    public void testRank_withValue_higherThanHighestNode_returnAllNodesInTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);
        bst.insert(18);
        bst.insert(23);

        int rank = bst.rank(50);
        Assertions.assertEquals(7, rank);
    }

    @Test
    public void testRank_withValue_lowerThanLowest_returnZero() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);
        bst.insert(18);
        bst.insert(23);

        int rank = bst.rank(-1);
        Assertions.assertEquals(0, rank);
    }

    @Test
    public void testDeleteRoot_LowerRankOfParentNodes() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(17);
        bst.insert(16);
        bst.insert(23);

        bst.delete(12);

        BinarySearchTree<Integer>.Node root = bst.getRoot();
        Assertions.assertEquals(Integer.valueOf(16), root.getValue());

        Assertions.assertEquals(3, bst.rank(16));
        Assertions.assertEquals(6, bst.rank(21));
    }
}
