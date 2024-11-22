package inqdo_demo;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
// --- <<IS-END-IMPORTS>> ---

public final class list

{
	// ---( internal utility methods )---

	final static list _instance = new list();

	static list _newInstance() { return new list(); }

	static list _cast(Object o) { return (list)o; }

	// ---( server methods )---




	public static final void getUniqueStringList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getUniqueStringList)>> ---
		// @sigtype java 3.5
		// [i] field:1:required stringList
		// [o] field:1:required uniqueStringList
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		// Retrieve the input StringList
		String[] stringList = null;
		if (pipelineCursor.first("stringList")) {
		    stringList = (String[]) pipelineCursor.getValue();
		}
		
		// Check if stringList is null
		if (stringList == null) {
		    // Return an empty list if the input is null
		    stringList = new String[0];
		}
		
		// Use a Set to get unique values
		Set<String> uniqueSet = new HashSet<>(Arrays.asList(stringList));
		
		// Convert Set back to StringList
		String[] uniqueStringList = uniqueSet.toArray(new String[0]);
		
		// Set the output StringList in the pipeline
		IDataUtil.put(pipelineCursor, "uniqueStringList", uniqueStringList);
		
		// Destroy the cursor
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}
}

