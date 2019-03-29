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
package org.springframework.security.saml2.model.signature;

import org.springframework.security.saml2.model.key.Saml2KeyData;

public class Saml2Signature {

	private Saml2CanonicalizationMethod canonicalizationAlgorithm;
	private Saml2AlgorithmMethod signatureAlgorithm;
	private Saml2DigestMethod digestAlgorithm;
	private String digestValue;
	private String signatureValue;
	private boolean validated = false;
	private Saml2KeyData validatingKey;

	public Saml2CanonicalizationMethod getCanonicalizationAlgorithm() {
		return canonicalizationAlgorithm;
	}

	public Saml2Signature setCanonicalizationAlgorithm(Saml2CanonicalizationMethod canonicalizationAlgorithm) {
		this.canonicalizationAlgorithm = canonicalizationAlgorithm;
		return this;
	}

	public Saml2AlgorithmMethod getSignatureAlgorithm() {
		return signatureAlgorithm;
	}

	public Saml2Signature setSignatureAlgorithm(Saml2AlgorithmMethod signatureAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
		return this;
	}

	public Saml2DigestMethod getDigestAlgorithm() {
		return digestAlgorithm;
	}

	public Saml2Signature setDigestAlgorithm(Saml2DigestMethod digestAlgorithm) {
		this.digestAlgorithm = digestAlgorithm;
		return this;
	}

	public String getDigestValue() {
		return digestValue;
	}

	public Saml2Signature setDigestValue(String digestValue) {
		this.digestValue = digestValue;
		return this;
	}

	public String getSignatureValue() {
		return signatureValue;
	}

	public Saml2Signature setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
		return this;
	}

	public boolean isValidated() {
		return validated;
	}

	public Saml2Signature setValidated(boolean b) {
		this.validated = b;
		return this;
	}

	public Saml2KeyData getValidatingKey() {
		return validatingKey;
	}

	public Saml2Signature setValidatingKey(Saml2KeyData validatingKey) {
		this.validatingKey = validatingKey;
		return this;
	}
}