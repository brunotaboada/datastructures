package tests.testdome;

class Node {
	public int value;
	public Node left, right;

	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class BinarySearchTree {

	public static boolean contains(Node root, int value) {
		if (root == null)
			throw new RuntimeException("Record was not found.");
		return findBy(value, root);
	}

	public static boolean findBy(int value, Node currenNode) {
		boolean result = false;

		if (currenNode == null)
			return result;
		if (value == currenNode.value)
			return true;

		if (value >= currenNode.value) {
			result = findBy(value, currenNode.right);
		} else {
			result = findBy(value, currenNode.left);
		}

		return result;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1, null, null);
		Node n3 = new Node(3, null, null);
		Node n2 = new Node(2, n1, n3);

		System.out.println(contains(n2, -1));
	}
}