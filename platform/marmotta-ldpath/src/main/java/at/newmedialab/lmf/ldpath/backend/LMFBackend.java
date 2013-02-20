/**
 * Copyright (C) 2013 Salzburg Research.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package at.newmedialab.lmf.ldpath.backend;

import at.newmedialab.ldpath.backend.sesame.SesameRepositoryBackend;
import kiwi.core.api.triplestore.SesameService;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Implementation of the LDPath RDFBackend<KiWiNode>, making use of the LMF internal triple store
 * implementation.
 * <p/>
 * Author: Sebastian Schaffert
 * 
 * @deprecated Use a {@link at.newmedialab.ldpath.backend.sesame.SesameConnectionBackend} instead
 *             and handle transactions manually.
 */
@ApplicationScoped
@Deprecated
public class LMFBackend extends SesameRepositoryBackend  {

    @Inject
    private Logger log;

    @Inject
    private SesameService sesameService;

    @PostConstruct
    public void initialize() {
        log.info("LMF LDPath backend starting up ...");

        setRepository(sesameService.getRepository());
        log.warn("LMFBackend is deprecated. Use a SesameConnectionBackend instead.", new Throwable("Deprecated Usage of LMFBackend"));
    }

}