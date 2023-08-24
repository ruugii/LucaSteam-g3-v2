package com.LucaSteam.controller.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * Custom implementation of error attributes for handling error responses.
 */
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {
    private static final Logger logger = LoggerFactory.getLogger(CustomErrorAttributes.class);

    private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    /**
     * Generates customized error attributes for the error response.
     *
     * @param webRequest The web request containing the error.
     * @param options    The options for customizing the error attributes.
     * @return A map of customized error attributes.
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest wr, ErrorAttributeOptions options) {
        logger.info("------ getErrorAttributes(): " + options);
        Map<String, Object> errorAttributes = super.getErrorAttributes(wr, options);
        logger.info("------ getErrorAttributes(): " + options);

        Object timestamp = errorAttributes.get("timestamp");
        if (timestamp == null) {
            errorAttributes.put("timestamp", df.format(new Date()));
        } else {
            errorAttributes.put("timestamp", df.format((Date) timestamp));
        }

        errorAttributes.remove("trace");

        errorAttributes.put("jdk", System.getProperty("java.version"));

        return errorAttributes;
    }
}
