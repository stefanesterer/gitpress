package net.derstefon.gitpress.service;

import net.derstefon.gitpress.common.Config;
import net.derstefon.gitpress.github.PushNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NotificationService {

    private final static Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private Config config;

    public Collection<String> update(PushNotification pushNotification) {
        if (!pushNotification.getRef().equals(config.getRelevantBranch())) {
            return Collections.EMPTY_LIST;
        }

        return pushNotification.getCommits().stream()
                .map(c -> Stream.concat(c.getModified().stream(), c.getAdded().stream()))
                .map(s -> s.collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .filter(s -> s.endsWith(".md"))
                .collect(Collectors.toList());


    }

}
