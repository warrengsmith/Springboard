package com.wgs.example;

/**
 * The Class ManipulatorImpl.
 * @author Warren Smith
 * @version 1.0
 */
public class ManipulatorImpl implements IManipulator {

	/* (non-Javadoc)
	 * @see com.wgs.example.IManipulator#manipulate(java.lang.String)
	 */
	@Override
	public void manipulate(String string) {
		System.out.println("Normal Execution - " + string);
	}

}
