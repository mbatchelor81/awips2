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

package oasis.names.tc.ebxml.regrep.xsd.rs.v4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.raytheon.uf.common.registry.schemas.ebxml.util.EbxmlNamespaces;
import com.raytheon.uf.common.serialization.ISerializableObject;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the oasis.names.tc.ebxml_regrep.xsd.rs._4
 * package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * Date         Ticket#     Engineer    Description
 * ------------ ----------  ----------- --------------------------
 * 2012                     bphillip    Initial implementation
 * 10/17/2013    1682       bphillip    Added software history
<<<<<<< HEAD
 * </pre>
 * 
 * @author bphillip
 * @version 1
=======
 * 10/27/2020    8170       ksunil      removed references to empty tables
 * </pre>
 *
 * @author bphillip
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
@XmlRegistry
public class ObjectFactory implements ISerializableObject {

<<<<<<< HEAD
    private final static QName _RegistryResponse_QNAME = new QName(
            EbxmlNamespaces.RS_URI, "RegistryResponse");

    private final static QName _RegistryException_QNAME = new QName(
            EbxmlNamespaces.RS_URI, "RegistryException");

    private final static QName _RegistryRequest_QNAME = new QName(
=======
    private static final QName _RegistryResponse_QNAME = new QName(
            EbxmlNamespaces.RS_URI, "RegistryResponse");

    private static final QName _RegistryException_QNAME = new QName(
            EbxmlNamespaces.RS_URI, "RegistryException");

    private static final QName _RegistryRequest_QNAME = new QName(
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            EbxmlNamespaces.RS_URI, "RegistryRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: oasis.names.tc.ebxml_regrep.xsd.rs._4
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReferencesExistExceptionType }
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public ReferencesExistExceptionType createReferencesExistExceptionType() {
        return new ReferencesExistExceptionType();
    }

    /**
     * Create an instance of {@link UnresolvedReferenceExceptionType }
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public UnresolvedReferenceExceptionType createUnresolvedReferenceExceptionType() {
        return new UnresolvedReferenceExceptionType();
    }

    /**
<<<<<<< HEAD
     * Create an instance of {@link UnsupportedCapabilityExceptionType }
     * 
     */
    public UnsupportedCapabilityExceptionType createUnsupportedCapabilityExceptionType() {
        return new UnsupportedCapabilityExceptionType();
    }

    /**
     * Create an instance of {@link TimeoutExceptionType }
     * 
     */
    public TimeoutExceptionType createTimeoutExceptionType() {
        return new TimeoutExceptionType();
    }

    /**
     * Create an instance of {@link RegistryResponseType }
     * 
=======
     * Create an instance of {@link RegistryResponseType }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public RegistryResponseType createRegistryResponseType() {
        return new RegistryResponseType();
    }

    /**
     * Create an instance of {@link InvalidRequestExceptionType }
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public InvalidRequestExceptionType createInvalidRequestExceptionType() {
        return new InvalidRequestExceptionType();
    }

    /**
     * Create an instance of {@link ObjectNotFoundExceptionType }
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public ObjectNotFoundExceptionType createObjectNotFoundExceptionType() {
        return new ObjectNotFoundExceptionType();
    }

    /**
     * Create an instance of {@link RegistryRequestType }
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public RegistryRequestType createRegistryRequestType() {
        return new RegistryRequestType();
    }

    /**
<<<<<<< HEAD
     * Create an instance of {@link AuthenticationExceptionType }
     * 
     */
    public AuthenticationExceptionType createAuthenticationExceptionType() {
        return new AuthenticationExceptionType();
    }

    /**
     * Create an instance of {@link AuthorizationExceptionType }
     * 
     */
    public AuthorizationExceptionType createAuthorizationExceptionType() {
        return new AuthorizationExceptionType();
    }

    /**
     * Create an instance of {@link RegistryExceptionType }
     * 
=======
     * Create an instance of {@link RegistryExceptionType }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public RegistryExceptionType createRegistryExceptionType() {
        return new RegistryExceptionType();
    }

    /**
     * Create an instance of {@link ObjectExistsExceptionType }
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public ObjectExistsExceptionType createObjectExistsExceptionType() {
        return new ObjectExistsExceptionType();
    }

    /**
<<<<<<< HEAD
     * Create an instance of {@link QuotaExceededExceptionType }
     * 
     */
    public QuotaExceededExceptionType createQuotaExceededExceptionType() {
        return new QuotaExceededExceptionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link RegistryResponseType }{@code >}
     * 
=======
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link RegistryResponseType }{@code >}
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    @XmlElementDecl(namespace = EbxmlNamespaces.RS_URI, name = "RegistryResponse")
    public JAXBElement<RegistryResponseType> createRegistryResponse(
            RegistryResponseType value) {
<<<<<<< HEAD
        return new JAXBElement<RegistryResponseType>(_RegistryResponse_QNAME,
=======
        return new JAXBElement<>(_RegistryResponse_QNAME,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                RegistryResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link RegistryExceptionType }{@code >}
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    @XmlElementDecl(namespace = EbxmlNamespaces.RS_URI, name = "RegistryException")
    public JAXBElement<RegistryExceptionType> createRegistryException(
            RegistryExceptionType value) {
<<<<<<< HEAD
        return new JAXBElement<RegistryExceptionType>(_RegistryException_QNAME,
=======
        return new JAXBElement<>(_RegistryException_QNAME,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                RegistryExceptionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link RegistryRequestType }{@code >}
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    @XmlElementDecl(namespace = EbxmlNamespaces.RS_URI, name = "RegistryRequest")
    public JAXBElement<RegistryRequestType> createRegistryRequest(
            RegistryRequestType value) {
<<<<<<< HEAD
        return new JAXBElement<RegistryRequestType>(_RegistryRequest_QNAME,
=======
        return new JAXBElement<>(_RegistryRequest_QNAME,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                RegistryRequestType.class, null, value);
    }

}
