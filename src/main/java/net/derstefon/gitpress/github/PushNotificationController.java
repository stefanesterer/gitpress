package net.derstefon.gitpress.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.derstefon.gitpress.common.Config;

@Controller
public class PushNotificationController {

	
	@Autowired
	private Config config;
	
	@RequestMapping(value = "/notification", method = RequestMethod.POST)
	public ResponseEntity<Boolean> update(@RequestBody PushNotification pushNotification) {
		System.out.println(pushNotification);
		System.out.println(config.getRelevantBranch());
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);

	}

}
