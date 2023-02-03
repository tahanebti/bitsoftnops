package com.tahanebti.bitOftnOps.core.domain;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public abstract class BaseDomain<ID extends Serializable> implements IdentifiableEntity<ID>  {

}
