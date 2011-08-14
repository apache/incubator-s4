/*
 * Copyright (c) 2011 Yahoo! Inc. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *          http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License. See accompanying LICENSE file. 
 */
package io.s4.example.counter;

import io.s4.App;
import io.s4.Event;
import io.s4.ProcessingElement;

public class PrintPE extends ProcessingElement {
    

    public PrintPE(App app) {
        super(app);
    }

    @Override
    protected void processInputEvent(Event event) {
        
        System.out.println(event.toString());
    }

    @Override
    public void sendEvent() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void initPEInstance() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void removeInstanceForKey(String id) {

        System.out.println("Removing PE instance of type " + this.getClass().getName() + " for key " + id);
    }
}
