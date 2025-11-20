/**
*
* Concrete class Crown implements the Headgear interface.
* Crown has its own property jewels, with its own accessor and mutator. It is used to implement getValue for this class.
* @author Nicholas Liu
*
*/
public class Crown implements Headgear {
    private int jewels;
    public Crown(int jewels) {
        if (jewels >= 0) {
            this.jewels = jewels;
        } else {
            throw new IllegalArgumentException("Jewels can't be below zero.");
        }
    }
    public double getValue() {
        return jewels * 200000;
    }
    public int getJewels() {
        return jewels;
    }
    public void setJewels(int jewels) {
        if (jewels >= 0) {
            this.jewels = jewels;
        } else {
            throw new IllegalArgumentException("Jewels can't be below zero.");
        }
    }
    @Override
    public String toString() {
        return "(Value: " + getValue() + "), (Jewels: " + jewels + ")";
    }
}
