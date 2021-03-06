/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.storm.hdfs.trident.format;

import java.io.Serializable;
import org.apache.hadoop.io.Writable;
import org.apache.storm.trident.tuple.TridentTuple;

/**
 * Interface for converting <code>TridentTuple</code> objects to HDFS sequence file key-value pairs.
 */
public interface SequenceFormat extends Serializable {
    /**
     * Key class used by implementation (e.g. IntWritable.class, etc.).
     */
    Class keyClass();

    /**
     * Value class used by implementation (e.g. Text.class, etc.).
     */
    Class valueClass();

    /**
     * Given a tuple, return the key that should be written to the sequence file.
     */
    Writable key(TridentTuple tuple);

    /**
     * Given a tuple, return the value that should be written to the sequence file.
     */
    Writable value(TridentTuple tuple);
}
