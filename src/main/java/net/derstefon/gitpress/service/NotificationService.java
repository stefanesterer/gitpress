package net.derstefon.gitpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.derstefon.gitpress.common.Config;
import net.derstefon.gitpress.github.PushNotification;

@Service
public class NotificationService {

	@Autowired
	private Config config;
	
	public void update(PushNotification pushNotification){
		if(!pushNotification.getRef().equals(config.getRelevantBranch())){
			System.out.println("WRONG BRANCH");
		}
		else System.out.println("CORRECT BRANCH");
	}
	
}
