package net.derstefon.gitpress.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="gitpress")
public class Config {

    private String relevantBranch;
	private String contentBaseUrl;
	private String repository;

	public String getRelevantBranch() {
		return relevantBranch;
	}

	public void setRelevantBranch(String relevantBranch) {
		this.relevantBranch = relevantBranch;
	}

	public String getContentBaseUrl() {
		return contentBaseUrl;
	}

	public void setContentBaseUrl(String contentBaseUrl) {
		this.contentBaseUrl = contentBaseUrl;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}
}