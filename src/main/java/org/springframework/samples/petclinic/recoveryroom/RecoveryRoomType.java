package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;


import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
@Table(name = "roomtypes")
@Getter
@Setter
@Entity
public class RecoveryRoomType extends BaseEntity{
	@Size(min = 3, max = 50)
	@Column(name = "name", unique = true)
	@NotNull
	private String name;
}
