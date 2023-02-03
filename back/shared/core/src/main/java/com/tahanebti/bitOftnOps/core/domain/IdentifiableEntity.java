package com.tahanebti.bitOftnOps.core.domain;

import java.io.Serializable;

public interface IdentifiableEntity<ID extends Serializable> extends Serializable {
	ID getId();
}
