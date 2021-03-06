/*
 * Copyright 2012 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugin.springsecurity.oauth

import org.scribe.model.Token

/**
 * OAuth authentication token for Google users. It's a standard {@link OAuthToken}
 * that returns the Google email address as the principal.
 *
 * @author <a href='mailto:cazacugmihai@gmail.com'>Mihai Cazacu</a>
 * @author Thierry Nicola
 * @author <a href='mailto:donbeave@gmail.com'>Alexey Zhokhov</a>
 */
class GoogleOAuthToken extends OAuthToken {

    public static final String PROVIDER_NAME = 'google'

    String email
    Map response

    GoogleOAuthToken(Token scribeToken, email, response) {
        super(scribeToken)
        this.email = email
        this.principal = email
        this.response = response
    }

    String getSocialId() {
        email
    }

    String getScreenName() {
        email
    }

    String getRefreshToken() {
        accessToken.secret
    }
    
    Date getExpiry() {
        accessToken.expiry
    }

    String getProviderName() {
        PROVIDER_NAME
    }

}
