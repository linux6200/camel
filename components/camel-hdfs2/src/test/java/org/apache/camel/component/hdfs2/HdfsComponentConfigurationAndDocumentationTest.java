/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.hdfs2;

import org.apache.camel.ComponentConfiguration;
import org.apache.camel.EndpointConfiguration;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class HdfsComponentConfigurationAndDocumentationTest extends CamelTestSupport {

    @Override
    public boolean isUseRouteBuilder() {
        return false;
    }

    @Test
    public void testComponentConfiguration() throws Exception {
        HdfsComponent comp = context.getComponent("hdfs2", HdfsComponent.class);
        EndpointConfiguration conf = comp.createConfiguration("hdfs2://localhost/tmp/simple-file?"
                + "splitStrategy=IDLE:1000,BYTES:5&fileSystemType=LOCAL&fileType=ARRAY_FILE&initialDelay=0");

        assertEquals("LOCAL", conf.getParameter("fileSystemType"));
        assertEquals("ARRAY_FILE", conf.getParameter("fileType"));
        assertEquals("0", conf.getParameter("initialDelay"));

        ComponentConfiguration compConf = comp.createComponentConfiguration();
        String json = compConf.createParameterJsonSchema();
        assertNotNull(json);
    }

}
