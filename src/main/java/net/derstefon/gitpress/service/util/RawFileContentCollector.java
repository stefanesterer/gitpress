package net.derstefon.gitpress.service.util;

import net.derstefon.gitpress.common.Config;
import net.derstefon.gitpress.service.dto.BlogContent;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Responsible for getting the raw data from a list of given files
 */
@Component
public class RawFileContentCollector {

    private final static Logger LOGGER = LoggerFactory.getLogger(RawFileContentCollector.class);

    @Autowired
    private Config config;

    public Collection<BlogContent> collectRawContent(Collection<String> touchedFiles) {

        String baseUrl = config.getContentBaseUrl() + "/" + config.getRepository() + "/" + config.getRelevantBranch();

        Collection<BlogContent> contents = touchedFiles.stream()
                .map(fileName -> {
                    try (InputStream in = new URL(baseUrl + "/" + fileName).openStream()) {

                        try {
                            String content =  IOUtils.toString(in, Charset.forName("UTF-8"));
                            return new BlogContent(fileName, content);
                        } finally {
                            IOUtils.closeQuietly(in);
                        }
                    } catch (Exception e) {
                        LOGGER.error("Error during getting raw github data", e);
                        return null;
                    }
                }).collect(Collectors.toList());

        return contents;

    }
}
