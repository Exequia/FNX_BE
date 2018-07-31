package com.fnx.be.services.interfaces;

import java.util.List;

import com.fnx.be.models.Task;

public interface ITaskService {

	/***
	 * Retorna una lista definida de todas las tareas a mostrar en la home de la
	 * applicación
	 * 
	 * @return
	 * @author Alberto Real
	 */
	List<Task> getHomeTasks(int id);

}
