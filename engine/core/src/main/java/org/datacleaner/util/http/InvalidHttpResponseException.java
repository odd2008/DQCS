/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.util.http;

import org.apache.http.HttpResponse;

/**
 * Represents an exception occurring because a HTTP response was invalid
 * (typically based on status code).
 * 表示由于HTTP响应无效（通常基于状态码）而发生的异常。
 */
public class InvalidHttpResponseException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final HttpResponse _response;
    private final String _url;

    public InvalidHttpResponseException(final String url, final HttpResponse response) {
        _response = response;
        _url = url;
    }

    @Override
    public String getMessage() {
        return "Invalid HTTP response status code: " + getStatusCode() + " (" + _url + ")";
    }

    public String getUrl() {
        return _url;
    }

    public HttpResponse getResponse() {
        return _response;
    }

    public int getStatusCode() {
        return _response.getStatusLine().getStatusCode();
    }
}
