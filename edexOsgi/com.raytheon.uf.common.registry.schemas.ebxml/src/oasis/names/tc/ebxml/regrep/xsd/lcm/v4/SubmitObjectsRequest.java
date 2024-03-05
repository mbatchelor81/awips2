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

package oasis.names.tc.ebxml.regrep.xsd.lcm.v4;

import java.util.List;

<<<<<<< HEAD
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

<<<<<<< HEAD
=======
import com.raytheon.uf.common.registry.schemas.ebxml.util.EbxmlNamespaces;
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RegistryObjectListType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RegistryObjectType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.SlotType;
import oasis.names.tc.ebxml.regrep.xsd.rs.v4.RegistryRequestType;

<<<<<<< HEAD
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.raytheon.uf.common.registry.schemas.ebxml.util.EbxmlNamespaces;
import com.raytheon.uf.common.registry.schemas.ebxml.util.RegrepUtil;
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
=======
/**
 * <p>
 * Java class for anonymous complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rs:4.0}RegistryRequestType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}RegistryObjectList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="checkReferences" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="mode" type="{urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0}mode" default="CreateOrReplace" />
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
 * 12/2/2013     1829       bphillip    Added Hibernate annotations
 * Mar 31, 2014  2889        dhladky      Added username for notification center tracking.
<<<<<<< HEAD
 * </pre>
 * 
=======
 * 10/27/2020    8170       ksunil      this is an empty table. Remove all JPA references
 * </pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * @author bphillip
 * @version 1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "registryObjectList" })
@XmlRootElement(name = "SubmitObjectsRequest")
@DynamicSerialize
<<<<<<< HEAD
@Entity
@Cache(region = RegrepUtil.DB_CACHE_REGION, usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(schema = RegrepUtil.EBXML_SCHEMA, name = "SubmitObjectsRequest")
=======

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
public class SubmitObjectsRequest extends RegistryRequestType {

    private static final long serialVersionUID = -6900232373438206618L;

    @XmlElement(name = "RegistryObjectList", namespace = EbxmlNamespaces.RIM_URI)
    @DynamicSerializeElement
<<<<<<< HEAD
    @OneToOne(cascade = CascadeType.ALL)
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    protected RegistryObjectListType registryObjectList;

    @XmlAttribute
    @DynamicSerializeElement
    protected Boolean checkReferences;

    @XmlAttribute
    @DynamicSerializeElement
    protected Mode mode;
<<<<<<< HEAD
    
=======

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @XmlAttribute
    @DynamicSerializeElement
    protected String username;

    public SubmitObjectsRequest() {
        super();
    }

<<<<<<< HEAD
    public SubmitObjectsRequest(String id, String comment,
            List<SlotType> slots, RegistryObjectListType registryObjectList,
            Boolean checkReferences, Mode mode) {
=======
    public SubmitObjectsRequest(String id, String comment, List<SlotType> slots,
            RegistryObjectListType registryObjectList, Boolean checkReferences,
            Mode mode) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        super(id, comment, slots);
        this.registryObjectList = registryObjectList;
        this.checkReferences = checkReferences;
        this.mode = mode;
    }

    /**
     * Gets the value of the registryObjectList property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link RegistryObjectListType }
     * 
=======
     *
     * @return possible object is {@link RegistryObjectListType }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public RegistryObjectListType getRegistryObjectList() {
        return registryObjectList;
    }

    /**
     * Sets the value of the registryObjectList property.
<<<<<<< HEAD
     * 
     * @param value
     *            allowed object is {@link RegistryObjectListType }
     * 
=======
     *
     * @param value
     *            allowed object is {@link RegistryObjectListType }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void setRegistryObjectList(RegistryObjectListType value) {
        this.registryObjectList = value;
    }

    /**
     * Get the registry objects on the request.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return
     */
    public List<RegistryObjectType> getRegistryObjects() {
        if (registryObjectList == null) {
            registryObjectList = new RegistryObjectListType();
        }
        return registryObjectList.getRegistryObject();
    }

    /**
     * Gets the value of the checkReferences property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link Boolean }
     * 
=======
     *
     * @return possible object is {@link Boolean }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public boolean isCheckReferences() {
        if (checkReferences == null) {
            return false;
        } else {
            return checkReferences;
        }
    }

    /**
     * Sets the value of the checkReferences property.
<<<<<<< HEAD
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
=======
     *
     * @param value
     *            allowed object is {@link Boolean }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void setCheckReferences(Boolean value) {
        this.checkReferences = value;
    }

    /**
     * Gets the value of the mode property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link Mode }
     * 
=======
     *
     * @return possible object is {@link Mode }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public Mode getMode() {
        if (mode == null) {
            return Mode.CREATE_OR_REPLACE;
        } else {
            return mode;
        }
    }

    /**
     * Sets the value of the mode property.
<<<<<<< HEAD
     * 
     * @param value
     *            allowed object is {@link Mode }
     * 
=======
     *
     * @param value
     *            allowed object is {@link Mode }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void setMode(Mode value) {
        this.mode = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((checkReferences == null) ? 0 : checkReferences.hashCode());
        result = prime * result + ((mode == null) ? 0 : mode.hashCode());
<<<<<<< HEAD
        result = prime
                * result
                + ((registryObjectList == null) ? 0 : registryObjectList
                        .hashCode());
=======
        result = prime * result + ((registryObjectList == null) ? 0
                : registryObjectList.hashCode());
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
        SubmitObjectsRequest other = (SubmitObjectsRequest) obj;
        if (checkReferences == null) {
            if (other.checkReferences != null)
                return false;
        } else if (!checkReferences.equals(other.checkReferences))
            return false;
        if (mode != other.mode)
            return false;
        if (registryObjectList == null) {
            if (other.registryObjectList != null)
                return false;
        } else if (!registryObjectList.equals(other.registryObjectList))
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
        SubmitObjectsRequest other = (SubmitObjectsRequest) obj;
        if (checkReferences == null) {
            if (other.checkReferences != null) {
                return false;
            }
        } else if (!checkReferences.equals(other.checkReferences)) {
            return false;
        }
        if (mode != other.mode) {
            return false;
        }
        if (registryObjectList == null) {
            if (other.registryObjectList != null) {
                return false;
            }
        } else if (!registryObjectList.equals(other.registryObjectList)) {
            return false;
        }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        if (username != null) {
            if (other.username != null) {
                return false;
            } else if (!username.equals(other.username)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SubmitObjectsRequest \n[comment=");
        builder.append(comment);
        builder.append(", \nid=");
        builder.append(id);
        builder.append(", \nslot=");
        builder.append(slot);
        builder.append(", \nregistryObjectList=");
        builder.append(registryObjectList);
        builder.append(", \ncheckReferences=");
        builder.append(checkReferences);
        builder.append(", \nmode=");
        builder.append(mode);
        builder.append("]");
        builder.append(", \nusername=");
        builder.append(username);
        builder.append("]");
        return builder.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
