/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mongodb.codecs;

import org.bson.codecs.Codec;

/**
 * A Codec that generates complete BSON documents for storage in a MongoDB collection.
 *
 * @param <T> the document type
 */
public interface CollectibleCodec<T> extends Codec<T> {
    /**
     * Generates a value for the _id field on the given document, if the document does not have one.
     *
     * @param document the document for which to generate a value for the _id.
     */
    void generateIdIfAbsentFromDocument(T document);

    /**
     * Returns true if the given document has an _id.
     *
     * @param document the document in which to look for an _id
     * @return true if the document has an _id
     */
    boolean documentHasId(T document);

    /**
     * Gets the _id of the given document.
     *
     * @param document the document from which to get the _id
     * @return the _id of the document, or null if it does not have one
     */
    Object getDocumentId(T document);
}
