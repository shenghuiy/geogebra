/* 
GeoGebra - Dynamic Mathematics for Everyone
http://www.geogebra.org

This file is part of GeoGebra.

This program is free software; you can redistribute it and/or modify it 
under the terms of the GNU General Public License as published by 
the Free Software Foundation.

*/

package geogebra.kernel.algos;

import geogebra.common.kernel.algos.AlgoElement;
import geogebra.common.kernel.geos.GeoElement;
import geogebra.common.kernel.geos.GeoList;
import geogebra.common.kernel.geos.GeoNumeric;
import geogebra.kernel.Construction;

/**
 * Take objects from the middle of a list
 * @author Michael Borcherds
 * @version 2008-03-04
 */

public class AlgoTake extends AlgoElement {

	private GeoList inputList; //input
	private GeoNumeric m,n; //input
    private GeoList outputList; //output	
    private int size;

    public AlgoTake(Construction cons, String label, GeoList inputList, GeoNumeric m, GeoNumeric n) {
        this(cons, inputList, m, n);
        outputList.setLabel(label);
    }

    public AlgoTake(Construction cons, GeoList inputList, GeoNumeric m, GeoNumeric n) {
        super(cons);
        this.inputList = inputList;
        this.m=m;
        this.n=n;

               
        outputList = new GeoList(cons);

        setInputOutput();
        compute();
    }

    @Override
	public String getClassName() {
        return "AlgoTake";
    }

    @Override
	protected void setInputOutput(){
        input = new GeoElement[3];
        input[0] = inputList;
        input[1] = m;
        input[2] = n;

        super.setOutputLength(1);
        super.setOutput(0, outputList);
        setDependencies(); // done by AlgoElement
    }

    public GeoList getResult() {
        return outputList;
    }

    @Override
	public final void compute() {
    	
    	if (!m.isDefined() || !n.isDefined()) {
    		// return empty list
        	outputList.setDefined(true);
        	outputList.clear();
        	return;
    	}
    	
    	size = inputList.size();
    	int start=(int)m.getDouble();
    	double nVal = n.getDouble();
    	int end = (int)nVal;
    	
    	if (nVal == 0 && inputList.isDefined() && start > 0 && start <= size) {
    		// return empty list
        	outputList.setDefined(true);
        	outputList.clear();
        	return;
    	}
    	
    	if (!inputList.isDefined() ||  size == 0 || start <= 0 || end > size || start > end) {
    		outputList.setUndefined();
    		return;
    	} 
       
    	outputList.setDefined(true);
    	outputList.clear();
    	
    	for (int i=start ; i<=end ; i++) {
    		outputList.add(inputList.get(i - 1).copyInternal(cons));
    	}
   }
  
}
