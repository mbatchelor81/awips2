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
package com.raytheon.viz.awipstools.ui.dialog;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
<<<<<<< HEAD
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
=======
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

import com.raytheon.uf.common.dataplugin.HDF5Util;
import com.raytheon.uf.common.dataplugin.PluginDataObject;
import com.raytheon.uf.common.dataplugin.radar.RadarRecord;
import com.raytheon.uf.common.dataplugin.radar.util.RadarDataRetriever;
import com.raytheon.uf.common.dataplugin.radar.util.RadarRecordUtil;
import com.raytheon.uf.common.dataquery.requests.DbQueryRequest;
import com.raytheon.uf.common.dataquery.requests.RequestConstraint;
import com.raytheon.uf.common.dataquery.responses.DbQueryResponse;
import com.raytheon.uf.common.datastorage.DataStoreFactory;
import com.raytheon.uf.common.datastorage.IDataStore;
import com.raytheon.uf.common.pointdata.spatial.ObStation;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.status.UFStatus.Priority;
import com.raytheon.uf.common.time.DataTime;
import com.raytheon.uf.viz.core.VizApp;
import com.raytheon.uf.viz.core.VizConstants;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.uf.viz.core.globals.VizGlobalsManager;
import com.raytheon.uf.viz.core.requests.ThriftClient;
import com.raytheon.uf.viz.datacube.DataCubeContainer;
import com.raytheon.uf.viz.points.IPointChangedListener;
import com.raytheon.uf.viz.points.PointsDataManager;
<<<<<<< HEAD
=======
import com.raytheon.viz.awipstools.IBaselineChangedListener;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.viz.awipstools.IToolChangedListener;
import com.raytheon.viz.awipstools.ToolsDataManager;
import com.raytheon.viz.ui.UiPlugin;
import com.raytheon.viz.ui.dialogs.CaveSWTDialog;
<<<<<<< HEAD
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;

/**
 * Dialog for selecting points
 * 
 * <pre>
 * SOFTWARE HISTORY
 * Date          Ticket#  Engineer    Description
 * ------------- -------- ----------- --------------------------
=======

/**
 * Dialog for selecting points
 *
 * <pre>
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer    Description
 * ------------- -------- ----------- ------------------------------------------
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * Dec 07, 2007  576      Eric Babin  Initial Creation.
 * Jul 23, 2010  5948     bkowal      Added the ability to move a point to the
 *                                    location of a &quot;mesocyclone&quot;.
 * Jul 31, 2012  875      rferrel     Let preopen initialize components.
 * Nov 05, 2012  1304     rferrel     Added Point Change Listener.
 * Sep 03, 2013  2310     bsteffen    Use IPointChangedListener and
 *                                    IToolChangedListener instead of
 *                                    IResourceDataChanged.
<<<<<<< HEAD
 * Sep  9, 2013  2277     mschenke    Got rid of ScriptCreator references
 * 
 * </pre>
 * 
 * @author ebabin
 * @version 1.0
 */

