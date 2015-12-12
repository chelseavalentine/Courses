import java.util.*;

/**
 * CollisionList class stores a list of collisions. The organization of this list is
 * based on the zip code associated with a given collision. This organization simplifies 
 * processing of collisions that occur within a particular zip code. 
 * @author Joanna K.
 * @author Chelsea Valentine
 */

public class CollisionList {

	private TreeSet<ZipCodeList> list; // store zipcodes in a tree set
	
	/**
	 * Creates an empty CollisionList object. 
	 */
	public CollisionList() {
		list = new TreeSet<ZipCodeList>();
	}
	
	
	/**
	 * Adds a particular record to this CollisionList object.
	 * The record should consist of 21 string entries in the following order:
	 * date
	 * time
	 * borough
	 * zip
	 * lattitude^
	 * longitude ^
	 * on street name^
	 * cross street name ^
	 * personsInjured
	 * personsKilled
	 * pedestriansInjured
	 * pedestriansKilled
	 * cyclistsInjured
	 * cyclistsKilled
	 * motoristsInjured
	 * motoristsKilled
	 * contributing factor vehicle 1^
	 * contributing factor vehicle 2^
	 * uniqueKey
	 * vehicleCode1
	 * vehicleCode2
	 * The entries indicated with ^ are not used. 
	 * 
	 * @param record an list of string describing a particular collision (see above
	 * for order of entries) 
	 * @return true if the record was added to this CollisionList object, false if any 
	 * problem occurred and the record was not added 
	 */
	public boolean add ( ArrayList<String> record ) {
		
		try{
			Collision col = new Collision(record);
			ZipCodeList tmp = new ZipCodeList(col);
			//add the collision object to the existing zip code list
			if (list.contains(tmp)) {
				// find the matching zipcode and increment it
				Iterator<ZipCodeList> it = list.iterator();
				while (it.hasNext()) {
					ZipCodeList current = it.next();
					// if we have created a zip code list identical to one that already exists,
					// just increment it
					if (current.equals(tmp)) {
						current.add(col);
						break;
					}
				}
			}
			// add the new zip code list
			else {
				list.add(tmp);
			}
		}
		catch (IllegalArgumentException ex ) {
			return false;  //return false if the Collision constructor failed 
		}
		
		return true; //return true to indicate that the object was added
		
	}
	
	/**
	 * Determines k zip codes with most collisions in this CollisionList object. 
	 * @param k number of zip codes with the highest number of collisions
	 * @return a string formatted as 
	 *     zip  numOfCollisions
	 *  one per line, that contains k zip codes with the highest number of collisions
	 */
	public String getZipCodesWithMostCollisions (int k) {
		@SuppressWarnings("unchecked")
		TreeSet<ZipCodeList> sortedList = new TreeSet<>(new CompareByNumOfCollisionsDescending());

		// "Clone" list into the treeset
		Iterator<ZipCodeList> itList = list.iterator();
		while (itList.hasNext()) {
			sortedList.add(itList.next());
		}
		StringBuffer result = new StringBuffer();
		
		int count = 0;

		Iterator<ZipCodeList> it = sortedList.iterator();
		ZipCodeList current;
		while (count < k && it.hasNext()) {
			// iterate through the list of most collisions and add the results to our result output
				current = it.next();
				result.append(String.format("    %5s  %5d collisions\n", current.getZip(),
						current.getTotalNumOfCollisions()));
				count++;
		}
		return result.toString();
	}
	
