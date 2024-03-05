package com.raytheon.viz.mpe.ui;

/**
 * DisplayFieldData enum
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jun 9, 2011            rgeorge      Initial creation
 * Jun 30, 2014 17457     snaples      Updated getCv_use to return name
 * Jan 7, 2015  16954     cgobs        Fix for cv_use issue - using getFieldName() in certain parts.
 * Mar 01, 2017 6160      bkowal       Added {@link #getDisplayString()}.
 * Sep 09, 2017 6407      bkowal       Added {@link #goesRSatPre}.
 * Oct 06, 2017 6407      bkowal       Cleanup. Updates to support GOES-R SATPRE.
<<<<<<< HEAD
=======
 * Feb 03, 2022 22005     jrohwein     Set parameter to their own color_use in place of PRECIP_ACCUM
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * </pre>
 * 
 * @author rgeorge
 */
public enum DisplayFieldData {
    rMosaic(
            "rfcwide_rmosaic_dir",
            "Radar-Derived Precip",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "RMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    avgrMosaic(
            "rfcwide_avg_rmosaic_dir",
            "Average Radar-Derived Precip",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "AVGRMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    maxrMosaic(
            "rfcwide_max_rmosaic_dir",
            "Max Radar-Derived Precip",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "MAXRMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    bMosaic(
            "rfcwide_bmosaic_dir",
            "Mean Field Bias Corrected Radar-Derived Precip",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "BMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    lMosaic(
            "rfcwide_lmosaic_dir",
            "Local Bias Corrected Radar-Derived Precip (in)",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "LMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    gageOnly(
            "rfcwide_gageonly_dir",
            "Gage Only Analysis (in)",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "GAGEONLY"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    satPre(
            "rfcwide_satpre_dir",
            "Satellite-Derived Precip (in)",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "SATPRE"), //jayroh
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    goesRSatPre(
            null,
            "Satellite-Derived Precip (in) [GOES-R]",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "GOESRSATPRE"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    lsatPre(
            "rfcwide_lsatpre_dir",
            "Local Bias Corrected Satellite-Derived Precip",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
    mMosaic("rfcwide_mmosaic_dir", "Multisensor Precip", 3600, "PRECIP_ACCUM"),
=======
            "LSATPRE"),
    mMosaic("rfcwide_mmosaic_dir", "Multisensor Precip", 3600, "MMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    mlMosaic(
            "rfcwide_mlmosaic_dir",
            "Local Bias Multisensor Precip",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),

    // Dual Pol Fields
    rdMosaic("mpe_rdmosaic_dir", "DP Radar Mosaic", 3600, "PRECIP_ACCUM"),
=======
            "MLMOSAIC"),

    // Dual Pol Fields
    rdMosaic("mpe_rdmosaic_dir", "DP Radar Mosaic", 3600, "RDMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    avgrdMosaic(
            "mpe_avgrdmosaic_dir",
            "DP Avg Radar Mosaic",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "AVGRDMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    maxrdMosaic(
            "mpe_maxrdmosaic_dir",
            "DP Max Radar Mosaic",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "MAXRDMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    bdMosaic(
            "mpe_bdmosaic_dir",
            "DP Field Bias Radar Mosaic",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "BDMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    ldMosaic(
            "mpe_ldmosaic_dir",
            "DP Local Bias Radar Mosaic",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "LDMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    mdMosaic(
            "mpe_mdmosaic_dir",
            "DP Field Bias Multisensor Radar Mosaic",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "MDMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    mldMosaic(
            "mpe_mldmosaic_dir",
            "DP Local Bias Multisensor Radar Mosaic",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "MLDMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    srdMosaic(
            "mpe_srdmosaic_dir",
            "DP Satellite Radar Mosaic",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "SRDMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    srdgMosaic(
            "mpe_srdgmosaic_dir",
            "DP Satellite Radar Gage Mosaic",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "SRDGMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    rfcMosaic(
            "gaq_xmrg_1hr_dir",
            "RFC Best Estimate Mosaic",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "RFCMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    sgMosaic(
            "mpe_sgmosaic_dir",
            "Satellite Gage Mosaic (in)",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "SGMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    srMosaic(
            "mpe_srmosaic_dir",
            "Satellite Radar Mosaic (in)",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "SRMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    srgMosaic(
            "mpe_srgmosaic_dir",
            "Satellite Gage Radar Mosaic (in)",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "SRGMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    rfcbMosaic(
            "mpe_rfcbmosaic_dir",
            "RFC Bias Corrected Radar-Derived Precip (in)",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
=======
            "RFCBMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    rfcmMosaic(
            "mpe_rfcmmosaic_dir",
            "RFC Multisensor Precip (in)",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),
    qmosaic("mpe_qmosaic_dir", "Q2 Radar Mosaic", 3600, "PRECIP_ACCUM"),
    lqmosaic("mpe_lqmosaic_dir", "Q2 Local Bias Mosaic", 3600, "PRECIP_ACCUM"),
=======
            "RFCMMOSAIC"),
    qmosaic("mpe_qmosaic_dir", "Q2 Radar Mosaic", 3600, "QMOSAIC"),
    lqmosaic("mpe_lqmosaic_dir", "Q2 Local Bias Mosaic", 3600, "LQMOSAIC"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    mlqmosaic(
            "mpe_mlqmosaic_dir",
            "Q2 MultiSensor Mosaic",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),

    // best estimate QPE
    Xmrg("rfcwide_xmrg_dir", "Best Estimate QPE (in)", 3600, "PRECIP_ACCUM"),
=======
            "MLQMOSAIC"),