public class ChooseByIdDialog extends CaveSWTDialog implements
        IPointChangedListener {
    private final transient IUFStatusHandler statusHandler = UFStatus
=======
 * Sep 09, 2013  2277     mschenke    Got rid of ScriptCreator references
 * May 13, 2021  8451     randerso    Use IBaseLineChangedListener
 * Oct 13, 2022  8946     mapeters    Handle VizGlobalsManager.getProperty()
 *                                    method rename
 *
 * </pre>
 *
 * @author ebabin
 */
public class ChooseByIdDialog extends CaveSWTDialog
        implements IPointChangedListener {
    private static final IUFStatusHandler statusHandler = UFStatus
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            .getHandler(ChooseByIdDialog.class);

    public static final String DIALOG_TITLE = "Choose By Id";

<<<<<<< HEAD
    private final String HOME_POINT = "Home";

    private Button pointsRdo, baselinesRdo, homeRdo;

    private final List<ChooseByIdKeyListener> changeListeners = new ArrayList<ChooseByIdKeyListener>();
=======
    private static final String HOME_POINT = "Home";

    private static final int NAME_INDEX = 0;

    private static final int POINT_TEXT_INDEX = 1;

    private final List<ChooseByIdKeyListener> changeListeners = new ArrayList<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private final List<Text> pointStationIdTextFields;

    private final List<Text> baselineStationIdTextFields;

    private final PointsDataManager pointsDataManager = PointsDataManager
            .getInstance();

    private final ToolsDataManager toolsDataManager = ToolsDataManager
            .getInstance();

    private ScrolledComposite pointsScroll;

<<<<<<< HEAD
    private final int NAME_INDEX = 0;

    private final int POINT_TEXT_INDEX = 1;

    private class ChooseByIdSelectionListener implements SelectionListener {
=======
    private Button pointsRdo, baselinesRdo, homeRdo;

    private static class ChooseByIdSelectionListener
            implements SelectionListener {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        private final List<Text> texts;

        /**
         * @param texts
         */
        public ChooseByIdSelectionListener(List<Text> texts) {
            this.texts = texts;
        }

<<<<<<< HEAD
        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org
         * .eclipse.swt.events.SelectionEvent)
         */
        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
            return;
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
         * .swt.events.SelectionEvent)
         */
=======
        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
        }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        @Override
        public void widgetSelected(SelectionEvent e) {
            Button checkBoxButton = (Button) e.getSource();
            if (checkBoxButton.getSelection()) {

                Event pressEnterEvent = new Event();
                pressEnterEvent.keyCode = SWT.CR;

                for (Text textField : texts) {
                    pressEnterEvent.widget = textField;
                    textField.notifyListeners(SWT.KeyUp, pressEnterEvent);
                }
            }
        }

    }

