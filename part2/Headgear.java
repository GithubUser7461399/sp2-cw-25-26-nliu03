/**
*
* Interface Headgear for which all other classes in the Part 2 coursework must implement from.
* The Headgear class requires all headgear have an implementation for the getValue() method.
* @author Nicholas Liu
*
*/
interface Headgear {
    double value = 0.0;
    double getValue();
    static double totalValue(Headgear[] headgears) {
        if (headgears != null) {
            double total = 0.0;
            for (Headgear headgear : headgears) {
                if (headgear != null) {
                    total += headgear.getValue();
                }
            }
            return total;
        } else {
            throw new IllegalArgumentException("headgears cannot be a null pointer.");
        }
    }
}
