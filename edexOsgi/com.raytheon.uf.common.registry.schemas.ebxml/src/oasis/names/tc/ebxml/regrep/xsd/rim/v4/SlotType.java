/**
 * This software was developed and / or modified by Raytheon Company,
 * pursuant to Contract DG133W-05-CQ-1067 with the US Government.
 * 
 * U.S. EXPORT CONTROLLED TECHNICAL DATA
 * This software product contains export-restricted data whose
 * export/transfer/disclosure is restricted by U.S. law. Dissemination
 * to non-U.S. persons whether in the United States or abroad requires
 * an export license or other authorization.
 * 
 * Contractor Name:        Raytheon Company
 * Contractor Address:     6825 Pine Street, Suite 340
 *                         Mail Stop B8
 *                         Omaha, NE 68106
 *                         402.291.0100
 * 
 * See the AWIPS II Master Rights File ("Master Rights File.pdf") for
 * further licensing information.
 **/

package oasis.names.tc.ebxml.regrep.xsd.rim.v4;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
=======
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
<<<<<<< HEAD
=======
import javax.xml.bind.annotation.XmlTransient;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;

import com.raytheon.uf.common.dataplugin.persist.IPersistableDataObject;
import com.raytheon.uf.common.registry.schemas.ebxml.util.RegrepUtil;
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;

/**
 * 
 * Represents an extensible attribute that may be dynamically added to any
 * ExtensibleObjectType instance. It is an important extensibility mechanism
 * with ebRIM. A SlotType instance contains a name and a value. The value may be
 * of any type.
 * 
 * 
 * <p>
 * Java class for SlotType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SlotType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="SlotValue" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}LongText" />
 *       &lt;attribute name="type" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}LongText" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- ----------------------------------------------------------------
 * 2012                   bphillip  Initial implementation
 * Oct 17, 2013  1682     bphillip  Added software history
 * Dec 02, 2013  1829     bphillip  Made ExtensibleObjectType persistable, modified persistence
 *                                  annotations, added constructors, hashCode, toString and equals
 * Jan 15, 2014  2613     bphillip  Removed automatically created index
 * May 24, 2016  5659     dhladky   Added indexes and columns for querying.
 * Aug 25, 2016  5846     rjpeter   Added index on value_id.
<<<<<<< HEAD
=======
 * May 11, 2020  8161     bsteffen  Change id to a long
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * </pre>
 * 
 * @author bphillip
 */
@XmlRootElement(name = "Slot")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "SlotType", propOrder = { "slotValue" })
@DynamicSerialize
@Entity
@Cache(region = RegrepUtil.DB_CACHE_REGION, usage = CacheConcurrencyStrategy.TRANSACTIONAL, include = "all")
@Table(schema = RegrepUtil.EBXML_SCHEMA, name = "Slot")
<<<<<<< HEAD
public class SlotType extends ExtensibleObjectType implements
        IPersistableDataObject<String> {

    private static final long serialVersionUID = -5563064693536600976L;
=======
public class SlotType implements IPersistableDataObject<Long> {

    @Id
    @SequenceGenerator(name = "SlotTypeGenerator", schema = RegrepUtil.EBXML_SCHEMA, sequenceName = RegrepUtil.EBXML_SCHEMA
            + ".Slot_sequence")
    @GeneratedValue(generator = "SlotTypeGenerator")
    @XmlTransient
    protected long id;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "value_id", referencedColumnName = "id")
    @XmlElement(name = "SlotValue")
    @Index(name = "slot_value_id_idx")
    @DynamicSerializeElement
    protected ValueType slotValue;

    @XmlAttribute(required = true)
    @DynamicSerializeElement
    @Index(name = "slot_name_idx")
    @Column(length = 255)
    protected String name;

    /** This field is here to support adhoc querying **/
    @Column(insertable = false, updatable = false)
    protected Integer value_id;

    /** This field is here to support adhoc querying **/
    @Column(length = 1024, insertable = false, updatable = false)
    protected String parent_id;

<<<<<<< HEAD
    @XmlAttribute
    @DynamicSerializeElement
    @Column(length = 64)
    protected String type;

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public SlotType() {
        super();
    }

<<<<<<< HEAD
    public SlotType(String id, List<SlotType> slot) {
        super(id, slot);
    }

    public SlotType(ValueType slotValue, String name, String type) {
        super();
        this.slotValue = slotValue;
        this.name = name;
        this.type = type;
    }

    public SlotType(String id, List<SlotType> slot, ValueType slotValue,
            String name, String type) {
        super(id, slot);
        this.slotValue = slotValue;
        this.name = name;
        this.type = type;
    }

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public SlotType(String name, ValueType slotValue) {
        this.name = name;
        this.slotValue = slotValue;
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((slotValue == null) ? 0 : slotValue.hashCode());
<<<<<<< HEAD
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
=======
        return result;
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SlotType other = (SlotType) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (slotValue == null) {
            if (other.slotValue != null) {
                return false;
            }
        } else if (!slotValue.equals(other.slotValue)) {
            return false;
        }
<<<<<<< HEAD
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SlotType \n[id=");
        builder.append(id);
<<<<<<< HEAD
        builder.append(", \nslot=");
        builder.append(slot);
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        builder.append(", \nslotValue=");
        builder.append(slotValue);
        builder.append(", \nname=");
        builder.append(name);
        builder.append(", \ntype=");
<<<<<<< HEAD
        builder.append(type);
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        builder.append("]");
        return builder.toString();
    }

<<<<<<< HEAD
=======
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    /**
     * Gets the value of the slotValue property.
     * 
     * @return possible object is {@link ValueType }
     * 
     */
    public ValueType getSlotValue() {
        return slotValue;
    }

    /**
     * Sets the value of the slotValue property.
     * 
     * @param value
     *            allowed object is {@link ValueType }
     * 
     */
    public void setSlotValue(ValueType value) {
        this.slotValue = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

<<<<<<< HEAD
    /**
     * Gets the value of the type property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setType(String value) {
        this.type = value;
    }

    @Override
    public String getIdentifier() {
=======
    @Override
    public Long getIdentifier() {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return id;
    }

}
