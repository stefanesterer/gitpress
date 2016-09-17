package net.derstefon.gitpress.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="gitpress")
public class Config {

    private String relevantBranch;

	public String getRelevantBranch() {
		return relevantBranch;
	}

	public void setRelevantBranch(String relevantBranch) {
		this.relevantBranch = relevantBranch;
	}
}