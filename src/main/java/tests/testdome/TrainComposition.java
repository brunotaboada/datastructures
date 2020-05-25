package tests.testdome;
import java.util.ArrayDeque;

public class TrainComposition {
	private ArrayDeque<Integer> array = new ArrayDeque<>();

	public void attachWagonFromLeft(int wagonId) {
		array.addFirst(wagonId);
	}

	public void attachWagonFromRight(int wagonId) {
		array.addLast(wagonId);
	}

	public int detachWagonFromLeft() {
		return array.pollFirst();
	}

	public int detachWagonFromRight() {
		return array.pollLast();
	}

	public static void main(String[] args) {
		TrainComposition train = new TrainComposition();
		train.attachWagonFromLeft(7);
		train.attachWagonFromLeft(13);
		System.out.println(train.detachWagonFromRight()); // 7
		System.out.println(train.detachWagonFromLeft()); // 13
	}
}