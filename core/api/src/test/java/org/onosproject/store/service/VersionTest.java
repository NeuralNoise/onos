/*
 * Copyright 2017-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.store.service;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Version test.
 */
public class VersionTest {

    @Test
    public void testVersion() {
        Version version1 = new Version(1);
        Version version2 = new Version(1);
        assertTrue(version1.equals(version2));
        assertTrue(version1.hashCode() == version2.hashCode());
        assertTrue(version1.value() == version2.value());

        Version version3 = new Version(2);
        assertFalse(version1.equals(version3));
        assertFalse(version1.hashCode() == version3.hashCode());
        assertFalse(version1.value() == version3.value());
    }

}
