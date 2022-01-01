/*
 * Copyright 2020-2022 the original author or authors.
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

package io.lettuce.core.api.coroutines

import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.KeyValue
import io.lettuce.core.LPosArgs
import io.lettuce.core.api.reactive.RedisListReactiveCommands
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull


/**
 * Coroutine executed commands (based on reactive commands) for Lists.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mikhael Sokolov
 * @since 6.0
 *
 * @generated by io.lettuce.apigenerator.CreateKotlinCoroutinesReactiveImplementation
 */
@ExperimentalLettuceCoroutinesApi
internal class RedisListCoroutinesCommandsImpl<K : Any, V : Any>(private val ops: RedisListReactiveCommands<K, V>) : RedisListCoroutinesCommands<K, V> {

    override suspend fun blpop(timeout: Long, vararg keys: K): KeyValue<K, V>? = ops.blpop(timeout, *keys).awaitFirstOrNull()

    override suspend fun brpop(timeout: Long, vararg keys: K): KeyValue<K, V>? = ops.brpop(timeout, *keys).awaitFirstOrNull()

    override suspend fun brpoplpush(timeout: Long, source: K, destination: K): V? = ops.brpoplpush(timeout, source, destination).awaitFirstOrNull()

    override suspend fun lindex(key: K, index: Long): V? = ops.lindex(key, index).awaitFirstOrNull()

    override suspend fun linsert(key: K, before: Boolean, pivot: V, value: V): Long? = ops.linsert(key, before, pivot, value).awaitFirstOrNull()

    override suspend fun llen(key: K): Long? = ops.llen(key).awaitFirstOrNull()

    override suspend fun lpop(key: K): V? = ops.lpop(key).awaitFirstOrNull()

    override suspend fun lpos(key: K, value: V): Long? = ops.lpos(key, value).awaitFirstOrNull()

    override suspend fun lpos(key: K, value: V, args: LPosArgs): Long? = ops.lpos(key, value, args).awaitFirstOrNull()

    override suspend fun lpos(key: K, value: V, count: Int): List<Long> = ops.lpos(key, value, count).asFlow().toList()

    override suspend fun lpos(key: K, value: V, count: Int, args: LPosArgs): List<Long> = ops.lpos(key, value, count, args).asFlow().toList()

    override suspend fun lpush(key: K, vararg values: V): Long? = ops.lpush(key, *values).awaitFirstOrNull()

    override suspend fun lpushx(key: K, vararg values: V): Long? = ops.lpushx(key, *values).awaitFirstOrNull()

    override suspend fun lrange(key: K, start: Long, stop: Long): List<V> = ops.lrange(key, start, stop).asFlow().toList()

    override suspend fun lrem(key: K, count: Long, value: V): Long? = ops.lrem(key, count, value).awaitFirstOrNull()

    override suspend fun lset(key: K, index: Long, value: V): String? = ops.lset(key, index, value).awaitFirstOrNull()

    override suspend fun ltrim(key: K, start: Long, stop: Long): String? = ops.ltrim(key, start, stop).awaitFirstOrNull()

    override suspend fun rpop(key: K): V? = ops.rpop(key).awaitFirstOrNull()

    override suspend fun rpoplpush(source: K, destination: K): V? = ops.rpoplpush(source, destination).awaitFirstOrNull()

    override suspend fun rpush(key: K, vararg values: V): Long? = ops.rpush(key, *values).awaitFirstOrNull()

    override suspend fun rpushx(key: K, vararg values: V): Long? = ops.rpushx(key, *values).awaitFirstOrNull()

}

