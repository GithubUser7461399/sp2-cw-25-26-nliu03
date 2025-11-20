public class ScooterHelmet extends ProtectiveHeadgear {
    private boolean visor;
    public ScooterHelmet(double value, double protectionFactor, boolean visor) {
        super(value, protectionFactor);
        this.visor = visor;
    }
    public double getValue() {
        return (visor)? 80.0 : 160.0 + protectionFactor * 400;
    }
    public boolean getVisor() {
        return visor;
    }
    public void setVisor(boolean visor) {
        this.visor = visor;
    }
}
