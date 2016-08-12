
package com.ngujjari.morphline;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.kitesdk.examples.morphlines.ExampleMorphlineTest;
import org.kitesdk.morphline.api.Record;
import org.kitesdk.morphline.base.Fields;

public class MorphlineTest extends ExampleMorphlineTest {

  
  
  @Test
  public void testWebServerLogs() throws Exception {
    morphline = createMorphline("test-morphlines/webserverLogs");
    InputStream in = new FileInputStream(new File(RESOURCES_DIR + "/test-documents/webserverLogs.log"));
    Record record = new Record();
    record.put(Fields.ATTACHMENT_BODY, in);
    record.put(Fields.ATTACHMENT_MIME_TYPE, "text/plain");
    
    assertTrue(morphline.process(record));
    Record expected = new Record(); 
    expected.put("ip", "125.158.192.193");
    assertTrue(collector.getRecords().size() > 0);    
  }
  
  @Test
  public void testLog4jLogs() throws Exception {
    morphline = createMorphline("test-morphlines/log4jLogs");
    InputStream in = new FileInputStream(new File(RESOURCES_DIR + "/test-documents/log4jLogs.log"));
    Record record = new Record();
    record.put(Fields.ATTACHMENT_BODY, in);
    record.put(Fields.ATTACHMENT_MIME_TYPE, "text/plain");
    
    assertTrue(morphline.process(record));
    Record expected = new Record(); 
    expected.put("ip", "125.158.192.193");
    assertTrue(collector.getRecords().size() > 0);    
  }
  

}
