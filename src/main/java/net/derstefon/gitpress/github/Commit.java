package net.derstefon.gitpress.github;

import java.util.ArrayList;
import java.util.Collection;

public class Commit {

	private Collection<String> modified = new ArrayList<>();
	private Collection<String> added = new ArrayList<>();

	public Collection<String> getModified() {
		return modified;
	}

	public Collection<String> getAdded() {
		return added;
	}

}
