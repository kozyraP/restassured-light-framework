package org.example.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:CredentialConfiguration.properties"})
public interface CredentialConfiguration extends Config {

    String clientId();

    String clientSecret();

}
