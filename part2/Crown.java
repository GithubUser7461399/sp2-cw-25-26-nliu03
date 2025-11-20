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
