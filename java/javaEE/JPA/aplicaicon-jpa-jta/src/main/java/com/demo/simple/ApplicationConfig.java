/*
 * Copyright (c) 2020 The Eclipse Foundation and others.
 * 
 * This program and the accompanying materials are made available under 
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution, and is available at https://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package com.demo.simple;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 * Configures the Jakarta REST application.
 * 
 * @author Ivar Grimstad (ivar.grimstad@eclipse-foundation.org)
 */
@ApplicationPath("/rest")
public class ApplicationConfig extends Application {
    
}
