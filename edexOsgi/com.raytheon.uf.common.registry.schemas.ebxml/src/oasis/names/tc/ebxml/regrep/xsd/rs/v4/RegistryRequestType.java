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

import java.util.Collections;
import java.util.List;

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
=======
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import oasis.names.tc.ebxml.regrep.xsd.lcm.v4.RemoveObjectsRequest;
import oasis.names.tc.ebxml.regrep.xsd.lcm.v4.SubmitObjectsRequest;
import oasis.names.tc.ebxml.regrep.xsd.lcm.v4.UpdateObjectsRequest;
import oasis.names.tc.ebxml.regrep.xsd.query.v4.QueryRequest;
<<<<<<< HEAD
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExtensibleObjectType;
=======
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExtensibleObjectTypeNonJPA;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.SlotType;
import oasis.names.tc.ebxml.regrep.xsd.spi.v4.CatalogObjectsRequest;
import oasis.names.tc.ebxml.regrep.xsd.spi.v4.FilterObjectsRequest;
import oasis.names.tc.ebxml.regrep.xsd.spi.v4.ValidateObjectsRequest;

<<<<<<< HEAD
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.raytheon.uf.common.registry.schemas.ebxml.util.RegrepUtil;
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;

/**
 * Base type for all ebXML Registry requests
 * 
 * <p>
 * Java class for RegistryRequestType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
=======
/**
 * Base type for all ebXML Registry requests
 *
 * <p>
 * Java class for RegistryRequestType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * <pre>
 * &lt;complexType name="RegistryRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ExtensibleObjectType">
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="comment" type="{http://www.w3.org/2001/XMLSchema}string" />
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
 * 10/27/2020    8170       ksunil      changed inheritance to a non JPA version
 * </pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * @author bphillip
 * @version 1
 */
@XmlRootElement(name = "RegistryRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistryRequestType")
@XmlSeeAlso({ CatalogObjectsRequest.class, ValidateObjectsRequest.class,
        FilterObjectsRequest.class, QueryRequest.class,
        UpdateObjectsRequest.class, SubmitObjectsRequest.class,
        RemoveObjectsRequest.class })
@DynamicSerialize
<<<<<<< HEAD
@Entity
@Cache(region = RegrepUtil.DB_CACHE_REGION, usage = CacheConcurrencyStrategy.TRANSACTIONAL, include = "all")
@Table(schema = RegrepUtil.EBXML_SCHEMA, name = "RegistryRequest")
public class RegistryRequestType extends ExtensibleObjectType {
=======

public class RegistryRequestType extends ExtensibleObjectTypeNonJPA {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private static final long serialVersionUID = 4127177436730907012L;

    @XmlAttribute
    @DynamicSerializeElement
    protected String comment;

    public RegistryRequestType() {
        super();
    }

<<<<<<< HEAD
    public RegistryRequestType(String id, String comment, List<SlotType> slots) {
=======
    public RegistryRequestType(String id, String comment,
            List<SlotType> slots) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        super(id, slots);
        this.id = id;
        this.comment = comment;
    }

    public RegistryRequestType(String id, String comment) {
        this(id, comment, Collections.<SlotType> emptyList());

    }

    /**
     * Gets the value of the id property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link String }
     * 
     */
=======
     *
     * @return possible object is {@link String }
     *
     */
    @Override
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @XmlAttribute(required = true)
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    /**
     * Gets the value of the comment property.
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
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
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
    public void setComment(String value) {
        this.comment = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
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
        RegistryRequestType other = (RegistryRequestType) obj;
        if (comment == null) {
            if (other.comment != null)
                return false;
        } else if (!comment.equals(other.comment))
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
        RegistryRequestType other = (RegistryRequestType) obj;
        if (comment == null) {
            if (other.comment != null) {
                return false;
            }
        } else if (!comment.equals(other.comment)) {
            return false;
        }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RegistryRequestType \n[id=");
        builder.append(id);
        builder.append(", \nslot=");
        builder.append(slot);
        builder.append(", \ncomment=");
        builder.append(comment);
        builder.append("]");
        return builder.toString();
    }

}
