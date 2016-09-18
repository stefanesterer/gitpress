package net.derstefon.gitpress.service.util;

import net.derstefon.gitpress.common.Config;
import net.derstefon.gitpress.github.Commit;
import net.derstefon.gitpress.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Responsible for collecting the list of modified or added *.md files for a collection of commits
 */
@Component
public class MDFileCollector {

    private final static Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private Config config;

    public Collection<String> collect(Collection<Commit> commits) {
        return commits.stream()
                .map(c -> Stream.concat(c.getModified().stream(), c.getAdded().stream()))
                .map(s -> s.collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .filter(s -> s.endsWith(".md"))
                .collect(Collectors.toList());
    }

}
