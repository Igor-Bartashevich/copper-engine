/*
 * Copyright 2002-2013 SCOOP Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.scoopgmbh.copper.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import de.scoopgmbh.copper.AbstractDependencyInjector;

/**
 * Connects SPRING to COPPER. Enables COPPER to inject dependencies into workflow instances using a spring container/context.
 * 
 * @author austermann
 *
 */
public class SpringDependencyInjector extends AbstractDependencyInjector implements ApplicationContextAware {
	
	private ApplicationContext context;
	
	public SpringDependencyInjector() {
	}
	
	public SpringDependencyInjector(ApplicationContext context) {
		this.context = context;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	@Override
	protected Object getBean(String beanId) {
		return context.getBean(beanId);
	}

}

