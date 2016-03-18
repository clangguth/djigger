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

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = -8516543608547851386L;

	private final String type;

	private final Object content;

	public Message(String type, Object content) {
		super();
		this.type = type;
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public Object getContent() {
		return content;
	}

	public String getStringContent() {
		if(content instanceof String) {
			return (String)content;
		} else {
			return null;
		}
	}

	public Integer getIntegerContent() {
		if(content instanceof Integer) {
			return (Integer)content;
		} else {
			return null;
		}
	}
}
