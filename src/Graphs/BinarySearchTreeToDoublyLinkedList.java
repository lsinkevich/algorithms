package Graphs;
import java.util.Random;
import java.util.Stack;

public class BinarySearchTreeToDoublyLinkedList {

    static class GraphNode<G extends Comparable<G>> {
        private GraphNode<G> left;
        private GraphNode<G> right;
        private G value;
        public GraphNode(final G v) {
            this.value = v;
            this.left = null;
            this.right = null;
        }
        public G getValue() {
            return value;
        }
        public GraphNode<G> getLeft() {
            return left;
        }
        public void setLeft(final GraphNode<G> left) {
            this.left = left;
        }
        public GraphNode<G> getRight() {
            return right;
        }
        public void setRight(final GraphNode<G> right) {
            this.right = right;
        }
    }

    public static GraphNode<Integer> BSTToDLL(GraphNode<Integer> node) {
        Stack<GraphNode<Integer>> stack = new Stack<>();
        GraphNode<Integer> leftNode = node;
        GraphNode<Integer> rightNode;
        GraphNode<Integer> leaderNode = null;
        GraphNode<Integer> previousNode = null;
        GraphNode<Integer> pop;

        while (leftNode != null) {
            stack.push(leftNode);
            leftNode = leftNode.getLeft();
        }

        while (!stack.isEmpty()) {
            pop = stack.pop();
            rightNode = pop.getRight();
            pop.setLeft(previousNode);

            if(leaderNode==null)
                leaderNode = pop;

            while (rightNode != null) {
                stack.push(rightNode);
                rightNode = rightNode.getLeft();
            }

            if (previousNode != null)
                previousNode.setRight(pop);
            previousNode = pop;
        }

        if(previousNode!= null)
            previousNode.setRight(null);

        return leaderNode;
    }

    public static GraphNode<Integer> insertion(final GraphNode<Integer> node, final int value) {
        if (node == null) {
            GraphNode<Integer> iNode = new GraphNode<Integer>(value);
            return iNode;
        }

        if (value > node.getValue())
            node.setRight(insertion(node.getRight(), value));
        else if (value < node.getValue())
            node.setLeft(insertion(node.getLeft(), value));
        return node;
    }

    public static void main(String[] args) {
        Random random = new Random();
        GraphNode<Integer> node = null;

        for (int i = 0; i < 10; i++)
            node = insertion(node, Math.abs(random.nextInt()) % 100);

        GraphNode<Integer> rootNode = BSTToDLL(node);

        while (rootNode != null) {
            System.out.printf("%d ", rootNode.getValue());
            rootNode = rootNode.getRight();
        }
    }
}
