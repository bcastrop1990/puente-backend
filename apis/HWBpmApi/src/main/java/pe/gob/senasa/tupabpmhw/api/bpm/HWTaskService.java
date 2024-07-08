package pe.gob.senasa.tupabpmhw.api.bpm;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.dom.DOMResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

import com.oracle.xmlns.bpel.workflow.taskqueryservice.TaskQueryService;
import com.oracle.xmlns.bpel.workflow.taskqueryservice.TaskQueryService_Service;
import com.oracle.xmlns.bpel.workflow.taskqueryservice.WorkflowErrorMessage;
import com.oracle.xmlns.bpel.workflow.taskservice.ReassignTaskType;
import com.oracle.xmlns.bpel.workflow.taskservice.StaleObjectFaultMessage;
import com.oracle.xmlns.bpel.workflow.taskservice.TaskAssigneeType;
import com.oracle.xmlns.bpel.workflow.taskservice.TaskAssigneesType;
import com.oracle.xmlns.bpel.workflow.taskservice.TaskService;
import com.oracle.xmlns.bpel.workflow.taskservice.TaskServiceContextTaskBaseType;
import com.oracle.xmlns.bpel.workflow.taskservice.TaskService_Service;
import com.oracle.xmlns.bpel.workflow.taskservice.UpdateTaskOutcomeType;

import oracle.bpel.services.workflow.common.model.CredentialType;
import oracle.bpel.services.workflow.common.model.WorkflowContextType;
import oracle.bpel.services.workflow.query.model.TaskDetailsByIdRequestType;
import oracle.bpel.services.workflow.query.model.WorkflowContextRequestType;
import oracle.bpel.services.workflow.task.model.Task;
import pe.gob.senasa.soa.service.org.procedimiento.proceso_procedimiento_tupa_v1.Procedimiento;
import pe.gob.senasa.tupabpmhw.api.model.Credencial;
import pe.gob.senasa.tupabpmhw.api.model.Payload;
import pe.gob.senasa.tupabpmhw.api.model.Tarea;
@Service
public class HWTaskService {

    private static final Logger LOGGER = Logger.getLogger(HWTaskService.class.getName());

    private TaskQueryService taskQueryService;
    private TaskService taskService;
    private static final boolean IS_GROUP_FALSE = false;
    private static final String TYPE_USER = "user";
    
    public HWTaskService() {
    	TaskQueryService_Service taskQueryServiceFactory
		        = new TaskQueryService_Service();
		taskQueryService = taskQueryServiceFactory.getTaskQueryServicePort();
		TaskService_Service taskServiceFactory
		        = new TaskService_Service();
		taskService = taskServiceFactory.getTaskServicePort();
    }
       
    public Tarea getTarea(String token, String id) throws Exception {
        try {
            WorkflowContextType workflowContext = getWorkflowContext(token);
            TaskDetailsByIdRequestType payload = new TaskDetailsByIdRequestType();
            payload.setTaskId(id);
            payload.setWorkflowContext(workflowContext);
            Task task = taskQueryService.getTaskDetailsById(payload);
            Tarea tarea = new Tarea(
                    id,
                    task.getTitle(),
                    task.getOwnerUser(),
                    task.getOwnerRole(),
                    task.getPayload()
            );
            return tarea;
        } catch (WorkflowErrorMessage ex) {
            //TODO gestionar excepciongi
            LOGGER.log(Level.SEVERE, null, ex);       
            throw new Exception("[OBTENER TAREA]", ex);
        }
    }

    public Task getTask(String token, String id) throws Exception {
        try {
            WorkflowContextType workflowContext = getWorkflowContext(token);
            TaskDetailsByIdRequestType payload = new TaskDetailsByIdRequestType();
            payload.setTaskId(id);
            payload.setWorkflowContext(workflowContext);
            return taskQueryService.getTaskDetailsById(payload);
        } catch (WorkflowErrorMessage ex) {
            //TODO gestionar excepciongi
            LOGGER.log(Level.SEVERE, null, ex);
            throw new Exception("[OBTENER TAREA]", ex);
        }
    }
   
