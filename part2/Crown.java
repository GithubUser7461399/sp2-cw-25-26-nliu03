/**
*
* Concrete class Crown implements the Headgear interface.
* Crown has its own property jewels, with its own accessor and mutator. It is used to implement getValue for this class.
* @author Nicholas Liu
*
*/
public class Crown implements Headgear {
    private int jewels;
    public double getValue() {
        return jewels * 200000;
    }
    public int getJewels() {
        return jewels;
    }
    public void setJewels(int jewels) {
        if (jewels >= 0) {
            this.jewels = jewels;
        }
    }
}
