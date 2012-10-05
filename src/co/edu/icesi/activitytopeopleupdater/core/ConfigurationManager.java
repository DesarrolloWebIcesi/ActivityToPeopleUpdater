/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.OptionConverter;

/**
 * This class is in charge of loading all application configuration files and
 * provide access they properties (Adapted from Dspace 1.7.2
 * ConfigurationManager class).
 *
 * @author David Andrés Manzano Herrera - damanzano
 */
public class ConfigurationManager {

    private static Logger log = Logger.getLogger(ConfigurationManager.class);
    /**
     * The configuration properties
     */
    private static Properties properties = null;
    private static File loadedFile = null;
    // limit of recursive depth of property variable interpolation in
    // configuration; anything greater than this is very likely to be a loop.
    private static final int RECURSION_LIMIT = 9;

    /** 
     * Verify if the log4j library is configured.
     * NOTE: Only current solution available to detect if log4j is truly
     * configured.
     * 
     * @return  <code>true</code> if log4j is configured
     *          <code>false</code> otherwise.
     */
    private static boolean isLog4jConfigured() {
        Enumeration<?> en = org.apache.log4j.LogManager.getRootLogger().getAllAppenders();

        if (!(en instanceof org.apache.log4j.helpers.NullEnumeration)) {
            return true;
        } else {
            Enumeration<?> cats = Category.getCurrentCategories();
            while (cats.hasMoreElements()) {
                Category c = (Category) cats.nextElement();
                if (!(c.getAllAppenders() instanceof org.apache.log4j.helpers.NullEnumeration)) {
                    return true;
                }
            }
        }
        return false;
    }

    /** 
     * Print an info log statement 
     * 
     * @param string The log message
     */
    private static void info(String string) {
        if (!isLog4jConfigured()) {
            System.out.println("INFO: " + string);
        } else {
            log.info(string);
        }
    }
    
    /** 
     * Print a fatal log statement
     * 
     * @param string The log message
     * @param e The thrown exceotion
     */
    private static void fatal(String string, Exception e) {
        if (!isLog4jConfigured()) {
            System.out.println("FATAL: " + string);
            e.printStackTrace();
        } else {
            log.fatal(string, e);
        }
    }

    /** 
     * Print a fatal log statement
     * 
     * @param string The log message
     */
    private static void fatal(String string) {
        if (!isLog4jConfigured()) {
            System.out.println("FATAL: " + string);
        } else {
            log.fatal(string);
        }
    }

    /**
     * Returns all properties in main configuration
     *
     * @return properties - all non-modular properties
     */
    public static Properties getProperties() {
        Properties props = getMutableProperties();
        return props == null ? null : (Properties) props.clone();
    }

    private static Properties getMutableProperties() {
        if (properties == null) {
            loadConfig(null);
        }

        return properties;
    }

    /**
     * Get a configuration property
     *
     * @param property the name of the property
     *
     * @return the value of the property, or
     * <code>null</code> if the property does not exist.
     */
    public static String getProperty(String property) {
        Properties props = getMutableProperties();
        String value = props == null ? null : props.getProperty(property);
        return (value != null) ? value.trim() : null;
    }

    /**
     * Load the ActivityInsight configuration properties file. Only does
     * anything if properties are not already loaded. Properties are loaded in
     * from the specified file, or default locations.
     *
     * @param configFile The
     * <code>dspace.cfg</code> configuration file to use, or
     * <code>null</code> to try default locations
     */
    public static synchronized void loadConfig(String configFile) {
        if (properties != null) {
            return;
        }

        URL url = null;
        InputStream is = null;

        try {
            if (loadedFile != null) {
                info("Reloading current config file: " + loadedFile.getAbsolutePath());

                url = loadedFile.toURI().toURL();
            } else {
                //url = ConfigurationManager.class.getResource("config/activitytopeople.properties");
                loadedFile = new File("config/activitytopeople.properties");
                url = loadedFile.toURI().toURL();
                if (url != null) {
                    info("Loading from classloader: " + url);
                    loadedFile = new File(url.getPath());
                }
            }

            if (url == null) {
                fatal("Cannot find activitywebservices.properties");
                throw new IllegalStateException("Cannot find activitywebservices.properties");
            } else {
                properties = new Properties();

                is = url.openStream();
                properties.load(is);

                // walk values, interpolating any embedded references.
                for (Enumeration<?> pe = properties.propertyNames(); pe.hasMoreElements();) {
                    String key = (String) pe.nextElement();
                    String value = interpolate(key, properties.getProperty(key), 1);
                    if (value != null) {
                        properties.setProperty(key, value);
                    }
                }
            }

        } catch (IOException e) {
            fatal("Can't load configuration: " + url, e);

            // FIXME: Maybe something more graceful here, but with the
            // configuration we can't do anything
            throw new IllegalStateException("Cannot load configuration: " + url, e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ioe) {
                }
            }
        }

