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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

<<<<<<< HEAD
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.w3c.dom.Element;

import com.raytheon.uf.common.registry.schemas.ebxml.util.RegrepUtil;
=======
import org.hibernate.annotations.Type;
import org.w3c.dom.Element;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;

/**
<<<<<<< HEAD
 * 
 * A QueryExpression whose value sub-element is an XML element. Use this for
 * XQuery.
 * 
 * 
 * <p>
 * Java class for XMLQueryExpressionType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
=======
 *
 * A QueryExpression whose value sub-element is an XML element. Use this for
 * XQuery.
 *
 *
 * <p>
 * Java class for XMLQueryExpressionType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * <pre>
 * &lt;complexType name="XMLQueryExpressionType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}QueryExpressionType">
 *       &lt;sequence>
 *         &lt;any processContents='lax' namespace='##other'/>
 *       &lt;/sequence>
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
 */
@Entity
@Table(schema = RegrepUtil.EBXML_SCHEMA, name = "XMLQueryExpression")
@Cache(region = RegrepUtil.DB_CACHE_REGION, usage = CacheConcurrencyStrategy.TRANSACTIONAL)
=======
 * 12/2/2013     1829       bphillip    Made ExtensibleObjectType persistable,
 *                                      modified persistence annotations, added
 *                                      constructors, hashCode, toString and equals
 * 10/27/2020    8170       ksunil      Empty table. Removed all JPA references
 * </pre>
 *
 * @author bphillip
 */

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
@XmlRootElement(name = "XMLQueryExpression")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLQueryExpressionType", propOrder = { "any" })
@DynamicSerialize
public class XMLQueryExpressionType extends QueryExpressionType {

    private static final long serialVersionUID = -4520183948278760674L;

    @XmlAnyElement(lax = true)
    @DynamicSerializeElement
<<<<<<< HEAD
    @Column(name = "anyValue", columnDefinition = "text")
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Type(type = "com.raytheon.uf.common.registry.schemas.ebxml.util.SerializedType")
    protected Object any;

    public XMLQueryExpressionType() {
        super();
    }

    public XMLQueryExpressionType(String queryLanguage, Object any) {
        super(queryLanguage);
        this.any = any;
    }

    /**
     * Gets the value of the any property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link Element } {@link Object }
     * 
=======
     *
     * @return possible object is {@link Element } {@link Object }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public Object getAny() {
        return any;
    }

    /**
     * Sets the value of the any property.
<<<<<<< HEAD
     * 
     * @param value
     *            allowed object is {@link Element } {@link Object }
     * 
=======
     *
     * @param value
     *            allowed object is {@link Element } {@link Object }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void setAny(Object value) {
        this.any = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((any == null) ? 0 : any.hashCode());
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
        XMLQueryExpressionType other = (XMLQueryExpressionType) obj;
        if (any == null) {
            if (other.any != null)
                return false;
        } else if (!any.equals(other.any))
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
        XMLQueryExpressionType other = (XMLQueryExpressionType) obj;
        if (any == null) {
            if (other.any != null) {
                return false;
            }
        } else if (!any.equals(other.any)) {
            return false;
        }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("XMLQueryExpressionType \n[queryLanguage=");
        builder.append(queryLanguage);
        builder.append(", \nid=");
        builder.append(id);
        builder.append(", \nslot=");
        builder.append(slot);
        builder.append(", \nany=");
        builder.append(any);
        builder.append("]");
        return builder.toString();
    }

}
