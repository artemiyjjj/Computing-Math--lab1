package edu.compmath.math_section;


import edu.compmath.utils.Context;

public abstract class CalculactionContext extends Context { //todo а оно надо?
    public CalculactionContext(CalculationStrategy calculationStrategy) {
        super(calculationStrategy);
    }
    public CalculactionContext() {
        super();
    }
}