    // best estimate QPE
    Xmrg("rfcwide_xmrg_dir", "Best Estimate QPE (in)", 3600, "RFCWIDE_XMRG"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    p3lMosaic(
            "rfcwide_p3lmosaic_dir",
            "P3 Local Bias Corrected Radar-Derived Precip (in)",
            3600,
<<<<<<< HEAD
            "PRECIP_ACCUM"),

    localField1("mpe_localfield1_dir", "Local Field #1", 3600, "PRECIP_ACCUM"),
    localField2("mpe_localfield2_dir", "Local Field #2", 3600, "PRECIP_ACCUM"),
    localField3("mpe_localfield3_dir", "Local Field #3", 3600, "PRECIP_ACCUM"),
=======
            "RFCWIDE_P3LMOSAIC"),

    localField1("mpe_localfield1_dir", "Local Field #1", 3600, "MPE_LOCALFIELD1"),
    localField2("mpe_localfield2_dir", "Local Field #2", 3600, "MPE_LOCALFIELD2"),
    localField3("mpe_localfield3_dir", "Local Field #3", 3600, "MPE_LOCALFIELD3"),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    // ------------------------------------------------------------------

    multiHour("", "%d hr Saved Precip Estimate For %s Ending %s (in)"),

    precipDifferenceField("", "Precip Difference Field", 3600, "PRECIP_DIFF"),
    precipRatioField("", "Precip Ratio Field", 3600, "PRECIP_RATIO"),

    Locspan("rfcwide_locspan_dir", "memory span index (local bias)", 0),
    Locbias("rfcwide_locbias_dir", "Local Bias Values", 0),

    LocspanDP(
            "mpe_locspandp_dir",
            "DP memory span index (local bias)",
            0,
            "LOCSPAN"),
    LocbiasDP("mpe_locbiasdp_dir", "DP Local Bias Values", 0, "LOCBIAS"),

    Height("rfcwide_height_dir", "Height of Radar Coverage (ft) ", 0),
    Index("rfcwide_index_dir", "Radar Coverage Map", 0),

    Prism("mpe_prism_dir", "Monthly Normal Precipitation (in)", 0),
    maxtempPrism("mpe_prism_dir", "Monthly Normal Max Temperature (F)", 0),
    mintempPrism("mpe_prism_dir", "Monthly Normal Min Temperature (F)", 0),

    subValue("", ""),

    missing("", ""),
    gageTriangles("rfcwide_p3lmosaic_dir", "Gage Triangles"),
    savelevel2("", "Save Level 2 Data"),
    qc_precipitation("", "QC Precipitation..."),
    qc_temperatures("", "QC Temperatures.."),
    qc_freezinglevel("", "QC Freezing Level...");

    // ------------------------------------------------------------
    private String dirToken;

    private String cv_use;

    private int cv_duration;

    private String displayString;

    private ComparisonFields comparisonFields = null;

    private DisplayFieldData(String dirToken, String displayString) {
        this(dirToken, displayString, 1, null);
    }

    private DisplayFieldData(String dirToken, String displayString,
            int cv_duration) {
        this(dirToken, displayString, cv_duration, null);
    }

    private DisplayFieldData(String dirToken, String displayString,
            int cv_duration, String cv_use) {
        this.dirToken = dirToken;
        this.displayString = displayString;
        this.cv_duration = cv_duration;
        this.cv_use = cv_use;
    }

    public String getDirToken() {
        return dirToken;
    }

    public boolean isAComparisonField() {
        if ((this.equals(precipDifferenceField))
                || (this.equals(precipRatioField))) {
            return true;
        } else {
            return false;
        }
    }

    public String getFieldName() {
        return name().toUpperCase();
    }

    /**
     * @return the cv_use
     */
    public String getCv_use() {
        if (cv_use == null) {
            cv_use = getFieldName();
        }
        return cv_use;
    }

    public int getCv_duration() {
        return cv_duration;
    }

    public String getFileNamePrefix() {
        return name().toUpperCase();
    }

    @Override
    public String toString() {
        if (isAComparisonField()) {
            ComparisonFields comparisonFields = getComparisonFields();

            DisplayFieldData field1 = comparisonFields.getField1();
            DisplayFieldData field2 = comparisonFields.getField2();

            String fieldName1 = field1.name().toUpperCase();
            String fieldName2 = field2.name().toUpperCase();

            if (this.equals(DisplayFieldData.precipDifferenceField)) {
                String newString = String.format(
                        "Difference field: %s - %s(in)", fieldName1,
                        fieldName2);
                return newString;
            } else if (this.equals(DisplayFieldData.precipRatioField)) {
                String newString = String.format("Ratio field: %s / %s",
                        fieldName1, fieldName2);
                return newString;
            }
            return "ERROR";
        } else {
            // not a comparison field
            return displayString;
        }
    }

    /**
     * A case-insensitive version of {@link DisplayFieldData#valueOf(String)}
     * 
     * @param displayFieldData
     * @return
     */
    public static DisplayFieldData fromString(String displayFieldData) {
        for (DisplayFieldData fieldData : DisplayFieldData.values()) {
            if (fieldData.name().equalsIgnoreCase(displayFieldData)) {
                return fieldData;
            }
        }
        return null;
    }

    public static DisplayFieldData fromDisplayNameString(
            String displayFieldData) {
        for (DisplayFieldData fieldData : DisplayFieldData.values()) {
            if (fieldData.displayString.equalsIgnoreCase(displayFieldData)) {
                return fieldData;
            }
        }
        return null;
    }

    public ComparisonFields getComparisonFields() {
        return comparisonFields;
    }

    public void setComparisonFields(ComparisonFields comparisonFields) {
        this.comparisonFields = comparisonFields;
    }

    public String getDisplayString() {
        return displayString;
    }
}