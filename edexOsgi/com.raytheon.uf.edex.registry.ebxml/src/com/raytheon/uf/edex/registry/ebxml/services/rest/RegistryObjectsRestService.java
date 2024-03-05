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
package com.raytheon.uf.edex.registry.ebxml.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.xml.bind.JAXBException;

<<<<<<< HEAD
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.AssociationType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.AuditableEventType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ClassificationNodeType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ClassificationSchemeType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ClassificationType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.CommentType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExternalIdentifierType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExternalLinkType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExtrinsicObjectType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.FederationType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.NotificationType;
=======
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raytheon.uf.common.registry.services.rest.IRegistryObjectsRestService;
import com.raytheon.uf.common.serialization.JAXBManager;
import com.raytheon.uf.edex.registry.ebxml.dao.RegistryObjectDao;

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.AssociationType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ClassificationNodeType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ClassificationSchemeType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ClassificationType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExternalIdentifierType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExternalLinkType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExtrinsicObjectType;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.OrganizationType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.PartyType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.PersonType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.QueryDefinitionType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RegistryObjectType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RegistryPackageType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RegistryType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RoleType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ServiceBindingType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ServiceEndpointType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ServiceInterfaceType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ServiceType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.SubscriptionType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.TaxonomyElementType;
<<<<<<< HEAD
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.WorkflowActionType;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raytheon.uf.common.registry.services.rest.IRegistryObjectsRestService;
import com.raytheon.uf.common.serialization.JAXBManager;
import com.raytheon.uf.edex.registry.ebxml.dao.RegistryObjectDao;

/**
 * 
 * REST service implementation for getting registry objects according to
 * specifications in Section 12.1.1 of the ebRS specification
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
=======

/**
 *
 * REST service implementation for getting registry objects according to
 * specifications in Section 12.1.1 of the ebRS specification
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * Date         Ticket#     Engineer    Description
 * ------------ ----------  ----------- --------------------------
 * 4/19/2013    1931        bphillip    Initial implementation
 * 5/21/2013    2022        bphillip    Added interface
 * 10/30/2013   1538        bphillip    Changed root REST service path
<<<<<<< HEAD
 * </pre>
 * 
 * @author bphillip
 * @version 1
=======
 * 5/26/2020    8165        bsteffen    Remove auditableevent and notification.
 * 10/30/2020   8170        ksunil      Removed a now deleted table reference
 * </pre>
 *
 * @author bphillip
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
@Path("/registryObjects/{objectId}")
@Service
@Transactional
public class RegistryObjectsRestService implements IRegistryObjectsRestService {

    /** The data access object for getting registry objects */
    private RegistryObjectDao registryObjectDao;

    /** The jaxbManager used to marshal the response */
    private JAXBManager jaxbManager;

    /**
     * Creates a new RegistryObjectRestService instance
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @throws JAXBException
     *             If errors occur while initializing the jaxb manager
     */
    public RegistryObjectsRestService() throws JAXBException {
        jaxbManager = new JAXBManager(RegistryObjectType.class,
<<<<<<< HEAD
                AssociationType.class, AuditableEventType.class,
                ClassificationType.class, ExternalIdentifierType.class,
                ExternalLinkType.class, ExtrinsicObjectType.class,
                CommentType.class, FederationType.class,
                NotificationType.class, PartyType.class,
=======
                AssociationType.class, ClassificationType.class,
                ExternalIdentifierType.class, ExternalLinkType.class,
                ExtrinsicObjectType.class, PartyType.class,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                OrganizationType.class, PersonType.class,
                QueryDefinitionType.class, RegistryPackageType.class,
                RegistryType.class, RoleType.class, ServiceBindingType.class,
                ServiceEndpointType.class, ServiceInterfaceType.class,
                ServiceType.class, SubscriptionType.class,
                TaxonomyElementType.class, ClassificationNodeType.class,
<<<<<<< HEAD
                ClassificationSchemeType.class, WorkflowActionType.class);
    }

=======
                ClassificationSchemeType.class);
    }

    @Override
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @GET
    @Produces("text/xml")
    public String getRegistryObject(@PathParam("objectId") String objectId)
            throws JAXBException {
        Object obj = registryObjectDao.getById(objectId);
        if (obj == null) {
            throw new WebApplicationException(404);
        }
        return jaxbManager.marshalToXml(obj);

    }

    public void setRegistryObjectDao(RegistryObjectDao registryObjectDao) {
        this.registryObjectDao = registryObjectDao;
    }

}
