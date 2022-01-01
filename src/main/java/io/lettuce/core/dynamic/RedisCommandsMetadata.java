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
package io.lettuce.core.dynamic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Interface exposing Redis command interface metadata.
 *
 * @author Mark Paluch
 * @since 5.0
 */
interface RedisCommandsMetadata {

    Collection<Method> getMethods();

    /**
     * Returns the Redis Commands interface.
     *
     * @return
     */
    Class<?> getCommandsInterface();

    /**
     * Lookup an interface annotation.
     *
     * @param annotationClass the annotation class.
     * @return the annotation object or {@code null} if not found.
     */
    <A extends Annotation> A getAnnotation(Class<A> annotationClass);

    /**
     * @param annotationClass the annotation class.
     * @return {@code true} if the interface is annotated with {@code annotationClass}.
     */
    boolean hasAnnotation(Class<? extends Annotation> annotationClass);

}
