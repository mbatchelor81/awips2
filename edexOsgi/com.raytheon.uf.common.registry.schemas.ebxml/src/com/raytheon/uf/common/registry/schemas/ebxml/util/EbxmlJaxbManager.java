/**
 * This software was developed and / or modified by Raytheon Company,
 * pursuant to Contract DG133W-05-CQ-1067 with the US Government.
 *
 * U.S. EXPORT CONTROLLED TECHNICAL DATA
 * This software product contains export-restricted data whose
 * export/transfer/disclosure is restricted by U.S. law. Dissemination
 * to non-U.S. persons whether in the United States or abroad requires
 * an export license or other authorization.
 *
 * Contractor Name:        Raytheon Company
 * Contractor Address:     6825 Pine Street, Suite 340
 *                         Mail Stop B8
 *                         Omaha, NE 68106
 *                         402.291.0100
 *
 * See the AWIPS II Master Rights File ("Master Rights File.pdf") for
 * further licensing information.
 **/
package com.raytheon.uf.common.registry.schemas.ebxml.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRegistry;

import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import com.raytheon.uf.common.serialization.JAXBManager;
import com.raytheon.uf.common.serialization.jaxb.PooledJaxbMarshallerStrategy;
<<<<<<< HEAD
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.status.UFStatus.Priority;
=======
import com.raytheon.uf.common.status.IPerformanceStatusHandler;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.PerformanceStatus;
import com.raytheon.uf.common.status.UFStatus;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.util.ReflectionUtil;

/**
 * A JAXB Manager for transforming EBXML objects to/from XML.
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
<<<<<<< HEAD
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Nov 12, 2013  ----      njensen     Initial release.
 * Nov 24, 2013  2584      dhladky     versioning
 * Jul 15, 2014  3373      bclement    pooling jaxb manager
 * Nov 09, 2017  6511      tgurney     Do not validate on unmarshal
=======
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- -----------------------------------
 * Nov 12, 2013           njensen   Initial release.
 * Nov 24, 2013  2584     dhladky   versioning
 * Jul 15, 2014  3373     bclement  pooling jaxb manager
 * Nov 09, 2017  6511     tgurney   Do not validate on unmarshal
 * Dec 16, 2021  8341     randerso  Changed to use performance logging
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * </pre>
 *
 * @author njensen
 */

public class EbxmlJaxbManager {

    /** The logger */
<<<<<<< HEAD
    private static final transient IUFStatusHandler statusHandler = UFStatus
            .getHandler(EbxmlJaxbManager.class);

=======
    private static final IUFStatusHandler statusHandler = UFStatus
            .getHandler(EbxmlJaxbManager.class);

    private static final IPerformanceStatusHandler perfLog = PerformanceStatus
            .getHandler("EbxmlJaxbManager");

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    private JAXBManager jaxb;

    private Set<Class<?>> jaxables;

    private Map<String, Class<?>> convertables = new HashMap<>(1);

    private Map<String, String> versions = new HashMap<>(1);

    private static EbxmlJaxbManager instance;

    /**
<<<<<<< HEAD
     * Get the desired version of the EbxmlJaxbManager
     *
     * @param version
     * @return
=======
     * Get the singleton EbxmlJaxbManager instance
     *
     * @return the EbxmlJaxbManager
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public static synchronized EbxmlJaxbManager getInstance() {
        if (instance == null) {
            instance = new EbxmlJaxbManager();
        }
        return instance;
    }

<<<<<<< HEAD
    public String findJaxables(String packageName) {

        statusHandler.info(" Scanning package ... " + packageName);
=======
    /**
     *
     * Locate XML annotated classes in the specified package
     *
     * @param packageName
     * @return the packageName
     */
    public String findJaxables(String packageName) {

        perfLog.log(String.format("Scanning package [%s]...", packageName));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        long t0 = System.currentTimeMillis();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.addUrls(ClasspathHelper.forPackage(packageName));
        cb.setScanners(new TypeAnnotationsScanner());
<<<<<<< HEAD
        // the call to build() will do the actual scanning so the separate
        // calls to getTypesAnnotatedWith(class, false) will not slow it down

=======

        /*
         * the call to build() will do the actual scanning so the separate calls
         * to getTypesAnnotatedWith(class, false) will not slow it down
         */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        Reflections reflecs = cb.build();
        Set<Class<?>> set = reflecs.getTypesAnnotatedWith(XmlAccessorType.class,
                false);
        synchronized (jaxables) {
<<<<<<< HEAD
            // add them to set for auditing purposes initially
            set.addAll(reflecs.getTypesAnnotatedWith(XmlRegistry.class, false));
            // copy set to jaxables
            jaxables.addAll(set);
        }
        long t1 = System.currentTimeMillis();
        statusHandler.info("Found " + set.size() + " classes for ebxml in "
                + (t1 - t0) + " ms");
        // if jaxb has already been initialized, reset it so that it will be
        // recreated with the latest set of jaxable classes.
=======
            /* add them to set for auditing purposes initially */
            set.addAll(reflecs.getTypesAnnotatedWith(XmlRegistry.class, false));
            /* copy set to jaxables */
            jaxables.addAll(set);
        }
        long t1 = System.currentTimeMillis();
        perfLog.logDuration(String.format(
                "Finding [%d] XML annotated classes in package [%s] for ebxml",
                set.size(), packageName), (t1 - t0));

