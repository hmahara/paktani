package com.setiti.paktani.loader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.setiti.paktani.entity.Location;
import com.setiti.paktani.persistence.MongoResource;

public class DataLoaderMongo {
	private static final String DB_NAME = "mydb";
	private static final String LOCATIONS_COLLECTION = "location";
	MongoResource res;
	MongoClient mongo;
	MongoOperations mongoOps;
	public static void main(String[] args) {
		DataLoaderMongo loader = new DataLoaderMongo();
		loader.init();
		loader.loadFromExcell("aa");
	}
	
	private void init(){
		res = MongoResource.INSTANCE;
		mongo = res.getClient();
		mongoOps = new MongoTemplate(mongo, DB_NAME);
		mongoOps.dropCollection(LOCATIONS_COLLECTION);
		mongoOps.getCollection(LOCATIONS_COLLECTION);
		
	}
	
public void loadToMongo(Location loc){
		
		///MongoClient mongo = new MongoClient(
        ///        MONGO_HOST, MONGO_PORT);
		 
	if (loc.getLocationName()==null || loc.getLocationName().trim().length()<1) {
		System.out.print("XXXXXXXXXXXXXXXXXXXXXXXX");
		//System.exit(2);
		return;
	}
	if (loc.getParentLocationId()==null || loc.getParentLocationId().trim().length()<1) {
		System.out.print("XXXXXXXXXXXXXXXXXXXXXXXX");
		//System.exit(2);
		return;
	}
	if (loc.getParentLocationId()==null || loc.getParentLocationId().trim().toUpperCase().startsWith("KAB")|| loc.getParentLocationId().trim().toUpperCase().startsWith("KAP")) {
		System.out.print("XXXXXXXXXXXXXXXXXXXXXXXX");
		//System.exit(2);
		return;
	}
			if (loc.getLocationName().startsWith("Kab.")){
				String clean = loc.getLocationName();
				clean = clean.replace("Kab.", "");
				clean = clean.trim();
				loc.setLocationName(clean);
				loc.setLocationType("kab");
				loc.setLocationId(clean);
			}
			
			if (loc.getLocationName().startsWith("Kota")){
				String clean = loc.getLocationName();
				clean = clean.replace("Kota", "");
				clean = clean.trim();
				loc.setLocationName(clean);
				loc.setLocationType("kab");
				loc.setLocationId(clean);
			}
			
			if (loc.getParentLocationId().startsWith("Prov.")){
				String clean = loc.getParentLocationId();
				clean = clean.replace("Prov.", "");
				clean = clean.trim();
				loc.setParentLocationId(clean);
				
			}
		
			
	        
	      //build query
	        Query query = new Query(Criteria.where("locationName").is(loc.getLocationName()));

	        //build update
	        DBObject dbDoc = new BasicDBObject();
	        mongoOps.getConverter().write(loc, dbDoc); //it is the one spring use for convertions.
	        Update update = Update.fromDBObject(dbDoc);
	        mongoOps.upsert(query, update, "location");
		
		

	}

	public void loadToMongo(){
		
		///MongoClient mongo = new MongoClient(
        ///        MONGO_HOST, MONGO_PORT);
		 
		
		
		for (int i=0; i < 25; i++){
			Location loc = new Location();
			//loc.setLocationId(new Date().getTime());
	        loc.setLocationName("DIY"+i);
	        loc.setLocationLevel(1);
	        loc.setLatitude("7");
	        loc.setLongitude("110");
	        loc.setParentLocationId("Indonesia");
	      //build query
	        Query query = new Query(Criteria.where("locationName").is(loc.getLocationName()));

	        //build update
	        DBObject dbDoc = new BasicDBObject();
	        mongoOps.getConverter().write(loc, dbDoc); //it is the one spring use for convertions.
	        Update update = Update.fromDBObject(dbDoc);
	        mongoOps.upsert(query, update, "location");
		}
		

	}
	
	public void loadFromExcell(String fileName)
    {
        try
        {
            FileInputStream file = new FileInputStream(new File("c:/data/minar/loc1.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int r = 0;
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                if (r == 0){
                	r++;
                	continue;
                }
                Location loc = new Location();
                //loc.setLocationId(new Date().getTime());
    	        
    	        loc.setLocationLevel(3);
    	        String prov = "";
    	        String kab = "";
    	        String latitude = "";
    	        String longitude = "";
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                int column = 0; 
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                        	if (column==1){
                        		System.out.print(cell.getNumericCellValue() + "[--prov--]N");
                        	}if (column==3){
                        		System.out.print(cell.getNumericCellValue() + "[--kab--]N");
                        	}if (column==4){
                        		System.out.print(cell.getNumericCellValue() + "[--lat--]N");
                        		latitude = ""+cell.getNumericCellValue();
                        	}if (column==5){
                        		System.out.print(cell.getNumericCellValue() + "[--long--]N");
                        		longitude = ""+cell.getNumericCellValue();
                        	}
                        	break;
                        case Cell.CELL_TYPE_STRING:
                        	if (column==1){
                        		System.out.print(cell.getStringCellValue() + "[--prov--]S");
                        		prov = cell.getStringCellValue();
                			}
                			  if (column==3){
                        		System.out.print(cell.getStringCellValue() + "[--kab--]S");
                        		kab = cell.getStringCellValue();
                			} if (column==4){
                        		System.out.print(cell.getStringCellValue() + "[--lat--]S");
                			} if (column==5){
                        		System.out.print(cell.getStringCellValue() + "[--long--]S");
                			}
                        	break;
                    }
                    column++;
                }
                loc.setLatitude(latitude);
                loc.setLongitude(longitude);
                loc.setLocationName(kab);
                loc.setParentLocationId(prov);
                loadToMongo(loc);
                System.out.println("");
                r++;
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
