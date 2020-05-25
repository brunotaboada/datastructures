package datastructures.binarytree;

/**
 * Represents the Binary Search Tree.
 */
public class BinarySearchTree {

    // Reference for the root of the tree.
    /**
    * 
    */
    public Node<Integer> root;

    /**
     * @param value
     * @return the same object
     */
    public BinarySearchTree insert(int value) {
        Node<Integer> node = new Node<Integer>(value);

        if (root == null) {
            root = node;
            return this;
        }

        insertRec(root, node);
        return this;
    }

    private void insertRec(Node<Integer> latestRoot, Node<Integer> node) {
        if (latestRoot.value > node.value) {
            if (latestRoot.left == null) {
                latestRoot.left = node;
                return;
            } else {
                insertRec(latestRoot.left, node);
            }
        } else {
            if (latestRoot.right == null) {
                latestRoot.right = node;
                return;
            } else {
                insertRec(latestRoot.right, node);
            }
        }
    }
    
    public Node<Integer> findBy(int value){
    	if(root == null)
    		throw new RuntimeException("Record was not found.");
    	return findBy(value, root);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Node<Integer> findBy(int value, Node<Integer> currenNode){
    	Node result = null;    	
    	
    	if(value == currenNode.value)
    		return currenNode;
    	
    	if(value >= currenNode.value){
    		result = findBy(value,currenNode.right);
    	} else{
    		result = findBy(value,currenNode.left);
    	}
    	    	
    	return result;
    }

    /**
     * @return a node value
     */
    public int findMinimum() {
        if (root == null) {
            return 0;
        }
        Node<Integer> currNode = root;
        while (currNode.left != null) {
            currNode = currNode.left;
        }
        return currNode.value;
    }

    /**
     * Returns the maximum value in the Binary Search Tree
     * 
     * @return node value
     */
    public int findMaximum() {
        if (root == null) {
            return 0;
        }

        Node<Integer> currNode = root;
        while (currNode.right != null) {
            currNode = currNode.right;
        }
        return currNode.value;
    }

    /**
     * Printing the contents of the tree in an inorder way.
     */
    public void printInorder() {
        printInOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in an inorder way
     */
    private void printInOrderRec(Node<Integer> currRoot) {
        if (currRoot == null) {
            return;
        }
        printInOrderRec(currRoot.left);
        System.out.print(currRoot.value + ", ");
        printInOrderRec(currRoot.right);
    }

    /**
     * Printing the contents of the tree in a Preorder way.
     */
    public void printPreorder() {
        printPreOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in a Preorder way
     */
    private void printPreOrderRec(Node<Integer> currRoot) {
        if (currRoot == null) {
            return;
        }
        System.out.print(currRoot.value + ", ");
        printPreOrderRec(currRoot.left);
        printPreOrderRec(currRoot.right);
    }

    /**
     * Printing the contents of the tree in a Postorder way.
     */
    public void printPostorder() {
        printPostOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in a Postorder way
     */
    private void printPostOrderRec(Node<Integer> currRoot) {
        if (currRoot == null) {
            return;
        }
        printPostOrderRec(currRoot.left);
        printPostOrderRec(currRoot.right);
        System.out.print(currRoot.value + ", ");
    }
}
