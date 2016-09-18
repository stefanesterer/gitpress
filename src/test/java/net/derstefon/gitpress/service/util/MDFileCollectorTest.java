package net.derstefon.gitpress.service.util;

import net.derstefon.gitpress.github.Commit;
import net.derstefon.gitpress.service.util.MDFileCollector;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

public class MDFileCollectorTest {

	private static final String RELEVANT_BRANCH = "relevantBranch";
	private static final String NOT_RELEVANT_BRANCH = "notRelevantBranch";
	
	private MDFileCollector service = new MDFileCollector();
	
	@BeforeMethod
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void update_withRelevantBranch(){
		Collection<Commit> commits = new ArrayList<>();

		Commit c1 = new Commit();
		c1.getModified().add("mod1.md");
		c1.getModified().add("mod1.txt");
		commits.add(c1);

		Commit c2 = new Commit();
		c2.getModified().add("mod2.md");
		c2.getModified().add("mod2.txt");
		commits.add(c2);

		Collection<String> modifiedFiles = service.collect(commits);

		assertEquals(modifiedFiles.size(), 2);
	}
	
}
