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

package org.springframework.security.saml2.spi;

import java.time.Clock;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.datatype.Duration;

import org.springframework.security.saml2.util.Saml2KeyData;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Static utility class that serves as the delimiter between Spring Security SAML and underlying implementation.
 *
 * @param <T> generic type for subclass in order to have a working builder pattern for subclasses
 */
abstract class Saml2JavaAbstraction<T extends Saml2JavaAbstraction> {

	private final AtomicBoolean hasInitCompleted = new AtomicBoolean(false);
	private Clock time;

	public Saml2JavaAbstraction(Clock time) {
		this.time = time;
	}

	public Clock getTime() {
		return time;
	}


	@SuppressWarnings("checked")
	public T init() {
		if (!hasInitCompleted.get()) {
			performInit();
		}
		return (T) this;
	}

	private synchronized void performInit() {
		if (hasInitCompleted.compareAndSet(false, true)) {
			java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			bootstrap();
		}
	}

	protected abstract void bootstrap();

	protected abstract Duration toDuration(long millis);

	public final Object resolve(String xml, List<Saml2KeyData> localKeys) {
		return resolve(xml.getBytes(UTF_8), localKeys);
	}

	protected abstract Object resolve(byte[] xml, List<Saml2KeyData> localKeys);

	public String encode(byte[] b) {
		return Saml2EncodingUtils.encode(b);
	}

	public byte[] decode(String s) {
		return Saml2EncodingUtils.decode(s);
	}

	public byte[] deflate(String s) {
		return Saml2EncodingUtils.deflate(s);
	}

	public String inflate(byte[] b) {
		return Saml2EncodingUtils.inflate(b);
	}

}