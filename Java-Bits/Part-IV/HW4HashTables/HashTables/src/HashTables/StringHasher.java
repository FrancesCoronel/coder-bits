/*
 * String Hasher
 */
package yourCode;

import providedCode.Hasher;

public class StringHasher implements Hasher 
{

	/**
	 * TODO Replace this comment with your own as appropriate.
	 * hash method
	 * @param  str [string argument]
	 * @return  key value of string argument passed in
	 */
	@Override
	public int hash(String str) 
	{
		// TODO Auto-generated method stub
		int total = 0;
		for (int i = 0; i < str.length(); i++)
		{
			total += str.charAt(i);
		}
		//return 0;
		return total;
	}
}
