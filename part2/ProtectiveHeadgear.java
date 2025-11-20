/**
*
* Abstract class ProtectiveHeadgear implements the Headgear interface.
* ProtectiveHeadgear implements a new property protectionFactor, which has its own accessor and mutator.
* @author Nicholas Liu
*
*/
abstract class ProtectiveHeadgear implements Headgear {
    protected double value;
    protected double protectionFactor;
    public ProtectiveHeadgear(double value, double protectionFactor) {
        this.value = value;
        if (protectionFactor >= 0) {
            this.protectionFactor = protectionFactor;
        } else {
            throw new IllegalArgumentException("Protection factor can't be below zero.");
        }
    }
    public double getValue() {
        return value;
    }
    public double getProtectionFactor() {
        return protectionFactor;
    }
    public void setProtectionFactor(double protectionFactor) {
        if (protectionFactor >= 0) {
            this.protectionFactor = protectionFactor;
        } else {
            throw new IllegalArgumentException("Protection factor can't be below zero.");
        }
    }
}
