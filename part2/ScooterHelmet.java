/**
*
* Concrete class ScooterHelmet extends functionality of the abstract class ProtectiveHeadgear.
* ScooterHelmet has a boolean property visor, true means it has a visor, otherwise false. visor has an accessor and mutator.
* ScooterHelmet's implementation for the method getValue() uses ternary operator to calculate the value based on prescence of a visor as well as the protectionFactor.
* @author Nicholas Liu
*
*/
public class ScooterHelmet extends ProtectiveHeadgear {
    private boolean visor;
    public ScooterHelmet(double value, double protectionFactor, boolean visor) {
        super(value, protectionFactor);
        this.visor = visor;
    }
    public double getValue() {
        return (visor)? 160.0 : 80.0 + protectionFactor * 400;
    }
    public boolean getVisor() {
        return visor;
    }
    public void setVisor(boolean visor) {
        this.visor = visor;
    }
    @Override
    public String toString() {
        return "(Value: " + getValue() + "), (Protection factor: " + protectionFactor + "), (Has visor?: " + visor + ")";
    }
}
