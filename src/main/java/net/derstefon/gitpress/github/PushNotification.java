package net.derstefon.gitpress.github;

public class PushNotification {

	private String ref;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		return "PushNotification [ref=" + ref + "]";
	}
	
	
}
