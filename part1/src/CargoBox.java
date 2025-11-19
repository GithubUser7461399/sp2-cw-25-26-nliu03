/**
 * A CargoBox holds zero or more Items and can provide information about the
 * Items. One can add Items to a CargoBox during its lifetime, empty the
 * CargoBox, create a copy which contains Items only up to a certain weight,
 * and make various queries to the CargoBox. (Thus, the number of Items that
 * will be stored by a CargoBox object is not yet known when the new object
 * is created, and it may grow and shrink over the lifetime of a CargoBox
 * object.)
 *
 * @author Nicholas Liu
 */
public class CargoBox {

    /* Constructors */
    protected Item[] Items;
    /**
     * Constructs a new CargoBox without any Items.
     */
    public CargoBox() {
        this.Items = new Item[0];
    }

    /**
     * Constructs a new CargoBox containing the non-null Items in items.
     * The items array may be modified by the caller afterwards without
     * affecting this CargoBox, and it will not be modified by this
     * constructor.
     *
     * @param items must not be null; non-null elements are added to the
     *  constructed CargoBox
     */
    public CargoBox(Item[] items) {
        if (items != null) {
            this.Items = items;
        } else {
            this.Items = new Item[0];
        }
    }

    /* Modifiers */

    /**
     * Adds an Item e to this CargoBox if e is not null; does not modify this
     * CargoBox otherwise. Returns true if e is not null, false otherwise.
     *
     * @param e an item to be added to this CargoBox
     * @return true if e is not null, false otherwise
     */
    public boolean add(Item e) {
        if (e != null) {
            this.Items = new Item[Items.length + 1];
            this.Items[Items.length] = e;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds all non-null Items in items to this CargoBox.
     *
     * @param items contains the Item objects to be added to
     *  this CargoBox; must not be null (but may contain null)
     * @return true if at least one element of items is non-null;
     *  false otherwise
     */
    public boolean addAll(Item[] items) {
        for (int i = 0; i > items.length; i++) {
            add(items[i]);
        }
        return false;
    }

    /**
     * Empties this CargoBox to a CargoBox that contains 0 Items.
     */
    public void empty() {
        this.Items = new Item[0];
    }

    /**
     * Removes certain Items from this CargoBox. Exactly those Items are kept
     * whose weight in grammes is less than or equal to the specified maximum
     * weight in grammes.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the
     *  Items that are kept
     */
    public void keepOnlyItemsWith(int maxItemWeightInGrammes) {
        CargoBox newBox = new CargoBox(Items);
        empty();
        for (Item item : newBox.Items) {
            if (item.getWeightInGrammes() <= maxItemWeightInGrammes) {
                add(item);
            }
        }
    }

    /* Accessors */

    /**
     * Returns the number of non-null Items in this CargoBox.
     *
     * @return the number of non-null Items in this CargoBox
     */
    public int numberOfItems() {
        int count = 0;
        for (Item item : Items) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the total weight of the Items in this CargoBox.
     *
     * @return the total weight of the Items in this CargoBox.
     */
    public int totalWeightInGrammes() {
        int totalWeight = 0;
        for (Item item : Items) {
            if (item != null) {
                totalWeight += item.getWeightInGrammes();
            }
        }
        return totalWeight;
    }

    /**
     * Returns the average weight in grammes of the (non-null) Items
     * in this CargoBox. In case there is no Item in this CargoBox,
     * -1.0 is returned.
     *
     * For example, if this CargoBox has the contents
     *   new Item("clock", 400)
     * and
     *   new Item("textbook", 395),
     * the result is: 397.5
     *
     * @return the average length of the Items in this CargoBox,
     *  or -1.0 if there is no such Item.
     */
    public double averageWeightInGrammes() {
        if (Items.length != 0) {
            return totalWeightInGrammes() / Items.length;
        } else {
            return -1.0;
        }
    }

    /**
     * Returns the greatest Item in this CargoBox according to the
     * natural ordering of Item given by its compareTo method;
     * null if this CargoBox does not contain any Item objects
     *
     * @return the greatest Item in this CargoBox according to the
     *  natural ordering of Item given by its compareTo method;
     *  null if this CargoBox does not contain any Item objects
     */
    public Item greatestItem() {
        if (Items.length != 0) {
            Item greatest = Items[0];
            for (Item item : Items) {
                if (item != null & item.compareTo(greatest) > 0) {
                    greatest = item;
                }
            }
            return greatest;
        } else {
            return null;
        }
    }

    /**
     * Returns a new CargoBox with exactly those Items of this CargoBox
     * whose weight is less than or equal to the specified method parameter.
     * Does not modify this CargoBox.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the
     *  Items in the new CargoBox
     * @return a new CargoBox with exactly those Items of this CargoBox
     *  whose weight is less than or equal to the specified method parameter
     */
    public CargoBox makeNewCargoBoxWith(int maxItemWeightInGrammes) {
        CargoBox newBox = new CargoBox(Items);
        newBox.keepOnlyItemsWith(maxItemWeightInGrammes);
        return newBox;
    }

    /**
     * Returns a string representation of this CargoBox. The string
     * representation consists of a list of the CargoBox's contents,
     * enclosed in square brackets ("[]"). Adjacent Items are
     * separated by the characters ", " (comma and space). Items are
     * converted to strings as by their toString() method. The
     * representation does not mention any null references.
     *
     * So for
     *
     * Item i1 = new Item("Pen", 15);
     * Item i2 = new Item("Letter", 20);
     * Item i3 = null;
     * Item[] items = { i1, i2, i3, i1 };
     * CargoBox k = new CargoBox(items);
     *
     * the call k.toString() will return one of the three following Strings:
     *
     * "[(Pen, 15g), (Pen, 15g), (Letter, 20g)]"
     * "[(Pen, 15g), (Letter, 20g), (Pen, 15g)]"
     * "[(Letter, 20g), (Pen, 15g), (Pen, 15g)]"
     *
     * @return a String representation of this CargoBox
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String string = "[";
        for (int i = 0; i < Items.length; i++) {
            string += "(" + Items[i].toString() + ", " + Items[i].getWeightInGrammes() + "), ";
        }
        string += "(" + Items[Items.length-1].toString() + ", " + Items[Items.length-1].getWeightInGrammes() + "), ";
        return string;
    }

    /* class methods */

    /**
     * Class method to return a CargoBox with the highest total weight from an
     * array of CargoBoxs. If we have an array with a CargoBox of 3000 grammes
     * and a CargoBox with 4000 grammes, the CargoBox with 4000 grammes is
     * returned.
     *
     * Entries of the array may be null, and your method should work also in
     * the presence of such entries. So if in the above example we had an
     * additional third array entry null, the result would be exactly the same.
     *
     * If there are several CargoBoxs with the same weight, it is up to the
     * method implementation to choose one of them as the result (i.e., the
     * choice is implementation-specific, and method users should not rely on
     * any particular behaviour).
     *
     * @param CargoBoxs must not be null, but may contain null
     * @return one of the CargoBoxs with the highest total weight among all
     *  CargoBoxs in the parameter array; null if there is no non-null
     *  reference in CargoBoxs
     */
    public static CargoBox heaviestCargoBox(CargoBox[] CargoBoxs) {
        CargoBox heaviest = CargoBoxs[0];
        for (CargoBox cargobox : CargoBoxs) {
            if (cargobox.totalWeightInGrammes() > heaviest.totalWeightInGrammes()) {
                heaviest = cargobox;
            }
        }
        return heaviest;
    }
}
