package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Programmers_길찾기게임 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
			{ 2, 2 } };
	static int[][] ans;
	static int idx;

	static int[][] solution(int[][] nodeinfo) {
		Node[] nodes = new Node[nodeinfo.length];
		for (int i = 0, c = nodeinfo.length; i < c; i++) {
			nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
		}
		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.y == o2.y) {
					return o1.x - o2.x;
				}
				return o2.y - o1.y;
			}
		});

		Node root = nodes[0];
		for (int i = 1; i < nodes.length; i++) {
			insert(root, nodes[i]);
		}
		ans = new int[2][nodes.length];
		idx = 0;
		post(root);
		idx = 0;
		pre(root);
		return ans;
	}

	static void insert(Node parent, Node newNode) {
		if (parent.x > newNode.x) {
			if (parent.left == null) {
				parent.left = newNode;
			} else {
				insert(parent.left, newNode);
			}
		} else {
			if (parent.right == null) {
				parent.right = newNode;
			} else {
				insert(parent.right, newNode);
			}
		}
	}

	static void pre(Node root) {
		if (root != null) {
			ans[0][idx++] = root.v;
			pre(root.left);
			pre(root.right);
		}
	}

	static void post(Node root) {
		if (root != null) {
			post(root.left);
			post(root.right);
			ans[1][idx++] = root.v;
		}
	}

	static public class Node {
		int x;
		int y;
		int v;
		Node left;
		Node right;

		public Node(int x, int y, int v, Node left, Node right) {
			this.x = x;
			this.y = y;
			this.v = v;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(nodeinfo));
	}

}