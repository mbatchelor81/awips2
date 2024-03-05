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

package oasis.names.tc.ebxml.regrep.xsd.query.v4;

import java.math.BigInteger;

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
import oasis.names.tc.ebxml.regrep.xsd.rs.v4.RegistryResponseType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;

import oasis.names.tc.ebxml.regrep.xsd.rs.v4.RegistryResponseType;

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
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rs:4.0}RegistryResponseType">
 *       &lt;attribute name="startIndex" type="{http://www.w3.org/2001/XMLSchema}integer" default="0" />
 *       &lt;attribute name="totalResultCount" type="{http://www.w3.org/2001/XMLSchema}integer" />
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
<<<<<<< HEAD
 * </pre>
 * 
 * @author bphillip
 * @version 1
=======
 * 10/27/2020    8170       ksunil      this is an empty table. Remove all JPA references
 * </pre>
 *
 * @author bphillip
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "QueryResponse")
@DynamicSerialize
<<<<<<< HEAD
@Entity
@Cache(region = RegrepUtil.DB_CACHE_REGION, usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(schema = RegrepUtil.EBXML_SCHEMA, name = "QueryResponse")
=======

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
public class QueryResponse extends RegistryResponseType {

    private static final long serialVersionUID = 994857768186130811L;

    @XmlAttribute
    @DynamicSerializeElement
    protected BigInteger startIndex;

    @XmlAttribute
    @DynamicSerializeElement
    protected BigInteger totalResultCount;

    public QueryResponse() {
        super();
    }

    public void incrementResultCount(BigInteger resultCount) {
        if (resultCount == null) {
            return;
        }
        if (totalResultCount == null) {
            totalResultCount = new BigInteger("0");
        }
        totalResultCount = totalResultCount.add(resultCount);
    }

    /**
     * Gets the value of the startIndex property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link BigInteger }
     * 
=======
     *
     * @return possible object is {@link BigInteger }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public BigInteger getStartIndex() {
        if (startIndex == null) {
            return new BigInteger("0");
        } else {
            return startIndex;
        }
    }

    /**
     * Sets the value of the startIndex property.
<<<<<<< HEAD
     * 
     * @param value
     *            allowed object is {@link BigInteger }
     * 
=======
     *
     * @param value
     *            allowed object is {@link BigInteger }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void setStartIndex(BigInteger value) {
        this.startIndex = value;
    }

    /**
     * Gets the value of the totalResultCount property.
<<<<<<< HEAD
     * 
     * @return possible object is {@link BigInteger }
     * 
=======
     *
     * @return possible object is {@link BigInteger }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public BigInteger getTotalResultCount() {
        return totalResultCount;
    }

    /**
     * Sets the value of the totalResultCount property.
<<<<<<< HEAD
     * 
     * @param value
     *            allowed object is {@link BigInteger }
     * 
=======
     *
     * @param value
     *            allowed object is {@link BigInteger }
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public void setTotalResultCount(BigInteger value) {
        this.totalResultCount = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((startIndex == null) ? 0 : startIndex.hashCode());
<<<<<<< HEAD
        result = prime
                * result
                + ((totalResultCount == null) ? 0 : totalResultCount.hashCode());
=======
        result = prime * result + ((totalResultCount == null) ? 0
                : totalResultCount.hashCode());
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
        QueryResponse other = (QueryResponse) obj;
        if (startIndex == null) {
            if (other.startIndex != null)
                return false;
        } else if (!startIndex.equals(other.startIndex))
            return false;
        if (totalResultCount == null) {
            if (other.totalResultCount != null)
                return false;
        } else if (!totalResultCount.equals(other.totalResultCount))
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
        QueryResponse other = (QueryResponse) obj;
        if (startIndex == null) {
            if (other.startIndex != null) {
                return false;
            }
        } else if (!startIndex.equals(other.startIndex)) {
            return false;
        }
        if (totalResultCount == null) {
            if (other.totalResultCount != null) {
                return false;
            }
        } else if (!totalResultCount.equals(other.totalResultCount)) {
            return false;
        }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QueryResponse \n[exception=");
        builder.append(exception);
        builder.append(", \nregistryObjectList=");
        builder.append(registryObjectList);
        builder.append(", \nobjectRefList=");
        builder.append(objectRefList);
        builder.append(", \nstatus=");
        builder.append(status);
        builder.append(", \nrequestId=");
        builder.append(requestId);
        builder.append(", \nid=");
        builder.append(id);
        builder.append(", \nslot=");
        builder.append(slot);
        builder.append(", \nstartIndex=");
        builder.append(startIndex);
        builder.append(", \ntotalResultCount=");
        builder.append(totalResultCount);
        builder.append("]");
        return builder.toString();
    }

}
