/*|----------------------------------------------------------------------------------------------
 *|														Heidelberg University
 *|	  _____ _____  _____      _                     	Department of Geography		
 *|	 / ____|_   _|/ ____|    (_)                    	Chair of GIScience
 *|	| |  __  | | | (___   ___ _  ___ _ __   ___ ___ 	(C) 2014-2016
 *|	| | |_ | | |  \___ \ / __| |/ _ \ '_ \ / __/ _ \	
 *|	| |__| |_| |_ ____) | (__| |  __/ | | | (_|  __/	Berliner Strasse 48								
 *|	 \_____|_____|_____/ \___|_|\___|_| |_|\___\___|	D-69120 Heidelberg, Germany	
 *|	        	                                       	http://www.giscience.uni-hd.de
 *|								
 *|----------------------------------------------------------------------------------------------*/
package heigit.ors.exceptions;

import heigit.ors.common.StatusCode;

public class UnknownParameterValueException extends StatusCodeException{
	private static final long serialVersionUID = 4866998272349837464L;

	public UnknownParameterValueException(String paramName, String paramValue)
	{
		this(-1 ,paramName, paramValue);
	}
	
	public UnknownParameterValueException(int errorCode, String paramName, String paramValue)
	{
		super(StatusCode.BAD_REQUEST, errorCode, "Unknown parameter value '" + paramValue + "' for '" + paramName + "'.");
	}
}
