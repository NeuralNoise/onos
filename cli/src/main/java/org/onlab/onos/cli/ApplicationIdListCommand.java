/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.onlab.onos.cli;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.karaf.shell.commands.Command;
import org.onlab.onos.core.ApplicationId;
import org.onlab.onos.core.CoreService;

import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Lists application ID information.
 */
@Command(scope = "onos", name = "apps",
         description = "Lists application ID information")
public class ApplicationIdListCommand extends AbstractShellCommand {

    @Override
    protected void execute() {
        CoreService service = get(CoreService.class);
        List<ApplicationId> ids = newArrayList(service.getAppIds());
        Collections.sort(ids, Comparators.APP_ID_COMPARATOR);

        if (outputJson()) {
            print("%s", json(ids));
        } else {
            for (ApplicationId id : ids) {
                print("id=%d, name=%s", id.id(), id.name());
            }
        }
    }

    // ApplicationId
    private JsonNode json(List<ApplicationId> ids) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode result = mapper.createArrayNode();
        for (ApplicationId id : ids) {
            result.add(mapper.createObjectNode()
                               .put("id", id.id())
                               .put("name", id.name()));
        }
        return result;
    }

}
