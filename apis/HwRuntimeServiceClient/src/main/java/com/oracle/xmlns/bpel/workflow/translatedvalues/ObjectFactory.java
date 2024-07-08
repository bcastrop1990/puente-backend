
package com.oracle.xmlns.bpel.workflow.translatedvalues;

/*
 * #%L
 * TUPA: Integration: BPM-Client: HW Runtime Service Client
 * %%
 * Copyright (C) 2016 SENASA
 * %%
 * This software is the confidential and proprietary information of SENASA. 
 * You shall not disclose such confidential information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with 
 * SENASA.
 * #L%
 */

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.bpel.workflow.translatedvalues package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.bpel.workflow.translatedvalues
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TranslatedValues }
     * 
     */
    public TranslatedValues createTranslatedValues() {
        return new TranslatedValues();
    }

    /**
     * Create an instance of {@link TranslatedValue }
     * 
     */
    public TranslatedValue createTranslatedValue() {
        return new TranslatedValue();
    }

    /**
     * Create an instance of {@link MetadataLocaleType }
     * 
     */
    public MetadataLocaleType createMetadataLocaleType() {
        return new MetadataLocaleType();
    }

    /**
     * Create an instance of {@link StageTranslatedValues }
     * 
     */
    public StageTranslatedValues createStageTranslatedValues() {
        return new StageTranslatedValues();
    }

    /**
     * Create an instance of {@link StageTranslatedValue }
     * 
     */
    public StageTranslatedValue createStageTranslatedValue() {
        return new StageTranslatedValue();
    }

    /**
     * Create an instance of {@link ParticipantTranslatedValues }
     * 
     */
    public ParticipantTranslatedValues createParticipantTranslatedValues() {
        return new ParticipantTranslatedValues();
    }

    /**
     * Create an instance of {@link ParticipantTranslatedValue }
     * 
     */
    public ParticipantTranslatedValue createParticipantTranslatedValue() {
        return new ParticipantTranslatedValue();
    }

    /**
     * Create an instance of {@link OutcomeTranslatedValues }
     * 
     */
    public OutcomeTranslatedValues createOutcomeTranslatedValues() {
        return new OutcomeTranslatedValues();
    }

    /**
     * Create an instance of {@link OutcomeTranslatedValue }
     * 
     */
    public OutcomeTranslatedValue createOutcomeTranslatedValue() {
        return new OutcomeTranslatedValue();
    }

}
