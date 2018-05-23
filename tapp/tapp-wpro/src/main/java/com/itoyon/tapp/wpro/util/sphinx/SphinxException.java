/*
 * $Id$
 */

package com.itoyon.tapp.wpro.util.sphinx;

/** Exception thrown on attempts to pass invalid arguments to Sphinx API methods. */
public class SphinxException extends Exception
{
	/** Trivial constructor. */
	public SphinxException()
	{
	}

	/** Constructor from error message string. */
	public SphinxException ( String message )
	{
		super ( message );
	}
}

/*
 * $Id$
 */
