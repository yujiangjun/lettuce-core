/*
 * Copyright 2018-2022 the original author or authors.
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
package io.lettuce.core.api.reactive;

import java.util.Map;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.lettuce.core.Consumer;
import io.lettuce.core.Limit;
import io.lettuce.core.Range;
import io.lettuce.core.StreamMessage;
import io.lettuce.core.XAddArgs;
import io.lettuce.core.XClaimArgs;
import io.lettuce.core.XGroupCreateArgs;
import io.lettuce.core.XReadArgs;
import io.lettuce.core.XReadArgs.StreamOffset;
import io.lettuce.core.models.stream.PendingMessage;
import io.lettuce.core.models.stream.PendingMessages;

/**
 * Reactive executed commands for Streams.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 5.1
 * @generated by io.lettuce.apigenerator.CreateReactiveApi
 */
public interface RedisStreamReactiveCommands<K, V> {

    /**
     * Acknowledge one or more messages as processed.
     *
     * @param key the stream key.
     * @param group name of the consumer group.
     * @param messageIds message Id's to acknowledge.
     * @return simple-reply the lenght of acknowledged messages.
     */
    Mono<Long> xack(K key, K group, String... messageIds);

    /**
     * Append a message to the stream {@code key}.
     *
     * @param key the stream key.
     * @param body message body.
     * @return simple-reply the message Id.
     */
    Mono<String> xadd(K key, Map<K, V> body);

    /**
     * Append a message to the stream {@code key}.
     *
     * @param key the stream key.
     * @param args
     * @param body message body.
     * @return simple-reply the message Id.
     */
    Mono<String> xadd(K key, XAddArgs args, Map<K, V> body);

    /**
     * Append a message to the stream {@code key}.
     *
     * @param key the stream key.
     * @param keysAndValues message body.
     * @return simple-reply the message Id.
     */
    Mono<String> xadd(K key, Object... keysAndValues);

    /**
     * Append a message to the stream {@code key}.
     *
     * @param key the stream key.
     * @param args
     * @param keysAndValues message body.
     * @return simple-reply the message Id.
     */
    Mono<String> xadd(K key, XAddArgs args, Object... keysAndValues);

    /**
     * Gets ownership of one or multiple messages in the Pending Entries List of a given stream consumer group.
     *
     * @param key the stream key.
     * @param consumer consumer identified by group name and consumer key.
     * @param minIdleTime
     * @param messageIds message Id's to claim.
     * @return simple-reply the {@link StreamMessage}.
     */
    Flux<StreamMessage<K, V>> xclaim(K key, Consumer<K> consumer, long minIdleTime, String... messageIds);

    /**
     * Gets ownership of one or multiple messages in the Pending Entries List of a given stream consumer group.
     * <p>
     * Note that setting the {@code JUSTID} flag (calling this method with {@link XClaimArgs#justid()}) suppresses the message
     * bode and {@link StreamMessage#getBody()} is {@code null}.
     *
     * @param key the stream key.
     * @param consumer consumer identified by group name and consumer key.
     * @param args
     * @param messageIds message Id's to claim.
     * @return simple-reply the {@link StreamMessage}.
     */
    Flux<StreamMessage<K, V>> xclaim(K key, Consumer<K> consumer, XClaimArgs args, String... messageIds);

    /**
     * Removes the specified entries from the stream. Returns the number of items deleted, that may be different from the number
     * of IDs passed in case certain IDs do not exist.
     *
     * @param key the stream key.
     * @param messageIds stream message Id's.
     * @return simple-reply number of removed entries.
     */
    Mono<Long> xdel(K key, String... messageIds);

    /**
     * Create a consumer group.
     *
     * @param streamOffset name of the stream containing the offset to set.
     * @param group name of the consumer group.
     * @return simple-reply {@code true} if successful.
     */
    Mono<String> xgroupCreate(StreamOffset<K> streamOffset, K group);

    /**
     * Create a consumer group.
     *
     * @param streamOffset name of the stream containing the offset to set.
     * @param group name of the consumer group.
     * @param args
     * @return simple-reply {@code true} if successful.
     * @since 5.2
     */
    Mono<String> xgroupCreate(StreamOffset<K> streamOffset, K group, XGroupCreateArgs args);

    /**
     * Delete a consumer from a consumer group.
     *
     * @param key the stream key.
     * @param consumer consumer identified by group name and consumer key.
     * @return Long integer-reply number of pending messages.
     */
    Mono<Long> xgroupDelconsumer(K key, Consumer<K> consumer);

    /**
     * Destroy a consumer group.
     *
     * @param key the stream key.
     * @param group name of the consumer group.
     * @return simple-reply {@code true} if successful.
     */
    Mono<Boolean> xgroupDestroy(K key, K group);

    /**
     * Set the current {@code group} id.
     *
     * @param streamOffset name of the stream containing the offset to set.
     * @param group name of the consumer group.
     * @return simple-reply OK.
     */
    Mono<String> xgroupSetid(StreamOffset<K> streamOffset, K group);

