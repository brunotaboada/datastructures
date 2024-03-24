package datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Represents the Binary Search Tree.
 */
public class BinarySearchTree {

	// Reference for the root of the tree.
	public Node<Integer> root;

	/**
	 * @param value
	 * @return the same object
	 */
	public BinarySearchTree insert(int value) {
		Node<Integer> node = new Node<>(value);

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
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

	public Node<Integer> findBy(int value) {
		if (root == null)
			throw new RuntimeException("Record was not found.");
		return findBy(value, root);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Node<Integer> findBy(int value, Node<Integer> currenNode) {
		Node result;
		if (value == currenNode.value)
			return currenNode;
		if (value >= currenNode.value) {
			result = findBy(value, currenNode.right);
		} else {
			result = findBy(value, currenNode.left);
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
	 * Printing the contents of the tree in an in-order way.
	 */
	public void printInorder() {
		printInOrderRecursively(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an in-order way
	 */
	private void printInOrderRecursively(Node<Integer> currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrderRecursively(currRoot.left);
		System.out.print(currRoot.value + ", ");
		printInOrderRecursively(currRoot.right);
	}

	/**
	 * Printing the contents of the tree in a Preorder way.
	 */
	public void printPreorder() {
		printPreOrderRecursively(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Preorder way
	 */
	private void printPreOrderRecursively(Node<Integer> currRoot) {
		if (currRoot == null) {
			return;
		}
		System.out.print(currRoot.value + ", ");
		printPreOrderRecursively(currRoot.left);
		printPreOrderRecursively(currRoot.right);
	}

	/**
	 * Printing the contents of the tree in a Postorder way.
	 */
	public void printPostorder() {
		printPostOrderRecursively(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Postorder way
	 */
	private void printPostOrderRecursively(Node<Integer> currRoot) {
		if (currRoot == null) {
			return;
		}
		printPostOrderRecursively(currRoot.left);
		printPostOrderRecursively(currRoot.right);
		System.out.print(currRoot.value + ", ");
	}

	private static int findLargest(Node<Integer> rootNode) {
		Node<Integer> current = rootNode;
		while (current.right != null) {
			current = current.right;
		}
		return current.value;
	}

	public static int findSecondLargest(Node<Integer> rootNode) {
		if (rootNode == null || (rootNode.left == null && rootNode.right == null)) {
			throw new IllegalArgumentException("Tree must have at least 2 nodes");
		}

		Node<Integer> current = rootNode;

		while (true) {

			// case: current is largest and has a left subtree
			// 2nd largest is the largest in that subtree
			if (current.left != null && current.right == null) {
				return findLargest(current.left);
			}

			// case: current is parent of largest, and largest has no children,
			// so current is 2nd largest
			if (current.right != null && current.right.left == null && current.right.right == null) {
				return current.value;
			}

			current = current.right;
		}
	}

	public static boolean isBinarySearchTree(Node<Integer> root) {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBinarySearchTree(Node<Integer> root, int lowerBound, int upperBound) {
		if (root == null) {
			return true;
		}

		if (root.value >= upperBound || root.value <= lowerBound) {
			return false;
		}

		return isBinarySearchTree(root.left, lowerBound, root.value)
				&& isBinarySearchTree(root.right, root.value, upperBound);
	}

	private static class NodeDepthPair {

		Node<Integer> node;
		int depth;

		NodeDepthPair(Node<Integer> node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public static boolean isBalanced(Node<Integer> treeRoot) {

		// a tree with no nodes is superbalanced, since there are no leaves!
		if (treeRoot == null) {
			return true;
		}

		// we short-circuit as soon as we find more than 2
		List<Integer> depths = new ArrayList<>(3);

		Deque<NodeDepthPair> nodes = new ArrayDeque<>();
		nodes.push(new NodeDepthPair(treeRoot, 0));

		while (!nodes.isEmpty()) {

			// pop a node and its depth from the top of our stack
			NodeDepthPair nodeDepthPair = nodes.pop();
			Node<Integer> node = nodeDepthPair.node;
			int depth = nodeDepthPair.depth;

			// case: we found a leaf
			if (node.left == null && node.right == null) {

				// we only care if it's a new depth
				if (!depths.contains(depth)) {
					depths.add(depth);

					// two ways we might now have an unbalanced tree:
					// 1) more than 2 different leaf depths
					// 2) 2 leaf depths that are more than 1 apart
					if (depths.size() > 2 || (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
						return false;
					}
				}

				// case: this isn't a leaf - keep stepping down
			} else {
				if (node.left != null) {
					nodes.push(new NodeDepthPair(node.left, depth + 1));
				}
				if (node.right != null) {
					nodes.push(new NodeDepthPair(node.right, depth + 1));
				}
			}
		}

		return true;
	}

	private static class NodeBounds {

		Node<Integer> node;
		int lowerBound;
		int upperBound;

		NodeBounds(Node<Integer> node, int lowerBound, int upperBound) {
			this.node = node;
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
	}

	public static boolean isBinarySearchTreeDeque(Node<Integer> root) {

		// start at the root, with an arbitrarily low lower bound
		// and an arbitrarily high upper bound
		Deque<NodeBounds> nodeAndBoundsStack = new ArrayDeque<>();
		nodeAndBoundsStack.push(new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		// depth-first traversal
		while (!nodeAndBoundsStack.isEmpty()) {
			NodeBounds nb = nodeAndBoundsStack.pop();
			Node<Integer> node = nb.node;
			int lowerBound = nb.lowerBound;
			int upperBound = nb.upperBound;

			// if this node is invalid, we return false right away
			if (node.value <= lowerBound || node.value >= upperBound) {
				return false;
			}

			if (node.left != null) {
				// this node must be less than the current node
				nodeAndBoundsStack.push(new NodeBounds(node.left, lowerBound, node.value));
			}
			if (node.right != null) {
				// this node must be greater than the current node
				nodeAndBoundsStack.push(new NodeBounds(node.right, node.value, upperBound));
			}
		}

		// if none of the nodes were invalid, return true
		// (at this point we have checked all nodes)
		return true;
	}

}
