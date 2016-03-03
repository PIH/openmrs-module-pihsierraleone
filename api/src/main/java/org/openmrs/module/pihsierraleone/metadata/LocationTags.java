/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.pihsierraleone.metadata;

import org.openmrs.module.metadatadeploy.descriptor.LocationTagDescriptor;

/**
 * Constants for all defined location tags
 */
public class LocationTags {

	public static LocationTagDescriptor LOGIN_LOCATION = new LocationTagDescriptor() {
		public String uuid() { return "b8bbf83e-645f-451f-8efe-a0db56f09676"; }
		public String name() { return "Login Location"; }
		public String description() { return "When a user logs in and chooses a session location, they may only choose one with this tag"; }
	};
}