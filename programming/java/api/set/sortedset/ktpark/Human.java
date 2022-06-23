package java.api.set.sortedset.ktpark;

public class Human implements Comparable<Human> {

	private final String value;

	Human(String name) {
		this.value = name;
	}

	public String getName() {
		return this.value;
	}

	@Override
	public int compareTo(Human human) {

        String val = value;
        String eqVal = human.getName();

        return val.compareTo(eqVal);

	}

}
