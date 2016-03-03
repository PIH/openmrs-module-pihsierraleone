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

import org.openmrs.module.metadatadeploy.descriptor.LocationDescriptor;
import org.openmrs.module.metadatadeploy.descriptor.LocationTagDescriptor;

import java.util.Arrays;
import java.util.List;

public class Locations {

    public static LocationDescriptor UNKNOWN = new LocationDescriptor() {
        public String uuid() { return "8d6c993e-c2cc-11de-8d13-0010c6dffd0f"; }
        public String name() { return "Unknown Location"; }
        public String description() { return "Unknown Location"; }
    };

    public static LocationDescriptor WELLBODY = new LocationDescriptor() {
        public String uuid() { return "88ce74ab-e0f9-11e5-be03-e82aea237783"; }
        public String name() { return "Wellbody Health Center"; }
        public String description() { return "Wellbody Health Center"; }
        public List<LocationTagDescriptor> tags() { return Arrays.asList(LocationTags.LOGIN_LOCATION); }
    };
}
