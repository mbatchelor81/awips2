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

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.Table;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

<<<<<<< HEAD
import oasis.names.tc.ebxml.regrep.xsd.query.v4.QueryExceptionType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExtensibleObjectType;
import oasis.names.tc.ebxml.regrep.xsd.spi.v4.CatalogingExceptionType;
import oasis.names.tc.ebxml.regrep.xsd.spi.v4.FilteringExceptionType;
import oasis.names.tc.ebxml.regrep.xsd.spi.v4.ValidationExceptionType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.raytheon.uf.common.registry.schemas.ebxml.util.RegrepUtil;
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;

/**
 * Base for all registry exceptions. Based upon SOAPFault:
 * http://www.w3schools.com/soap/soap_fault.asp
 * 
 * <p>
 * Java class for RegistryExceptionType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
=======
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;

import oasis.names.tc.ebxml.regrep.xsd.query.v4.QueryExceptionType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExtensibleObjectTypeNonJPA;
import oasis.names.tc.ebxml.regrep.xsd.spi.v4.ValidationExceptionType;

/**
 * Base for all registry exceptions. Based upon SOAPFault:
 * http://www.w3schools.com/soap/soap_fault.asp
 *
 * <p>
 * Java class for RegistryExceptionType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * <pre>
 * &lt;complexType name="RegistryExceptionType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ExtensibleObjectType">
 *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="detail" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="message" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="severity" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}objectReferenceType" default="urn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
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
 * 12/2/2013     1829       bphillip    Made ExtensibleObjectType persistable, 
 *                                      modified persistence annotations, added 
 *                                      constructors, hashCode, toString and equals
 * </pre>
 * 
 * @author bphillip
 * @version 1
=======
 * 12/2/2013     1829       bphillip    Made ExtensibleObjectType persistable,
 *                                      modified persistence annotations, added
 *                                      constructors, hashCode, toString and equals
 * 10/27/2020    8170       ksunil      this is an empty table. Remove all JPA references
 * </pre>
 *
 * @author bphillip
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
@XmlRootElement(name = "RegistryException")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistryExceptionType")
@XmlSeeAlso({ ObjectNotFoundExceptionType.class,
<<<<<<< HEAD
        UnsupportedCapabilityExceptionType.class,
        AuthenticationExceptionType.class, InvalidRequestExceptionType.class,
        ReferencesExistExceptionType.class, TimeoutExceptionType.class,
        QuotaExceededExceptionType.class, AuthorizationExceptionType.class,
        UnresolvedReferenceExceptionType.class,
        ObjectExistsExceptionType.class, QueryExceptionType.class,
        FilteringExceptionType.class, ValidationExceptionType.class,
        CatalogingExceptionType.class })
@DynamicSerialize
@Entity
@Cache(region = RegrepUtil.DB_CACHE_REGION, usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(schema = RegrepUtil.EBXML_SCHEMA, name = "RegistryException")
public class RegistryExceptionType extends ExtensibleObjectType {
=======
        InvalidRequestExceptionType.class, ReferencesExistExceptionType.class,
        UnresolvedReferenceExceptionType.class, ObjectExistsExceptionType.class,
        QueryExceptionType.class, ValidationExceptionType.class })
@DynamicSerialize

public class RegistryExceptionType extends ExtensibleObjectTypeNonJPA {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private static final long serialVersionUID = -811672255660498468L;

    @XmlAttribute
    @DynamicSerializeElement
    protected String code;

    @XmlAttribute
    @DynamicSerializeElement
    protected String detail;

    @XmlAttribute
    @DynamicSerializeElement
    protected String message;

    @XmlAttribute
    @DynamicSerializeElement
    protected String severity;

    public RegistryExceptionType() {
        super();
    }

    /**
     * Gets the value of the code property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link String }
     * 
=======
     *
     * @return possible object is {@link String }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
<<<<<<< HEAD
     * 
     * @param value
     *            allowed object is {@link String }
     * 
=======
     *
     * @param value
     *            allowed object is {@link String }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the detail property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link String }
     * 
=======
     *
     * @return possible object is {@link String }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Sets the value of the detail property.
<<<<<<< HEAD
     * 
     * @param value
     *            allowed object is {@link String }
     * 
=======
     *
     * @param value
     *            allowed object is {@link String }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void setDetail(String value) {
        this.detail = value;
    }

    /**
     * Gets the value of the message property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link String }
     * 
=======
     *
     * @return possible object is {@link String }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
<<<<<<< HEAD
     * 
     * @param value
     *            allowed object is {@link String }
     * 
=======
     *
     * @param value
     *            allowed object is {@link String }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the severity property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link String }
     * 
=======
     *
     * @return possible object is {@link String }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public String getSeverity() {
        if (severity == null) {
            return "urn:oasis:names:tc:ebxml-regrep:ErrorSeverityType:Error";
        } else {
            return severity;
        }
    }

    /**
     * Sets the value of the severity property.
<<<<<<< HEAD
     * 
     * @param value
     *            allowed object is {@link String }
     * 
=======
     *
     * @param value
     *            allowed object is {@link String }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void setSeverity(String value) {
        this.severity = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RegistryExceptionType \n[id=");
        builder.append(id);
        builder.append(", \nslot=");
        builder.append(slot);
        builder.append(", \ncode=");
        builder.append(code);
        builder.append(", \ndetail=");
        builder.append(detail);
        builder.append(", \nmessage=");
        builder.append(message);
        builder.append(", \nseverity=");
        builder.append(severity);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((detail == null) ? 0 : detail.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result
                + ((severity == null) ? 0 : severity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
<<<<<<< HEAD
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        RegistryExceptionType other = (RegistryExceptionType) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (detail == null) {
            if (other.detail != null)
                return false;
        } else if (!detail.equals(other.detail))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (severity == null) {
            if (other.severity != null)
                return false;
        } else if (!severity.equals(other.severity))
            return false;
=======
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RegistryExceptionType other = (RegistryExceptionType) obj;
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }
        if (detail == null) {
            if (other.detail != null) {
                return false;
            }
        } else if (!detail.equals(other.detail)) {
            return false;
        }
        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
            return false;
        }
        if (severity == null) {
            if (other.severity != null) {
                return false;
            }
        } else if (!severity.equals(other.severity)) {
            return false;
        }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return true;
    }

}