    public void completeTarea(String token, String id , String resultado, DOMResult payload, boolean updatePayload) throws Exception {
        try {
            LOGGER.log(Level.INFO, "Completar Tarea ID: {0} }", new Object[]{id});

            if (updatePayload) {
                Task task = getTask(token, id);
                
                LOGGER.log(Level.INFO, "Consultando  Task por ID: {0} }", new Object[]{task.toString()});
                Procedimiento serializar = null;
                                
                //Obteniendo Node - ProcedimientoWrapper Serializado
                Node element = payload.getNode();                
                task.setPayload(element.getFirstChild());                
                
                LOGGER.log(Level.INFO, "SET PAYLOAD TASK: {0} }", new Object[]{task.getPayload().getClass().getName()});
                TaskServiceContextTaskBaseType payloadTaskServiceContext = new TaskServiceContextTaskBaseType();
                payloadTaskServiceContext.setWorkflowContext(getWorkflowContext(token));
                payloadTaskServiceContext.setTask(task);
                taskService.mergeAndUpdateTask(payloadTaskServiceContext);

                LOGGER.log(Level.INFO, "TASK SERVICE : mergeAndUpdateTask  {0} }", new Object[]{task.getPayload().getClass().getName()});
            }
            UpdateTaskOutcomeType payloadUpdateTask = new UpdateTaskOutcomeType();
            payloadUpdateTask.setWorkflowContext(getWorkflowContext(token));
            payloadUpdateTask.setTaskId(id);
            payloadUpdateTask.setSkipCallback(Boolean.FALSE);
            payloadUpdateTask.setOutcome(resultado);
            taskService.updateTaskOutcome(payloadUpdateTask);

            LOGGER.log(Level.INFO, "TASK SERVICE : updateTaskOutcome  {0} }", id);

        } catch (                StaleObjectFaultMessage |
                com.oracle.xmlns.bpel.workflow.taskservice.WorkflowErrorMessage ex) {
            LOGGER.log(Level.SEVERE, "[COMPLETAR TAREA] ErrorMessage {0}", ex);            
            throw new Exception("[COMPLETAR TAREA]", ex);
        }catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "[COMPLETAR TAREA] Exception {0}", ex);
            throw new Exception("[COMPLETAR TAREA]", ex);
        }
    }
    
    private WorkflowContextType getWorkflowContext(String token) throws WorkflowErrorMessage {
        WorkflowContextRequestType payload = new WorkflowContextRequestType();
        payload.setToken(token);
        WorkflowContextType workflowContext = taskQueryService
                .getWorkflowContext(payload);
        return workflowContext;
    }

    public Credencial getCredencial(String token) throws Exception {
        try {
            WorkflowContextType workflowContext = getWorkflowContext(token);
            CredentialType credential = workflowContext.getCredential();
            Credencial credencial = new Credencial(
                    credential.getLogin(),
                    credential.getIdentityContext(),
                    workflowContext.getUserDisplayName()
            );
            return credencial;
        } catch (WorkflowErrorMessage ex) {
            //TODO gestionar excepciongi
            LOGGER.log(Level.SEVERE, null, ex);
            throw new Exception("[VALIDAR CREDENCIAL]", ex);
        }
    }
      
    public void derivar(String taskId, String token, String usuario) throws Exception {
        try {
            ReassignTaskType payload = new ReassignTaskType();
            payload.setWorkflowContext(getWorkflowContext(token));
            payload.setTaskId(taskId);
            TaskAssigneesType tasks = new TaskAssigneesType();
            TaskAssigneeType e = new TaskAssigneeType();
            e.setIsGroup(IS_GROUP_FALSE);
            e.setType(TYPE_USER);
            e.setValue(usuario);
            tasks.getTaskAssignee().add(e);
            payload.setTaskAssignees(tasks);
            Task task = taskService.reassignTask(payload);
            if (Optional.ofNullable(task).isPresent()) {
                LOGGER.log(Level.INFO, "[DERIVAR TAREA] TASK ID {0} - SUCCESS", taskId);
            }
        } catch (WorkflowErrorMessage | com.oracle.xmlns.bpel.workflow.taskservice.WorkflowErrorMessage | StaleObjectFaultMessage ex) {
            LOGGER.log(Level.INFO, "[DERIVAR TAREA] TASK ID {0} - ERROR", taskId);
            Logger.getLogger(HWTaskService.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("[DERIVAR TAREA]", ex);
        }
    }
    
}
