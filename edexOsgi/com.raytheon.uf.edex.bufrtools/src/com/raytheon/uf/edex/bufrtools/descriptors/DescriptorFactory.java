/**
 * This software was developed and / or modified by Raytheon Company,
 * pursuant to Contract DG133W-05-CQ-1067 with the US Government.
<<<<<<< HEAD
 * 
=======
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * U.S. EXPORT CONTROLLED TECHNICAL DATA
 * This software product contains export-restricted data whose
 * export/transfer/disclosure is restricted by U.S. law. Dissemination
 * to non-U.S. persons whether in the United States or abroad requires
 * an export license or other authorization.
<<<<<<< HEAD
 * 
=======
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * Contractor Name:        Raytheon Company
 * Contractor Address:     6825 Pine Street, Suite 340
 *                         Mail Stop B8
 *                         Omaha, NE 68106
 *                         402.291.0100
<<<<<<< HEAD
 * 
=======
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * See the AWIPS II Master Rights File ("Master Rights File.pdf") for
 * further licensing information.
 **/
package com.raytheon.uf.edex.bufrtools.descriptors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
<<<<<<< HEAD
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * 20071127            382 jkorman     Initial Coding.
 * 20080214            862 jkorman     BUFRMOS implementation changes.
 * 9/16/2014    #3628      mapeters    Moved from uf.edex.decodertools plugin.
 * 12/14/2015   5166       kbisanz     Update logging to use SLF4J
 * </pre>
 * 
=======
 *
 * SOFTWARE HISTORY
 *
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * 20071127     382        jkorman     Initial Coding.
 * 20080214     862        jkorman     BUFRMOS implementation changes.
 * 9/16/2014    #3628      mapeters    Moved from uf.edex.decodertools plugin.
 * 12/14/2015   5166       kbisanz     Update logging to use SLF4J
 * Mar 21, 2022 102643     tjensen     Update Table_D configuration file
 *
 * </pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * @author jkorman
 * @version 1.0
 */
public class DescriptorFactory {

<<<<<<< HEAD
    private Logger logger = LoggerFactory.getLogger(getClass());
=======
    private final Logger logger = LoggerFactory.getLogger(getClass());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private static Pattern DESC_PATTERN = Pattern
            .compile("[0-3] \\d{2} \\d{3}");

    private static final String DEFAULT_TABLE_B = "/res/bufrtables/BUFR_Table_B.txt";

<<<<<<< HEAD
    private static final String DEFAULT_TABLE_D = "/res/bufrtables/BUFR_Table_D_1.txt";

    // private static DescriptorFactory factoryInstance = null;

    private HashMap<Integer, BUFRTableB> tableBEntries = new HashMap<Integer, BUFRTableB>();
=======
    private static final String DEFAULT_TABLE_D = "/res/bufrtables/BUFR_Table_D.txt";

    // private static DescriptorFactory factoryInstance = null;