	/**
	 * Determines k zip codes with least collisions in this CollisionList object. 
	 * @param k number of zip codes with the lowest number of collisions
	 * @return a string formatted as 
	 *     zip  numOfCollisions
	 *  one per line, that contains k zip codes with the lowest number of collisions
	 */
	public String getZipCodesWithLeastCollisions (int k) {

		@SuppressWarnings("unchecked")
		TreeSet<ZipCodeList> sortedList = new TreeSet<>(new CompareByNumOfCollisionsAscending());

		// "Clone" list into the treeset
		Iterator<ZipCodeList> itList = list.iterator();
		while (itList.hasNext())
			sortedList.add(itList.next());

		StringBuffer result = new StringBuffer();

		int count = 0;

		// get lowest number of collisions
		Iterator<ZipCodeList> it = sortedList.iterator();

		ZipCodeList current;

		String[] ascResults = new String[k]; // array of results in ascending order
		int resultIndex = 0; // keep track of asc results index

		while (count < k && it.hasNext()) {
			// iterate through sorted list and add results to asc result
			current = it.next();
			ascResults[resultIndex] = String.format("    %5s  %5d collisions\n", current.getZip(),
					current.getTotalNumOfCollisions());
			resultIndex++;
			count++;
		}

		// make results descending
		for (int i = ascResults.length - 1; i >= 0; i--) {
			result.append(ascResults[i]);
		}
		return result.toString();
	}
	

	
	/**
	 * Determines k zip codes with most number of collisions involving 
	 * cyclists in this CollisionList object. 
	 * @param k number of zip codes with the highest number of collisions that involved cyclists 
	 * @return a string formatted as 
	 *     zip  numOfCycliststHurt  (numOfCyclists killed) 
	 *  one per line, that contains k zip codes with the highest number of injured cyclists 
	 */
	public String getZipCodesWithMostCyclistIncidents ( int k ) {
		@SuppressWarnings("unchecked")
		TreeSet<ZipCodeList> sortedList = new TreeSet<>(new CompareByNumOfCyclistsIncidentsDescending());

		// "Clone" list into the treeset
		Iterator<ZipCodeList> itList = list.iterator();
		while (itList.hasNext()) {
			sortedList.add(itList.next());
		}
		StringBuffer result = new StringBuffer();

		int inj = 0, killed = 0;
		int count = 0;

		Iterator<ZipCodeList> it = sortedList.iterator();
		ZipCodeList current;
		while (count < k && it.hasNext()) {
			// iterate through the zipcode lists and add the related cyclist data to results
			current = it.next();
			inj = current.getTotalNumOfCyclistsInjured();
			killed = current.getTotalNumOfCyclistsKilled();
			result.append(String.format("    %5s  %5d (%3d killed ) cyclists hurt\n", current.getZip(), inj + killed,
					killed));
			count++;
		}

		return result.toString();
	}
	
	
	/**
	 * Determines k zip codes with most number of injured and killed persons. 
	 * @param k number of zip codes with the highest number of injured and killed persons
	 * @return a string formatted as 
	 *     zip  numOfPersonsHurt  (numOfPersons killed) 
	 *  one per line, that contains k zip codes with the highest number of injured persons 
	 */
	public String getZipCodesWithMostPersonIncidents ( int k ) {
		@SuppressWarnings("unchecked")
		TreeSet<ZipCodeList> sortedList = new TreeSet<>(new CompareByNumOfPersonsIncidentsDescending());

		// "Clone" list into the treeset
		Iterator<ZipCodeList> itList = list.iterator();
		while (itList.hasNext()) {
			sortedList.add(itList.next());
		}
		StringBuffer result = new StringBuffer();

		int inj = 0, killed = 0;
		int count = 0;

		Iterator<ZipCodeList> it = sortedList.iterator();
		ZipCodeList current;
		while (count < k && it.hasNext()) {
			// iterate through the list until we've found k of the top zip code lists w/ person casualties
			// and injuries
			current = it.next();
			inj = current.getTotalNumOfPersonsInjured();
			killed = current.getTotalNumOfPersonsKilled();
			result.append(String.format("    %5s  %5d (%3d killed ) persons hurt\n", current.getZip(), inj + killed,
					killed));
			count++;
		}

		return result.toString();
	}
	

