package net.derstefon.gitpress.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.derstefon.gitpress.common.Config;
import net.derstefon.gitpress.github.PushNotification;

@Service
public class NotificationService {

	private final static Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);
	
	@Autowired
	private Config config;
	
	public void update(PushNotification pushNotification){
		if(!pushNotification.getRef().equals(config.getRelevantBranch())){
			LOGGER.debug("WRONG BRANCH");
		}
		else LOGGER.debug("CORRECT BRANCH");
	}
	
}
