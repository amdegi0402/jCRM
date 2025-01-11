

package amsys_common;

import java.util.ArrayList;


public class SystemException extends Exception{


	ArrayList<String> messageList = new ArrayList<>();

	public SystemException(String message) {
		super(message);
	}

}
