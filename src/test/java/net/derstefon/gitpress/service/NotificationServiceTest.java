package net.derstefon.gitpress.service;

import net.derstefon.gitpress.github.Commit;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import net.derstefon.gitpress.common.Config;
import net.derstefon.gitpress.github.PushNotification;

public class NotificationServiceTest {

	private static final String RELEVANT_BRANCH = "relevantBranch";
	private static final String NOT_RELEVANT_BRANCH = "notRelevantBranch";
	
	private NotificationService service = new NotificationService();
	
	@Mock
	private PushNotification notification;
	@Mock
	private Config config;
	
	@BeforeMethod
	public void init(){
		MockitoAnnotations.initMocks(this);

		when(config.getRelevantBranch()).thenReturn(RELEVANT_BRANCH);
		ReflectionTestUtils.setField(service, "config", config);
	}
	
	@Test
	public void update_withIrrelevantranch(){
		when(notification.getRef()).thenReturn(NOT_RELEVANT_BRANCH);

		Collection<String> modifiedFiles = service.update(notification);

		assertEquals(modifiedFiles.size(), 0);
	}

	@Test
	public void update_withRelevantBranch(){
		ReflectionTestUtils.setField(service, "config", config);

		when(notification.getRef()).thenReturn(RELEVANT_BRANCH);
		Collection<Commit> commits = new ArrayList<>();

		Commit c1 = new Commit();
		c1.getModified().add("mod1.md");
		c1.getModified().add("mod1.txt");
		commits.add(c1);

		Commit c2 = new Commit();
		c2.getModified().add("mod2.md");
		c2.getModified().add("mod2.txt");
		commits.add(c2);

		when(notification.getCommits()).thenReturn(commits);

		Collection<String> modifiedFiles = service.update(notification);

		assertEquals(modifiedFiles.size(), 2);
	}
	
}
