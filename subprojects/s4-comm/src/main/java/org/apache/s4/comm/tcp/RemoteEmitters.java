/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
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

package org.apache.s4.comm.tcp;

import java.util.HashMap;
import java.util.Map;

import org.apache.s4.base.RemoteEmitter;
import org.apache.s4.comm.RemoteEmitterFactory;
import org.apache.s4.comm.topology.Cluster;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Manages the {@link RemoteEmitter} instances for sending messages to remote subclusters.
 * 
 */
@Singleton
public class RemoteEmitters {

    Map<Cluster, RemoteEmitter> emitters = new HashMap<Cluster, RemoteEmitter>();

    @Inject
    RemoteEmitterFactory emitterFactory;

    public RemoteEmitter getEmitter(Cluster topology) {
        RemoteEmitter emitter = emitters.get(topology);
        if (emitter == null) {
            emitter = emitterFactory.createRemoteEmitter(topology);
            emitters.put(topology, emitter);
        }
        return emitter;
    }

}
