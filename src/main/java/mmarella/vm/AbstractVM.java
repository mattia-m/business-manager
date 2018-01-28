package mmarella.vm;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Executions;

public abstract class AbstractVM {

	private WebApplicationContext applicationContext;

	public AbstractVM() {
		this.autowire();
	}

	private void autowire() {
		this.getApplicationContext().getAutowireCapableBeanFactory().autowireBean(this);
	}

	public ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		}
		return applicationContext;
	}

	public ServletContext getServletContext() {
		return Executions.getCurrent().getDesktop().getWebApp().getServletContext();
	}

	public void setApplicationContext(WebApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

}