public class BobbleHat extends ProtectiveHeadgear {
    private double bobbleDiameter;
    public BobbleHat(double value, double protectionFactor, double bobbleDiameter) {
        super(value, protectionFactor);
        this.bobbleDiameter = bobbleDiameter;
    }
    public double getValue() {
        return bobbleDiameter * 4 * protectionFactor;
    }
    public double getBobbleDiameter() {
        return bobbleDiameter;
    }
    public void setBobbleDiameter(double bobbleDiameter) {
        this.bobbleDiameter = bobbleDiameter;
    }
}
