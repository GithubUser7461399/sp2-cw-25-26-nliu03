/**
*
* Concrete class BobbleHat extends abstract class ProtectiveHeadgear.
* BobbleHat has property bobbleDiameter, which is the diameter of its bobble in millimetres.bobbleDiameter has an accessor and mutator.
* bobbleDiameter is used in the BobbleHat class' implementation for getValue().
* @author Nicholas Liu
*
*/
public class BobbleHat extends ProtectiveHeadgear {
    private double bobbleDiameter;
    public BobbleHat(double value, double protectionFactor, double bobbleDiameter) {
        super(value, protectionFactor);
        if (bobbleDiameter >= 0) {
            this.bobbleDiameter = bobbleDiameter;
        } else {
            throw new IllegalArgumentException("Bobble diameter can't be below zero.");
        }
    }
    public double getValue() {
        return bobbleDiameter * 4 * protectionFactor;
    }
    public double getBobbleDiameter() {
        return bobbleDiameter;
    }
    public void setBobbleDiameter(double bobbleDiameter) {
        if (bobbleDiameter >= 0) {
            this.bobbleDiameter = bobbleDiameter;
        } else {
            throw new IllegalArgumentException("Bobble diameter can't be below zero.");
        }
    }
}
