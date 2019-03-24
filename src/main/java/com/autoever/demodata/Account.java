package com.autoever.demodata;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {


    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();


    //
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date created = new Date();
//
//	private String yes;
//
//	@Transient
//	private String no;
//
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "street", column = @Column(name = "home_street")),
//		@AttributeOverride(name = "city", column = @Column(name = "home_city")),
//		@AttributeOverride(name = "state", column = @Column(name = "home_state")),
//		@AttributeOverride(name = "zipCode", column = @Column(name = "home_zipCode")),
//	})
//	private Address homeAddress;
//
//	@Embedded
//	private Address officeAddress;
//
//

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }
}
