/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.marmotta.platform.core.logging;

import ch.qos.logback.classic.Level;
import com.google.common.collect.ImmutableSet;
import org.apache.marmotta.platform.core.api.logging.LoggingModule;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;

/**
 * Logging module for system-related information (startup, shutdown, ...).
 *
 * @author Sebastian Schaffert (sschaffert@apache.org)
 */
@ApplicationScoped
public class SystemLoggingModule extends BaseLoggingModule implements LoggingModule {

    /**
     * Return the default (logback) level used by this logging module. Should in most cases be INFO or WARN.
     *
     * @return
     */
    @Override
    public Level getDefaultLevel() {
        return Level.INFO;
    }

    /**
     * Return a unique identifier for this logging module. This identifier will e.g. be used in the configuration file
     * to store the configuration for this module. For this reason it should only consist of alpha-numeric characters
     * plus _ and _.
     *
     * @return a unique identifier for the module, suitable for use in the configuration file
     */
    @Override
    public String getId() {
        return "system";
    }

    /**
     * Return a human-readable name for this logging module. This name is used for displaying information about the
     * module to the user, e.g. in a configuration interface.
     *
     * @return a human-readable name for the module, suitable for displaying in a user interface
     */
    @Override
    public String getName() {
        return "System";
    }

    /**
     * Return a collection of packages covered by this logging module. This method should be used to group together
     * those packages that conceptually make up the functionality described by the logging module (e.g. "SPARQL").
     *
     * @return a collection of package names
     */
    @Override
    public Collection<String> getPackages() {
        return ImmutableSet.of(
                "org.apache.marmotta.platform.core.filters",
                "org.apache.marmotta.platform.core.startup",
                "org.apache.marmotta.platform.core.servlet",
                "org.apache.marmotta.platform.core.services.modules",
                "org.apache.marmotta.platform.core.webservices.system",
                "org.apache.marmotta.platform.core.jndi",
                "org.apache.marmotta.platform.core.jaxrs",
                "org.apache.marmotta.platform.core.util"
        );
    }
}
