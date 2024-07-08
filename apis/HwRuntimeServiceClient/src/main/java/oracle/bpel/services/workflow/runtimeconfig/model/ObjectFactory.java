
package oracle.bpel.services.workflow.runtimeconfig.model;

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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oracle.bpel.services.workflow.runtimeconfig.model package. 
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

    private final static QName _Fault_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "fault");
    private final static QName _GetWorkflowPayloadMappingsRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getWorkflowPayloadMappingsRequest");
    private final static QName _GetBPMProcessPayloadMappingsRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getBPMProcessPayloadMappingsRequest");
    private final static QName _CreateAttributeLabelRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "createAttributeLabelRequest");
    private final static QName _UpdateAttributeLabelRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "updateAttributeLabelRequest");
    private final static QName _DeleteAttributeLabelRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "deleteAttributeLabelRequest");
    private final static QName _GetAttributeLabelUsagesRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getAttributeLabelUsagesRequest");
    private final static QName _CreatePayloadMappingRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "createPayloadMappingRequest");
    private final static QName _DeletePayloadMappingRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "deletePayloadMappingRequest");
    private final static QName _GetDynamicAssignmentFunctionsRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getDynamicAssignmentFunctionsRequest");
    private final static QName _GetUserDynamicAssignmentFunctionsRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getUserDynamicAssignmentFunctionsRequest");
    private final static QName _GetGroupDynamicAssignmentFunctionsRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getGroupDynamicAssignmentFunctionsRequest");
    private final static QName _GetTaskDisplayInfoRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getTaskDisplayInfoRequest");
    private final static QName _SetTaskDisplayInfoRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "setTaskDisplayInfoRequest");
    private final static QName _DeleteTaskDisplayInfoRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "deleteTaskDisplayInfoRequest");
    private final static QName _GetTaskDisplayInfoByTaskDefinitionIdRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getTaskDisplayInfoByTaskDefinitionIdRequest");
    private final static QName _GetTaskStatusRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getTaskStatusRequest");
    private final static QName _CreateApprovalGroupRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "createApprovalGroupRequest");
    private final static QName _UpdateApprovalGroupRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "updateApprovalGroupRequest");
    private final static QName _BulkUpdateApprovalGroupRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "bulkUpdateApprovalGroupRequest");
    private final static QName _GetApprovalGroupRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getApprovalGroupRequest");
    private final static QName _DeleteApprovalGroupRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "deleteApprovalGroupRequest");
    private final static QName _CreateInGroupRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "createInGroupRequest");
    private final static QName _UpdateInGroupRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "updateInGroupRequest");
    private final static QName _DeleteFromGroupRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "deleteFromGroupRequest");
    private final static QName _SearchApprovalGroupsRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "searchApprovalGroupsRequest");
    private final static QName _GetServerURLFromFabricConfigRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getServerURLFromFabricConfigRequest");
    private final static QName _GetInternalServerURLRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getInternalServerURLRequest");
    private final static QName _GetInternalServerURLResponse_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getInternalServerURLResponse");
    private final static QName _GetJndiURLFromFabricConfigRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getJndiURLFromFabricConfigRequest");
    private final static QName _GetSupportedWorkflowExtensionsRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getSupportedWorkflowExtensionsRequest");
    private final static QName _GetSupportedWorkflowExtensionsResponse_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getSupportedWorkflowExtensionsResponse");
    private final static QName _GetConfigurationRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getConfigurationRequest");
    private final static QName _GetTranslatedValuesUsingTaskDefIdsRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getTranslatedValuesUsingTaskDefIdsRequest");
    private final static QName _AttributeLabel_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "attributeLabel");
    private final static QName _AttributeLabelUsages_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "attributeLabelUsages");
    private final static QName _PayloadMapping_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "payloadMapping");
    private final static QName _DynamicAssignFunction_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "dynamicAssignFunction");
    private final static QName _TaskDisplayInfo_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "taskDisplayInfo");
    private final static QName _SuccessResponse_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "successResponse");
    private final static QName _TaskStatus_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "taskStatus");
    private final static QName _ApprovalGroup_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "approvalGroup");
    private final static QName _ApprovalGroupMember_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "approvalGroupMember");
    private final static QName _GetServerURLFromFabricConfigResponse_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getServerURLFromFabricConfigResponse");
    private final static QName _GetJndiURLFromFabricConfigResponse_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "getJndiURLFromFabricConfigResponse");
    private final static QName _UcmInfo_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "ucmInfo");
    private final static QName _UcmRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/runtimeConfig", "ucmRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oracle.bpel.services.workflow.runtimeconfig.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XpathType }
     * 
     */
    public XpathType createXpathType() {
        return new XpathType();
    }

    /**
     * Create an instance of {@link DynamicAssignFunctionType }
     * 
     */
    public DynamicAssignFunctionType createDynamicAssignFunctionType() {
        return new DynamicAssignFunctionType();
    }

    /**
     * Create an instance of {@link FaultType }
     * 
     */
    public FaultType createFaultType() {
        return new FaultType();
    }

    /**
     * Create an instance of {@link WorkflowIdRequestType }
     * 
     */
    public WorkflowIdRequestType createWorkflowIdRequestType() {
        return new WorkflowIdRequestType();
    }

    /**
     * Create an instance of {@link ProcessDNRequestType }
     * 
     */
    public ProcessDNRequestType createProcessDNRequestType() {
        return new ProcessDNRequestType();
    }

    /**
     * Create an instance of {@link AttributeLabelRequestType }
     * 
     */
    public AttributeLabelRequestType createAttributeLabelRequestType() {
        return new AttributeLabelRequestType();
    }

    /**
     * Create an instance of {@link AttributeLabelIdRequestType }
     * 
     */
    public AttributeLabelIdRequestType createAttributeLabelIdRequestType() {
        return new AttributeLabelIdRequestType();
    }

    /**
     * Create an instance of {@link AttributeTypeRequestType }
     * 
     */
    public AttributeTypeRequestType createAttributeTypeRequestType() {
        return new AttributeTypeRequestType();
    }

    /**
     * Create an instance of {@link PayloadMappingRequestType }
     * 
     */
    public PayloadMappingRequestType createPayloadMappingRequestType() {
        return new PayloadMappingRequestType();
    }

    /**
     * Create an instance of {@link GetDynamicAssignmentFunctionsRequestType }
     * 
     */
    public GetDynamicAssignmentFunctionsRequestType createGetDynamicAssignmentFunctionsRequestType() {
        return new GetDynamicAssignmentFunctionsRequestType();
    }

    /**
     * Create an instance of {@link WfCtxtRequestType }
     * 
     */
    public WfCtxtRequestType createWfCtxtRequestType() {
        return new WfCtxtRequestType();
    }

    /**
     * Create an instance of {@link GetTaskDisplayInfoRequestType }
     * 
     */
    public GetTaskDisplayInfoRequestType createGetTaskDisplayInfoRequestType() {
        return new GetTaskDisplayInfoRequestType();
    }

    /**
     * Create an instance of {@link SetTaskDisplayInfoRequestType }
     * 
     */
    public SetTaskDisplayInfoRequestType createSetTaskDisplayInfoRequestType() {
        return new SetTaskDisplayInfoRequestType();
    }

    /**
     * Create an instance of {@link DeleteTaskDisplayInfoRequestType }
     * 
     */
    public DeleteTaskDisplayInfoRequestType createDeleteTaskDisplayInfoRequestType() {
        return new DeleteTaskDisplayInfoRequestType();
    }

    /**
     * Create an instance of {@link GetTaskDisplayInfoByTaskDefinitionIdRequestType }
     * 
     */
    public GetTaskDisplayInfoByTaskDefinitionIdRequestType createGetTaskDisplayInfoByTaskDefinitionIdRequestType() {
        return new GetTaskDisplayInfoByTaskDefinitionIdRequestType();
    }

    /**
     * Create an instance of {@link GetTaskStatusRequestType }
     * 
     */
    public GetTaskStatusRequestType createGetTaskStatusRequestType() {
        return new GetTaskStatusRequestType();
    }

    /**
     * Create an instance of {@link ApprovalGroupRequestType }
     * 
     */
    public ApprovalGroupRequestType createApprovalGroupRequestType() {
        return new ApprovalGroupRequestType();
    }

    /**
     * Create an instance of {@link ApprovalGroupNameRequestType }
     * 
     */
    public ApprovalGroupNameRequestType createApprovalGroupNameRequestType() {
        return new ApprovalGroupNameRequestType();
    }

    /**
     * Create an instance of {@link ApprovalGroupMemberRequestType }
     * 
     */
    public ApprovalGroupMemberRequestType createApprovalGroupMemberRequestType() {
        return new ApprovalGroupMemberRequestType();
    }

    /**
     * Create an instance of {@link ApprovalGroupSearchRequestType }
     * 
     */
    public ApprovalGroupSearchRequestType createApprovalGroupSearchRequestType() {
        return new ApprovalGroupSearchRequestType();
    }

    /**
     * Create an instance of {@link GetSupportedWorkflowExtensionsResponseType }
     * 
     */
    public GetSupportedWorkflowExtensionsResponseType createGetSupportedWorkflowExtensionsResponseType() {
        return new GetSupportedWorkflowExtensionsResponseType();
    }

    /**
     * Create an instance of {@link GetTranslatedValuesUsingTaskDefIdsRequestType }
     * 
     */
    public GetTranslatedValuesUsingTaskDefIdsRequestType createGetTranslatedValuesUsingTaskDefIdsRequestType() {
        return new GetTranslatedValuesUsingTaskDefIdsRequestType();
    }

    /**
     * Create an instance of {@link AttributeLabelType }
     * 
     */
    public AttributeLabelType createAttributeLabelType() {
        return new AttributeLabelType();
    }

    /**
     * Create an instance of {@link LabelUsages }
     * 
     */
    public LabelUsages createLabelUsages() {
        return new LabelUsages();
    }

    /**
     * Create an instance of {@link AttributeLabelUsageList }
     * 
     */
    public AttributeLabelUsageList createAttributeLabelUsageList() {
        return new AttributeLabelUsageList();
    }

    /**
     * Create an instance of {@link PayloadMappingType }
     * 
     */
    public PayloadMappingType createPayloadMappingType() {
        return new PayloadMappingType();
    }

    /**
     * Create an instance of {@link PayloadMappingsList }
     * 
     */
    public PayloadMappingsList createPayloadMappingsList() {
        return new PayloadMappingsList();
    }

    /**
     * Create an instance of {@link DynamicAssignFunctionList }
     * 
     */
    public DynamicAssignFunctionList createDynamicAssignFunctionList() {
        return new DynamicAssignFunctionList();
    }

    /**
     * Create an instance of {@link TaskDisplayInfoType }
     * 
     */
    public TaskDisplayInfoType createTaskDisplayInfoType() {
        return new TaskDisplayInfoType();
    }

    /**
     * Create an instance of {@link TaskDisplayInfoList }
     * 
     */
    public TaskDisplayInfoList createTaskDisplayInfoList() {
        return new TaskDisplayInfoList();
    }

    /**
     * Create an instance of {@link TaskStatusType }
     * 
     */
    public TaskStatusType createTaskStatusType() {
        return new TaskStatusType();
    }

    /**
     * Create an instance of {@link ApprovalGroupType }
     * 
     */
    public ApprovalGroupType createApprovalGroupType() {
        return new ApprovalGroupType();
    }

    /**
     * Create an instance of {@link ApprovalGroupMemberType }
     * 
     */
    public ApprovalGroupMemberType createApprovalGroupMemberType() {
        return new ApprovalGroupMemberType();
    }

    /**
     * Create an instance of {@link ApprovalGroupNameList }
     * 
     */
    public ApprovalGroupNameList createApprovalGroupNameList() {
        return new ApprovalGroupNameList();
    }

    /**
     * Create an instance of {@link UcmInfoType }
     * 
     */
    public UcmInfoType createUcmInfoType() {
        return new UcmInfoType();
    }

    /**
     * Create an instance of {@link UcmRequestType }
     * 
     */
    public UcmRequestType createUcmRequestType() {
        return new UcmRequestType();
    }

    /**
     * Create an instance of {@link LabelUsageType }
     * 
     */
    public LabelUsageType createLabelUsageType() {
        return new LabelUsageType();
    }

    /**
     * Create an instance of {@link DynamicAssignmentParameterType }
     * 
     */
    public DynamicAssignmentParameterType createDynamicAssignmentParameterType() {
        return new DynamicAssignmentParameterType();
    }

    /**
     * Create an instance of {@link UcmFolderType }
     * 
     */
    public UcmFolderType createUcmFolderType() {
        return new UcmFolderType();
    }

    /**
     * Create an instance of {@link UcmPropertyType }
     * 
     */
    public UcmPropertyType createUcmPropertyType() {
        return new UcmPropertyType();
    }

    /**
     * Create an instance of {@link UcmSecGroupType }
     * 
     */
    public UcmSecGroupType createUcmSecGroupType() {
        return new UcmSecGroupType();
    }

    /**
     * Create an instance of {@link UcmErrorType }
     * 
     */
    public UcmErrorType createUcmErrorType() {
        return new UcmErrorType();
    }

    /**
     * Create an instance of {@link UcmDocType }
     * 
     */
    public UcmDocType createUcmDocType() {
        return new UcmDocType();
    }

    /**
     * Create an instance of {@link UcmDocumentType }
     * 
     */
    public UcmDocumentType createUcmDocumentType() {
        return new UcmDocumentType();
    }

    /**
     * Create an instance of {@link UcmAccountType }
     * 
     */
    public UcmAccountType createUcmAccountType() {
        return new UcmAccountType();
    }

    /**
     * Create an instance of {@link XpathType.Namespace }
     * 
     */
    public XpathType.Namespace createXpathTypeNamespace() {
        return new XpathType.Namespace();
    }

    /**
     * Create an instance of {@link DynamicAssignFunctionType.SupportedAssigneeTypes }
     * 
     */
    public DynamicAssignFunctionType.SupportedAssigneeTypes createDynamicAssignFunctionTypeSupportedAssigneeTypes() {
        return new DynamicAssignFunctionType.SupportedAssigneeTypes();
    }

    /**
     * Create an instance of {@link DynamicAssignFunctionType.Parameters }
     * 
     */
    public DynamicAssignFunctionType.Parameters createDynamicAssignFunctionTypeParameters() {
        return new DynamicAssignFunctionType.Parameters();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "fault")
    public JAXBElement<FaultType> createFault(FaultType value) {
        return new JAXBElement<FaultType>(_Fault_QNAME, FaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowIdRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getWorkflowPayloadMappingsRequest")
    public JAXBElement<WorkflowIdRequestType> createGetWorkflowPayloadMappingsRequest(WorkflowIdRequestType value) {
        return new JAXBElement<WorkflowIdRequestType>(_GetWorkflowPayloadMappingsRequest_QNAME, WorkflowIdRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessDNRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getBPMProcessPayloadMappingsRequest")
    public JAXBElement<ProcessDNRequestType> createGetBPMProcessPayloadMappingsRequest(ProcessDNRequestType value) {
        return new JAXBElement<ProcessDNRequestType>(_GetBPMProcessPayloadMappingsRequest_QNAME, ProcessDNRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeLabelRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "createAttributeLabelRequest")
    public JAXBElement<AttributeLabelRequestType> createCreateAttributeLabelRequest(AttributeLabelRequestType value) {
        return new JAXBElement<AttributeLabelRequestType>(_CreateAttributeLabelRequest_QNAME, AttributeLabelRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeLabelRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "updateAttributeLabelRequest")
    public JAXBElement<AttributeLabelRequestType> createUpdateAttributeLabelRequest(AttributeLabelRequestType value) {
        return new JAXBElement<AttributeLabelRequestType>(_UpdateAttributeLabelRequest_QNAME, AttributeLabelRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeLabelIdRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "deleteAttributeLabelRequest")
    public JAXBElement<AttributeLabelIdRequestType> createDeleteAttributeLabelRequest(AttributeLabelIdRequestType value) {
        return new JAXBElement<AttributeLabelIdRequestType>(_DeleteAttributeLabelRequest_QNAME, AttributeLabelIdRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeTypeRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getAttributeLabelUsagesRequest")
    public JAXBElement<AttributeTypeRequestType> createGetAttributeLabelUsagesRequest(AttributeTypeRequestType value) {
        return new JAXBElement<AttributeTypeRequestType>(_GetAttributeLabelUsagesRequest_QNAME, AttributeTypeRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayloadMappingRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "createPayloadMappingRequest")
    public JAXBElement<PayloadMappingRequestType> createCreatePayloadMappingRequest(PayloadMappingRequestType value) {
        return new JAXBElement<PayloadMappingRequestType>(_CreatePayloadMappingRequest_QNAME, PayloadMappingRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayloadMappingRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "deletePayloadMappingRequest")
    public JAXBElement<PayloadMappingRequestType> createDeletePayloadMappingRequest(PayloadMappingRequestType value) {
        return new JAXBElement<PayloadMappingRequestType>(_DeletePayloadMappingRequest_QNAME, PayloadMappingRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDynamicAssignmentFunctionsRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getDynamicAssignmentFunctionsRequest")
    public JAXBElement<GetDynamicAssignmentFunctionsRequestType> createGetDynamicAssignmentFunctionsRequest(GetDynamicAssignmentFunctionsRequestType value) {
        return new JAXBElement<GetDynamicAssignmentFunctionsRequestType>(_GetDynamicAssignmentFunctionsRequest_QNAME, GetDynamicAssignmentFunctionsRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WfCtxtRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getUserDynamicAssignmentFunctionsRequest")
    public JAXBElement<WfCtxtRequestType> createGetUserDynamicAssignmentFunctionsRequest(WfCtxtRequestType value) {
        return new JAXBElement<WfCtxtRequestType>(_GetUserDynamicAssignmentFunctionsRequest_QNAME, WfCtxtRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WfCtxtRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getGroupDynamicAssignmentFunctionsRequest")
    public JAXBElement<WfCtxtRequestType> createGetGroupDynamicAssignmentFunctionsRequest(WfCtxtRequestType value) {
        return new JAXBElement<WfCtxtRequestType>(_GetGroupDynamicAssignmentFunctionsRequest_QNAME, WfCtxtRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaskDisplayInfoRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getTaskDisplayInfoRequest")
    public JAXBElement<GetTaskDisplayInfoRequestType> createGetTaskDisplayInfoRequest(GetTaskDisplayInfoRequestType value) {
        return new JAXBElement<GetTaskDisplayInfoRequestType>(_GetTaskDisplayInfoRequest_QNAME, GetTaskDisplayInfoRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTaskDisplayInfoRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "setTaskDisplayInfoRequest")
    public JAXBElement<SetTaskDisplayInfoRequestType> createSetTaskDisplayInfoRequest(SetTaskDisplayInfoRequestType value) {
        return new JAXBElement<SetTaskDisplayInfoRequestType>(_SetTaskDisplayInfoRequest_QNAME, SetTaskDisplayInfoRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTaskDisplayInfoRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "deleteTaskDisplayInfoRequest")
    public JAXBElement<DeleteTaskDisplayInfoRequestType> createDeleteTaskDisplayInfoRequest(DeleteTaskDisplayInfoRequestType value) {
        return new JAXBElement<DeleteTaskDisplayInfoRequestType>(_DeleteTaskDisplayInfoRequest_QNAME, DeleteTaskDisplayInfoRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaskDisplayInfoByTaskDefinitionIdRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getTaskDisplayInfoByTaskDefinitionIdRequest")
    public JAXBElement<GetTaskDisplayInfoByTaskDefinitionIdRequestType> createGetTaskDisplayInfoByTaskDefinitionIdRequest(GetTaskDisplayInfoByTaskDefinitionIdRequestType value) {
        return new JAXBElement<GetTaskDisplayInfoByTaskDefinitionIdRequestType>(_GetTaskDisplayInfoByTaskDefinitionIdRequest_QNAME, GetTaskDisplayInfoByTaskDefinitionIdRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaskStatusRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getTaskStatusRequest")
    public JAXBElement<GetTaskStatusRequestType> createGetTaskStatusRequest(GetTaskStatusRequestType value) {
        return new JAXBElement<GetTaskStatusRequestType>(_GetTaskStatusRequest_QNAME, GetTaskStatusRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "createApprovalGroupRequest")
    public JAXBElement<ApprovalGroupRequestType> createCreateApprovalGroupRequest(ApprovalGroupRequestType value) {
        return new JAXBElement<ApprovalGroupRequestType>(_CreateApprovalGroupRequest_QNAME, ApprovalGroupRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "updateApprovalGroupRequest")
    public JAXBElement<ApprovalGroupRequestType> createUpdateApprovalGroupRequest(ApprovalGroupRequestType value) {
        return new JAXBElement<ApprovalGroupRequestType>(_UpdateApprovalGroupRequest_QNAME, ApprovalGroupRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "bulkUpdateApprovalGroupRequest")
    public JAXBElement<ApprovalGroupRequestType> createBulkUpdateApprovalGroupRequest(ApprovalGroupRequestType value) {
        return new JAXBElement<ApprovalGroupRequestType>(_BulkUpdateApprovalGroupRequest_QNAME, ApprovalGroupRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupNameRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getApprovalGroupRequest")
    public JAXBElement<ApprovalGroupNameRequestType> createGetApprovalGroupRequest(ApprovalGroupNameRequestType value) {
        return new JAXBElement<ApprovalGroupNameRequestType>(_GetApprovalGroupRequest_QNAME, ApprovalGroupNameRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupNameRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "deleteApprovalGroupRequest")
    public JAXBElement<ApprovalGroupNameRequestType> createDeleteApprovalGroupRequest(ApprovalGroupNameRequestType value) {
        return new JAXBElement<ApprovalGroupNameRequestType>(_DeleteApprovalGroupRequest_QNAME, ApprovalGroupNameRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupMemberRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "createInGroupRequest")
    public JAXBElement<ApprovalGroupMemberRequestType> createCreateInGroupRequest(ApprovalGroupMemberRequestType value) {
        return new JAXBElement<ApprovalGroupMemberRequestType>(_CreateInGroupRequest_QNAME, ApprovalGroupMemberRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupMemberRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "updateInGroupRequest")
    public JAXBElement<ApprovalGroupMemberRequestType> createUpdateInGroupRequest(ApprovalGroupMemberRequestType value) {
        return new JAXBElement<ApprovalGroupMemberRequestType>(_UpdateInGroupRequest_QNAME, ApprovalGroupMemberRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupMemberRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "deleteFromGroupRequest")
    public JAXBElement<ApprovalGroupMemberRequestType> createDeleteFromGroupRequest(ApprovalGroupMemberRequestType value) {
        return new JAXBElement<ApprovalGroupMemberRequestType>(_DeleteFromGroupRequest_QNAME, ApprovalGroupMemberRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupSearchRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "searchApprovalGroupsRequest")
    public JAXBElement<ApprovalGroupSearchRequestType> createSearchApprovalGroupsRequest(ApprovalGroupSearchRequestType value) {
        return new JAXBElement<ApprovalGroupSearchRequestType>(_SearchApprovalGroupsRequest_QNAME, ApprovalGroupSearchRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getServerURLFromFabricConfigRequest")
    public JAXBElement<String> createGetServerURLFromFabricConfigRequest(String value) {
        return new JAXBElement<String>(_GetServerURLFromFabricConfigRequest_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getInternalServerURLRequest")
    public JAXBElement<String> createGetInternalServerURLRequest(String value) {
        return new JAXBElement<String>(_GetInternalServerURLRequest_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getInternalServerURLResponse")
    public JAXBElement<String> createGetInternalServerURLResponse(String value) {
        return new JAXBElement<String>(_GetInternalServerURLResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getJndiURLFromFabricConfigRequest")
    public JAXBElement<String> createGetJndiURLFromFabricConfigRequest(String value) {
        return new JAXBElement<String>(_GetJndiURLFromFabricConfigRequest_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getSupportedWorkflowExtensionsRequest")
    public JAXBElement<String> createGetSupportedWorkflowExtensionsRequest(String value) {
        return new JAXBElement<String>(_GetSupportedWorkflowExtensionsRequest_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSupportedWorkflowExtensionsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getSupportedWorkflowExtensionsResponse")
    public JAXBElement<GetSupportedWorkflowExtensionsResponseType> createGetSupportedWorkflowExtensionsResponse(GetSupportedWorkflowExtensionsResponseType value) {
        return new JAXBElement<GetSupportedWorkflowExtensionsResponseType>(_GetSupportedWorkflowExtensionsResponse_QNAME, GetSupportedWorkflowExtensionsResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WfCtxtRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getConfigurationRequest")
    public JAXBElement<WfCtxtRequestType> createGetConfigurationRequest(WfCtxtRequestType value) {
        return new JAXBElement<WfCtxtRequestType>(_GetConfigurationRequest_QNAME, WfCtxtRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTranslatedValuesUsingTaskDefIdsRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getTranslatedValuesUsingTaskDefIdsRequest")
    public JAXBElement<GetTranslatedValuesUsingTaskDefIdsRequestType> createGetTranslatedValuesUsingTaskDefIdsRequest(GetTranslatedValuesUsingTaskDefIdsRequestType value) {
        return new JAXBElement<GetTranslatedValuesUsingTaskDefIdsRequestType>(_GetTranslatedValuesUsingTaskDefIdsRequest_QNAME, GetTranslatedValuesUsingTaskDefIdsRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeLabelType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "attributeLabel")
    public JAXBElement<AttributeLabelType> createAttributeLabel(AttributeLabelType value) {
        return new JAXBElement<AttributeLabelType>(_AttributeLabel_QNAME, AttributeLabelType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LabelUsages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "attributeLabelUsages")
    public JAXBElement<LabelUsages> createAttributeLabelUsages(LabelUsages value) {
        return new JAXBElement<LabelUsages>(_AttributeLabelUsages_QNAME, LabelUsages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayloadMappingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "payloadMapping")
    public JAXBElement<PayloadMappingType> createPayloadMapping(PayloadMappingType value) {
        return new JAXBElement<PayloadMappingType>(_PayloadMapping_QNAME, PayloadMappingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DynamicAssignFunctionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "dynamicAssignFunction")
    public JAXBElement<DynamicAssignFunctionType> createDynamicAssignFunction(DynamicAssignFunctionType value) {
        return new JAXBElement<DynamicAssignFunctionType>(_DynamicAssignFunction_QNAME, DynamicAssignFunctionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskDisplayInfoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "taskDisplayInfo")
    public JAXBElement<TaskDisplayInfoType> createTaskDisplayInfo(TaskDisplayInfoType value) {
        return new JAXBElement<TaskDisplayInfoType>(_TaskDisplayInfo_QNAME, TaskDisplayInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "successResponse")
    public JAXBElement<String> createSuccessResponse(String value) {
        return new JAXBElement<String>(_SuccessResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskStatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "taskStatus")
    public JAXBElement<TaskStatusType> createTaskStatus(TaskStatusType value) {
        return new JAXBElement<TaskStatusType>(_TaskStatus_QNAME, TaskStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "approvalGroup")
    public JAXBElement<ApprovalGroupType> createApprovalGroup(ApprovalGroupType value) {
        return new JAXBElement<ApprovalGroupType>(_ApprovalGroup_QNAME, ApprovalGroupType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovalGroupMemberType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "approvalGroupMember")
    public JAXBElement<ApprovalGroupMemberType> createApprovalGroupMember(ApprovalGroupMemberType value) {
        return new JAXBElement<ApprovalGroupMemberType>(_ApprovalGroupMember_QNAME, ApprovalGroupMemberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getServerURLFromFabricConfigResponse")
    public JAXBElement<String> createGetServerURLFromFabricConfigResponse(String value) {
        return new JAXBElement<String>(_GetServerURLFromFabricConfigResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "getJndiURLFromFabricConfigResponse")
    public JAXBElement<String> createGetJndiURLFromFabricConfigResponse(String value) {
        return new JAXBElement<String>(_GetJndiURLFromFabricConfigResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UcmInfoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "ucmInfo")
    public JAXBElement<UcmInfoType> createUcmInfo(UcmInfoType value) {
        return new JAXBElement<UcmInfoType>(_UcmInfo_QNAME, UcmInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UcmRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/runtimeConfig", name = "ucmRequest")
    public JAXBElement<UcmRequestType> createUcmRequest(UcmRequestType value) {
        return new JAXBElement<UcmRequestType>(_UcmRequest_QNAME, UcmRequestType.class, null, value);
    }

}
