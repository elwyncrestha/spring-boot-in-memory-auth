package com.github.elwyncrestha.springbootinmemoryauth.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Elvin Shrestha on 3/9/2020
 */
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class BaseEntity<PK extends Serializable> extends AbstractPersistable<Long> {

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();
}
