package com.himamis.retex.renderer.share.commands;

import com.himamis.retex.renderer.share.Atom;
import com.himamis.retex.renderer.share.PhantomAtom;
import com.himamis.retex.renderer.share.RowAtom;
import com.himamis.retex.renderer.share.ScriptsAtom;
import com.himamis.retex.renderer.share.SpaceAtom;
import com.himamis.retex.renderer.share.TeXConstants;
import com.himamis.retex.renderer.share.TeXLength;
import com.himamis.retex.renderer.share.TeXParser;

public class CommandPreScript extends Command3A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b, Atom c) {
		final RowAtom ra = new RowAtom(
				new ScriptsAtom(new PhantomAtom(c, false, true, true), b, a,
						false),
				new SpaceAtom(TeXLength.Unit.MU, -0.3, 0., 0.),
				c.changeType(TeXConstants.TYPE_ORDINARY));
		ra.lookAtLast(true);
		return ra;
	}

	@Override
	public Command duplicate() {
		CommandPreScript ret = new CommandPreScript();
		ret.atom1 = atom1;
		ret.atom2 = atom2;
		return ret;
	}

}
