package net.derstefon.gitpress.github;

import java.util.ArrayList;
import java.util.Collection;

public class PushNotification {

	private String ref;
	private Collection<Commit> commits = new ArrayList<>();

	public String getRef() {
		return ref;
	}

	public String getBranch() {
		return ref.replaceAll("refs/heads/", "");
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Collection<Commit> getCommits() {
		return commits;
	}
	
	@Override
	public String toString() {
		return "PushNotification [ref=" + ref + "]";
	}

}