        try {
            /*
             * Initialize Logging once ConfigurationManager is initialized.
             *
             * This is selection from a property in activitytopeople.cfg, if the
             * property is absent then nothing will be configured and the
             * application will use the defaults provided by log4j.
             *
             * Property format is:
             *
             * log.init.config = log4j.properties or log.init.config = log4j.xml
             *
             * See default log4j initialization documentation here:
             * http://logging.apache.org/log4j/docs/manual.html
             *
             * If there is a problem with the file referred to in
             * "log.configuration" it needs to be sent to System.err so do not
             * instantiate another Logging configuration.
             *
             */
            String logConfiguration = ConfigurationManager.getProperty("log.init.config");

            if (logConfiguration == null) {
                /*
                 * Do nothing if log config not set. Leave it upto log4j to
                 * properly init its logging via classpath or system properties.
                 */
                info("Using default log4j provided log configuration,"
                        + "if unintended, check your activitytopeople.properties for (log.init.config)");
            } else {
                info("Using application provided log configuration (log.init.config)");


                File logConfigFile = new File(logConfiguration);

                if (logConfigFile.exists()) {
                    info("Loading: " + logConfiguration);

                    OptionConverter.selectAndConfigure(logConfigFile.toURI().toURL(), null, org.apache.log4j.LogManager.getLoggerRepository());
                } else {
                    info("File does not exist: " + logConfiguration);
                }
            }

        } catch (MalformedURLException e) {
            fatal("Can't load provided log4j configuration", e);
            throw new IllegalStateException("Cannot load provided log4j configuration", e);
        }

    }

    /**
     * Recursively interpolate variable references in value of property named
     * "key".
     *
     * @return new value if it contains interpolations, or null if it had no
     * variable references.
     */
    private static String interpolate(String key, String value, int level) {
        if (level > RECURSION_LIMIT) {
            throw new IllegalArgumentException("ConfigurationManager: Too many levels of recursion in configuration property variable interpolation, property=" + key);
        }
        //String value = (String)properties.get(key);
        int from = 0;
        StringBuffer result = null;
        while (from < value.length()) {
            int start = value.indexOf("${", from);
            if (start >= 0) {
                int end = value.indexOf('}', start);
                if (end < 0) {
                    break;
                }
                String var = value.substring(start + 2, end);
                if (result == null) {
                    result = new StringBuffer(value.substring(from, start));
                } else {
                    result.append(value.substring(from, start));
                }
                if (properties.containsKey(var)) {
                    String ivalue = interpolate(var, properties.getProperty(var), level + 1);
                    if (ivalue != null) {
                        result.append(ivalue);
                        properties.setProperty(var, ivalue);
                    } else {
                        result.append((String) properties.getProperty(var));
                    }
                } else {
                    log.warn("Interpolation failed in value of property \"" + key
                            + "\", there is no property named \"" + var + "\"");
                }
                from = end + 1;
            } else {
                break;
            }
        }
        if (result != null && from < value.length()) {
            result.append(value.substring(from));
        }
        return (result == null) ? null : result.toString();
    }
    
    /** 
     * Return a Map object with the necesary properties to configure persistence.xml
     * 
     * @return Map object with the necesary database properties
     */
    public static Map getDatabaseProperties(){
        Map databaseProperties = new HashMap();
        databaseProperties.put("javax.persistence.jdbc.driver", getProperty("db.driver"));
        databaseProperties.put("javax.persistence.jdbc.url", getProperty("db.url"));
        databaseProperties.put("javax.persistence.jdbc.user", getProperty("db.user"));
        databaseProperties.put("javax.persistence.jdbc.password", getProperty("db.password"));
        return databaseProperties;
    }
}