	/**
	 * Computes percentage of total collisions in this CollisionList object that involved one
	 * of the following vehicle types: taxi, bus, bicycle, truck, fire truck and ambulance. 
	 * @return a string containing the results of the computation 
	 */
	public String getVehicleTypeStats ( ) {
		String result = new String();
		
		int taxi = 0;
		int bus = 0;
		int bicycle = 0;
		int fireTruck = 0;
		int ambulance = 0;

		Iterator<ZipCodeList> it = list.iterator();
		// iterate through the zip code lists
		while (it.hasNext()) {
			ZipCodeList current = it.next();
			Iterator<Collision> colIt = current.iterator();
			// iterate through the zip code list's collisions
			while (colIt.hasNext()) {
				Collision c = colIt.next();
				// add to respective tallies
				if (c.getVehicleCode1().equalsIgnoreCase("taxi") ||
						c.getVehicleCode2().equalsIgnoreCase("taxi")) taxi++;
				if (c.getVehicleCode1().equalsIgnoreCase("bus") ||
						c.getVehicleCode2().equalsIgnoreCase("bus")) bus++;
				if (c.getVehicleCode1().equalsIgnoreCase("bicycle") ||
						c.getVehicleCode2().equalsIgnoreCase("bicycle")) bicycle++;
				if (c.getVehicleCode1().equalsIgnoreCase("fire truck") ||
						c.getVehicleCode2().equalsIgnoreCase("fire truck")) fireTruck++;
				if (c.getVehicleCode1().equalsIgnoreCase("ambulance") ||
						c.getVehicleCode2().equalsIgnoreCase("ambulance")) ambulance++;
			}
		}

		//create a string object with results
		// divide by the size of the list of zip code lists
		result += String.format("    %-11s %5.2f%%\n", "taxi", (float)(taxi)/list.size()*100);
		result += String.format("    %-11s %5.2f%%\n", "bus", (float)(bus)/list.size()*100);
		result += String.format("    %-11s %5.2f%%\n", "bicycle", (float)(bicycle)/list.size()*100);
		result += String.format("    %-11s %5.2f%%\n", "fire truck", (float)(fireTruck)/list.size()*100);
		result += String.format("    %-11s %5.2f%%\n", "ambulance", (float)(ambulance)/list.size()*100);
		
		return result;
	}
	
	/**
	 * Computes percentage of total collisions in this CollisionList object that occured within 
	 * a particular hour. The collisions are placed into bins of 1 hour intervals.  
	 * @return a string containing the results of the computation 
	 */
	public String getHourlyStats ( ) { 
		StringBuffer result = new StringBuffer() ;
		
		//counter for each hour
		int [] hourlyCount = new int [24]; 
		
		String hour = "", time = ""; 
		StringBuffer bar; 

		for (ZipCodeList l : list ) {
			for ( Collision c : l ) {
				try { 
					//extract the hour from the time entry 
					time = c.getTime();
					hour = time.substring(0,time.indexOf(':')).trim();
					//increment counter for that hour
					hourlyCount[Integer.parseInt(hour)]++;
				} catch (IndexOutOfBoundsException e) {
					//ignore incorrectly formed times 
				} catch (NumberFormatException e ) {
					//ignore incorrectly formed times 
				}
			}
		}
		
		for (int i = 0; i < 24; i++ ) {
			//determine number of "bars" to be printed for visual representation of 
			//the histogram 
			int numOfBars = (int)(((double)hourlyCount[i]/list.size()) * 240);
			bar = new StringBuffer(numOfBars);
			for (int j = 0; j < numOfBars; j++)
				bar.append("|");
			result.append(String.format("%3d h  %5.1f%% %s%n", 
					i, 100.0*hourlyCount[i]/list.size(), bar.toString() ));
		}
		
		return result.toString();
	}
	
}


/*
 * Comparator class for comparing two @see ZipCodeList objects based on the
 * number of collisions occurring in each. The resulting order is ascending. 
 * @author Joanna K. 
 *
 */
class CompareByNumOfCollisionsAscending implements Comparator <ZipCodeList> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(ZipCodeList arg0, ZipCodeList arg1) {
		return arg0.getTotalNumOfCollisions() - arg1.getTotalNumOfCollisions();
	}
	
}


