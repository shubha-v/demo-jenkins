package demofile.core.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import demofile.core.service.DemoFileService;

@Model(adaptables = Resource.class, defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class DemoFileModel {

	
	private List<String> sno;
	
	private List<String> name;
	
	private List<String> marks;
	
	@OSGiService
	private DemoFileService service;
	
	@PostConstruct
	protected void init() {
		sno = service.getSnoList();
		name = service.getNameList();
		marks = service.getMarksList();
	}

	public List<String> getSno() {
		return sno;
	}

	public List<String> getName() {
		return name;
	}

	public List<String> getMarks() {
		return marks;
	}

}
