package testdome;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Song {

	private String name;
	private Song nextSong;

	public Song(String name) {
		this.name = name;
	}

	public void setNextSong(Song nextSong) {
		this.nextSong = nextSong;
	}

	public boolean isRepeatingPlaylist() {
		boolean result = false;
		Stack<Song> stack = new Stack<>();
		Set<Song> sett = new HashSet<>();
		sett.add(this);
		stack.add(this.nextSong);
		while (!stack.isEmpty()) {
			Song check = stack.pop();
			if (check != null && check.nextSong != null) {
				if (!sett.add(check)) {
					result = true;
					break;
				}
				stack.add(check.nextSong);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Song first = new Song("Hello");
		Song second = new Song("Eye of the tiger");
		Song third = new Song("asd");

		first.setNextSong(second);
		second.setNextSong(third);
		third.setNextSong(first);

		System.out.println(first.isRepeatingPlaylist());
	}

}