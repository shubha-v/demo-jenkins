package demofile.core.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(service=DemoFileService.class, immediate=true)
public class DemoFileServiceImpl implements DemoFileService {

	@ValueMapValue
	private List<String> snoList;
	@ValueMapValue
	private List<String> nameList;
	@ValueMapValue
	private List<String> marksList;
	
	@Activate
	@Modified
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		snoList = new ArrayList<String>();
		nameList = new ArrayList<String>();
		marksList = new ArrayList<String>();
		
		File file = new File("C:\\Users\\hp\\Desktop\\AEM\\excelfile.xlsx");
		FileInputStream fs = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fs);
		Sheet sheet = workbook.getSheetAt(0);
		
		int row = sheet.getPhysicalNumberOfRows();
		for(int i=0;i<row;i++) {
			String Sno = String.valueOf(sheet.getRow(i).getCell(0).getStringCellValue());
			String Name = String.valueOf(sheet.getRow(i).getCell(1).getStringCellValue());
			String Marks = String.valueOf(sheet.getRow(i).getCell(2).getStringCellValue());
			
			snoList.add(Sno);
			nameList.add(Name);
			marksList.add(Marks);
		}
		workbook.close();
	}

	@Override
	public List<String> getSnoList() {
		// TODO Auto-generated method stub
		return snoList;
	}

	@Override
	public List<String> getNameList() {
		// TODO Auto-generated method stub
		return nameList;
	}

	@Override
	public List<String> getMarksList() {
		// TODO Auto-generated method stub
		return marksList;
	}

	
}
