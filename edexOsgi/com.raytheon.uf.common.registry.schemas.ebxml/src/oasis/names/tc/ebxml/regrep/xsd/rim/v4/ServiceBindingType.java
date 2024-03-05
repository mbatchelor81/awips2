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

package oasis.names.tc.ebxml.regrep.xsd.rim.v4;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.Table;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

<<<<<<< HEAD
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.raytheon.uf.common.registry.schemas.ebxml.util.RegrepUtil;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.registry.schemas.ebxml.util.annotations.RegistryObjectReference;
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;

/**
<<<<<<< HEAD
 * 
 * Represents a service binding in ebRIM. Matches binding as defined in WSDL 2.
 * 
 * 
 * <p>
 * Java class for ServiceBindingType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
=======
 *
 * Represents a service binding in ebRIM. Matches binding as defined in WSDL 2.
 *
 *
 * <p>
 * Java class for ServiceBindingType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * <pre>
 * &lt;complexType name="ServiceBindingType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}RegistryObjectType">
 *       &lt;attribute name="serviceInterface" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}objectReferenceType" />
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
=======
 * 12/2/2013     1829       bphillip    Made ExtensibleObjectType persistable,
 *                                      modified persistence annotations, added
 *                                      constructors, hashCode, toString and equals
 * 10/27/2020    8170       ksunil      this is an empty table. Remove all JPA references
 * </pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * @author bphillip
 * @version 1
 */
@XmlRootElement(name = "ServiceBinding")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceBindingType")
@DynamicSerialize
<<<<<<< HEAD
@Entity
@Cache(region = RegrepUtil.DB_CACHE_REGION, usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(schema = RegrepUtil.EBXML_SCHEMA, name = "ServiceBinding")
public class ServiceBindingType extends RegistryObjectType {
=======

public class ServiceBindingType extends RegistryObjectTypeNonJPA {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private static final long serialVersionUID = -7893999754736999974L;

    @XmlAttribute
    @DynamicSerializeElement
    @RegistryObjectReference
    protected String serviceInterface;

    public ServiceBindingType() {
        super();

    }

    public ServiceBindingType(String id, String lid, String objectType,
            String owner, String status, String name, String description) {
        super(id, lid, objectType, owner, status, name, description);

    }

    public ServiceBindingType(String id, String lid) {
        super(id, lid);

    }

    /**
     * Gets the value of the serviceInterface property.
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
    public String getServiceInterface() {
        return serviceInterface;
    }

    /**
     * Sets the value of the serviceInterface property.
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
    public void setServiceInterface(String value) {
        this.serviceInterface = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
<<<<<<< HEAD
        result = prime
                * result
                + ((serviceInterface == null) ? 0 : serviceInterface.hashCode());
=======
        result = prime * result + ((serviceInterface == null) ? 0
                : serviceInterface.hashCode());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
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
        ServiceBindingType other = (ServiceBindingType) obj;
        if (serviceInterface == null) {
            if (other.serviceInterface != null)
                return false;
        } else if (!serviceInterface.equals(other.serviceInterface))
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
        ServiceBindingType other = (ServiceBindingType) obj;
        if (serviceInterface == null) {
            if (other.serviceInterface != null) {
                return false;
            }
        } else if (!serviceInterface.equals(other.serviceInterface)) {
            return false;
        }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ServiceBindingType \n[name=");
        builder.append(name);
        builder.append(", \ndescription=");
        builder.append(description);
        builder.append(", \nversionInfo=");
        builder.append(versionInfo);
        builder.append(", \nclassification=");
        builder.append(classification);
        builder.append(", \nexternalIdentifier=");
        builder.append(externalIdentifier);
        builder.append(", \nexternalLink=");
        builder.append(externalLink);
        builder.append(", \nlid=");
        builder.append(lid);
        builder.append(", \nobjectType=");
        builder.append(objectType);
        builder.append(", \nowner=");
        builder.append(owner);
        builder.append(", \nstatus=");
        builder.append(status);
        builder.append(", \nid=");
        builder.append(id);
        builder.append(", \nslot=");
        builder.append(slot);
        builder.append(", \nserviceInterface=");
        builder.append(serviceInterface);
        builder.append("]");
        return builder.toString();
    }

}