/*
 * Comparator class for comparing two @see ZipCodeList objects based on the
 * number of collisions occurring in each. The resulting order is descending. 
 * @author Joanna K. 
 *
 */
class CompareByNumOfCollisionsDescending implements Comparator <ZipCodeList> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(ZipCodeList arg0, ZipCodeList arg1) {
		return arg1.getTotalNumOfCollisions() - arg0.getTotalNumOfCollisions();
	}
	
}

/*
 * Comparator class for comparing two @see ZipCodeList objects based on the
 * number of injured persons. The resulting order is descending. Ties are resolved
 * based on the number of killed persons. 
 * @author Joanna K. 
 *
 */
class CompareByNumOfPersonsIncidentsDescending implements Comparator <ZipCodeList> {

	@Override
	public int compare(ZipCodeList arg0, ZipCodeList arg1) {
		int diff = ( arg1.getTotalNumOfPersonsInjured() + arg1.getTotalNumOfPersonsKilled()) 
				- ( arg0.getTotalNumOfPersonsInjured() + arg0.getTotalNumOfPersonsKilled()) ; 

		if (diff != 0 ) 
			return diff;
		else return ( arg1.getTotalNumOfPersonsKilled() - arg0.getTotalNumOfPersonsKilled() );
	}
	
}

/*
 * Comparator class for comparing two @see ZipCodeList objects based on the
 * number of injured persons. The resulting order is ascending. Ties are resolved
 * based on the number of killed persons. 
 * @author Joanna K. 
 *
 */
class CompareByNumOfPersonsIncidentsAscending implements Comparator <ZipCodeList> {

	@Override
	public int compare(ZipCodeList arg0, ZipCodeList arg1) {
		int diff = - ( arg1.getTotalNumOfPersonsInjured() + arg1.getTotalNumOfPersonsKilled()) 
				+ ( arg0.getTotalNumOfPersonsInjured() + arg0.getTotalNumOfPersonsKilled()) ; 

		if (diff != 0 ) 
			return diff;
		else return ( -arg1.getTotalNumOfPersonsKilled() + arg0.getTotalNumOfPersonsKilled() );
	}
	
}

/*
 * Comparator class for comparing two @see ZipCodeList objects based on the
 * number of injured cyclists. The resulting order is descending. Ties are resolved
 * based on the number of killed cyclists. 
 * @author Joanna K. 
 *
 */
class CompareByNumOfCyclistsIncidentsDescending implements Comparator <ZipCodeList> {

	@Override
	public int compare(ZipCodeList arg0, ZipCodeList arg1) {
		int diff = ( arg1.getTotalNumOfCyclistsInjured() + arg1.getTotalNumOfCyclistsKilled()) 
				- ( arg0.getTotalNumOfCyclistsInjured() + arg0.getTotalNumOfCyclistsKilled()) ; 

		if (diff != 0 ) 
			return diff;
		else return ( arg1.getTotalNumOfCyclistsKilled() - arg0.getTotalNumOfCyclistsKilled() );
	}
	
}

/*
 * Comparator class for comparing two @see ZipCodeList objects based on the
 * number of injured cyclists. The resulting order is ascending. Ties are resolved
 * based on the number of killed cyclists. 
 * @author Joanna K. 
 *
 */
class CompareByNumOfCyclistsIncidentsAscending implements Comparator <ZipCodeList> {

	@Override
	public int compare(ZipCodeList arg0, ZipCodeList arg1) {
		int diff = - ( arg1.getTotalNumOfCyclistsInjured() + arg1.getTotalNumOfCyclistsKilled()) 
				+ ( arg0.getTotalNumOfCyclistsInjured() + arg0.getTotalNumOfCyclistsKilled()) ; 

		if (diff != 0 ) 
			return diff;
		else return ( -arg1.getTotalNumOfCyclistsKilled() + arg0.getTotalNumOfCyclistsKilled() );
	}
	
}