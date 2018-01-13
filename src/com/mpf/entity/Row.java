package com.mpf.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Row {

	//�����
	public int index() default -1;
	//����
	public String columnName() default "";
	//�ֶε�����
	public Class<?> clazz() default Object.class;
	
}