    /**
     * Retrieve information about the stream at {@code key}.
     *
     * @param key the stream key.
     * @return Object array-reply.
     * @since 5.2
     */
    Flux<Object> xinfoStream(K key);

    /**
     * Retrieve information about the stream consumer groups at {@code key}.
     *
     * @param key the stream key.
     * @return Object array-reply.
     * @since 5.2
     */
    Flux<Object> xinfoGroups(K key);

    /**
     * Retrieve information about consumer groups of group {@code group} and stream at {@code key}.
     *
     * @param key the stream key.
     * @param group name of the consumer group.
     * @return Object array-reply.
     * @since 5.2
     */
    Flux<Object> xinfoConsumers(K key, K group);

    /**
     * Get the length of a steam.
     *
     * @param key the stream key.
     * @return simple-reply the lenght of the stream.
     */
    Mono<Long> xlen(K key);

    /**
     * Read pending messages from a stream for a {@code group}.
     *
     * @param key the stream key.
     * @param group name of the consumer group.
     * @return Object array-reply list pending entries.
     */
    Mono<PendingMessages> xpending(K key, K group);

    /**
     * Read pending messages from a stream within a specific {@link Range}.
     *
     * @param key the stream key.
     * @param group name of the consumer group.
     * @param range must not be {@code null}.
     * @param limit must not be {@code null}.
     * @return Object array-reply list with members of the resulting stream.
     */
    Flux<PendingMessage> xpending(K key, K group, Range<String> range, Limit limit);

    /**
     * Read pending messages from a stream within a specific {@link Range}.
     *
     * @param key the stream key.
     * @param consumer consumer identified by group name and consumer key.
     * @param range must not be {@code null}.
     * @param limit must not be {@code null}.
     * @return Object array-reply list with members of the resulting stream.
     */
    Flux<PendingMessage> xpending(K key, Consumer<K> consumer, Range<String> range, Limit limit);

    /**
     * Read messages from a stream within a specific {@link Range}.
     *
     * @param key the stream key.
     * @param range must not be {@code null}.
     * @return StreamMessage array-reply list with members of the resulting stream.
     */
    Flux<StreamMessage<K, V>> xrange(K key, Range<String> range);

    /**
     * Read messages from a stream within a specific {@link Range} applying a {@link Limit}.
     *
     * @param key the stream key.
     * @param range must not be {@code null}.
     * @param limit must not be {@code null}.
     * @return StreamMessage array-reply list with members of the resulting stream.
     */
    Flux<StreamMessage<K, V>> xrange(K key, Range<String> range, Limit limit);

    /**
     * Read messages from one or more {@link StreamOffset}s.
     *
     * @param streams the streams to read from.
     * @return StreamMessage array-reply list with members of the resulting stream.
     */
    Flux<StreamMessage<K, V>> xread(StreamOffset<K>... streams);

    /**
     * Read messages from one or more {@link StreamOffset}s.
     *
     * @param args read arguments.
     * @param streams the streams to read from.
     * @return StreamMessage array-reply list with members of the resulting stream.
     */
    Flux<StreamMessage<K, V>> xread(XReadArgs args, StreamOffset<K>... streams);

    /**
     * Read messages from one or more {@link StreamOffset}s using a consumer group.
     *
     * @param consumer consumer/group.
     * @param streams the streams to read from.
     * @return StreamMessage array-reply list with members of the resulting stream.
     */
    Flux<StreamMessage<K, V>> xreadgroup(Consumer<K> consumer, StreamOffset<K>... streams);

    /**
     * Read messages from one or more {@link StreamOffset}s using a consumer group.
     *
     * @param consumer consumer/group.
     * @param args read arguments.
     * @param streams the streams to read from.
     * @return StreamMessage array-reply list with members of the resulting stream.
     */
    Flux<StreamMessage<K, V>> xreadgroup(Consumer<K> consumer, XReadArgs args, StreamOffset<K>... streams);

    /**
     * Read messages from a stream within a specific {@link Range} in reverse order.
     *
     * @param key the stream key.
     * @param range must not be {@code null}.
     * @return StreamMessage array-reply list with members of the resulting stream.
     */
    Flux<StreamMessage<K, V>> xrevrange(K key, Range<String> range);

    /**
     * Read messages from a stream within a specific {@link Range} applying a {@link Limit} in reverse order.
     *
     * @param key the stream key.
     * @param range must not be {@code null}.
     * @param limit must not be {@code null}.
     * @return StreamMessage array-reply list with members of the resulting stream.
     */
    Flux<StreamMessage<K, V>> xrevrange(K key, Range<String> range, Limit limit);

    /**
     * Trims the stream to {@code count} elements.
     *
     * @param key the stream key.
     * @param count length of the stream.
     * @return simple-reply number of removed entries.
     */
    Mono<Long> xtrim(K key, long count);

    /**
     * Trims the stream to {@code count} elements.
     *
     * @param key the stream key.
     * @param approximateTrimming {@code true} to trim approximately using the {@code ~} flag.
     * @param count length of the stream.
     * @return simple-reply number of removed entries.
     */
    Mono<Long> xtrim(K key, boolean approximateTrimming, long count);
}
