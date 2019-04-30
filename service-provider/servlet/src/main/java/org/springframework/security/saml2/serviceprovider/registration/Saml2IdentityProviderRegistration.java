/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.springframework.security.saml2.serviceprovider.registration;

import java.util.List;

import org.springframework.security.saml2.util.Saml2KeyData;

/**
 * Configuration object that represents an external identity provider
 */
public class Saml2IdentityProviderRegistration {

	private String alias;
	private String linktext;
	private String entityId;
	private List<Saml2KeyData> verificationKeys;

	public Saml2IdentityProviderRegistration() {
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getLinktext() {
		return linktext;
	}

	public void setLinktext(String linktext) {
		this.linktext = linktext;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public List<Saml2KeyData> getVerificationKeys() {
		return verificationKeys;
	}

	public void setVerificationKeys(List<Saml2KeyData> verificationKeys) {
		this.verificationKeys = verificationKeys;
	}
}