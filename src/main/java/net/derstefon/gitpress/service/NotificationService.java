package net.derstefon.gitpress.service;

import net.derstefon.gitpress.common.Config;
import net.derstefon.gitpress.github.PushNotification;
import net.derstefon.gitpress.service.util.MDFileCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.StringJoiner;

/**
 * Responsible for collecting the list of modified or added *.md files for a collection of commits
 */
@Service
public class NotificationService {

    private final static Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private Config config;

    @Autowired
    private MDFileCollector mdFileCollector;

    public void update(PushNotification pushNotification) {
        if (!pushNotification.getRef().equals(config.getRelevantBranch())) {
            LOGGER.debug("Do nothing because given branch {} is not the relevant {} one", pushNotification.getRef(),
                    config.getRelevantBranch());
            return;
        }
        LOGGER.debug("Branch matches the relevant {} one. Further work necessary", config.getRelevantBranch());
        Collection<String> touchedFiles = mdFileCollector.collect(pushNotification.getCommits());
        LOGGER.debug("Following files need to be updated in wordpress: {}", String.join(",", touchedFiles));
    }

}
