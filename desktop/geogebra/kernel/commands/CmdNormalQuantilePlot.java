package geogebra.kernel.commands;

import geogebra.common.kernel.geos.GeoElement;
import geogebra.common.kernel.geos.GeoList;
import geogebra.kernel.Kernel;

/**
 * NormalQuantilePlot[ <List of Numeric> ] G.Sturr 2011-6-29
 */
class CmdNormalQuantilePlot extends CmdOneListFunction {

	/**
	 * Create new command processor
	 * 
	 * @param kernel
	 *            kernel
	 */
	public CmdNormalQuantilePlot(Kernel kernel) {
		super(kernel);
	}

	final protected GeoElement doCommand(String a, GeoList b) {
		return kernel.NormalQuantilePlot(a, b);
	}

}
