package geogebra.common.kernel.prover;

import java.util.HashMap;

import geogebra.common.main.AbstractApplication;
import geogebra.common.kernel.prover.Polynomial;

/**
 * A simple class for variables.
 * @author Simon Weitzhofer
 * @author Damien Desfontaines
 *
 */
public class Variable implements Comparable<Variable> {
	private static int n = 0;
    private static int nextAvailableNumber = 0;
	private static HashMap<String,Integer> nameToId;
    private static HashMap<String,Variable> twins;

	private final String name;
    private final int id;

	static {
		nameToId = new HashMap<String, Integer>();
		twins = new HashMap<String, Variable>();
	}
	
	/**
	 * Creates a new variable
	 */
	public Variable() {
        n++;
        nextAvailableNumber++;
        name = "v".concat(Integer.toString(nextAvailableNumber));
        nameToId.put(name,n);
        id = n;
	}

    /**
     * Returns the variable v
     * @param x the name of the variable
     */
    public Variable(String v) {
        if (nameToId.containsKey(v)) {
            name = v;
            id = nameToId.get(name);
        }
        else {
            n++;
            name = v;
            nameToId.put(name,n);
            id = n;
        }
    }

	/**
	 * Copies a variable
	 * @param fv the variable to copy
	 */
	protected Variable(Variable fv) {
		name = fv.getName();
        id = fv.getId();
	}

	/**
	 * Returns the unique id of the variable
	 * @return the id
	 */
	public int getId() {
        return id;
	}

	@Override
	public String toString() {
		return getName();
	}

	public int compareTo(Variable v) {
        int vId = v.getId();
		if (id < vId) {
			return 1;
		}
		if (id > vId) {
			return -1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Variable) {
			return name == ((Variable) o).name;
		}
		return super.equals(o);
	}

	/**
	 * Returns the name of the variable.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return nameToId.get(name);
	}

	/**
	 * Returns the Variable which describes the other coordinate of the same point
	 * @return the Variable
	 */
	public Variable getTwin() {
		return twins.get(name);
	}

	/**
	 * Sets the Variable which describes the other coordinate of the same point
	 * @param twin the Variable. Is null if there is no twin.
	 */
	public void setTwin(Variable twin) {
		twins.put(name,twin);
	}
}
