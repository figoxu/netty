/*
 * Copyright 2012 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;

/**
 * The default {@link SpdyHeadersFrame} implementation.
 */
public class DefaultSpdyHeadersFrame extends DefaultSpdyHeaderBlock
        implements SpdyHeadersFrame {

    private int streamID;

    /**
     * Creates a new instance.
     *
     * @param streamID the Stream-ID of this frame
     */
    public DefaultSpdyHeadersFrame(int streamID) {
        super();
        setStreamID(streamID);
    }

    public int getStreamID() {
        return streamID;
    }

    public void setStreamID(int streamID) {
        if (streamID <= 0) {
            throw new IllegalArgumentException(
                    "Stream-ID must be positive: " + streamID);
        }
        this.streamID = streamID;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(getClass().getSimpleName());
        buf.append(StringUtil.NEWLINE);
        buf.append("--> Stream-ID = ");
        buf.append(streamID);
        buf.append(StringUtil.NEWLINE);
        buf.append("--> Headers:");
        buf.append(StringUtil.NEWLINE);
        appendHeaders(buf);

        // Remove the last newline.
        buf.setLength(buf.length() - StringUtil.NEWLINE.length());
        return buf.toString();
    }
}
