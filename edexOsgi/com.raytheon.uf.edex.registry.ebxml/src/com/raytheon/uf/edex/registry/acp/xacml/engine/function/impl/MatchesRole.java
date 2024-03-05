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
package com.raytheon.uf.edex.registry.acp.xacml.engine.function.impl;

import java.util.List;

<<<<<<< HEAD
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RoleType;

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import org.opensaml.xacml.ctx.AttributeType;
import org.opensaml.xacml.ctx.AttributeValueType;
import org.opensaml.xacml.ctx.SubjectType;

import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.edex.registry.acp.xacml.conformance.Identifiers;
import com.raytheon.uf.edex.registry.acp.xacml.engine.function.XACMLFunction;
import com.raytheon.uf.edex.registry.acp.xacml.exception.XACMLProcessingException;
import com.raytheon.uf.edex.registry.ebxml.dao.RoleDao;
<<<<<<< HEAD
import com.raytheon.uf.edex.registry.ebxml.exception.EbxmlRegistryException;

/**
 * Implementation of the matches-role function
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- ------------------------------------------------------------
 * Aug 20, 2012  724      bphillip  Initial Coding
 * Mar 18, 2013  1802     bphillip  Modified to use transaction boundaries and spring injection
 * 2/25/2016    5380         tjensen     Update to support newer FOSS versions
 * Aug 25, 2016  5846     rjpeter   Remove InternationalString from DB
 * 
 * </pre>
 * 
=======

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RoleType;

/**
 * Implementation of the matches-role function
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Aug 20, 2012  724      bphillip  Initial Coding
 * Mar 18, 2013  1802     bphillip  Modified to use transaction boundaries and
 *                                  spring injection
 * Feb 25, 2016  5380     tjensen   Update to support newer FOSS versions
 * Aug 25, 2016  5846     rjpeter   Remove InternationalString from DB
 * Apr 14, 2021  7849     mapeters  Remove unreachable try/catch
 *
 * </pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * @author bphillip
 */
public class MatchesRole extends XACMLFunction {

    /** The logger */
    private static final transient IUFStatusHandler statusHandler = UFStatus
            .getHandler(MatchesRole.class);

    private RoleDao roleDao;

    @Override
    protected String getFunctionId() {
        return "urn:oasis:names:tc:ebxml-regrep:4.0:rim:acp:function: matches-role";
    }

    /**
     * <table border="1">
     * <tr>
     * <th>Parameter/Return</th>
     * <th>Name</th>
     * <th>Description</th>
     * <th>Data Type</th>
     * </tr>
     * <tr>
     * <td>Parameter 1</td>
     * <td>roles</td>
     * <td>Specifies a bag containing ids of RoleType instances representing the
     * contextual roles that a subject is expected to have</td>
<<<<<<< HEAD
     * <td>Bag of attributes of type http://www.w3.org/2001/XMLSchema#string</td>
=======
     * <td>Bag of attributes of type
     * http://www.w3.org/2001/XMLSchema#string</td>
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * </tr>
     * <tr>
     * <td>Parameter 2</td>
     * <td>roleType</td>
     * <td>Specifies the id of a ClassificationNode within the canonical
     * SubjectRole ClassificationScheme</td>
     * <td>http://www.w3.org/2001/XMLSchema#string</td>
     * </tr>
     * <tr>
     * <td>Parameter 3+N</td>
     * <td>contextKey</td>
     * <td>Specifies a context identifier</td>
     * <td>http://www.w3.org/2001/XMLSchema#string</td>
     * </tr>
     * <tr>
     * <td>Parameter 4+N</td>
     * <td>contextValue</td>
     * <td>Specifies a context value associated with the context identifier
     * specified by previous parameter</td>
     * <td>http://www.w3.org/2001/XMLSchema#string</td>
     * </tr>
     * </table>
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param roles
     *            See method description
     * @param roleType
     *            See method description
     * @param contextKey
     *            See method description
     * @return MUST return "True" if and only if at least one RoleType instance
     *         assigned to the subject meets the following conditions:<br>
     *         - If roleType is specified, then the type attribute of RoleType
     *         instance MUST match the role type ClassificationNode (or a
     *         descendant of if) specified by the roleType parameter<br>
     *         - If any context key/value pairs are specified then the RoleType
     *         instance MUST have a Slot whose name matches the context key and
     *         whose value matches the context value<br>
     *         - MUST return "false" otherwise
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public Boolean executeFunction(List<String> roles, String roleType,
            String... contextKey) throws XACMLProcessingException {
        statusHandler.info("Evaluating matches-role function.");

<<<<<<< HEAD
        try {
            // Get the subject ID from the request object
            String subjectId = getSubjectId();
            if (subjectId == null) {
                throw new XACMLProcessingException(
                        "Subject ID not found in request!");
            }
            // Gets the current role assigned to the user
            RoleType userRole = roleDao.getUserRole(subjectId);
            if (userRole == null) {
                throw new XACMLProcessingException("User [" + subjectId
                        + "] currently doesn not have a role assigned");
            }
            String roleName = userRole.getName();
            statusHandler.info("Role for user [" + subjectId + "] is ["
                    + userRole + "]");
            for (String role : roles) {
                if (roleName != null) {
                    if (roleName.equals(role)) {
                        statusHandler.info("Role for user matches " + roleName);
                        return true;
                    }
                }
            }
        } catch (EbxmlRegistryException e) {
            throw new XACMLProcessingException("Error getting role for user", e);
=======
        // Get the subject ID from the request object
        String subjectId = getSubjectId();
        if (subjectId == null) {
            throw new XACMLProcessingException(
                    "Subject ID not found in request!");
        }
        // Gets the current role assigned to the user
        RoleType userRole = roleDao.getUserRole(subjectId);
        if (userRole == null) {
            throw new XACMLProcessingException("User [" + subjectId
                    + "] currently doesn not have a role assigned");
        }
        String roleName = userRole.getName();
        statusHandler.info(
                "Role for user [" + subjectId + "] is [" + userRole + "]");
        for (String role : roles) {
            if (roleName != null) {
                if (roleName.equals(role)) {
                    statusHandler.info("Role for user matches " + roleName);
                    return true;
                }
            }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }
        return false;
    }

    /**
     * Gets the subject ID from the current request. This method looks for the
     * urn:oasis:names:tc:xacml:1.0:subject:subject-id identifier. If found, the
     * value of the attribute is retrieved as the subject ID. If it is not
     * found, null is returned
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return The subject ID or null if not found in the request
     */
    private String getSubjectId() {
        statusHandler.info("Getting the subject ID from the request");
        String subjectId = null;
        List<SubjectType> subjectsList = request.getSubjects();
        /*
         * Iterate through the subjects listed in the request and look for the
         * subject ID identifier string
         */
        for (SubjectType subject : subjectsList) {
            List<AttributeType> attrs = subject.getAttributes();
            for (AttributeType attr : attrs) {
                String attributeId = attr.getAttributeId();
                if (attributeId.equals(Identifiers.SUBJECT_ID)) {
                    List<AttributeValueType> attrValues = attr
                            .getAttributeValues();
                    for (AttributeValueType attrValue : attrValues) {
                        subjectId = attrValue.getValue();
<<<<<<< HEAD
                        statusHandler.info("Subject ID determined to be "
                                + subjectId);
=======
                        statusHandler.info(
                                "Subject ID determined to be " + subjectId);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    }
                }
            }
        }
        return subjectId;

    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

}
