/*
 * Copyright 2011-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lettuce.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Cursor providing a list of values.
 *
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 3.0
 */
public class ValueScanCursor<V> extends ScanCursor {

    private final List<V> values = new ArrayList<>();

    public ValueScanCursor() {
    }

    public List<V> getValues() {
        return values;
    }

}
