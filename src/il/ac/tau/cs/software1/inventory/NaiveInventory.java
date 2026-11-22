package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	private Collectible [] objArray; //       - an array of Collectibles (it may be larger than the number of items actually stored)
	private int count; //       - an int that counts how many items are actually stored

	public NaiveInventory() {
		// initialize the fields of this class
		this.objArray = new Collectible[INITIAL_CAPACITY];
		this.count = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		// adds the given item to the array. If the array is full (the number of items equals its length), first create a new array, twice as long, and copy the existing items into it, in the same order.
		if (this.count == this.objArray.length) {
			Collectible[] newArray = new Collectible[this.objArray.length * 2];
			for (int i = 0; i< this.objArray.length; i++) {
				newArray[i] = this.objArray[i];
			}
			this.objArray = newArray;
		}
		this.objArray[this.count] = collectible;
		this.count++;
	}

	@Override
	public float getTotalWeight() {
		// Returns combined weight of all items in the inventory
		float totalWeight = 0.f;
		for (int i = 0; i < this.count; i++) {
			totalWeight += this.objArray[i].getWeight();
		}
		return totalWeight;
	}

	@Override
	public int getCurrentCount() {
		// Returns the amount of items in the inventory
		return this.count;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		// returns the array that is stored in the field.
		return this.objArray;
	}
}
