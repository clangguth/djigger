/*******************************************************************************
 * (C) Copyright  2016 J�r�me Comte and others.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Contributors:
 *    - J�r�me Comte
 *******************************************************************************/
package org.smb.core;

public class SynchronMessageResponse extends SynchronMessage {

	private static final long serialVersionUID = 2966020065475654427L;
	
	private final Exception exception;

	public SynchronMessageResponse(String type, Object content, int correlationID, Exception exception) {
		super(type, content, correlationID);
		this.exception = exception;
	}

	public Exception getException() {
		return exception;
	}
}
