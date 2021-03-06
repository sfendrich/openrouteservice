/*  This file is part of Openrouteservice.
 *
 *  Openrouteservice is free software; you can redistribute it and/or modify it under the terms of the 
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 
 *  of the License, or (at your option) any later version.

 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details.

 *  You should have received a copy of the GNU Lesser General Public License along with this library; 
 *  if not, see <https://www.gnu.org/licenses/>.  
 */
package org.heigit.ors.isochrones;

import com.graphhopper.util.Helper;
import org.heigit.ors.isochrones.builders.IsochroneMapBuilder;
import org.heigit.ors.isochrones.builders.concaveballs.ConcaveBallsIsochroneMapBuilder;
import org.heigit.ors.isochrones.builders.grid.GridBasedIsochroneMapBuilder;
import org.heigit.ors.routing.RouteSearchContext;

public class IsochroneMapBuilderFactory {
	private RouteSearchContext searchContext;

	public IsochroneMapBuilderFactory(RouteSearchContext searchContext) {
		this.searchContext = searchContext;
	}

	public IsochroneMap buildMap(IsochroneSearchParameters parameters) throws Exception {
		IsochroneMapBuilder isochroneBuilder ;
		String method = parameters.getCalcMethod();
		if (Helper.isEmpty(method) || "Default".equalsIgnoreCase(method) || "ConcaveBalls".equalsIgnoreCase(method)) {
			isochroneBuilder = new ConcaveBallsIsochroneMapBuilder();
		} else if ("grid".equalsIgnoreCase(method)) {
        	isochroneBuilder= new GridBasedIsochroneMapBuilder();
        } else {
			throw new Exception("Unknown method.");
		}
		isochroneBuilder.initialize(searchContext);
		return isochroneBuilder.compute(parameters);
	}
}