        /*
         * if jaxb has already been initialized, reset it so that it will be
         * recreated with the latest set of jaxable classes.
         */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        synchronized (this) {
            jaxb = null;
        }

        return packageName;
    }

<<<<<<< HEAD
=======
    /**
     *
     * @return the JAXBManager for the ebxml classes
     * @throws JAXBException
     */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public synchronized JAXBManager getJaxbManager() throws JAXBException {
        if (jaxb == null) {
            jaxb = new JAXBManager(new PooledJaxbMarshallerStrategy(false),
                    jaxables.toArray(new Class[0]));
        }
        return jaxb;
    }

    private EbxmlJaxbManager() {
        jaxables = new HashSet<>();

<<<<<<< HEAD
        // add the default jaxables
=======
        /* add the default jaxables */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        jaxables.add(
                oasis.names.tc.ebxml.regrep.xsd.lcm.v4.ObjectFactory.class);
        jaxables.add(
                oasis.names.tc.ebxml.regrep.xsd.query.v4.ObjectFactory.class);
        jaxables.add(
                oasis.names.tc.ebxml.regrep.xsd.rim.v4.ObjectFactory.class);
        jaxables.add(oasis.names.tc.ebxml.regrep.xsd.rs.v4.ObjectFactory.class);
        jaxables.add(
                oasis.names.tc.ebxml.regrep.xsd.spi.v4.ObjectFactory.class);

<<<<<<< HEAD
        statusHandler.info("Initialization Complete.");
    }

    /**
     * Gets the set of classes for this encoder.
     *
     * @return
     */
    public Set<Class<?>> getJaxables() {
        return jaxables;
=======
        perfLog.log("Initialization Complete.");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets the class from the convertables
     *
     * @param className
<<<<<<< HEAD
     * @return
=======
     * @return the class
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public Class<?> getClass(String className) {

        Class<?> clazz = convertables.get(className);

        if (clazz == null) {

            for (Class<?> pclazz : jaxables) {
                if (pclazz.getCanonicalName().equals(className)) {
                    clazz = pclazz;
                    addClass(className, clazz);
                    break;
                }
            }
<<<<<<< HEAD
            // Didn't find it, now we have a possible problem.
            // Try reflecting a version of it.
            if (clazz == null) {
                statusHandler.handle(Priority.WARN,
                        "Didn't find class in list of jaxables! class: "
=======
            /*
             * Didn't find it, now we have a possible problem. Try reflecting a
             * version of it.
             */
            if (clazz == null) {
                statusHandler
                        .warn("Didn't find class in list of jaxables! class: "
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                                + className);
                try {
                    clazz = ReflectionUtil.forName(className);
                    addClass(className, clazz);
                } catch (Exception e) {
<<<<<<< HEAD
                    statusHandler.handle(Priority.ERROR,
=======
                    statusHandler.error(
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                            "Can not reflect a version of this class. class: "
                                    + className,
                            e);
                }
            }
        }

        return clazz;
    }

    /**
     * Set the class to the cache
     *
     * @param className
     * @param clazz
     */
    private void addClass(String className, Class<?> clazz) {
        synchronized (convertables) {
            convertables.put(className, clazz);
        }
    }

    /**
     * Set the version to the cache
     *
     * @param className
<<<<<<< HEAD
     * @param clazz
=======
     * @param version
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void addVersion(String className, String version) {
        synchronized (versions) {
            versions.put(className, version);
        }
    }

    /**
     * Get the version of the class
     *
     * @param className
     * @return version
     */
    public String getVersion(String className) {
        return versions.get(className);
    }

}