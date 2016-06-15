package datastrctures.binarytree;

/**
 * Represents a node in the Binary Search Tree.
 * 
 * @param <T>
 */
public class Node<T> {
    // The value present in the node.
    /**
    * 
    */
    public int value;

    // The reference to the left subtree.
    /**
     * 
     */

    public Node<T> left;

    // The reference to the right subtree.
    /**
     * 
     */
    public Node<T> right;

    /**
     * @param value
     */
    public Node(int value) {
        this.value = value;
    }

}
