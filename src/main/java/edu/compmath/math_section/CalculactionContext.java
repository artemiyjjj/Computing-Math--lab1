package edu.compmath.math_section;


import edu.compmath.utils.Context;

public abstract class CalculactionContext extends Context {
    public CalculactionContext(CalculationStrategy calculationStrategy) {
        super(calculationStrategy);
    }
    public CalculactionContext() {
        super();
    }
}