    private final HashMap<Integer, BUFRTableB> tableBEntries = new HashMap<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private HashMap<Integer, BUFRTableD> tableDEntries = null;

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param resourceClassReference
     */
    public DescriptorFactory() {
        this(DescriptorFactory.class, null, null);
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param resourceClassReference
     * @param tableB
     * @param tableD
     */
    public DescriptorFactory(Class<?> resourceClassReference, String tableB,
            String tableD) {
        logger.info("Loading tableB " + tableB);
        populateTableB(resourceClassReference, tableB);
        logger.info("Loading tableD " + tableD);
        populateTableD(resourceClassReference, tableD);
    }

    /**
<<<<<<< HEAD
     * 
     * @param resourceClassReference
     * @param tableB
     */
    private void populateTableB(Class<?> resourceClassReference, String tableB) {
=======
     *
     * @param resourceClassReference
     * @param tableB
     */
    private void populateTableB(Class<?> resourceClassReference,
            String tableB) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        InputStream strm = null;

        BufferedReader bf = null;
        try {
            strm = this.getClass().getResourceAsStream(DEFAULT_TABLE_B);
            int count = 0;
            if (strm != null) {
                bf = new BufferedReader(new InputStreamReader(strm));

                String line = null;
                while ((line = bf.readLine()) != null) {

                    BUFRTableB entry = BUFRTableB.createEntry(line);
                    if (entry != null) {
                        count++;
                        logger.debug("Source = " + tableB + " " + entry);
                        tableBEntries.put(entry.getDescriptor(), entry);
                    }
                }
            }
            logger.debug(count + " entries entered from " + DEFAULT_TABLE_B);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }

        if (tableB != null) {
            tableB = "/res/bufrtables/" + tableB;
            bf = null;
            try {
                strm = resourceClassReference.getResourceAsStream(tableB);
                int count = 0;
                if (strm != null) {
                    bf = new BufferedReader(new InputStreamReader(strm));

                    String line = null;
                    while ((line = bf.readLine()) != null) {

                        BUFRTableB entry = BUFRTableB.createEntry(line);
                        if (entry != null) {
                            count++;
                            logger.debug("Source = " + tableB + " " + entry);
                            tableBEntries.put(entry.getDescriptor(), entry);
                        }
                    }
                } else {
                    logger.error("Could not get stream to " + tableB);
                }
                logger.debug(count + " entries entered from " + tableB);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                if (bf != null) {
                    try {
                        bf.close();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
        }
    }

    /**
<<<<<<< HEAD
     * 
     * @param resourceClassReference
     * @param tableD
     */
    private void populateTableD(Class<?> resourceClassReference, String tableD) {
        if (tableDEntries == null) {
            tableDEntries = new HashMap<Integer, BUFRTableD>();
=======
     *
     * @param resourceClassReference
     * @param tableD
     */
    private void populateTableD(Class<?> resourceClassReference,
            String tableD) {
        if (tableDEntries == null) {
            tableDEntries = new HashMap<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }
        readTableD(resourceClassReference, DEFAULT_TABLE_D, false);
        if (tableD != null) {
            readTableD(resourceClassReference, "/res/bufrtables/" + tableD,
                    true);
        }
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param resourceClassReference
     * @param tableD
     */
    private void readTableD(Class<?> resourceClassReference, String tableD,
            boolean allowOverwrites) {
        InputStream strm = null;
        BufferedReader bf = null;

        try {
            String line = null;
            BUFRDescriptor tableDInstance = null;
            strm = resourceClassReference.getResourceAsStream(tableD);
            if (strm != null) {
                bf = new BufferedReader(new InputStreamReader(strm));

                while ((line = bf.readLine()) != null) {
                    if (line.length() > 1) {
                        logger.debug("Processing [" + line + "]");
                        switch (line.charAt(0)) {

                        case ' ': {
                            if (tableDInstance != null) {
                                BUFRDescriptor desc = getDescriptor(line);
                                if (desc != null) {
                                    if (tableDInstance.isDefined()) {
                                        logger.debug("Attempting to add ["
                                                + line
                                                + "] to a defined descriptor");
                                    } else {
<<<<<<< HEAD
                                        logger.debug("Adding [" + desc
                                                + "] to [" + tableDInstance
                                                + "]");
=======
                                        logger.debug(
                                                "Adding [" + desc + "] to ["
                                                        + tableDInstance + "]");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                                        tableDInstance.addDescriptor(desc);
                                    }
                                }
                            }
                            break;
                        }
                        case '3': {
                            if (tableDInstance != null) {
                                // we were defining an entry
                                tableDInstance.setDefined(true);
                            }
                            tableDInstance = null;

                            Matcher m = DESC_PATTERN.matcher(line);
                            if (m.find()) {
                                String s = line.substring(m.start(), m.end())
                                        .trim();
                                tableDInstance = getDescriptor(s);
                                if (tableDInstance.isDefined()
                                        && allowOverwrites) {
<<<<<<< HEAD
                                    tableDInstance
                                            .setSubList(new ArrayList<BUFRDescriptor>());
=======
                                    tableDInstance.setSubList(
                                            new ArrayList<BUFRDescriptor>());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                                }
                            } else {
                                logger.debug("Could not create descriptor for ["
                                        + line + "]");
                            }
                            break;
                        }
                        default: {
<<<<<<< HEAD

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                            break;
                        }
                        }
                    }
                }

                bf.close();
            } else {
<<<<<<< HEAD
                logger.error("Reading table D : Could not get stream to "
                        + tableD);
=======
                logger.error(
                        "Reading table D : Could not get stream to " + tableD);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param descriptor
     * @return
     */
    public synchronized BUFRDescriptor getDescriptor(int descriptor) {
        BUFRDescriptor descInstance = null;
        int desciptor_f = (descriptor & 0xC000) >> 14;
        switch (desciptor_f) {
        case 0: {
            descInstance = queryTableB(descriptor);
            break;
        }
        case 1: {
            descInstance = new BUFRReplicationDescriptor(descriptor);
            break;
        }
        case 2: {
            descInstance = new BUFRTableC(descriptor);
            break;
        }
        case 3: {
            descInstance = queryTableD(descriptor);
            if (descInstance == null) {
                // Not currently defined, create an undefined descriptor
                BUFRTableD d = new BUFRTableD(descriptor);
                // and put the into the table as a forward reference.
                tableDEntries.put(d.getDescriptor(), d);
                descInstance = d;
            }
            break;
        }
        }
        return descInstance;
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param f
     * @param x
     * @param y
     * @return
     */
    public synchronized BUFRDescriptor getDescriptor(int f, int x, int y) {
        return getDescriptor((f << 14) | (x << 8) | y);
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param descriptor
     * @return
     */
    public BUFRDescriptor getDescriptor(String descriptor) {
        BUFRDescriptor descInstance = null;
        synchronized (DESC_PATTERN) {
            Matcher m = DESC_PATTERN.matcher(descriptor);
            if (m.find()) {

<<<<<<< HEAD
                int f = Integer.parseInt(descriptor.substring(m.start(),
                        m.start() + 1).trim());
                int x = Integer.parseInt(descriptor.substring(m.start() + 2,
                        m.start() + 4).trim());
                int y = Integer.parseInt(descriptor.substring(m.start() + 5,
                        m.start() + 8).trim());
=======
                int f = Integer.parseInt(
                        descriptor.substring(m.start(), m.start() + 1).trim());
                int x = Integer.parseInt(descriptor
                        .substring(m.start() + 2, m.start() + 4).trim());
                int y = Integer.parseInt(descriptor
                        .substring(m.start() + 5, m.start() + 8).trim());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

                descInstance = getDescriptor(f, x, y);
            }
        }

        return descInstance;
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param descriptor
     * @return
     */
    public synchronized BUFRTableB queryTableB(Integer descriptor) {
        return tableBEntries.get(descriptor);
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param descriptor
     * @return
     */
    public synchronized BUFRTableD queryTableD(Integer descriptor) {
        return tableDEntries.get(descriptor);
    }

    public List<BUFRTableB> getTableB() {
<<<<<<< HEAD
        ArrayList<BUFRTableB> table = new ArrayList<BUFRTableB>();
=======
        ArrayList<BUFRTableB> table = new ArrayList<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        table.addAll(tableBEntries.values());
        return table;
    }

    public List<BUFRTableD> getTableD() {
<<<<<<< HEAD
        ArrayList<BUFRTableD> table = new ArrayList<BUFRTableD>();
=======
        ArrayList<BUFRTableD> table = new ArrayList<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        table.addAll(tableDEntries.values());
        return table;
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param descriptor
     * @return
     */
    public synchronized BUFRTableD addToTableD(BUFRTableD descriptor) {
        BUFRTableD desc = tableDEntries.put(descriptor.getDescriptor(),
                descriptor);
        return desc;
    }

<<<<<<< HEAD
    // public static synchronized DescriptorFactory getInstance() {
    // if (factoryInstance == null) {
    // factoryInstance = new DescriptorFactory();
    // }
    // return factoryInstance;
    // }
    //
    // public static synchronized DescriptorFactory getInstance(String tableB,
    // String tableD) {
    // if (factoryInstance == null) {
    // factoryInstance = new DescriptorFactory();
    // }
    // return factoryInstance;
    // }

    /**
     * 
=======
    /**
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param descriptor
     * @param indent
     */
    private static void displayDescriptor(BUFRDescriptor descriptor,
            String indent, Logger logger) {
        if (descriptor.getSubList() != null) {
            logger.debug(descriptor.getStringDescriptor());
            logger.debug(indent + "  [");
            display(descriptor.getSubList(), indent + "  ", logger);
            logger.debug(indent + "  ]");
        } else {
            logger.debug(descriptor.getStringDescriptor());
        }
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public static void display(List<BUFRDescriptor> list, String indent,
            Logger logger) {
        for (BUFRDescriptor d : list) {
            displayDescriptor(d, indent, logger);
        }
    }
}
