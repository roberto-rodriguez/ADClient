package common.persistence.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
@Entity
@Table(name = "store")
@XmlRootElement
public class Store {

    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "store_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Generated(GenerationTime.INSERT)
    private Long id;

    @Column(name = "login")
    private String loginId;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "creation_date")
    private Date creationDate;
     @Column(name = "send_report")
    private Boolean sendReport;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
    private List<Factura> facturas;

    @Override
    public String toString() {
        return "[ login:" + loginId + " , name:" + name + ", lastName:" + lastName + ",address: " + address + ", phone:" + phone + ", email:" + email + ", cretionDate:" + creationDate + "]";
    }

    /**
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the facturas
     */
    public List<Factura> getFacturas() {
        return facturas;
    }

    /**
     * @param facturas the facturas to set
     */
    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    /**
     * @return the sendReport
     */
    public Boolean getSendReport() {
        return sendReport;
    }

    /**
     * @param sendReport the sendReport to set
     */
    public void setSendReport(Boolean sendReport) {
        this.sendReport = sendReport;
    }
}
