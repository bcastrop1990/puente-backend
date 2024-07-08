
package oracle.bpel.services.workflow.task.error.model;

/*
 * #%L
 * TUPA: Integration: BPM-Client: HW Task Query Service Client
 * %%
 * Copyright (C) 2016 SENASA
 * %%
 * This software is the confidential and proprietary information of SENASA. 
 * You shall not disclose such confidential information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with 
 * SENASA.
 * #L%
 */

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oracle.bpel.services.workflow.task.error.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ErrorParameter_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/taskError", "errorParameter");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oracle.bpel.services.workflow.task.error.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TaskError }
     * 
     */
    public TaskError createTaskError() {
        return new TaskError();
    }

    /**
     * Create an instance of {@link TaskError.Sca }
     * 
     */
    public TaskError.Sca createTaskErrorSca() {
        return new TaskError.Sca();
    }

    /**
     * Create an instance of {@link ErrorParameterListType }
     * 
     */
    public ErrorParameterListType createErrorParameterListType() {
        return new ErrorParameterListType();
    }

    /**
     * Create an instance of {@link ErrorParameterType }
     * 
     */
    public ErrorParameterType createErrorParameterType() {
        return new ErrorParameterType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorParameterType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/taskError", name = "errorParameter")
    public JAXBElement<ErrorParameterType> createErrorParameter(ErrorParameterType value) {
        return new JAXBElement<ErrorParameterType>(_ErrorParameter_QNAME, ErrorParameterType.class, null, value);
    }

}
