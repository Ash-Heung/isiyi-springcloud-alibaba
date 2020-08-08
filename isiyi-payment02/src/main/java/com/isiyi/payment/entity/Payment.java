package com.isiyi.payment.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xpf
 * @since 2020-08-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Payment implements Serializable {

    private static final long serialVersionUID=1L;

    private long id;

    private String serial;


}