<<<<<<< HEAD
    private class ChooseByIdKeyListener implements KeyListener,
            IPointChangedListener, IToolChangedListener {
=======
    private class ChooseByIdKeyListener
            implements KeyListener, IPointChangedListener, IToolChangedListener,
            IBaselineChangedListener {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        private final String idName;

        private boolean isBaseline;

        private Text textWidget;

        private ArrayList<Coordinate> stationCoordinates;

        private String clearedStationIDs;

        private boolean isHome() {
            return (idName.equals(HOME_POINT));
        }

        private boolean isBaseline() {
            return (isBaseline && toolsDataManager.getBaseline(idName) != null);
        }

        private boolean isPoint() {
<<<<<<< HEAD
            return (!isBaseline && pointsDataManager.getCoordinate(idName) != null);
        }

        /**
         * 
=======
            return (!isBaseline
                    && pointsDataManager.getCoordinate(idName) != null);
        }

        /**
         *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
         * @param idName
         */
        public ChooseByIdKeyListener(String idName) {
            this.idName = idName;
            setBaseline(false);
            clearedStationIDs = "";
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.keyCode) {
            case '=':
                e.doit = false;
                break;
            default:
                break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

<<<<<<< HEAD
            stationCoordinates = new ArrayList<Coordinate>();
=======
            stationCoordinates = new ArrayList<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            textWidget = ((org.eclipse.swt.widgets.Text) e.getSource());

            switch (e.keyCode) {
            case SWT.CR:
                String stationIDs = getFilteredStationIDs(textWidget.getText());

<<<<<<< HEAD
                if (stationIDs.equals("") && clearedStationIDs.length() > 0) {
=======
                if (stationIDs.isEmpty() && clearedStationIDs.length() > 0) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    stationIDs = clearedStationIDs;
                }

                if (stationIDs.length() == 0) {
                    return;
                }

                if (isBaseline && stationIDs.split(" ").length < 2) {
                    String errorString = getErrorString(stationIDs) + " ";
                    textWidget.setText(errorString);
                    textWidget.setSelection(errorString.length());
                    return;
                }

                textWidget.setText(stationIDs);

                for (String stationID : stationIDs.split(" ")) {

                    Coordinate c = null;
                    /*
                     * If an Obs station is not found, see if the user has
                     * entered a MD or DMD id.
                     */
                    ObStation obStation = getObStation(stationID);
                    if (obStation != null) {
                        c = obStation.getGeometry().getCoordinate();
                    } else {
                        c = this.getDmdInformation(stationID);
                    }

                    if (c == null) {
                        String errorString = getErrorString(stationIDs);
                        textWidget.setText(errorString);
                        int badStationIndex = errorString.indexOf(stationID);
                        textWidget.setSelection(badStationIndex,
                                badStationIndex + stationID.length());
                        stationCoordinates = null;
                        return;
                    }

                    this.stationCoordinates.add(c);
                }
                updatePosition(stationCoordinates);
                break;
<<<<<<< HEAD
=======

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            case SWT.ESC:
            case '=':
                clearedStationIDs = getFilteredStationIDs(textWidget.getText());
                textWidget.setText("");
                stationCoordinates = null;
<<<<<<< HEAD
=======
                break;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            default:
                break;
            }
        }

        /**
         * @param text
         * @return
         */
        private String getFilteredStationIDs(String text) {
            text = text.toUpperCase().replace("> ", "");
            return text.replace("* ", "");
        }

        /**
         * @param stationIDs
         * @return
         */
        private String getErrorString(String stationIDs) {
            return "> " + stationIDs;
        }

        /**
         * @param stationCoordinates
         */
        private void updatePosition(List<Coordinate> stationCoordinates) {

            if (isPoint()) {
                pointsDataManager.setCoordinate(idName,
                        stationCoordinates.get(0));
                pointsDataManager.addPointsChangedListener(this);
            } else if (isBaseline()) {
<<<<<<< HEAD
                toolsDataManager.setBaseline(idName, (new GeometryFactory())
                        .createLineString(stationCoordinates
                                .toArray(new Coordinate[] {})));
=======
                toolsDataManager.setBaseline(idName,
                        (new GeometryFactory())
                                .createLineString(stationCoordinates
                                        .toArray(new Coordinate[] {})));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                toolsDataManager.addBaselinesChangedListener(this);
            } else if (isHome()) {
                pointsDataManager.setHome(stationCoordinates.get(0));
                pointsDataManager.addHomeChangedListener(this);
            }
            changeListeners.add(this);
        }

        /**
<<<<<<< HEAD
         * 
=======
         *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
         * @param mesoId
         * @return
         */
        private Coordinate getDmdInformation(String mesoId) {
            int frameCount = 64;
            Object framesObj = VizGlobalsManager.getCurrentInstance()
<<<<<<< HEAD
                    .getPropery(VizConstants.FRAMES_ID);
=======
                    .getProperty(VizConstants.FRAMES_ID);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            if (framesObj instanceof Integer) {
                frameCount = (Integer) framesObj;
            }

            Coordinate c = null;
            RadarRecord rr = null;

<<<<<<< HEAD
            HashMap<String, RequestConstraint> metadataMap = new HashMap<String, RequestConstraint>();

            DataTime[] availableDataTimes = null;
            Collection<DataTime> selectedDataTimes = new LinkedHashSet<DataTime>();
=======
            Map<String, RequestConstraint> metadataMap = new HashMap<>();

            DataTime[] availableDataTimes = null;
            Collection<DataTime> selectedDataTimes = new LinkedHashSet<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

            metadataMap.put("productCode", new RequestConstraint("149"));
            metadataMap.put("pluginName", new RequestConstraint("radar"));
            metadataMap.put("format", new RequestConstraint("Graphic"));

            try {
<<<<<<< HEAD
                availableDataTimes = DataCubeContainer.performTimeQuery(
                        metadataMap, false);
=======
                availableDataTimes = DataCubeContainer
                        .performTimeQuery(metadataMap, false);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            } catch (Exception e) {
                Status s = new Status(Status.INFO, UiPlugin.PLUGIN_ID,
                        "The query for the entered Mesocyclone ID has failed.");
                ErrorDialog.openError(Display.getCurrent().getActiveShell(),
                        "Error Finding Mesocyclone ID",
                        "Error Finding Mesocyclone ID", s);
                return null;
            }

            if (availableDataTimes != null && availableDataTimes.length > 0) {
                Arrays.sort(availableDataTimes, Collections.reverseOrder());

                for (int i = 0; i < availableDataTimes.length
                        && selectedDataTimes.size() < frameCount; ++i) {
                    DataTime dt = availableDataTimes[i];
                    if (dt != null) {
                        selectedDataTimes.add(dt);
                    }
                }
            }

<<<<<<< HEAD
            if (selectedDataTimes.isEmpty() == false) {
=======
            if (!selectedDataTimes.isEmpty()) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                PluginDataObject[] resp = null;

                try {
                    resp = DataCubeContainer.getData(metadataMap,
                            selectedDataTimes.toArray(new DataTime[0]));
                } catch (Exception e) {
                    Status s = new Status(Status.INFO, UiPlugin.PLUGIN_ID,
                            "The query for the entered Mesocyclone ID has failed.");
<<<<<<< HEAD
                    ErrorDialog.openError(
                            Display.getCurrent().getActiveShell(),
=======
                    ErrorDialog.openError(Display.getCurrent().getActiveShell(),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                            "Error Finding Mesocyclone ID",
                            "Error Finding Mesocyclone ID", s);
                    return null;
                }

<<<<<<< HEAD
                for (int i = 0; i < resp.length; i++) {
                    rr = (RadarRecord) resp[i];
=======
                for (PluginDataObject element : resp) {
                    rr = (RadarRecord) element;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    File loc = HDF5Util.findHDF5Location(rr);

                    IDataStore dataStore = DataStoreFactory.getDataStore(loc);

                    try {
                        RadarDataRetriever.populateRadarRecord(dataStore, rr);
                    } catch (Exception e) {
<<<<<<< HEAD
                        e.printStackTrace();
=======
                        statusHandler.error(
                                "Error populating radar record: " + rr, e);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    }

                    List<String> ids = RadarRecordUtil.getDMDFeatureIDs(rr);
                    if (!ids.contains(mesoId)) {
                        continue;
                    }
                    c = RadarRecordUtil.getDMDLonLatFromFeatureID(rr, mesoId);
                    break;
                }
            }

            return c;
        }

        /**
<<<<<<< HEAD
         * 
=======
         *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
         * @param stationID
         * @return the ObStation with the given stationID
         */
        private ObStation getObStation(String stationID) {
            ObStation obStation = null;
            DbQueryRequest request = new DbQueryRequest();
<<<<<<< HEAD
            request.addConstraint(
                    "gid",
                    new RequestConstraint(ObStation.createGID(
                            ObStation.CAT_TYPE_ICAO, stationID)));
=======
            request.addConstraint("gid", new RequestConstraint(
                    ObStation.createGID(ObStation.CAT_TYPE_ICAO, stationID)));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            request.setEntityClass(ObStation.class);
            request.setLimit(1);

            try {
                DbQueryResponse response = (DbQueryResponse) ThriftClient
                        .sendRequest(request);
                if (response.getNumResults() == 1) {
                    obStation = response.getEntityObjects(ObStation.class)[0];
                }
            } catch (VizException e) {
<<<<<<< HEAD
                statusHandler.handle(Priority.WARN,
                        "Error querying for points", e);
=======
                statusHandler.handle(Priority.WARN, "Error querying for points",
                        e);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }

            return obStation;
        }

        public void setBaseline(boolean isBaseline) {
            this.isBaseline = isBaseline;
        }

        @Override
        public void pointChanged() {
            toolChanged();
        }

        @Override
<<<<<<< HEAD
        public void toolChanged() {
            VizApp.runAsync(new Runnable() {

                @Override
                public void run() {
                    handleChange();
                }
            });
=======
        public void baselineChanged(String name, LineString baseline) {
            toolChanged();
        }

        @Override
        public void toolChanged() {
            VizApp.runAsync(() -> handleChange());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }

        public void handleChange() {
            boolean stationLocationHasChanged = false;

<<<<<<< HEAD
            if (stationCoordinates == null || stationCoordinates.size() == 0) {
=======
            if (stationCoordinates == null || stationCoordinates.isEmpty()) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                return;
            }

            if (isHome()) {
                Coordinate homeCoordinate = pointsDataManager.getHome();

                stationLocationHasChanged = (!homeCoordinate
                        .equals(stationCoordinates.get(0)));

            } else if (isPoint()) {
                Coordinate pointCoordinate = pointsDataManager
                        .getCoordinate(idName);

                stationLocationHasChanged = (!pointCoordinate
                        .equals(stationCoordinates.get(0)));
            } else if (isBaseline()) {
                Coordinate[] baselineCoordinates = toolsDataManager
                        .getBaseline(idName).getCoordinates();

                for (Coordinate baselineCoordinate : baselineCoordinates) {
                    if (!stationCoordinates.contains(baselineCoordinate)) {
                        stationLocationHasChanged = true;
                    }
                }
            }

            if (stationLocationHasChanged) {
                String coordinateChanged = "* "
                        + getFilteredStationIDs(textWidget.getText());
                textWidget.setText(coordinateChanged);

                if ((homeRdo.getSelection() && isHome())
                        || (pointsRdo.getSelection() && isPoint())
                        || (baselinesRdo.getSelection() && isBaseline)) {

                    Event pressEnterEvent = new Event();
                    pressEnterEvent.keyCode = SWT.CR;

                    pressEnterEvent.widget = textWidget;
                    textWidget.notifyListeners(SWT.KeyUp, pressEnterEvent);
                }

            }
        }

    }

    public ChooseByIdDialog(Shell parentShell) {
        super(parentShell, SWT.DIALOG_TRIM | SWT.RESIZE, CAVE.DO_NOT_BLOCK);
        setText(DIALOG_TITLE);

<<<<<<< HEAD
        pointStationIdTextFields = new ArrayList<Text>();
        baselineStationIdTextFields = new ArrayList<Text>();
=======
        pointStationIdTextFields = new ArrayList<>();
        baselineStationIdTextFields = new ArrayList<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    @Override
    protected Layout constructShellLayout() {
        GridLayout gridLayout = new GridLayout(1, true);
        gridLayout.verticalSpacing = 2;
        return gridLayout;
    }

    @Override
    protected void initializeComponents(Shell shell) {
        // prevent escape from closing the dialog
<<<<<<< HEAD
        shell.addListener(SWT.Traverse, new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (event.detail == SWT.TRAVERSE_ESCAPE) {
                    event.doit = false;
                }
=======
        shell.addListener(SWT.Traverse, event -> {
            if (event.detail == SWT.TRAVERSE_ESCAPE) {
                event.doit = false;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }
        });

        shell.pack();
        shell.setMinimumSize(new Point(340, 570));
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    private void unregisterListeners() {
        for (ChooseByIdKeyListener changeListener : changeListeners) {
            pointsDataManager.removePointsChangedListener(changeListener);
            pointsDataManager.removeHomeChangedListener(changeListener);
            toolsDataManager.removeBaselinesChangedListener(changeListener);
        }
    }

    /**
     * Initializes the components.
     */
    private void initializeComponents() {
        createTopBar();
        pointsScroll = new ScrolledComposite(shell, SWT.V_SCROLL);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        pointsScroll.setLayoutData(gd);
        createIdBoxes();
        createBottomBar();
    }

    private void createIdBoxes() {
        Composite pointsComposite = (Composite) pointsScroll.getContent();
        boolean doPack = false;

        // Assume base lines do not change.
        if (pointsComposite == null) {
<<<<<<< HEAD
            String[] names = toolsDataManager.getBaselineNames().toArray(
                    new String[0]);
=======
            String[] names = toolsDataManager.getBaselineNames()
                    .toArray(new String[0]);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            Arrays.sort(names);

            pointsComposite = new Composite(pointsScroll, SWT.NONE);
            GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
            pointsComposite.setLayout(new GridLayout(1, false));
            pointsComposite.setLayoutData(gd);
            pointsScroll.setContent(pointsComposite);
            for (String name : names) {
                createGroup(pointsComposite, name, true);
            }
        }

<<<<<<< HEAD
        String[] pointNames = pointsDataManager.getPointNames().toArray(
                new String[] {});
=======
        String[] pointNames = pointsDataManager.getPointNames()
                .toArray(new String[] {});
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        Arrays.sort(pointNames);
        Control[] oldGroups = pointsComposite.getChildren();
        int index = 0;
        for (String point : pointNames) {
            boolean doMoveAbove = false;
            boolean createGroup = true;
            Control moveAbove = null;
            while (index < oldGroups.length) {
                Group group = (Group) oldGroups[index];
                String oldPoint = ((Label) group.getChildren()[NAME_INDEX])
                        .getText();
                boolean isBaseline = (Boolean) group.getData();
                Text pointText = (Text) group.getChildren()[POINT_TEXT_INDEX];
                int cmp = point.compareTo(oldPoint);
                if (cmp == 0) {
                    createGroup = false;
<<<<<<< HEAD
                    if (pointText.isEnabled() == false) {
=======
                    if (!pointText.isEnabled()) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                        pointStationIdTextFields.add(pointText);
                        pointText.setEnabled(true);
                    }
                    ++index;
                    break;
                } else if (cmp > 0) {
                    pointStationIdTextFields.remove(pointText);

                    if (isBaseline) {
                        pointText.setEnabled(false);
                        pointText.setText("");
                    } else {
                        group.dispose();
                        doPack = true;
                    }
                    ++index;
                } else {
                    moveAbove = group;
                    doMoveAbove = true;
                    break;
                }
            }

            if (createGroup) {
                doPack = true;
                Group group = createGroup(pointsComposite, point, false);
                if (doMoveAbove) {
                    group.moveAbove(moveAbove);
                }
            }
        }

        while (index < oldGroups.length) {
            Group group = (Group) oldGroups[index];
            boolean isBaseline = (Boolean) group.getData();
            Text pointText = (Text) group.getChildren()[POINT_TEXT_INDEX];
            pointStationIdTextFields.remove(pointText);
            if (isBaseline) {
                pointText.setEnabled(false);
            } else {
                oldGroups[index].dispose();
                doPack = true;
            }
            ++index;
        }

<<<<<<< HEAD
        pointsScroll.setMinSize(pointsComposite.computeSize(SWT.DEFAULT,
                SWT.DEFAULT));
=======
        pointsScroll.setMinSize(
                pointsComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        pointsScroll.setExpandHorizontal(true);
        pointsScroll.setExpandVertical(true);
        if (doPack) {
            pointsComposite.pack();
        }
    }

    private Group createGroup(Composite pointsComposite, String name,
            boolean isBaseLine) {
        Group group = new Group(pointsComposite, SWT.NONE);
        group.setData(isBaseLine);

        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.grabExcessHorizontalSpace = true;
        group.setLayoutData(gridData);
        group.setLayout(new GridLayout(3, false));

        Label label = new Label(group, SWT.NONE);
        label.setText(name);
        Text pointText = new Text(group, SWT.BORDER);
        pointText.setText("");
        pointText.addKeyListener(new ChooseByIdKeyListener(name));

        if (isBaseLine) {
            pointText.setEnabled(false);
        } else {
            pointStationIdTextFields.add(pointText);
        }

        Text baselineText = new Text(group, SWT.BORDER);
<<<<<<< HEAD
        baselineText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
                | GridData.HORIZONTAL_ALIGN_FILL));
=======
        baselineText.setLayoutData(new GridData(
                GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        ChooseByIdKeyListener chooseByIdKeyListener = new ChooseByIdKeyListener(
                name);
        chooseByIdKeyListener.setBaseline(true);
        baselineText.addKeyListener(chooseByIdKeyListener);

        if (isBaseLine) {
            baselineStationIdTextFields.add(baselineText);
        } else {
            baselineText.setEnabled(false);
        }
        return group;
    }

    @Override
    protected void preOpened() {
        super.preOpened();
        initializeComponents();
        pointsDataManager.addPointsChangedListener(this);
    }

    private void createBottomBar() {
        Group g = new Group(shell, SWT.NONE);

        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.CENTER;
        gridData.grabExcessHorizontalSpace = true;
        g.setLayoutData(gridData);
        g.setLayout(new GridLayout(3, false));

        Label label = new Label(g, SWT.NONE);
        label.setText(HOME_POINT);
        Text text1 = new Text(g, SWT.BORDER);
        text1.setText("");

        text1.addKeyListener(new ChooseByIdKeyListener(HOME_POINT));

        homeRdo = new Button(g, SWT.CHECK);
<<<<<<< HEAD
        homeRdo.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
                | GridData.HORIZONTAL_ALIGN_FILL));
        homeRdo.setText("lock");

        List<Text> homeStationIdText = new ArrayList<Text>();
        homeStationIdText.add(text1);

        homeRdo.addSelectionListener(new ChooseByIdSelectionListener(
                homeStationIdText));
=======
        homeRdo.setLayoutData(new GridData(
                GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
        homeRdo.setText("lock");

        List<Text> homeStationIdText = new ArrayList<>();
        homeStationIdText.add(text1);

        homeRdo.addSelectionListener(
                new ChooseByIdSelectionListener(homeStationIdText));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    }

    private void createTopBar() {
        Group comp = new Group(shell, SWT.NONE | SWT.FILL);

        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.grabExcessHorizontalSpace = true;
        comp.setLayoutData(gridData);

        comp.setLayout(new GridLayout(4, true));
        Label pointsLabel = new Label(comp, SWT.NONE);
        pointsLabel.setText("Points");
        pointsLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

        pointsRdo = new Button(comp, SWT.CHECK);
        pointsRdo.setText("lock");
<<<<<<< HEAD
        pointsRdo
                .setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING
                        | GridData.GRAB_HORIZONTAL));

        pointsRdo.addSelectionListener(new ChooseByIdSelectionListener(
                pointStationIdTextFields));
=======
        pointsRdo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING
                | GridData.GRAB_HORIZONTAL));

        pointsRdo.addSelectionListener(
                new ChooseByIdSelectionListener(pointStationIdTextFields));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        Label baselinesLabel = new Label(comp, SWT.NONE);
        baselinesLabel.setText("Baselines");
        baselinesLabel
                .setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
        baselinesRdo = new Button(comp, SWT.CHECK);
        baselinesRdo.setText("lock");
        baselinesRdo
                .setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING
                        | GridData.GRAB_HORIZONTAL));
<<<<<<< HEAD
        baselinesRdo.addSelectionListener(new ChooseByIdSelectionListener(
                baselineStationIdTextFields));
=======
        baselinesRdo.addSelectionListener(
                new ChooseByIdSelectionListener(baselineStationIdTextFields));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    @Override
    protected void disposed() {
        pointsDataManager.removePointsChangedListener(this);
        unregisterListeners();
    }

    @Override
    public void pointChanged() {
<<<<<<< HEAD
        VizApp.runAsync(new Runnable() {
            @Override
            public void run() {
                createIdBoxes();
            }
        });
=======
        VizApp.runAsync(() -> createIdBoxes());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

}
