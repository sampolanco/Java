/*
 * Copyright (c) 2020 The Eclipse Foundation and others.
 * 
 * This program and the accompanying materials are made available under 
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution, and is available at https://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package com.demo.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.demo.model.Persona;
import com.demo.service.PersonaService;

/**
 * Simple Hello World endpoint.
 * 
 * @author Ivar Grimstad (ivar.grimstad@eclipse-foundation.org)
 */
@Path("")
public class Rest {
	@Inject 
	PersonaService personaService;
    
    @GET
    public Response hello(){
        return Response.ok("Hello, World!").build();
    }
    @GET
    @Path("persona")
    public Response persona(){
    	Persona persona=personaService.buscarPersonaPorNombre("sam");
        return Response.ok(persona).build();
    	//return null;
    }
    @GET
    @Path("mensaje")
    public Response mensaje(){
        return Response.ok("Hello, World desde mensaje!").build();
    }
    @GET
    @Path("index")
    public String index(){
        return "index.jsp";
    }
}
