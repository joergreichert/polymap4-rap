/*
 * polymap.org 
 * Copyright (C) 2015 individual contributors as indicated by the @authors tag. 
 * All rights reserved.
 * 
 * This is free software; you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software
 * Foundation; either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 */
package org.polymap.rap.openlayers.geom;

import java.util.Arrays;
import java.util.List;

import org.polymap.core.runtime.config.Concern;
import org.polymap.core.runtime.config.Config2;
import org.polymap.core.runtime.config.Immutable;
import org.polymap.core.runtime.config.Mandatory;
import org.polymap.rap.openlayers.base.OlPropertyConcern;
import org.polymap.rap.openlayers.types.Coordinate;


/**
 * 
 * @see <a href="http://openlayers.org/en/master/apidoc/ol.geom.MultiLineString.html">OpenLayers Doc</a>
 * @author Joerg Reichert <joerg@mapzone.io>
 *
 */
public class MultilineStringGeometry extends SimpleGeometry {

    @Immutable
    @Mandatory
    @Concern(OlPropertyConcern.class)
    Config2<SimpleGeometry,List<Coordinate>> coordinates;


    public MultilineStringGeometry( Coordinate... coordinates ) {
        this( Arrays.asList( coordinates ) );
    }


    public MultilineStringGeometry( List<Coordinate> coordinates ) {
        super( "ol.geom.MultiLineString" );
        this.coordinates.set( coordinates );
    }


    @Override
    protected void create() {
        super.create( jsClassname, "[" + OlPropertyConcern.propertyAsJson( coordinates.get() ) + "]" );
    }
}
