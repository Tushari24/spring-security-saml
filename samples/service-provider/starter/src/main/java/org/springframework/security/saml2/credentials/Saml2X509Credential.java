/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.springframework.security.saml2.credentials;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.springframework.util.Assert.notEmpty;
import static org.springframework.util.Assert.notNull;

/**
 * Saml2X509Credential is meant to hold an X509 certificate, or an X509 certificate and a
 * private key. Per:
 * https://www.oasis-open.org/committees/download.php/8958/sstc-saml-implementation-guidelines-draft-01.pdf
 * Line: 584, Section 4.3 Credentials Used for both signing and encryption/decryption
 */
public class Saml2X509Credential {
	public enum Saml2X509CredentialUsage {
		VERIFICATION,
		ENCRYPTION,
		SIGNING,
		DECRYPTION,
	}

	private final PrivateKey privateKey;
	private final X509Certificate certificate;
	private final Set<Saml2X509CredentialUsage> saml2X509CredentialUsage;

	public Saml2X509Credential(PrivateKey privateKey,
							   X509Certificate certificate,
							   Saml2X509CredentialUsage... usages) {
		notNull(certificate, "certificate is always required");
		notEmpty(usages, "credentials usages cannot be empty");
		this.privateKey = privateKey;
		this.certificate = certificate;
		this.saml2X509CredentialUsage = new LinkedHashSet<>(asList(usages));
		if (isSigningCredential() || isDecryptionCredential()) {
			notNull(privateKey, "private key is required for signing and decryption credentials");
		}
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public X509Certificate getCertificate() {
		return certificate;
	}

	public Set<Saml2X509CredentialUsage> getSaml2X509CredentialUsages() {
		return saml2X509CredentialUsage;
	}

	public boolean isSigningCredential() {
		return getSaml2X509CredentialUsages().contains(Saml2X509CredentialUsage.SIGNING);
	}

	public boolean isSignatureVerficationCredential() {
		return getSaml2X509CredentialUsages().contains(Saml2X509CredentialUsage.VERIFICATION);
	}

	public boolean isEncryptionCredential() {
		return getSaml2X509CredentialUsages().contains(Saml2X509CredentialUsage.ENCRYPTION);
	}

	public boolean isDecryptionCredential() {
		return getSaml2X509CredentialUsages().contains(Saml2X509CredentialUsage.DECRYPTION);
	}
}
