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
package org.openmrs.module.pihsierraleone.metadata.deploy;

import org.openmrs.Privilege;
import org.openmrs.Provider;
import org.openmrs.Role;
import org.openmrs.User;
import org.openmrs.api.ProviderService;
import org.openmrs.api.UserService;
import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserBundle extends AbstractMetadataBundle {

    @Autowired
    UserService userService;

    @Autowired
    ProviderService providerService;

    @Override
    public void install() throws Exception {
        addPrivilegeToRole("Anonymous", "Get Locations");
        ensureUserIsProvider("admin");
    }

    /**
     * Adds the passed privilege to the passed role, if it exists
     */
    protected void addPrivilegeToRole(String role, String privilege) {
        Role r = userService.getRole(role);
        Privilege p = userService.getPrivilege(privilege);
        if (r == null) {
            throw new IllegalStateException("Unable to privilege to role. Role '" + role + "'not found.");
        }
        if (p == null) {
            throw new IllegalStateException("Unable to privilege to role. Privilege '" + privilege + "'not found.");
        }
        if (!r.getPrivileges().contains(p)) {
            r.addPrivilege(p);
        }
        userService.saveRole(r);
    }

    protected void ensureUserIsProvider(String username) {
        User u = userService.getUserByUsername(username);
        if (u == null) {
            throw new IllegalStateException("Unable to make user a provider. Username '" + username + "'not found.");
        }
        Collection<Provider> providers = providerService.getProvidersByPerson(u.getPerson());
        if (providers == null || providers.isEmpty()) {
            Provider p = new Provider();
            p.setPerson(u.getPerson());
            providerService.saveProvider(p);
        }
    }
}
