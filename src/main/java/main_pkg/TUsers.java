/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pkg;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vasil
 */
@Entity
@Table(name = "t_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUsers.findAll", query = "SELECT t FROM TUsers t")
    , @NamedQuery(name = "TUsers.findById", query = "SELECT t FROM TUsers t WHERE t.id = :id")
    , @NamedQuery(name = "TUsers.findByCreateDate", query = "SELECT t FROM TUsers t WHERE t.createDate = :createDate")
    , @NamedQuery(name = "TUsers.findByDescription", query = "SELECT t FROM TUsers t WHERE t.description = :description")
    , @NamedQuery(name = "TUsers.findByEmail", query = "SELECT t FROM TUsers t WHERE t.email = :email")
    , @NamedQuery(name = "TUsers.findByEnabled", query = "SELECT t FROM TUsers t WHERE t.enabled = :enabled")
    , @NamedQuery(name = "TUsers.findByFirstname", query = "SELECT t FROM TUsers t WHERE t.firstname = :firstname")
    , @NamedQuery(name = "TUsers.findByHashType", query = "SELECT t FROM TUsers t WHERE t.hashType = :hashType")
    , @NamedQuery(name = "TUsers.findByLastname", query = "SELECT t FROM TUsers t WHERE t.lastname = :lastname")
    , @NamedQuery(name = "TUsers.findByPassword", query = "SELECT t FROM TUsers t WHERE t.password = :password")
    , @NamedQuery(name = "TUsers.findByPhone", query = "SELECT t FROM TUsers t WHERE t.phone = :phone")
    , @NamedQuery(name = "TUsers.findBySalt", query = "SELECT t FROM TUsers t WHERE t.salt = :salt")
    , @NamedQuery(name = "TUsers.findByThirdname", query = "SELECT t FROM TUsers t WHERE t.thirdname = :thirdname")
    , @NamedQuery(name = "TUsers.findByUpdateDate", query = "SELECT t FROM TUsers t WHERE t.updateDate = :updateDate")
    , @NamedQuery(name = "TUsers.findByUserRegion", query = "SELECT t FROM TUsers t WHERE t.userRegion = :userRegion")
    , @NamedQuery(name = "TUsers.findByUserStatus", query = "SELECT t FROM TUsers t WHERE t.userStatus = :userStatus")
    , @NamedQuery(name = "TUsers.findByUsername", query = "SELECT t FROM TUsers t WHERE t.username = :username")
    , @NamedQuery(name = "TUsers.findByEmailVerified", query = "SELECT t FROM TUsers t WHERE t.emailVerified = :emailVerified")})
public class TUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @Size(max = 255)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 255)
    @Column(name = "hash_type")
    private String hashType;
    @Size(max = 255)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Недопустимый формат номера телефона/факса (должен иметь формат xxx-xxx-xxxx)")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @Size(max = 255)
    @Column(name = "salt")
    private String salt;
    @Size(max = 255)
    @Column(name = "thirdname")
    private String thirdname;
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "user_region")
    private Integer userRegion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_status")
    private int userStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "email_verified")
    private boolean emailVerified;
    @JoinTable(name = "t_user_required_action", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<TUsers> tUsersCollection;
    @ManyToMany(mappedBy = "tUsersCollection")
    private Collection<TUsers> tUsersCollection1;

    public TUsers() {
    }

    public TUsers(Long id) {
        this.id = id;
    }

    public TUsers(Long id, Date createDate, boolean enabled, int userStatus, String username, boolean emailVerified) {
        this.id = id;
        this.createDate = createDate;
        this.enabled = enabled;
        this.userStatus = userStatus;
        this.username = username;
        this.emailVerified = emailVerified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getHashType() {
        return hashType;
    }

    public void setHashType(String hashType) {
        this.hashType = hashType;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(Integer userRegion) {
        this.userRegion = userRegion;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    @XmlTransient
    public Collection<TUsers> getTUsersCollection() {
        return tUsersCollection;
    }

    public void setTUsersCollection(Collection<TUsers> tUsersCollection) {
        this.tUsersCollection = tUsersCollection;
    }

    @XmlTransient
    public Collection<TUsers> getTUsersCollection1() {
        return tUsersCollection1;
    }

    public void setTUsersCollection1(Collection<TUsers> tUsersCollection1) {
        this.tUsersCollection1 = tUsersCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUsers)) {
            return false;
        }
        TUsers other = (TUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main_pkg.TUsers[ id=" + id + " ]";
    }
    
}
