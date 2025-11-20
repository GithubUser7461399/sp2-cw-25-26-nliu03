abstract class ProtectiveHeadgear implements Headgear {
    protected double value;
    protected double protectionFactor;
    public ProtectiveHeadgear(double value, double protectionFactor) {
        this.value = value;
        this.protectionFactor = protectionFactor;
    }
    public double getValue() {
        return value;
    }
}
